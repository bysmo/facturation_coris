package com.coris.facturation.controllers.CIP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coris.facturation.repositories.CIP_Input_CarteBancaireRepository;
import com.coris.facturation.repositories.CIP_Input_ChequeIrregRepository;
import com.coris.facturation.repositories.CIP_Input_CompteRepository;
import com.coris.facturation.repositories.CIP_Input_GestionnaireRepository;
import com.coris.facturation.repositories.CIP_Input_IncidentRepository;
import com.coris.facturation.repositories.CIP_Input_RegularisationRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Controller
@RequestMapping("/CIP")
public class CIPDataUploadController {

    @Autowired
    private CIP_Input_CarteBancaireRepository input_carte_bancaireRepository; // Repository pour interagir avec la
    @Autowired // base de données
    private CIP_Input_ChequeIrregRepository input_cheque_irregRepository; // Repository pour interagir avec la
    @Autowired // base de données
    private CIP_Input_CompteRepository input_compteRepository; // Repository pour interagir avec la base de
    @Autowired // données
    private CIP_Input_GestionnaireRepository input_gestionnaireRepository; // Repository pour interagir avec la
    @Autowired // base de données
    private CIP_Input_IncidentRepository input_incidentRepository; // Repository pour interagir avec la base de
    @Autowired // données
    private CIP_Input_RegularisationRepository input_regularisationRepository; // Repository pour interagir avec
                                                                               // la base de données

    public CIPDataUploadController() {

    }

    public boolean isAlphaOnly(String data) {
        return data.matches("[a-zA-Z']+");
    }

    public boolean isNumericOnly(String data) {
        return data.matches("\\d+");
    }

    @GetMapping("/upload")
    public String upload() {
        return "cip/upload_inputs";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Veuillez sélectionner un fichier.");
            return "redirect:/";
        }

        try {
            // Créer un répertoire temporaire pour extraire les fichiers zip
            File tempDir = Files.createTempDirectory("temp-dir").toFile();

            // Copier le fichier zip dans le répertoire temporaire
            File zipFile = new File(tempDir, file.getOriginalFilename());
            try (OutputStream os = new FileOutputStream(zipFile)) {
                os.write(file.getBytes());
            }

            // Extraire le fichier zip
            unzipFile(zipFile, tempDir);

            // Parcourir les fichiers extraits
            File[] extractedFiles = tempDir.listFiles();
            if (extractedFiles != null) {
                for (File extractedFile : extractedFiles) {
                    if (extractedFile.getName().endsWith(".txt")) {
                        // Charger les données du fichier texte dans la table MySQL
                        loadDataIntoDatabase(extractedFile);
                    }
                }
            }

            redirectAttributes.addFlashAttribute("message", "Le fichier a été traité avec succès.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Une erreur s'est produite lors du traitement du fichier.");
        }

        return "redirect:/";
    }

    private void unzipFile(File zipFile, File destDir) throws IOException {
        byte[] buffer = new byte[1024];
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = new File(destDir, zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    newFile.getParentFile().mkdirs();
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                zis.closeEntry();
                zipEntry = zis.getNextEntry();
            }
        }
    }

    private void loadDataIntoDatabase(File file) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
        // Insérer les données dans la table MySQL à l'aide de votre repository ou de
        // votre service approprié
        // Exemple : dataRepository.save(new Data(content));
        // Assurez-vous de configurer correctement votre connexion MySQL dans le fichier
        // application.properties
    }

    @GetMapping("/listFiles")
    public List<String> listFilesInDirectory(@RequestParam("directory") String directoryPath) {
        List<String> fileList = new ArrayList<>();

        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileList.add(file.getName());
                    }
                }
            }

            return fileList;
        } catch (Exception e) {
            // Gérer les erreurs de votre choix
            return fileList;
        }
    }
}
