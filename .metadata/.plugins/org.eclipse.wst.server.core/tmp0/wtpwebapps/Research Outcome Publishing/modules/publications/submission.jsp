<div class="row ui-state-active pub_no_border pub_sub_step_bar">
	<div class="col-md-2 <c:if test="${mod_pub_step == null || mod_pub_step == 1}">ui-state-hover pub-highlight</c:if>"><c:choose><c:when test="${mod_pub_step == null || mod_pub_step > 1}"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('select_journal')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_process_step_1', sessionScope.tag)}" /></a></c:when><c:otherwise><c:out value="${applicationScope.languageManager.getLanguageValue('pub_process_step_1', sessionScope.tag)}" /></c:otherwise></c:choose></div>
	<div class="col-md-2 <c:if test="${mod_pub_step != null && mod_pub_step == 2}">ui-state-hover pub-highlight</c:if>"><c:choose><c:when test="${mod_pub_step == null || mod_pub_step > 2}"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('add_authors')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_process_step_2', sessionScope.tag)}" /></a></c:when><c:otherwise><c:out value="${applicationScope.languageManager.getLanguageValue('pub_process_step_2', sessionScope.tag)}" /></c:otherwise></c:choose></div>
	<div class="col-md-2 <c:if test="${mod_pub_step != null && mod_pub_step == 3}">ui-state-hover pub-highlight</c:if>"><c:choose><c:when test="${mod_pub_step == null || mod_pub_step > 3}"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('add_referees_editors')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_process_step_3', sessionScope.tag)}" /></a></c:when><c:otherwise><c:out value="${applicationScope.languageManager.getLanguageValue('pub_process_step_3', sessionScope.tag)}" /></c:otherwise></c:choose></div>
	<div class="col-md-2 <c:if test="${mod_pub_step != null && mod_pub_step == 4}">ui-state-hover pub-highlight</c:if>"><c:choose><c:when test="${mod_pub_step == null || mod_pub_step > 4}"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('exclude_referees_editors')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_process_step_4', sessionScope.tag)}" /></a></c:when><c:otherwise><c:out value="${applicationScope.languageManager.getLanguageValue('pub_process_step_4', sessionScope.tag)}" /></c:otherwise></c:choose></div>
	<div class="col-md-2 <c:if test="${mod_pub_step != null && mod_pub_step == 5}">ui-state-hover pub-highlight</c:if>"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_process_step_5', sessionScope.tag)}" /></div>
	<div id="subLoadingZone" class="col-md-1 pull-right" style="display: none;"><img src="<c:url value="/ressources/images/loading4.gif" />" alt="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_loading', sessionScope.tag)}" />" /></div>
