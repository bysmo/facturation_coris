  $(document).ready(function () {


    // Bind submit button onclick handler to send an Ajax request and
   //  process Ajax response.
   $('#edit_form').submit(function (event) {
    event.preventDefault();  // Do not run the default action
    var submittedMessage = "OK";
    //$(':text[name="message"]').val();

    var xhref = $(this).attr('action');
    var data_to_send =  $(this).serialize();

    alert(data_to_send + " " + xhref);

    $.ajax({
       type: 'POST',
       url:  xhref,
       dataType: "json",
       data: data_to_send, // serializes the form's elements
       success: function(retour){
          alert(retour);
          $('#form_zone').html(retour);
        }
    });

 });  



  });