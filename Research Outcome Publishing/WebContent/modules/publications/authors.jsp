<c:choose>
	<c:when test="${mod_pub_authors != null && !empty mod_pub_authors}">
		<div id="pub_authors" class="row">
			<div class="col-md-12 table-responsive">
				<table class="table table-striped table-bordered table-condensed pub_table">
					<thead>
						<tr>
							<th class="col-md-3"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_name', sessionScope.tag)}" /></th>
							<th class="col-md-3"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_institution', sessionScope.tag)}" /></th>
							<th class="col-md-3"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_mail', sessionScope.tag)}" /></th>
							<th class="col-md-1"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_is_principal', sessionScope.tag)}" /></th>
							<th class="col-md-2"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_actions', sessionScope.tag)}" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mod_pub_authors}" var="author">
							<tr>
								<td class="col-md-3"><c:out value="${author.name}" /></td>
								<td class="col-md-3"><c:out value="${author.institution}" /></td>
								<td class="col-md-3"><c:out value="${author.email}" /></td>
								<td class="col-md-1"><span style="color: rgb(76, 175, 80);" class="glyphicon glyphicon-<c:if test="${author.principal}">check</c:if>"></span></td>
								<td class="col-md-2">
									<div class="btn-group">
										<button data-toggle="modal" href="#subEditAuthorForm<c:out value="${author.authorId}" />" class="btn btn-sm btn-default" title="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_edit_author', sessionScope.tag)}" />"><span class="glyphicon glyphicon-pencil"></span></button>
										<button id="subMarkAsPrincipal<c:out value="${author.authorId}" />" class="btn btn-sm btn-default" title="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_set_principal_author', sessionScope.tag)}" />"><span class="glyphicon glyphicon-check"></span></button>
										<button id="subDeleteAuthor<c:out value="${author.authorId}" />" class="btn btn-sm btn-danger" title="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_delete_author', sessionScope.tag)}" />"><span class="glyphicon glyphicon-remove"></span></button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<c:forEach items="${mod_pub_authors}" var="author">
				<div id="subEditAuthorForm<c:out value="${author.authorId}" />" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">x</button>
								<h4 class="modal-title"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_edit_author', sessionScope.tag)}" /></h4>
							</div>
							<div class="modal-body">
								<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('edit_author')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subEditAuthorForm<c:out value="${author.authorId}" />" class="form">
									<div id="form-name-group" class="form-group">
										<label class="auth_label control-label" for="name<c:out value="${author.authorId}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_name', sessionScope.tag)}" /><span class="required">*</span></label>
										<input type="text" name="name<c:out value="${author.authorId}" />" id="name<c:out value="${author.authorId}" />" value="<c:out value="${author.name}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_name_holder', sessionScope.tag)}" />" />
										<span class="help-block" id="nameError<c:out value="${author.authorId}" />"></span>
										<input type="hidden" id="editAuthorNameError<c:out value="${author.authorId}" />" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_name_error', sessionScope.tag)}" />" />
									</div>
									<div id="form-email-group" class="form-group">
										<label class="auth_label control-label" for="email<c:out value="${author.authorId}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_mail', sessionScope.tag)}" /><span class="required">*</span></label>
										<input type="email" name="email<c:out value="${author.authorId}" />" id="email<c:out value="${author.authorId}" />" value="<c:out value="${author.email}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_mail_holder', sessionScope.tag)}" />" />
										<span class="help-block" id="emailError<c:out value="${author.authorId}" />"></span>
										<input type="hidden" id="editAuthorEmailError<c:out value="${author.authorId}" />" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_mail_error', sessionScope.tag)}" />" />
									</div>
									<div id="form-institution-group" class="form-group">
										<label class="auth_label control-label" for="institution<c:out value="${author.authorId}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_institution', sessionScope.tag)}" /><span class="required">*</span></label>
										<input type="text" name="institution<c:out value="${author.authorId}" />" id="institution<c:out value="${author.authorId}" />" value="<c:out value="${author.institution}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_institution_holder', sessionScope.tag)}" />" />
										<span class="help-block" id="institutionError<c:out value="${author.authorId}" />"></span>
										<input type="hidden" id="editAuthorInstitutionError<c:out value="${author.authorId}" />" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_institution_error', sessionScope.tag)}" />" />
									</div>
									<div class="form-group">
										<input type="checkbox" name="isPrincipal<c:out value="${author.authorId}" />" id="isPrincipal<c:out value="${author.authorId}" />" <c:if test="${author.principal}">checked</c:if> class="auth_checkbox" />
										<label class="auth_label auth_checkbox_label" for="isPrincipal<c:out value="${author.authorId}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_set_principal_author', sessionScope.tag)}" /></label>
									</div>
								</form>
							</div>
							<div class="modal-footer" style="clear:both;">
								<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_edit_author', sessionScope.tag)}" />" class="auth_button btn btn-success" />
							</div>
						</div>
					</div>
				</div>
				<script type="text/javascript">
					$(document).ready(function(){
						var checkName<c:out value="${author.authorId}" /> = function(event){
							var name = $('#subEditAuthorForm<c:out value="${author.authorId}" /> form #name<c:out value="${author.authorId}" />').val();
							if(name == null || name.trim() === ''){
								$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #form-name-group').removeClass('has-error').addClass('has-error');
								$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #nameError<c:out value="${author.authorId}" />').html($('#subEditAuthorForm<c:out value="${author.authorId}" /> form #editAuthorNameError<c:out value="${author.authorId}" />').val());
								return false;
							}
							$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #form-name-group').removeClass('has-error');
							$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #nameError<c:out value="${author.authorId}" />').html('');
							return name;
						};
						
						$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #name<c:out value="${author.authorId}" />').change(checkName<c:out value="${author.authorId}" />);
						
						var checkInstitution<c:out value="${author.authorId}" /> = function(event){
							var institution = $('#subEditAuthorForm<c:out value="${author.authorId}" /> form #institution<c:out value="${author.authorId}" />').val();
							if(institution == null || institution.trim() === ''){
								$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #form-institution-group').removeClass('has-error').addClass('has-error');
								$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #institutionError<c:out value="${author.authorId}" />').html($('#subEditAuthorForm<c:out value="${author.authorId}" /> form #editAuthorInstitutionError<c:out value="${author.authorId}" />').val());
								return false;
							}
							$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #form-institution-group').removeClass('has-error');
							$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #institutionError<c:out value="${author.authorId}" />').html('');
							return institution;
						};
						
						$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #institution<c:out value="${author.authorId}" />').change(checkInstitution<c:out value="${author.authorId}" />);
						
						var checkEmail<c:out value="${author.authorId}" /> = function(event){
							var email = $('#subEditAuthorForm<c:out value="${author.authorId}" /> form #email<c:out value="${author.authorId}" />').val();
							if(email == null || email.trim() === '' || !/[a-zA-Z_][a-zA-Z0-9_-]{2,}@[a-zA-Z0-9_-]{2,}/.test(email)){
								$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #form-email-group').removeClass('has-error').addClass('has-error');
								$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #emailError<c:out value="${author.authorId}" />').html($('#subEditAuthorForm<c:out value="${author.authorId}" /> form #editAuthorEmailError<c:out value="${author.authorId}" />').val());
								return false;
							}
							$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #form-email-group').removeClass('has-error');
							$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #emailError<c:out value="${author.authorId}" />').html('');
							return email;
						};
						
						$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #email<c:out value="${author.authorId}" />').change(checkEmail<c:out value="${author.authorId}" />);
						
						var checkIsPrincipal<c:out value="${author.authorId}" /> = function(event){
							var isPrincipal = $('#subEditAuthorForm<c:out value="${author.authorId}" /> form #isPrincipal<c:out value="${author.authorId}" />').attr('checked') ? 'on' : 'off';
							return isPrincipal;
						};
						
						$('#subEditAuthorForm<c:out value="${author.authorId}" /> form #isPrincipal<c:out value="${author.authorId}" />').click(function(event){
							if($(this).attr('checked'))
								$(this).attr('checked', null);
							else
								$(this).attr('checked', 'checked');
						});
						
						$('#subEditAuthorForm<c:out value="${author.authorId}" /> .modal-footer input.auth_button').click(function(event){
							var authorId = <c:out value="${author.authorId}" />;
							var name = checkName<c:out value="${author.authorId}" />();
							var institution = checkInstitution<c:out value="${author.authorId}" />();
							var email = checkEmail<c:out value="${author.authorId}" />();
							var isPrincipal = checkIsPrincipal<c:out value="${author.authorId}" />();
							if(name && institution && email && isPrincipal){
								$.ajax({
									'url' : $('#subEditAuthorForm<c:out value="${author.authorId}" /> form').attr('action'),
									'type' : 'POST',
									'data' : {'authorId' : authorId, 'name' : name, 'email' : email, 'institution' : institution, 'isPrincipal' : isPrincipal},
									'dataType' : 'html',
									'success' : function(data){
										if(data != null && data.trim() != ""){
											$('#subAuthorData').html(data);
										}
										$('#subLoadingZone').fadeOut(10);
									}
								});
								$('#subEditAuthorForm<c:out value="${author.authorId}" />').modal('hide');
								$('#subLoadingZone').fadeIn(10);
								return true;
							}
							return false;
						});
						
						var markAsPrincipal<c:out value="${author.authorId}" /> = function(event){
							var authorId = <c:out value="${author.authorId}" />;
							$.ajax({
								'url' : $('#subEditAuthorForm<c:out value="${author.authorId}" /> form').attr('action'),
								'type' : 'POST',
								'data' : {'authorId' : authorId, 'markAsPrincipal' : true},
								'dataType' : 'html',
								'success' : function(data){
									if(data != null && data.trim() != ""){
										$('#subAuthorData').html(data);
									}
									$('#subLoadingZone').fadeOut(10);
								}
							});
							$('#subEditAuthorForm<c:out value="${author.authorId}" />').modal('hide');
							$('#subLoadingZone').fadeIn(10);
							return true;
						};
						
						$('#subMarkAsPrincipal<c:out value="${author.authorId}" />').click(markAsPrincipal<c:out value="${author.authorId}" />);
						
						var deleteAuthor<c:out value="${author.authorId}" /> = function(event){
							var authorId = <c:out value="${author.authorId}" />;
							$.ajax({
								'url' : $('#subEditAuthorForm<c:out value="${author.authorId}" /> form').attr('action'),
								'type' : 'POST',
								'data' : {'authorId' : authorId, 'delete' : true},
								'dataType' : 'html',
								'success' : function(data){
									if(data != null && data.trim() != ""){
										$('#subAuthorData').html(data);
									}
									$('#subLoadingZone').fadeOut(10);
								}
							});
							$('#subEditAuthorForm<c:out value="${author.authorId}" />').modal('hide');
							$('#subLoadingZone').fadeIn(10);
							return true;
						};
						
						$('#subDeleteAuthor<c:out value="${author.authorId}" />').click(deleteAuthor<c:out value="${author.authorId}" />);
					});
				</script>
			</c:forEach>
		</div>
	</c:when>
	<c:otherwise>
		<div id="pub_no_author" class="row">
			<div id="addAuthorError" class="col-md-12" style="display: none;">
				<div class="form-group alert alert-danger alert-dismissable">
					<c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_author_error', sessionScope.tag)}" />
				</div>
			</div>
			<div class="col-md-12 text-center">
				<span><c:out value="${applicationScope.languageManager.getLanguageValue('pub_no_author_select', sessionScope.tag)}" /></span>
			</div>
		</div>
	</c:otherwise>
</c:choose>