<c:choose>
	<c:when test="${mod_pub_referees != null && !empty mod_pub_referees}">
		<div id="pub_referees" class="row">
			<div class="col-md-12 table-responsive">
				<table class="table table-striped table-bordered table-condensed pub_table">
					<thead>
						<tr>
							<th class="col-md-3"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_name', sessionScope.tag)}" /></th>
							<th class="col-md-2"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_institution', sessionScope.tag)}" /></th>
							<th class="col-md-2"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_mail', sessionScope.tag)}" /></th>
							<th class="col-md-3"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_motivation', sessionScope.tag)}" /></th>
							<th class="col-md-2"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_actions', sessionScope.tag)}" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mod_pub_referees}" var="referee">
							<tr>
								<td class="col-md-3"><c:out value="${referee.name}" /></td>
								<td class="col-md-2"><c:out value="${referee.institution}" /></td>
								<td class="col-md-2"><c:out value="${referee.email}" /></td>
								<td class="col-md-3"><c:out value="${referee.motivation}" escapeXml="false" /></td>
								<td class="col-md-2">
									<div class="btn-group">
										<button data-toggle="modal" href="#subEditRefereeForm<c:out value="${referee.refereeId}" />" class="btn btn-sm btn-default" title="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_edit_referee', sessionScope.tag)}" />"><span class="glyphicon glyphicon-pencil"></span></button>
										<button id="subDeleteReferee<c:out value="${referee.refereeId}" />" class="btn btn-sm btn-danger" title="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_delete_referee', sessionScope.tag)}" />"><span class="glyphicon glyphicon-remove"></span></button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<c:forEach items="${mod_pub_referees}" var="referee">
				<div id="subEditRefereeForm<c:out value="${referee.refereeId}" />" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">x</button>
								<h4 class="modal-title"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_edit_referee', sessionScope.tag)}" /></h4>
							</div>
							<div class="modal-body">
								<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('edit_proposed_referee')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subEditRefereeForm<c:out value="${referee.refereeId}" />" class="form">
									<div id="form-name-group" class="form-group">
										<label class="auth_label control-label" for="name<c:out value="${referee.refereeId}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_name', sessionScope.tag)}" /><span class="required">*</span></label>
										<input type="text" name="name<c:out value="${referee.refereeId}" />" id="name<c:out value="${referee.refereeId}" />" value="<c:out value="${referee.name}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_name_holder', sessionScope.tag)}" />" />
										<span class="help-block" id="nameError<c:out value="${referee.refereeId}" />"></span>
										<input type="hidden" id="editRefereeNameError<c:out value="${referee.refereeId}" />" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_name_error', sessionScope.tag)}" />" />
									</div>
									<div id="form-email-group" class="form-group">
										<label class="auth_label control-label" for="email<c:out value="${referee.refereeId}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_mail', sessionScope.tag)}" /><span class="required">*</span></label>
										<input type="email" name="email<c:out value="${referee.refereeId}" />" id="email<c:out value="${referee.refereeId}" />" value="<c:out value="${referee.email}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_mail_holder', sessionScope.tag)}" />" />
										<span class="help-block" id="emailError<c:out value="${referee.refereeId}" />"></span>
										<input type="hidden" id="editRefereeEmailError<c:out value="${referee.refereeId}" />" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_mail_error', sessionScope.tag)}" />" />
									</div>
									<div id="form-institution-group" class="form-group">
										<label class="auth_label control-label" for="institution<c:out value="${referee.refereeId}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_institution', sessionScope.tag)}" /><span class="required">*</span></label>
										<input type="text" name="institution<c:out value="${referee.refereeId}" />" id="institution<c:out value="${referee.refereeId}" />" value="<c:out value="${referee.institution}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_institution_holder', sessionScope.tag)}" />" />
										<span class="help-block" id="institutionError<c:out value="${referee.refereeId}" />"></span>
										<input type="hidden" id="editRefereeInstitutionError<c:out value="${referee.refereeId}" />" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_institution_error', sessionScope.tag)}" />" />
									</div>
									<div id="form-motivation-group" class="form-group <c:if test="${addRefereeMotivationError != null}">has-error</c:if>">
										<label class="auth_label control-label" for="motivation<c:out value="${referee.refereeId}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_motivation', sessionScope.tag)}" /><span class="required">*</span></label>
										<textarea name="motivation<c:out value="${referee.refereeId}" />" id="motivation<c:out value="${referee.refereeId}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_referee_motivation_holder', sessionScope.tag)}" />"><c:out value="${referee.motivation}" /></textarea>
										<span class="help-block" id="motivationError<c:out value="${referee.refereeId}" />"><c:out value="${addRefereeMotivationError}" /></span>
										<input type="hidden" id="addRefereeMotivationError<c:out value="${referee.refereeId}" />" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_motivation_error', sessionScope.tag)}" />" />
									</div>
								</form>
							</div>
							<div class="modal-footer" style="clear:both;">
								<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_edit_referee', sessionScope.tag)}" />" class="auth_button btn btn-success" />
							</div>
						</div>
					</div>
				</div>
				<script type="text/javascript">
					$(document).ready(function(){
						var checkName<c:out value="${referee.refereeId}" /> = function(event){
							var name = $('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #name<c:out value="${referee.refereeId}" />').val();
							if(name == null || name.trim() === ''){
								$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #form-name-group').removeClass('has-error').addClass('has-error');
								$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #nameError<c:out value="${referee.refereeId}" />').html($('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #editRefereeNameError<c:out value="${referee.refereeId}" />').val());
								return false;
							}
							$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #form-name-group').removeClass('has-error');
							$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #nameError<c:out value="${referee.refereeId}" />').html('');
							return name;
						};
						
						$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #name<c:out value="${referee.refereeId}" />').change(checkName<c:out value="${referee.refereeId}" />);
						
						var checkInstitution<c:out value="${referee.refereeId}" /> = function(event){
							var institution = $('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #institution<c:out value="${referee.refereeId}" />').val();
							if(institution == null || institution.trim() === ''){
								$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #form-institution-group').removeClass('has-error').addClass('has-error');
								$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #institutionError<c:out value="${referee.refereeId}" />').html($('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #editRefereeInstitutionError<c:out value="${referee.refereeId}" />').val());
								return false;
							}
							$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #form-institution-group').removeClass('has-error');
							$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #institutionError<c:out value="${referee.refereeId}" />').html('');
							return institution;
						};
						
						$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #institution<c:out value="${referee.refereeId}" />').change(checkInstitution<c:out value="${referee.refereeId}" />);
						
						var checkEmail<c:out value="${referee.refereeId}" /> = function(event){
							var email = $('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #email<c:out value="${referee.refereeId}" />').val();
							if(email == null || email.trim() === '' || !/[a-zA-Z_][a-zA-Z0-9_-]{2,}@[a-zA-Z0-9_-]{2,}/.test(email)){
								$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #form-email-group').removeClass('has-error').addClass('has-error');
								$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #emailError<c:out value="${referee.refereeId}" />').html($('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #editRefereeEmailError<c:out value="${referee.refereeId}" />').val());
								return false;
							}
							$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #form-email-group').removeClass('has-error');
							$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #emailError<c:out value="${referee.refereeId}" />').html('');
							return email;
						};
						
						$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #email<c:out value="${referee.refereeId}" />').change(checkEmail<c:out value="${referee.refereeId}" />);
						
						var checkMotivation<c:out value="${referee.refereeId}" /> = function(event){
							var motivation = $('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #motivation<c:out value="${referee.refereeId}" />').val();
							if(motivation == null || motivation.trim() === ''){
								$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #form-motivation-group').removeClass('has-error').addClass('has-error');
								$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #motivationError<c:out value="${referee.refereeId}" />').html($('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #addRefereeMotivationError<c:out value="${referee.refereeId}" />').val());
								return false;
							}
							$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #form-motivation-group').removeClass('has-error');
							$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #motivationError<c:out value="${referee.refereeId}" />').html('');
							return motivation;
						};
						
						$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form #motivation<c:out value="${referee.refereeId}" />').change(checkMotivation<c:out value="${referee.refereeId}" />);
						
						$('#subEditRefereeForm<c:out value="${referee.refereeId}" /> .modal-footer input.auth_button').click(function(event){
							var refereeId = <c:out value="${referee.refereeId}" />;
							var name = checkName<c:out value="${referee.refereeId}" />();
							var institution = checkInstitution<c:out value="${referee.refereeId}" />();
							var email = checkEmail<c:out value="${referee.refereeId}" />();
							var motivation = checkMotivation<c:out value="${referee.refereeId}" />();
							if(name && institution && email && motivation){
								$.ajax({
									'url' : $('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form').attr('action'),
									'type' : 'POST',
									'data' : {'refereeId' : refereeId, 'name' : name, 'email' : email, 'institution' : institution, 'motivation' : motivation},
									'dataType' : 'html',
									'success' : function(data){
										if(data != null && data.trim() != ""){
											$('#subRefereeData').html(data);
										}
										$('#subLoadingZone').fadeOut(10);
									}
								});
								$('#subEditRefereeForm<c:out value="${referee.refereeId}" />').modal('hide');
								$('#subLoadingZone').fadeIn(10);
								return true;
							}
							return false;
						});
						
						var deleteReferee<c:out value="${referee.refereeId}" /> = function(event){
							var refereeId = <c:out value="${referee.refereeId}" />;
							$.ajax({
								'url' : $('#subEditRefereeForm<c:out value="${referee.refereeId}" /> form').attr('action'),
								'type' : 'POST',
								'data' : {'refereeId' : refereeId, 'delete' : true},
								'dataType' : 'html',
								'success' : function(data){
									if(data != null && data.trim() != ""){
										$('#subRefereeData').html(data);
									}
									$('#subLoadingZone').fadeOut(10);
								}
							});
							$('#subEditRefereeForm<c:out value="${referee.refereeId}" />').modal('hide');
							$('#subLoadingZone').fadeIn(10);
							return true;
						};
						
						$('#subDeleteReferee<c:out value="${referee.refereeId}" />').click(deleteReferee<c:out value="${referee.refereeId}" />);
					});
				</script>
			</c:forEach>
		</div>
	</c:when>
	<c:otherwise>
		<div id="pub_no_referee" class="row">
			<div class="col-md-12 text-center">
				<span><c:out value="${applicationScope.languageManager.getLanguageValue('pub_no_referee_proposal', sessionScope.tag)}" /></span>
			</div>
		</div>
	</c:otherwise>
</c:choose>