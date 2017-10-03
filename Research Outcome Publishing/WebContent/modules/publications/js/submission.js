$(document).ready(function(){
	var displayJournalOrConf = function(event){
		var selectedValue = $('#paperType').val();
		if(selectedValue === 'Journal'){
			$('#pub_journal_line').fadeIn(500);
			$('#pub_conference_line').fadeOut(50);
			return;
		}
		$('#pub_journal_line').fadeOut(50);
		$('#pub_conference_line').fadeIn(500);
	};
	
	$('#paperType').change(displayJournalOrConf);
	
	displayJournalOrConf();
	
	$('#approveGTU').click(function(event){
		if($(this).attr('checked'))
			$(this).attr('checked', null);
		else
			$(this).attr('checked', 'checked');
	});
	
	$('#subApproveGTUForm form').submit(function(event){
		var error = false;
		if($('#pub_no_author').html()){
			$('#addAuthorError').fadeOut(10).fadeIn(500);
			error = true;
		}
		if($('#approveGTU').attr('checked')){}
		else{
			$('#approveGTUFormError').fadeOut(10).fadeIn(500);
			error = true;
		}
		if(error === true) 
			return false;
		return true;
	});
	
	var checkName = function(event){
		var name = $('#subAddAuthorForm form #name').val();
		if(name == null || name.trim() === ''){
			$('#subAddAuthorForm form #form-name-group').removeClass('has-error').addClass('has-error');
			$('#subAddAuthorForm form #nameError').html($('#subAddAuthorForm form #addAuthorNameError').val());
			return false;
		}
		$('#subAddAuthorForm form #form-name-group').removeClass('has-error');
		$('#subAddAuthorForm form #nameError').html('');
		return name;
	};
	
	$('#subAddAuthorForm form #name').change(checkName);
	
	var checkInstitution = function(event){
		var institution = $('#subAddAuthorForm form #institution').val();
		if(institution == null || institution.trim() === ''){
			$('#subAddAuthorForm form #form-institution-group').removeClass('has-error').addClass('has-error');
			$('#subAddAuthorForm form #institutionError').html($('#subAddAuthorForm form #addAuthorInstitutionError').val());
			return false;
		}
		$('#subAddAuthorForm form #form-institution-group').removeClass('has-error');
		$('#subAddAuthorForm form #institutionError').html('');
		return institution;
	};
	
	$('#subAddAuthorForm form #institution').change(checkInstitution);
	
	var checkEmail = function(event){
		var email = $('#subAddAuthorForm form #email').val();
		if(email == null || email.trim() === '' || !/[a-zA-Z_][a-zA-Z0-9_-]{2,}@[a-zA-Z0-9_-]{2,}/.test(email)){
			$('#subAddAuthorForm form #form-email-group').removeClass('has-error').addClass('has-error');
			$('#subAddAuthorForm form #emailError').html($('#subAddAuthorForm form #addAuthorEmailError').val());
			return false;
		}
		$('#subAddAuthorForm form #form-email-group').removeClass('has-error');
		$('#subAddAuthorForm form #emailError').html('');
		return email;
	};
	
	$('#subAddAuthorForm form #email').change(checkEmail);
	
	var checkIsPrincipal = function(event){
		var isPrincipal = $('#subAddAuthorForm form #isPrincipal').attr('checked') ? 'on' : 'off';
		return isPrincipal;
	};
	
	$('#subAddAuthorForm form #isPrincipal').click(function(event){
		if($(this).attr('checked'))
			$(this).attr('checked', null);
		else
			$(this).attr('checked', 'checked');
	});
	
	$('#subAddAuthorForm .modal-footer input.auth_button').click(function(event){
		var name = checkName();
		var institution = checkInstitution();
		var email = checkEmail();
		var isPrincipal = checkIsPrincipal();
		if(name && institution && email && isPrincipal){
			$.ajax({
				'url' : $('#subAddAuthorForm form').attr('action'),
				'type' : 'POST',
				'data' : {'name' : name, 'email' : email, 'institution' : institution, 'isPrincipal' : isPrincipal},
				'dataType' : 'html',
				'success' : function(data){
					if(data != null && data.trim() != ""){
						$('#subAuthorData').html(data);
					}
					$('#subLoadingZone').fadeOut(10);
				}
			});
			$('#subAddAuthorForm').modal('hide');
			$('#subLoadingZone').fadeIn(10);
			return true;
		}
		return false;
	});
	
	
	
	//Add referree
	var checkRefName = function(event){
		var name = $('#subAddRefereeForm form #name').val();
		if(name == null || name.trim() === ''){
			$('#subAddRefereeForm form #form-name-group').removeClass('has-error').addClass('has-error');
			$('#subAddRefereeForm form #nameError').html($('#subAddRefereeForm form #addRefereeNameError').val());
			return false;
		}
		$('#subAddRefereeForm form #form-name-group').removeClass('has-error');
		$('#subAddRefereeForm form #nameError').html('');
		return name;
	};
	
	$('#subAddRefereeForm form #name').change(checkRefName);
	
	var checkRefInstitution = function(event){
		var institution = $('#subAddRefereeForm form #institution').val();
		if(institution == null || institution.trim() === ''){
			$('#subAddRefereeForm form #form-institution-group').removeClass('has-error').addClass('has-error');
			$('#subAddRefereeForm form #institutionError').html($('#subAddRefereeForm form #addRefereeInstitutionError').val());
			return false;
		}
		$('#subAddRefereeForm form #form-institution-group').removeClass('has-error');
		$('#subAddRefereeForm form #institutionError').html('');
		return institution;
	};
	
	$('#subAddRefereeForm form #institution').change(checkRefInstitution);
	
	var checkRefEmail = function(event){
		var email = $('#subAddRefereeForm form #email').val();
		if(email == null || email.trim() === '' || !/[a-zA-Z_][a-zA-Z0-9_-]{2,}@[a-zA-Z0-9_-]{2,}/.test(email)){
			$('#subAddRefereeForm form #form-email-group').removeClass('has-error').addClass('has-error');
			$('#subAddRefereeForm form #emailError').html($('#subAddRefereeForm form #addRefereeEmailError').val());
			return false;
		}
		$('#subAddRefereeForm form #form-email-group').removeClass('has-error');
		$('#subAddRefereeForm form #emailError').html('');
		return email;
	};
	
	$('#subAddRefereeForm form #email').change(checkRefEmail);
	
	var checkRefMotivation = function(event){
		var motivation = $('#subAddRefereeForm form #motivation').val();
		if(motivation == null || motivation.trim() === ''){
			$('#subAddRefereeForm form #form-motivation-group').removeClass('has-error').addClass('has-error');
			$('#subAddRefereeForm form #motivationError').html($('#subAddRefereeForm form #addRefereeMotivationError').val());
			return false;
		}
		$('#subAddRefereeForm form #form-motivation-group').removeClass('has-error');
		$('#subAddRefereeForm form #motivationError').html('');
		return motivation;
	};
	
	$('#subAddRefereeForm form #motivation').change(checkRefMotivation);
	
	$('#subAddRefereeForm .modal-footer input.auth_button').click(function(event){
		var name = checkRefName();
		var institution = checkRefInstitution();
		var email = checkRefEmail();
		var motivation = checkRefMotivation();
		if(name && institution && email && motivation){
			$.ajax({
				'url' : $('#subAddRefereeForm form').attr('action'),
				'type' : 'POST',
				'data' : {'name' : name, 'email' : email, 'institution' : institution, 'motivation' : motivation},
				'dataType' : 'html',
				'success' : function(data){
					if(data != null && data.trim() != ""){
						$('#subRefereeData').html(data);
					}
					$('#subLoadingZone').fadeOut(10);
				}
			});
			$('#subAddRefereeForm').modal('hide');
			$('#subLoadingZone').fadeIn(10);
			return true;
		}
		return false;
	});
});