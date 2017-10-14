function iAgreeCookie(){
	$.ajax({
		'url' : 'index.jsp',
		'type' : 'GET',
		'data' : {'c' : 'c'},
		'dataType' : 'html',
		'success' : function(data){
			
		}
	});
	pgb_close_status();
	return false;
}