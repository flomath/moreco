
// onLoad
var rootUrl = 'http://localhost:8080/moreco/overview/';

$.ajax({
	type: 'GET',
	url: rootURL,
	dataType: "json",
	success: function(data,, textStatus, jqXHR) {
    var list = data == null ? [] : (data instanceof Array ? data : [data]);
  	$.each(list, function(index, record) {
  		$('#Table tbody').append('<tr><td>' + record.ID + '</td><td>' + record.Description + '</td><td>' + record.Start + '</td><td>' + record.End + '</td></tr>');
  	});
  }
});
