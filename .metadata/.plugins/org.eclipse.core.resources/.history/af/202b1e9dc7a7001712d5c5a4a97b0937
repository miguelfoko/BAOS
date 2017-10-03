$(document).ready(function(){
	var checkEmail = function(event){
		var email = $('#email').val();
		$.ajax({
			'url' : 'index.jsp',
			'type' : 'GET',
			'data' : {'m' : $('#modEncryptedName').val(), 'o' : $('#actionEncryptedName').val(), 'email' : email, 'echeck' : 'true'},
			'dataType' : 'html',
			'success' : function(data){
				if(data != null && data.trim() != ""){
					$('#email').removeClass('textZoneError').addClass('textZoneError');
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
			'data' : {'m' : $('#modEncryptedName').val(), 'o' : $('#actionEncryptedName').val(), 'login' : login, 'echeck' : 'true'},
			'dataType' : 'html',
			'success' : function(data){
				if(data != null && data.trim() != ""){
					$('#login').removeClass('textZoneError').addClass('textZoneError');
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
					if(data != null && data.trim() != ""){
						$('#pass').removeClass('textZoneError').addClass('textZoneError');
						$('#form-pass-group').removeClass('has-error').addClass('has-error');
					}else{
						$('#pass').removeClass('textZoneError');
						$('#form-pass-group').removeClass('has-error');
						checkConfirmPass();
					}
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
			$('#form-confirm-pass-group').removeClass('has-error');
			$('#passError').html("");
		}else{
			var mess = '';
			if(confirmPass !== pass){
				$('#confirmPass').removeClass('textZoneError').addClass('textZoneError');
				$('#form-confirm-pass-group').removeClass('has-error').addClass('has-error');
				mess = $('#wrongConfirmPass').val();
			}else{
				$('#confirmPass').removeClass('textZoneError');
				$('#form-confirm-pass-group').removeClass('has-error');
			}
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
		var imageData = $('.auth_image_editor').cropit('export');
	    $('.auth-hidden-image-data').val(imageData);
		if($(this).find('.textZoneError').val())
			return false;
	});
	
	$('#avatarType').change(function(){
		if($('#avatarType').val() === 'classic')
			$('.avatar_file_line').fadeIn(250);
		else
			$('.avatar_file_line').fadeOut(250);
	});
	
	$('.auth_image_editor').cropit();
});