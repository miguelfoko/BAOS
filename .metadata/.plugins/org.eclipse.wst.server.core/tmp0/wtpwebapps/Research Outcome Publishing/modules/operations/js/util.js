$(document).ready(function(){
	var checkAccount = function(event){
		$('.loader').addClass('loading');
		var num = $('.account').val();
		$.ajax({
			'url' : 'index.jsp',
			'type' : 'GET',
			'data' : {'module' : $('.modEncryptedName').val(), 'action' : $('.actionEncryptedName').val(), 'num' : num},
			'dataType' : 'html',
			'success' : function(data){
				$('#account').html(data);
				$('.loader').removeClass('loading');
			}
		});
	};
	
	$('.account').change(checkAccount).keyup(checkAccount);
	
	if($('.op').val() != '2'){
		$('.hidden').html($('.accountTo').html());
		$('.accountTo').css('display', 'none').html('');
	}
	
	$('.op').change(function(){
		if($('.op').val() == '2')
			$('.accountTo')
				.html($('.hidden').html())
				.fadeIn(1500);
		else{
			$('.hidden').html($('.accountTo').html());
			$('.accountTo')
				.fadeOut(800);
			setTimeout(function(){
				$('.accountTo').html('');
			}, 800);
		}
	});
});