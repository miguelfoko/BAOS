$(document).ready(function(){
	var checkEmail = function(event){
		var email = $('#email').val();
		$.ajax({
			'url' : 'index.jsp',
			'type' : 'GET',
			'data' : {'m' : $('#modEncryptedName').val(), 'o' : $('#actionEncryptedName').val(), 'email' : email, 'echeck' : 'true'},
			'dataType' : 'html',
			'success' : function(data){
				if(data != null && data.trim() != "")
					$('#email').addClass('textZoneError');
				else
					$('#email').removeClass('textZoneError');
				$('#emailError').html(data.trim());
			}
		});
	};
	
	$('#email').change(checkEmail).keyup(checkLogin);
	
	var checkLogin = function(event){
		var login = $('#login').val();
		$.ajax({
			'url' : 'index.jsp',
			'type' : 'GET',
			'data' : {'m' : $('#modEncryptedName').val(), 'o' : $('#actionEncryptedName').val(), 'login' : login, 'echeck' : 'true'},
			'dataType' : 'html',
			'success' : function(data){
				if(data != null && data.trim() != "")
					$('#login').addClass('textZoneError');
				else
					$('#login').removeClass('textZoneError');
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
					if(data != null && data.trim() != "")
						$('#pass').addClass('textZoneError');
					else
						$('#pass').removeClass('textZoneError');
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
			$('#passError').html("");
		}else{
			var mess = '';
			if(confirmPass !== pass){
				$('#confirmPass').addClass('textZoneError');
				mess = $('#wrongConfirmPass').val();
			}else
				$('#confirmPass').removeClass('textZoneError');
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
		if($(this).find('.textZoneError').val())
			return false;
	});
	
	$('#avatarType').change(function(){
		if($('#avatarType').val() === 'classic')
			$('.avatar_file_line').fadeIn(250);
		else
			$('.avatar_file_line').fadeOut(250);
	});
});