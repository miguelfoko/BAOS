$(document).ready(function(){
	var checkEmail = function(event){
		var email = $('#email').val();
		$.ajax({
			'url' : 'index.jsp',
			'type' : 'GET',
			'data' : {'m' : $('#modEncryptedName').val(), 'o' : $('#actionEncryptedName').val(), 'email' : email, 'echeck' : 'true'},
			'dataType' : 'html',
			'success' : function(data){
<<<<<<< HEAD
				if(data != null && data.trim() != "")
					$('#email').addClass('textZoneError');
				else
					$('#email').removeClass('textZoneError');
=======
				if(data != null && data.trim() != ""){
					$('#email').removeClass('textZoneError').addClass('textZoneError');
					$('#form-email-group').removeClass('has-error').addClass('has-error');
				}else{
					$('#email').removeClass('textZoneError');
					$('#form-email-group').removeClass('has-error');
				}
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
				$('#emailError').html(data.trim());
			}
		});
	};
	
<<<<<<< HEAD
	$('#email').change(checkEmail).keyup(checkLogin);
=======
	$('#email').change(checkEmail).keyup(checkEmail);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	
	var checkLogin = function(event){
		var login = $('#login').val();
		$.ajax({
			'url' : 'index.jsp',
			'type' : 'GET',
			'data' : {'m' : $('#modEncryptedName').val(), 'o' : $('#actionEncryptedName').val(), 'login' : login, 'echeck' : 'true'},
			'dataType' : 'html',
			'success' : function(data){
<<<<<<< HEAD
				if(data != null && data.trim() != "")
					$('#login').addClass('textZoneError');
				else
					$('#login').removeClass('textZoneError');
=======
				if(data != null && data.trim() != ""){
					$('#login').removeClass('textZoneError').addClass('textZoneError');
					$('#form-login-group').removeClass('has-error').addClass('has-error');
				}else{
					$('#login').removeClass('textZoneError');
					$('#form-login-group').removeClass('has-error');
				}
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
				$('#loginError').html(data);
			}
		});
	};
	
	$('#login').change(checkLogin).keyup(checkLogin);
	
	var checkPass = function(event){
		var pass = $('#pass').val();
		var confirmPass = $('#confirmPass').val();
		if(pass.trim() == "" && confirmPass.trim() == "" && $('#pass').attr('required') == null){
			$('#prevpass').attr('required', null);
			$('#pass').removeClass('textZoneError');
			$('#passError').html("");
		}else{
			$('#prevpass').attr('required', 'required');
			$.ajax({
				'url' : 'index.jsp',
				'type' : 'GET',
				'data' : {'m' : $('#modEncryptedName').val(), 'o' : $('#actionEncryptedName').val(), 'pass' : pass, 'echeck' : 'true'},
				'dataType' : 'html',
				'success' : function(data){
<<<<<<< HEAD
					if(data != null && data.trim() != "")
						$('#pass').addClass('textZoneError');
					else
						$('#pass').removeClass('textZoneError');
=======
					if(data != null && data.trim() != ""){
						$('#pass').removeClass('textZoneError').addClass('textZoneError');
						$('#form-pass-group').removeClass('has-error').addClass('has-error');
					}else{
						$('#pass').removeClass('textZoneError');
						$('#form-pass-group').removeClass('has-error');
						checkConfirmPass();
					}
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
					$('#passError').html(data);
				}
			});
		}
	};
	
	$('#pass').change(checkPass).keyup(checkPass);
	
	var checkPrevPass = function(event){
		var prevpass = $('#prevpass').val();
		if(prevpass.trim() == "")
			$('#pass, #confirmPass').attr('required', null);
		else
			$('#pass, #confirmPass').attr('required', 'required');
		checkPass(event);
	};
	
	$('#prevpass').change(checkPrevPass);
	
	var checkConfirmPass = function(event){
		var pass = $('#pass').val();
		var confirmPass = $('#confirmPass').val();
		if(pass.trim() == "" && confirmPass.trim() == "" && $('#pass').attr('required') == null){
			$('#prevpass').attr('required', null);
			$('#pass').removeClass('textZoneError');
<<<<<<< HEAD
=======
			$('#form-confirm-pass-group').removeClass('has-error');
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			$('#passError').html("");
		}else{
			var mess = '';
			if(confirmPass !== pass){
<<<<<<< HEAD
				$('#confirmPass').addClass('textZoneError');
				mess = $('#wrongConfirmPass').val();
			}else
				$('#confirmPass').removeClass('textZoneError');
=======
				$('#confirmPass').removeClass('textZoneError').addClass('textZoneError');
				$('#form-confirm-pass-group').removeClass('has-error').addClass('has-error');
				mess = $('#wrongConfirmPass').val();
			}else{
				$('#confirmPass').removeClass('textZoneError');
				$('#form-confirm-pass-group').removeClass('has-error');
			}
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			$('#confirmPassError').html(mess);
		}
	};
	
	$('#confirmPass').change(checkConfirmPass).keyup(checkConfirmPass);
	
	var countBioWords = function(event){
		var limit = 600;
		var val = $('#biography').val().length;
		if(val >= limit){
			$('#biography').val($('#biography').val().substr(0, limit));
			$('#biographyCounter').html("0 "+($('#counterText').val()));
			//$('#biography').attr('disabled', 'disabled');
		}else{
			$('#biographyCounter').html((limit - val)+" "+($('#counterText').val()));
			//$('#biography').attr('disabled', null);
		}
	};
	
	$('#biography').change(countBioWords).keydown(countBioWords).keyup(countBioWords);
	
	checkEmail();
	checkLogin();
	checkPass();
	countBioWords();
	checkConfirmPass();
	
	$('#mod_auth_tab_edit_profile form').submit(function(event){
		checkEmail();
		checkLogin();
		checkPass();
		checkConfirmPass();
<<<<<<< HEAD
=======
		var imageData = $('.auth_image_editor').cropit('export');
	    $('.auth-hidden-image-data').val(imageData);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		if($(this).find('.textZoneError').val())
			return false;
	});
	
	$('#avatarType').change(function(){
		if($('#avatarType').val() === 'classic')
			$('.avatar_file_line').fadeIn(250);
		else
			$('.avatar_file_line').fadeOut(250);
	});
<<<<<<< HEAD
=======
	
	//$('.auth_image_editor').cropit();
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
});