  // search-box open close js code
    jQuery(document).ready(function (){



      // Bind a onclick handler to ajax
   $('.ajax_lnk').click(function() {
   
      $("#main-container").load(this.href);
      //put a loading image in the target element
    $("#main-container").html("<p class='display:flex; align-items:center; justify-content:center;'> "+
    "<img src='../img/loading.gif'/></p>");
    $("#main-container").load(this.href);


    return false;   // Prevent triggering the default handler
 });




/*
  // Bind submit button onclick handler to send an Ajax request and
   //  process Ajax response.
   $(':submit').click(function (event) {
    event.preventDefault();  // Do not run the default action
    var submittedMessage = $(':text[name="message"]').val();
    $.ajax({
       type: 'POST',
       url:  "",
       data: { message: submittedMessage }
    })
       .done( function (responseText) {
          // Triggered if response status code is 200 (OK)
          $('#message').html('Your message is: ' + responseText);
       })
       .fail( function (jqXHR, status, error) {
          // Triggered if response status code is NOT 200 (OK)
          alert(jqXHR.responseText);
       })
       .always( function() {
          // Always run after .done() or .fail()
          $('p:first').after('<p>Thank you.</p>');
       });
 });


*/

	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	

    });