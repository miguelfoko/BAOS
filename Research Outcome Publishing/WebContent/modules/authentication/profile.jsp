<c:choose>
	<c:when test="${baoUser != null}">
		<div id="mod_auth_tabs">
			<c:set var="notification_tab_url" value="#mod_auth_tab_notification" />
			<c:set var="research_summary_tab_url" value="#mod_auth_tab_research_summary" />
			<c:set var="courses_summary_tab_url" value="#mod_auth_tab_courses_summary" />
			<c:if test="${mod_auth_active_tab != 3}">
				<c:set var="notification_tab_url">
					<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('notification-ajax')}" />
				</c:set>
			</c:if>
			<c:if test="${mod_auth_active_tab != 4}">
				<c:set var="research_summary_tab_url">
					<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('research-ajax')}" />
				</c:set>
			</c:if>
			<c:if test="${mod_auth_active_tab != 5}">
				<c:set var="courses_summary_tab_url">
					<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('courses-ajax')}" />
				</c:set>
			</c:if>
			<ul class="row">
				<li class="col-md-2">
					<a href="#mod_auth_tab_profile" title="">
						<c:out value="${applicationScope.languageManager.getLanguageValue('profile_title', sessionScope.tag)}" />
					</a>
				</li>
				<li class="col-md-2">
					<a id="mod_auth_tab_edit_profile_link" href="#mod_auth_tab_edit_profile" title="">
						<c:out value="${applicationScope.languageManager.getLanguageValue('edit_profile', sessionScope.tag)}" />
					</a>
				</li>
				<li class="col-md-2">
					<a href="<c:out value="${notification_tab_url}" />" title="">
						<c:out value="${applicationScope.languageManager.getLanguageValue('auth_notification', sessionScope.tag)}" />
						<span class="badge baos-notification-badge pgb-background-red">2</span>
					</a>
				</li>
				<li class="col-md-2">
					<a href="<c:out value="${research_summary_tab_url}" />" title="">
						<c:out value="${applicationScope.languageManager.getLanguageValue('auth_research_summary', sessionScope.tag)}" />
					</a>
				</li>
				<li class="col-md-2">
					<a href="<c:out value="${courses_summary_tab_url}" />" title="">
						<c:out value="${applicationScope.languageManager.getLanguageValue('auth_courses_summary', sessionScope.tag)}" />
					</a>
				</li>
			</ul>
			<div id="mod_auth_tab_profile" class="mod_auth_tab">
				<div class="row">
					<div class="col-md-6">
						<div class="col-md-12">
							<div class="row text-center">
								<c:choose>
									<c:when test="${baoUser.additionalInfoId.userAvatar != null || baoUser.additionalInfoId.userAvatarType == 'gravatar'}">
										<c:choose>
											<c:when test="${baoUser.additionalInfoId.userAvatarType == 'gravatar' || baoUser.additionalInfoId.userAvatarType == null}">
												<img src="https://www.gravatar.com/avatar/<c:out value="${applicationScope.encryptor.md5HexEmail(baoUser.userEmail)}?s=120" />" alt="Gravatar" />
											</c:when>
											<c:otherwise>
												<img src="<c:url value="/ressources/images/avatars/${baoUser.additionalInfoId.userAvatar}" />" alt="Avatar" />
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<img src="<c:url value="/ressources/images/avatars/default.png" />" alt="Avatar" />
									</c:otherwise>
								</c:choose>
							</div>
							<div class="row">
								<div class="col-md-9">
									<span><c:out value="${baoUser.userSurname} ${baoUser.userName} (${baoUser.userLogin})" /></span>
								</div>
								<div class="col-md-3 pull-right">
									<a class="btn btn-danger" href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('logout')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('logout_title', sessionScope.tag)}" /></a>
								</div>
							</div>
						</div>
						<fieldset class="col-md-12">
							<legend><c:out value="${applicationScope.languageManager.getLanguageValue('auth_basic_infos', sessionScope.tag)}" /></legend>
							<div class="row">
								<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_email', sessionScope.tag)}:" /></b></span></div>
								<div class="col-md-9"><span><c:out value="${baoUser.userEmail}" /></span></div>
							</div>
							<c:if test="${baoUser.userBirthday != null}">
								<div class="row">
									<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_birthday', sessionScope.tag)}:" /></b></span></div>
									<div class="col-md-9"><span><c:out value="${baoUser.userBirthday}" /></span></div>
								</div>
							</c:if>
							<c:if test="${baoUser.userBiography != null}">
								<div class="row">
									<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_biography', sessionScope.tag)}:" /></b></span></div>
									<div class="col-md-9"><span><c:out value="${baoUser.userBiography}" /></span></div>
								</div>
							</c:if>
						</fieldset>
					</div>
					<div class="col-md-6">
						<fieldset class="col-md-12">
							<legend><c:out value="${applicationScope.languageManager.getLanguageValue('auth_additional_infos', sessionScope.tag)}" /></legend>
							<c:choose>
								<c:when test="${baoUser.additionalInfoId.userDefaultLanguage != null}">
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_default_language', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="${baoUser.additionalInfoId.userDefaultLanguage}" /></span></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_default_language', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="<em>${applicationScope.languageManager.getLanguageValue('auth_not_set', sessionScope.tag)}</em>" escapeXml="false" /></span></div>
									</div>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${baoUser.additionalInfoId.userCurrentWork != null}">
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_current_work', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="${baoUser.additionalInfoId.userCurrentWork}" /></span></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_current_work', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="<em>${applicationScope.languageManager.getLanguageValue('auth_not_set', sessionScope.tag)}</em>" escapeXml="false" /></span></div>
									</div>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${baoUser.additionalInfoId.userCurrentInstitution != null}">
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_current_institution', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="${baoUser.additionalInfoId.userCurrentInstitution}" /></span></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_current_institution', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="<em>${applicationScope.languageManager.getLanguageValue('auth_not_set', sessionScope.tag)}</em>" escapeXml="false" /></span></div>
									</div>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${baoUser.additionalInfoId.userPhoneNumber != null}">
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_phone_number', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="${baoUser.additionalInfoId.userPhoneNumber}" /></span></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_phone_number', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="<em>${applicationScope.languageManager.getLanguageValue('auth_not_set', sessionScope.tag)}</em>" escapeXml="false" /></span></div>
									</div>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${baoUser.additionalInfoId.userFacebookAccount != null}">
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_facebook_account', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="${baoUser.additionalInfoId.userFacebookAccount}" /></span></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_facebook_account', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="<em>${applicationScope.languageManager.getLanguageValue('auth_not_set', sessionScope.tag)}</em>" escapeXml="false" /></span></div>
									</div>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${baoUser.additionalInfoId.userTwitterAccount != null}">
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_twitter_account', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="${baoUser.additionalInfoId.userTwitterAccount}" /></span></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_twitter_account', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="<em>${applicationScope.languageManager.getLanguageValue('auth_not_set', sessionScope.tag)}</em>" escapeXml="false" /></span></div>
									</div>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${baoUser.additionalInfoId.userLinkedinAccount != null}">
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_linkedin_account', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="${baoUser.additionalInfoId.userLinkedinAccount}" /></span></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_linkedin_account', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="<em>${applicationScope.languageManager.getLanguageValue('auth_not_set', sessionScope.tag)}</em>" escapeXml="false" /></span></div>
									</div>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${baoUser.additionalInfoId.userWebsiteUrl != null}">
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_website_url', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="${baoUser.additionalInfoId.userWebsiteUrl}" /></span></div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="row">
										<div class="col-md-3"><span><b><c:out value="${applicationScope.languageManager.getLanguageValue('auth_website_url', sessionScope.tag)}:" /></b></span></div>
										<div class="col-md-9"><span><c:out value="<em>${applicationScope.languageManager.getLanguageValue('auth_not_set', sessionScope.tag)}</em>" escapeXml="false" /></span></div>
									</div>
								</c:otherwise>
							</c:choose>
						</fieldset>
						<div class="row">
							<div class="col-md-12 text-right">
								<a class="baosButton btn btn-default auth_edit_profile_button" href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('edit-profile')}" />"><span class="glyphicon glyphicon-edit"></span> <c:out value="${applicationScope.languageManager.getLanguageValue('edit_profile', sessionScope.tag)}" /></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="mod_auth_tab_edit_profile" class="mod_auth_tab">
				<div class="row">
					<form enctype="multipart/form-data" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('edit-profile')}" />" method="post" class="form col-md-12">
						<c:if test="${editProfileError != null}">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group alert alert-danger alert-dismissable">
										<button type="button" class="close" data-dismiss="alert"><span class="glyphicon glyphicon-remove"></span></button>
										<c:out value="${editProfileError}" />
									</div>
								</div>
							</div>
						</c:if>
						<input type="hidden" id="modEncryptedName" value="<c:out value="${applicationScope.encryptor.encrypt('authentication')}" />" />
						<input type="hidden" id="actionEncryptedName" value="<c:out value="${applicationScope.encryptor.encrypt('check')}" />" />
						<input type="hidden" id="counterText" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_counter_text', sessionScope.tag)}" />" />
						<input type="hidden" id="wrongConfirmPass" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_wrong_confirm_pass', sessionScope.tag)}" />" />
						<input type="hidden" id="userId" name="userId" value="<c:out value="${applicationScope.encryptor.encrypt(baoUser.userId)}" />" />
						<fieldset class="mod_auth_tab_block col-md-6">
							<legend class="title"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_basic_infos', sessionScope.tag)}" /></legend>
							<div class="form-group">
								<label class="auth_label" for="surname"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_surname', sessionScope.tag)}" /></label>
								<input type="text" name="surname" id="surname" value="<c:out value="${param.surname != null ? param.surname : baoUser.userSurname}" />" class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_surname_holder', sessionScope.tag)}" />" />
							</div>
							<div id="form-name-group" class="form-group <c:if test="${editProfileNameError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="name"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_name', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="text" name="name" id="name" value="<c:out value="${param.name != null ? param.name : baoUser.userName}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_name_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="nameError"><c:out value="${editProfileNameError}" /></span>
							</div>
							<div id="form-login-group" class="form-group <c:if test="${editProfileLoginError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="login"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_login', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="text" name="login" id="login" value="<c:out value="${param.login != null ? param.login : baoUser.userLogin}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_login_holder_2', sessionScope.tag)}" />" />
								<span class="help-block" id="loginError"><c:out value="${editProfileLoginError}" /></span>
							</div>
							<div id="form-email-group" class="form-group <c:if test="${editProfileEmailError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="email"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_email', sessionScope.tag)}" /><span class="required">*</span></label>
								<input type="email" name="email" id="email" value="<c:out value="${param.email != null ? param.email : baoUser.userEmail}" />" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_email_holder', sessionScope.tag)}" />" />
								<span class="help-block" id="emailError"><c:out value="${editProfileEmailError}" /></span>
							</div>
							<div id="form-prevpass-group" class="form-group <c:if test="${editProfilePrevpassError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="prevpass"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_prevpass', sessionScope.tag)}" /></label>
								<input type="password" name="prevpass" id="prevpass" class="auth_text_zone form-control" />
								<span class="help-block" id="prevpassError"><c:out value="${editProfilePrevpassError}" /></span>
							</div>
							<div id="form-pass-group" class="form-group <c:if test="${editProfilePassError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="pass"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_pass', sessionScope.tag)}" /></label>
								<input type="password" name="pass" id="pass" class="auth_text_zone form-control" />
								<span class="help-block" id="passError"><c:out value="${editProfilePassError}" /></span>
							</div>
							<div id="form-confirm-pass-group" class="form-group <c:if test="${editProfileConfirmPassError != null}">has-error</c:if>">
								<label class="auth_label control-label" for="confirmPass"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_confirm_pass', sessionScope.tag)}" /></label>
								<input type="password" name="confirmPass" id="confirmPass" class="auth_text_zone form-control" />
								<span class="help-block" id="confirmPassError"><c:out value="${editProfileConfirmPassError}" /></span>
							</div>
							<div class="form-group">
								<label class="auth_label" for="biography"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_biography', sessionScope.tag)}" /></label><br />
								<textarea name="biography" id="biography" class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_biography_holder', sessionScope.tag)}" />"><c:out value="${param.biography != null ? param.biography : baoUser.userBiography}" /></textarea>
								<span class="help-block counter" id="biographyCounter"></span>
							</div>
						</fieldset>
						<fieldset class="mod_auth_tab_block col-md-6">
							<legend class="title"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_additional_infos', sessionScope.tag)}" /></legend>
							<div class="form-group">
								<label class="auth_label form-label" for="avatarType"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_avatar_type', sessionScope.tag)}" /></label>
								<select name="avatarType" id="avatarType" class="form-control">
									<option value="gravatar" <c:if test="${(avatarType != null && avatarType.equals('gravatar')) || baoUser.additionalInfoId.userAvatarType == null || baoUser.additionalInfoId.userAvatarType.equals('gravatar')}">selected</c:if>><c:out value="${applicationScope.languageManager.getLanguageValue('auth_avatar_type_gravatar', sessionScope.tag)}" /></option>
									<option value="classic" <c:if test="${(avatarType != null && avatarType.equals('classic')) || (baoUser.additionalInfoId.userAvatarType != null && baoUser.additionalInfoId.userAvatarType.equals('classic'))}">selected</c:if>><c:out value="${applicationScope.languageManager.getLanguageValue('auth_avatar_type_classic', sessionScope.tag)}" /></option>
								</select>
							</div>
							<div class="form-group avatar_file_line <c:if test="${editProfileAvatarFileError != null}">has-error</c:if>" style="display:<c:out value="${(avatarType != null && avatarType.equals('gravatar')) || baoUser.additionalInfoId.userAvatarType == null || baoUser.additionalInfoId.userAvatarType.equals('gravatar') ? 'none' : 'block'};" />">
								<label class="auth_label form-label" for="avatarFile"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_avatar_file', sessionScope.tag)}" /></label>
								<input type="file" name="avatarFile" id="avatarFile" class="auth_text_zone form-control" />
								<span class="help-block" id="avatarFileError"><c:out value="${editProfileConfirmPassError}" /></span>
							</div>
							<div class="form-group">
								<label class="auth_label form-label" for="defaultLang"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_default_language', sessionScope.tag)}" /></label>
								<select name="defaultLang" id="defaultLang" class="form-control">
									<option value="auth_defaultLang"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_select_lang', sessionScope.tag)}" /></option>
									<c:forEach var="langName" items="${applicationScope.configManager.getLangNames()}">
										<option value="${langName}" <c:if test="${langName.equals(baoUser.additionalInfoId.userDefaultLanguage)}">selected</c:if>><c:out value="${langName}" /></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label class="auth_label form-label" for="currentWork"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_current_work', sessionScope.tag)}" /></label>
								<input type="text" name="currentWork" id="currentWork" value="<c:out value="${param.currentWork != null ? param.currentWork : baoUser.additionalInfoId.userCurrentWork}" />" class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_current_work_holder', sessionScope.tag)}" />" />
							</div>
							<div class="form-group">
								<label class="auth_label form-label" for="currentInstitution"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_current_institution', sessionScope.tag)}" /></label>
								<input type="text" name="currentInstitution" id="currentInstitution" value="<c:out value="${param.currentInstitution != null ? param.currentInstitution : baoUser.additionalInfoId.userCurrentInstitution}" />" class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_current_institution_holder', sessionScope.tag)}" />" />
							</div>
							<div class="form-group">
								<label class="auth_label form-label" for="phoneNumber"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_phone_number', sessionScope.tag)}" /></label>
								<input type="tel" name="phoneNumber" id="phoneNumber" value="<c:out value="${param.phoneNumber != null ? param.phoneNumber : baoUser.additionalInfoId.userPhoneNumber}" />" class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_phone_number_holder', sessionScope.tag)}" />" />
							</div>
							<div class="form-group">
								<label class="auth_label form-label" for="facebookAccount"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_facebook_account', sessionScope.tag)}" /></label>
								<input type="text" name="facebookAccount" id="facebookAccount" value="<c:out value="${param.facebookAccount != null ? param.facebookAccount : baoUser.additionalInfoId.userFacebookAccount}" />" class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_facebook_account_holder', sessionScope.tag)}" />" />
							</div>
							<div class="form-group">
								<label class="auth_label form-label" for="twitterAccount"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_twitter_account', sessionScope.tag)}" /></label>
								<input type="text" name="twitterAccount" id="twitterAccount" value="<c:out value="${param.twitterAccount != null ? param.twitterAccount : baoUser.additionalInfoId.userTwitterAccount}" />" class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_twitter_account_holder', sessionScope.tag)}" />" />
							</div>
							<div class="form-group">
								<label class="auth_label form-label" for="linkedinAccount"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_linkedin_account', sessionScope.tag)}" /></label>
								<input type="text" name="linkedinAccount" id="linkedinAccount" value="<c:out value="${param.linkedinAccount != null ? param.linkedinAccount : baoUser.additionalInfoId.userLinkedinAccount}" />" class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_linkedin_account_holder', sessionScope.tag)}" />" />
							</div>
							<div class="form-group">
								<label class="auth_label form-label" for="websiteUrl"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_website_url', sessionScope.tag)}" /></label>
								<input type="text" name="websiteUrl" id="websiteUrl" value="<c:out value="${param.websiteUrl != null ? param.websiteUrl : baoUser.additionalInfoId.userWebsiteUrl}" />" class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_website_url_holder', sessionScope.tag)}" />" />
							</div>
						</fieldset>
						<div class="form-group pull-right">
							<input type="submit" class="auth_button btn btn-success" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_save_profile', sessionScope.tag)}" />" />
							<input type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_reset', sessionScope.tag)}" />" class="auth_button btn btn-default" />
						</div>
					</form>
				</div>
			</div>
			<c:if test="${mod_auth_active_tab == 3}">
				<div id="mod_auth_tab_notification" class="mod_auth_tab">
					<c:import url="/modules/authentication/notification.jsp" />
				</div>
			</c:if>
			<c:if test="${mod_auth_active_tab == 4}">
				<div id="mod_auth_tab_research_summary" class="mod_auth_tab">
					<c:import url="/modules/authentication/research.jsp" />
				</div>
			</c:if>
			<c:if test="${mod_auth_active_tab == 5}">
				<div id="mod_auth_tab_courses_summary" class="mod_auth_tab">
					<c:import url="/modules/authentication/courses.jsp" />
				</div>
			</c:if>
		</div>
	</c:when>
	<c:otherwise>
		<a class="baosButton" href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('login')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('login_title', sessionScope.tag)}" /></a>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	authenticationDoTabs(<c:out value="${mod_auth_active_tab - 1}" />);
</script>