$(document).ready(function(){
	var checkEmail = function(event){
		var email = $('#email').val();
		$.ajax({
			'url' : 'index.jsp',
			'type' : 'GET',
			'data' : {'m' : $('#modEncryptedName').val(), 'o' : $('#actionEncryptedName').val(), 'email' : email},
			'dataType' : 'html',
			'success' : function(data){
				if(data != null && data.trim() != ""){
<<<<<<< HEAD
					$('#email').addClass('textZoneError');
=======
					$('#email').removeClass('textZoneError').addClass('textZoneError');
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
					$('#form-email-group').removeClass('has-error').addClass('has-error');
				}else{
					$('#email').removeClass('textZoneError');
					$('#form-email-group').removeClass('has-error');
				}
				$('#emailError').html(data.trim());
			}
		});
	};
	
	$('#email').change(checkEmail).keyup(checkEmail);
	
	var checkLogin = function(event){
		var login = $('#login').val();
		$.ajax({
			'url' : 'index.jsp',
			'type' : 'GET',
			'data' : {'m' : $('#modEncryptedName').val(), 'o' : $('#actionEncryptedName').val(), 'login' : login},
			'dataType' : 'html',
			'success' : function(data){
				if(data != null && data.trim() != ""){
<<<<<<< HEAD
					$('#login').addClass('textZoneError');
=======
					$('#login').removeClass('textZoneError').addClass('textZoneError');
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
					$('#form-login-group').removeClass('has-error').addClass('has-error');
				}else{
					$('#login').removeClass('textZoneError');
					$('#form-login-group').removeClass('has-error');
				}
				$('#loginError').html(data);
			}
		});
	};
	
	$('#login').change(checkLogin).keyup(checkLogin);
	
	var checkPass = function(event){
		var pass = $('#pass').val();
		$.ajax({
			'url' : 'index.jsp',
			'type' : 'GET',
			'data' : {'m' : $('#modEncryptedName').val(), 'o' : $('#actionEncryptedName').val(), 'pass' : pass},
			'dataType' : 'html',
			'success' : function(data){
				if(data != null && data.trim() != ""){
<<<<<<< HEAD
					$('#pass').addClass('textZoneError');
=======
					$('#pass').removeClass('textZoneError').addClass('textZoneError');
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
					$('#form-pass-group').removeClass('has-error').addClass('has-error');
				}else{
					$('#pass').removeClass('textZoneError');
					$('#form-pass-group').removeClass('has-error');
					checkConfirmPass();
				}
				$('#passError').html(data);
			}
		});
	};
	
	$('#pass').change(checkPass).keyup(checkPass);
	
	var checkConfirmPass = function(event){
		var confirmPass = $('#confirmPass').val();
		var pass = $('#pass').val();
		var mess = '';
		if(confirmPass !== pass){
<<<<<<< HEAD
			$('#confirmPass').addClass('textZoneError');
=======
			$('#confirmPass').removeClass('textZoneError').addClass('textZoneError');
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			$('#form-confirm-pass-group').removeClass('has-error').addClass('has-error');
			mess = $('#wrongConfirmPass').val();
		}else{
			$('#confirmPass').removeClass('textZoneError');
			$('#form-confirm-pass-group').removeClass('has-error');
		}
		$('#confirmPassError').html(mess);
	};
	
	$('#confirmPass').change(checkConfirmPass).keyup(checkConfirmPass);
	
	checkEmail();
	checkLogin();
	checkPass();
	checkConfirmPass();
	
	$('#regForm form').submit(function(event){
		checkEmail();
		checkLogin();
		checkPass();
		checkConfirmPass();
		if($(this).find('.textZoneError').val())
			return false;
	});
});