</div>
<c:choose>
	<c:when test="${mod_pub_step == null || mod_pub_step == 1}">
		<div id="subSelectJournalForm" class="row">
			<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('select_journal')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subSelectJournalForm" class="form col-md-12">
				<legend><c:out value="${applicationScope.languageManager.getLanguageValue('pub_select_journal_or_conf', sessionScope.tag)}" /></legend>
				<div class="form-group">
					<label class="auth_label control-label" for="login"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_type', sessionScope.tag)}" /></label>
					<select name="paperType" id="paperType" class="form-control">
						<option value="Journal" <c:if test="${(paperType != null && paperType.equals('Journal')) || (mod_pub_paper_type != null && mod_pub_paper_type.equals('Journal'))}">selected</c:if>><c:out value="${applicationScope.languageManager.getLanguageValue('pub_journal', sessionScope.tag)}" /></option>
						<option value="Conference" <c:if test="${(paperType != null && paperType.equals('Conference')) || (mod_pub_paper_type != null && mod_pub_paper_type.equals('Conference'))}">selected</c:if>><c:out value="${applicationScope.languageManager.getLanguageValue('pub_conf', sessionScope.tag)}" /></option>
					</select>
				</div>
				<div id="pub_journal_line" class="form-group" style="display:none;">
					<label class="auth_label control-label" for="pass"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_select_journal', sessionScope.tag)}" /></label>
					<select name="journal" id="journal" class="form-control">
						<c:forEach items="${mod_pub_journal_list}" var="joc">
							<c:if test="${joc.journalOrConfType.equals('Journal')}">
								<option value="<c:out value="${joc.journalOrConfId}" />" <c:if test="${(journal != null && journal == joc.journalOrConfId) || (mod_pub_journal_or_conf != null && mod_pub_journal_or_conf.equals(joc))}">selected</c:if>><c:out value="${joc.journalOrConfName}" /></option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div id="pub_conference_line" class="form-group" style="display:none;">
					<label class="auth_label control-label" for="pass"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_select_conf', sessionScope.tag)}" /></label>
					<select name="conference" id="conference" class="form-control">
						<c:forEach items="${mod_pub_journal_list}" var="joc">
							<c:if test="${joc.journalOrConfType.equals('Conference')}">
								<option value="<c:out value="${joc.journalOrConfId}" />" <c:if test="${(journal != null && journal == joc.journalOrConfId) || (mod_pub_journal_or_conf != null && mod_pub_journal_or_conf.equals(joc))}">selected</c:if>><c:out value="${joc.journalOrConfName}" /></option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<legend class="divider pub-divider"></legend>
				<div class="form-group pull-right">
					<input type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_reset', sessionScope.tag)}" />" class="auth_button btn btn-default" />
					<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_next', sessionScope.tag)}" />" class="auth_button btn btn-success" />
				</div>
			</form>
		</div>
	</c:when>
	<c:when test="${mod_pub_step != null && mod_pub_step == 2}">
		<div id="subAuthorData">
			<c:import url="/modules/publications/authors.jsp" />
		</div>
		<div class="pull-right sub_add_author_group">
			<button data-toggle="modal" href="#subAddAuthorForm" class="btn btn-primary"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_author', sessionScope.tag)}" /></button>
		</div>
		<div id="subApproveGTUForm" class="row pub-clearfix">
			<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('add_authors')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subApproveGTUForm" class="form col-md-12">
				<legend><c:out value="${applicationScope.languageManager.getLanguageValue('pub_approve_gtu', sessionScope.tag)}" /></legend>
				<div id="approveGTUFormError" class="row" style="display: none;">
					<div class="col-md-12">
						<div class="form-group alert alert-danger alert-dismissable">
							<c:out value="${applicationScope.languageManager.getLanguageValue('pub_approve_gtu_error', sessionScope.tag)}" />
						</div>
					</div>
				</div>
				<input type="hidden" id="pubSid" value="<c:out value="${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" />" />
				<div class="form-group">
					<input type="checkbox" name="approveGTU" id="approveGTU" <c:if test="${mod_pub_gtu_selected != null && mod_pub_gtu_selected}">checked</c:if> class="auth_checkbox" />
					<label class="auth_label auth_checkbox_label" for="approveGTU"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_i_approve', sessionScope.tag)}" /> <a href="#" target="_blank"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_gtu', sessionScope.tag)}" /></a></label>
				</div>
				<legend class="divider pub-divider"></legend>
				<div class="form-group pull-right">
					<a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('select_journal')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" class="auth_button btn btn-default"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_prev', sessionScope.tag)}" /></a>
					<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_next', sessionScope.tag)}" />" class="auth_button btn btn-success" />
				</div>
			</form>
		</div>
		<div id="subAddAuthorForm" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">x</button>
						<h4 class="modal-title"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_author', sessionScope.tag)}" /></h4>
					</div>
					<div class="modal-body">
						<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('add_author')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subAddAuthorForm" class="form">
							<div id="form-name-group" class="form-group <c:if test="${addAuthorNameError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="name"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_name', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="text" name="name" id="name" value="<c:out value="${param.name}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_name_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="nameError"><c:out value="${addAuthorNameError}" /></span>
								<input type="hidden" id="addAuthorNameError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_name_error', sessionScope.tag)}" />" />
							</div>
							<div id="form-email-group" class="form-group <c:if test="${addAuthorEmailError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="email"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_mail', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="email" name="email" id="email" value="<c:out value="${param.email}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_mail_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="emailError"><c:out value="${addAuthorEmailError}" /></span>
								<input type="hidden" id="addAuthorEmailError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_mail_error', sessionScope.tag)}" />" />
							</div>
							<div id="form-institution-group" class="form-group <c:if test="${addAuthorInstitutionError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="institution"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_institution', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="text" name="institution" id="institution" value="<c:out value="${param.institution}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_institution_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="institutionError"><c:out value="${addAuthorInstitutionError}" /></span>
								<input type="hidden" id="addAuthorInstitutionError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_author_institution_error', sessionScope.tag)}" />" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="isPrincipal" id="isPrincipal" class="auth_checkbox" />
								<label class="auth_label auth_checkbox_label" for="isPrincipal"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_set_principal_author', sessionScope.tag)}" /></label>
							</div>
						</form>
					</div>
					<div class="modal-footer" style="clear:both;">
						<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_author', sessionScope.tag)}" />" class="auth_button btn btn-success" />
					</div>
				</div>
			</div>
		</div>
	</c:when>
	<c:when test="${mod_pub_step != null && mod_pub_step == 3}">
		<div id="subRefereeData">
			<c:import url="/modules/publications/referees.jsp" />
		</div>
		<div class="pull-right sub_add_referee_group">
			<button data-toggle="modal" href="#subAddRefereeForm" class="btn btn-primary"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_request_referee', sessionScope.tag)}" /></button>
		</div>
		<div id="subAddRefereeRealForm" class="row pub-clearfix">
			<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('add_referees_editors')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subAddRefereeRealForm" class="form col-md-12">
				<legend class="divider pub-divider"></legend>
				<input type="hidden" id="pubSid" value="<c:out value="${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" />" />
				<div class="form-group pull-right">
					<a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('add_authors')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" class="auth_button btn btn-default"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_prev', sessionScope.tag)}" /></a>
					<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_next', sessionScope.tag)}" />" class="auth_button btn btn-success" />
				</div>
			</form>
		</div>
		<div id="subAddRefereeForm" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">x</button>
						<h4 class="modal-title"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_referee', sessionScope.tag)}" /></h4>
					</div>
					<div class="modal-body">
						<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('add_proposed_referee')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subAddRefereeForm" class="form">
							<div id="form-name-group" class="form-group <c:if test="${addRefereeNameError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="name"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_name', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="text" name="name" id="name" value="<c:out value="${param.name}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_name_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="nameError"><c:out value="${addRefereeNameError}" /></span>
								<input type="hidden" id="addRefereeNameError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_name_error', sessionScope.tag)}" />" />
							</div>
							<div id="form-email-group" class="form-group <c:if test="${addRefereeEmailError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="email"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_mail', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="email" name="email" id="email" value="<c:out value="${param.email}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_mail_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="emailError"><c:out value="${addRefereeEmailError}" /></span>
								<input type="hidden" id="addRefereeEmailError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_mail_error', sessionScope.tag)}" />" />
							</div>
							<div id="form-institution-group" class="form-group <c:if test="${addRefereeInstitutionError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="institution"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_institution', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="text" name="institution" id="institution" value="<c:out value="${param.institution}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_institution_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="institutionError"><c:out value="${addRefereeInstitutionError}" /></span>
								<input type="hidden" id="addRefereeInstitutionError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_institution_error', sessionScope.tag)}" />" />
							</div>
							<div id="form-motivation-group" class="form-group <c:if test="${addRefereeMotivationError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="motivation"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_motivation', sessionScope.tag)}" /><span class="required">*</span></label>
								<textarea name="motivation" id="motivation" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_referee_motivation_holder', sessionScope.tag)}" />"><c:out value="${param.motivation}" /></textarea>
								<span class="help-block" id="motivationError"><c:out value="${addRefereeMotivationError}" /></span>
								<input type="hidden" id="addRefereeMotivationError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_motivation_error', sessionScope.tag)}" />" />
							</div>
						</form>
					</div>
					<div class="modal-footer" style="clear:both;">
						<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_referee', sessionScope.tag)}" />" class="auth_button btn btn-success" />
					</div>
				</div>
			</div>
		</div>
	</c:when>
	<c:when test="${mod_pub_step != null && mod_pub_step == 4}">
		<div id="subRefereeData">
			<c:import url="/modules/publications/excl_referees.jsp" />
		</div>
		<div class="pull-right sub_add_referee_group">
			<button data-toggle="modal" href="#subAddRefereeForm" class="btn btn-primary"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_exclude_referee', sessionScope.tag)}" /></button>
		</div>
		<div id="subAddRefereeRealForm" class="row pub-clearfix">
			<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('exclude_referees_editors')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subAddRefereeRealForm" class="form col-md-12">
				<legend class="divider pub-divider"></legend>
				<input type="hidden" id="pubSid" value="<c:out value="${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" />" />
				<div class="form-group pull-right">
					<a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('add_referees_editors')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" class="auth_button btn btn-default"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_prev', sessionScope.tag)}" /></a>
					<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_next', sessionScope.tag)}" />" class="auth_button btn btn-success" />
				</div>
			</form>
		</div>
		<div id="subAddRefereeForm" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">x</button>
						<h4 class="modal-title"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_referee', sessionScope.tag)}" /></h4>
					</div>
					<div class="modal-body">
						<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('add_excluded_referee')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subAddRefereeForm" class="form">
							<div id="form-name-group" class="form-group <c:if test="${addRefereeNameError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="name"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_name', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="text" name="name" id="name" value="<c:out value="${param.name}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_name_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="nameError"><c:out value="${addRefereeNameError}" /></span>
								<input type="hidden" id="addRefereeNameError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_name_error', sessionScope.tag)}" />" />
							</div>
							<div id="form-email-group" class="form-group <c:if test="${addRefereeEmailError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="email"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_mail', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="email" name="email" id="email" value="<c:out value="${param.email}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_mail_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="emailError"><c:out value="${addRefereeEmailError}" /></span>
								<input type="hidden" id="addRefereeEmailError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_mail_error', sessionScope.tag)}" />" />
							</div>
							<div id="form-institution-group" class="form-group <c:if test="${addRefereeInstitutionError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="institution"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_institution', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="text" name="institution" id="institution" value="<c:out value="${param.institution}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_institution_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="institutionError"><c:out value="${addRefereeInstitutionError}" /></span>
								<input type="hidden" id="addRefereeInstitutionError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_referee_institution_error', sessionScope.tag)}" />" />
							</div>
							<div id="form-motivation-group" class="form-group <c:if test="${addRefereeMotivationError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="motivation"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_motivation', sessionScope.tag)}" /><span class="required">*</span></label>
								<textarea name="motivation" id="motivation" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_excl_referee_motivation_holder', sessionScope.tag)}" />"><c:out value="${param.motivation}" /></textarea>
								<span class="help-block" id="motivationError"><c:out value="${addRefereeMotivationError}" /></span>
								<input type="hidden" id="addRefereeMotivationError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_motivation_error', sessionScope.tag)}" />" />
							</div>
						</form>
					</div>
					<div class="modal-footer" style="clear:both;">
						<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_add_referee', sessionScope.tag)}" />" class="auth_button btn btn-success" />
					</div>
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div id="subUploadPaperForm" class="row">
			<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('upload_paper')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" name="subUploadPaperForm" class="form col-md-12">
				<legend><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_informations', sessionScope.tag)}" /></legend>
				<div id="form-title-group" class="form-group <c:if test="${addPaperTitleError != null}">has-error</c:if>">
					<label class="auth_label control-label" for="paperTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_title', sessionScope.tag)}" /><span class="required">*</span></label>
					<input type="text" name="paperTitle" id="paperTitle" value="<c:out value="${param.paperTitle}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_title_holder', sessionScope.tag)}" />" />
					<span class="help-block" id="paperTitleError"><c:out value="${addPaperTitleError}" /></span>
					<input type="hidden" id="addPaperTitleError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_title_error', sessionScope.tag)}" />" />
				</div>
				<div id="form-abstract-group" class="form-group <c:if test="${addPaperAbstractError != null}">has-error</c:if>">
					<label class="auth_label control-label" for="paperAbstract"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_abstract', sessionScope.tag)}" /><span class="required">*</span></label>
					<textarea name="paperAbstract" id="paperAbstract" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_abstract_holder', sessionScope.tag)}" />"><c:out value="${param.paperTitle}" /></textarea>
					<span class="help-block" id="paperAbstractError"><c:out value="${addPaperAbstractError}" /></span>
					<input type="hidden" id="addPaperAbstractError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_abstract_error', sessionScope.tag)}" />" />
				</div>
				<div id="form-keywords-group" class="form-group <c:if test="${addPaperKeywordsError != null}">has-error</c:if>">
					<label class="auth_label control-label" for="paperKeywords"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_keywords', sessionScope.tag)}" /><span class="required">*</span></label>
					<input type="text" name="paperKeywords" id="paperKeywords" value="<c:out value="${param.paperKeywords}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_keywords_holder', sessionScope.tag)}" />" />
					<span class="help-block" id="paperKeywordsError"><c:out value="${addPaperKeywordsError}" /></span>
					<input type="hidden" id="addPaperKeywordsError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_keywords_error', sessionScope.tag)}" />" />
				</div>
				
				<legend class="divider pub-divider"></legend>
				<div class="form-group pull-right">
					<a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('paperSubmission')}&pstep=${applicationScope.encryptor.encrypt('exclude_referees_editors')}&sid=${applicationScope.encryptor.encrypt(mod_pub_submission_id)}" class="auth_button btn btn-default"><c:out value="${applicationScope.languageManager.getLanguageValue('pub_prev', sessionScope.tag)}" /></a>
					<input type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_reset', sessionScope.tag)}" />" class="auth_button btn btn-default" />
					<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_validate_submission', sessionScope.tag)}" />" class="auth_button btn btn-success" />
				</div>
			</form>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				tinymce.init({
					selector: '#paperAbstract',
					menubar: 'edit format',
					autosave_interval: '20s',
					language: '<c:out value="${sessionScope.tag}" />',
					plugins: [
					          'autolink link spellchecker',
					          'wordcount',
					          'contextmenu paste textcolor'
					 ]
				});
			});
		</script>
	</c:otherwise>
</c:choose>