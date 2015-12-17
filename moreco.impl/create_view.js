var rootUrl = 'http://localhost:8080/moreco/create/';

function onSubmit() {
  $.ajax({
       type: 'POST',
       contentType: 'application/json',
       url: rootUrl,
       dataType: "json",
       data: formToJSON(),
       success: function(data, textStatus, jqXHR){
           alert('A new record was added.');
       },
       error: function(jqXHR, textStatus, errorThrown){
           alert('onSubmit error: ' + textStatus);
       }
   });
}

function formToJSON() {
  return JSON.stringify({
      "User": $('#User').val(),
      "Description": $('#Description').val(),
      "Start": $('#Start').val(),
      "End": $('#End').val()
      });
}
