
  $(document).ready(function () {



    $(".alert").click(function () {
      $(this).hide( "fade", 1000 );
    });


    function showSuccessAlert(message) {
      $(".alert-success").html(message);
      $(".alert-success").show( "fade", 1000 );
      $(".alert-success").fadeTo(2000, 500).slideUp(500, function(){
        $(".alert-success").slideUp(500);
      });
    }
  
    function showErrorAlert(message) {

      $(".alert").html(message);
      $(".alert").show( "fade", 1000 );
      $(".alert").fadeTo(2000, 500).slideUp(500, function(){
        $(".alert").slideUp(500);
      });
    }


    
  

    
      // Bind a onclick handler to ajax
   $('#add_new_data').click(function(e) {
    //e.preventDefault();

    var loc = $(this).data('href');
    var titre = $(this).data('titre');
    var largeur = $(this).data('width');
    var hauteur = $(this).data('height');
    
    $("#form_zone").load(loc);


    $("#form_zone").dialog({
      modal: true,
      title: titre,
      width: largeur,
      height: hauteur,
      buttons: [
      {
          id: "Cancel",
          text: "Fermer",
          click: function () {
              $(this).dialog('close');
          }
      }
      ]
  });

 });


 
	// Select/Deselect checkboxes
	var checkbox = $('#table_data tbody input[type="checkbox"]');

	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});

  
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});



      $('#table_data').DataTable({
        dom: 'Bfrtip',
        keys: true,
        scrollY: 500,
        scrollX: false,
        scrollCollapse: true,
        paging: true,
        pagingType: "full_numbers",
        fixedHeader: true,
        language: {
        // url: '//cdn.datatables.net/plug-ins/1.10.20/i18n/French.json',
        url: '../locale/fr_FR.json',
        buttons: {
          copyTitle: 'Copie effectuée dans le presse-papier',
          copySuccess: {
            _: '%d lignes copiées',
            1: '1 ligne copiée'
          }
        }},
        responsive: true,

        fixedColumns: {
          leftColumns: 2,
          rightColumns: 1
        },
        buttons: [

        /*  {
            text: '<span><i class="fa fa-file-csv">Nouveau</i></span>',
            action: function ( e, dt, node, config ) {
                alert( 'Button activated' );
            }
        },
        */
          {
            extend: 'copy',
            text: '<i class="fa fa-copy"></i> Copie',
            titleAttr: 'Copier',
            className: 'btn btn-secondary btn-sm'
          },
          {
            extend: 'csv',
            text: '<i class="fa fa-file-csv"></i> CSV',
            titleAttr: 'Exporter en CSV',
            className: 'btn btn-secondary btn-sm'
          },
          {
            extend: 'excel',
            text: '<i class="fa fa-file-excel"></i> Excel',
            titleAttr: 'Exporter en Excel',
            className: 'btn btn-secondary btn-sm'
          },
          {
            extend: 'pdf',
            text: '<i class="fa fa-file-pdf"></i> PDF',
            titleAttr: 'Exporter en PDF',
            className: 'btn btn-secondary btn-sm'
          },
          {
            extend: 'print',
            text: '<i class="fa fa-print"></i> Imprimer',
            titleAttr: 'Imprimer',
            className: 'btn btn-secondary btn-sm'
          },
          {
            extend: 'colvis',
            text: '<i class="fa fa-eye"></i>',
            titleAttr: 'Colvis',
            className: 'btn btn-secondary btn-sm'
          }
        ]
      });
  });
  