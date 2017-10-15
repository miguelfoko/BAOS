function iAgreeCookie(successMessage){
	$.ajax({
		'url' : 'index.jsp',
		'type' : 'GET',
		'data' : {'c' : 'c'},
		'dataType' : 'html',
		'success' : function(data){
			alert(successMessage);
		}
	});
	return false;
}

function sendConfirmEmail(dataS, successMessage){
	$.ajax({
		'url' : 'index.jsp',
		'type' : 'GET',
		'data' : dataS,
		'dataType' : 'html',
		'success' : function(data){
			alert(successMessage);
		}
	});
	return false;
}