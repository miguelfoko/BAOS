<div id="comptesBox">
	<div class="filtered">
		<form method="post" action="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('gestion')}&action=${applicationScope.encryptor.encrypt('filtered')}" />">
			<fieldset class="fieldset">
				<legend class="legend"><c:out value="${applicationScope.languageManager.getLanguageValue('research_filters', sessionScope.tag)}" /></legend>
				<select name="statut" class="select">
					<option value="-1"><c:out value="${applicationScope.languageManager.getLanguageValue('choose_state', sessionScope.tag)}" /></option>
					<option value="0" <c:if test="${activeState == 0}" >selected</c:if>><c:out value="${applicationScope.languageManager.getLanguageValue('active_accounts', sessionScope.tag)}" /></option>
					<option value="1" <c:if test="${activeState == 1}" >selected</c:if>><c:out value="${applicationScope.languageManager.getLanguageValue('desactive_accounts', sessionScope.tag)}" /></option>
				</select>
				<select name="userId" class="select">
					<option value="<c:if test="${consult_accounts != null}">0</c:if><c:if test="${consult_accounts == null}">${sessionScope.user.idUser}</c:if>"><c:out value="${applicationScope.languageManager.getLanguageValue('choose_user', sessionScope.tag)}" /></option>
					<c:forEach items="${users}" var="user">
						<c:if test="${consult_accounts != null || user == sessionScope.user}">
							<option value="${user.idUser}" <c:if test="${activeUser != null && activeUser == user}">selected</c:if>><c:out value="${user.prenom} ${user.nom}" /></option>
						</c:if>
					</c:forEach>
				</select>
				<select name="accTypeId" class="select">
					<option value="0"><c:out value="${applicationScope.languageManager.getLanguageValue('choose_type', sessionScope.tag)}" /></option>
					<c:forEach items="${typesComptes}" var="type">
						<option value="${type.idTypeCompte}" <c:if test="${activeType != null && activeType == type}">selected</c:if>><c:out value="${type.nomType}" /></option>
					</c:forEach>
				</select>
				<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('research', sessionScope.tag)}" />" class="auth_button" />
			</fieldset>
		</form>
	</div>
	<div class="results">
		<c:if test="${comptesActifs == null  && comptesInactifs == null}">
			<span class="resultLine"><c:out value="${applicationScope.languageManager.getLanguageValue('no_account_found', sessionScope.tag)}" /></span>
		</c:if>
		<c:if test="${comptesActifs != null}">
			<span class="resultLine"><c:out value="${comptesActifs.size()} ${applicationScope.languageManager.getLanguageValue('activated_account_found', sessionScope.tag)}" /></span>
		</c:if>
		<c:if test="${comptesInactifs != null}">
			<span class="resultLine"><c:out value="${comptesInactifs.size()} ${applicationScope.languageManager.getLanguageValue('desactivated_account_found', sessionScope.tag)}" /></span>
		</c:if>
	</div>
	<c:if test="${comptesActifs != null}">
		<h3><c:out value="${applicationScope.languageManager.getLanguageValue('active_accounts', sessionScope.tag)}" /></h3>
		<c:forEach items="${comptesActifs}" var="compte">
			<div class="compte">
				<h5 class="title"><c:out value="${compte.nomCompte}"/></h5>
				<div class="infoCompte">
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('type', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.idTypeCompte.nomType}"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('proprio', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.idUserProprietaire.prenom} ${compte.idUserProprietaire.nom}"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('creation_date', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.dateCreationCompte}"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('creation_agent', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.idUserAgent.prenom} ${compte.idUserAgent.nom}"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('account_amount', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.getAmount(compte.solde)} FCFA"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('account_interet', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.getAmount(compte.interet)} FCFA"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('last_op_date', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.dateDerniereOp}"/></span>
					</span>
					<span class="command">
						<a href="<c:url value="index.jsp?module=" />" class="cmd" title="<c:out value="${applicationScope.languageManager.getLanguageValue('activity_history', sessionScope.tag)}" />">
							<strong class="cmdCircle his_acc_icon"></strong><br />
						</a>
						<c:if test="${deb_accounts != null}">
							<a href="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('operations')}&action=${applicationScope.encryptor.encrypt('debiter')}&account=${applicationScope.encryptor.encrypt(compte.idCompte.toString())}" />" class="cmd" title="<c:out value="${applicationScope.languageManager.getLanguageValue('deb_accounts', sessionScope.tag)}" />">
								<strong class="cmdCircle deb_acc_icon"></strong><br />
							</a>
						</c:if>
						
						<c:if test="${credit_accounts != null}">
							<a href="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('operations')}&action=${applicationScope.encryptor.encrypt('crediter')}&account=${applicationScope.encryptor.encrypt(compte.idCompte.toString())}" />" class="cmd" title="<c:out value="${applicationScope.languageManager.getLanguageValue('credit_accounts', sessionScope.tag)}" />">
								<strong class="cmdCircle cred_acc_icon"></strong><br />
							</a>
						</c:if>
						
						<c:if test="${transfert != null}">
							<a href="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('operations')}&action=${applicationScope.encryptor.encrypt('transferer')}&account=${applicationScope.encryptor.encrypt(compte.idCompte.toString())}" />" class="cmd" title="<c:out value="${applicationScope.languageManager.getLanguageValue('transf_accounts', sessionScope.tag)}" />">
								<strong class="cmdCircle trans_icon"></strong><br />
							</a>
						</c:if>
						<c:if test="${delete_accounts != null}">
							<a href="<c:url value="index.jsp?module=" />" class="cmd" title="<c:out value="${applicationScope.languageManager.getLanguageValue('delete_accounts', sessionScope.tag)}" />">
								<strong class="cmdCircle del_acc_icon"></strong><br />
							</a>
						</c:if>
					</span>
				</div>
			</div>
		</c:forEach>
	</c:if>
	<div class="clresp"></div>
	<c:if test="${comptesInactifs != null}">
		<h3><c:out value="${applicationScope.languageManager.getLanguageValue('desactive_accounts', sessionScope.tag)}" /></h3>
		<c:forEach items="${comptesInactifs}" var="compte">
			<div class="compte inactif">
				<h5 class="title"><c:out value="${compte.nomCompte}"/></h5>
				<div class="infoCompte">
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('type', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.idTypeCompte.nomType}"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('proprio', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.idUserProprietaire.prenom} ${compte.idUserProprietaire.nom}"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('creation_date', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.dateCreationCompte}"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('creation_agent', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.idUserAgent.prenom} ${compte.idUserAgent.nom}"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('account_amount', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.getAmount(compte.solde)} FCFA"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('account_interet', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.getAmount(compte.interet)} FCFA"/></span>
					</span>
					<span class="infoLine">
						<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('last_op_date', sessionScope.tag)} :" /></label>
						<span class="anInfo"><c:out value="${compte.dateDerniereOp}"/></span>
					</span>
					<span class="command">
						<a href="<c:url value="index.jsp?module=" />" class="cmd" title="<c:out value="${applicationScope.languageManager.getLanguageValue('activity_history', sessionScope.tag)}" />">
							<strong class="cmdCircle his_acc_icon"></strong><br />
						</a>
						<c:if test="${delete_accounts != null}">
							<a href="<c:url value="index.jsp?module=" />" class="cmd" title="<c:out value="${applicationScope.languageManager.getLanguageValue('delete_accounts', sessionScope.tag)}" />">
								<strong class="cmdCircle del_acc_icon"></strong><br />
							</a>
						</c:if>
					</span>
				</div>
			</div>
		</c:forEach>
	</c:if>
	<div class="clresp"></div>
	<div class="filtered">
		<form method="post" action="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('gestion')}&action=${applicationScope.encryptor.encrypt('filtered')}" />">
			<fieldset class="fieldset">
				<legend class="legend"><c:out value="${applicationScope.languageManager.getLanguageValue('research_filters', sessionScope.tag)}" /></legend>
				<select name="statut" class="select">
					<option value="-1"><c:out value="${applicationScope.languageManager.getLanguageValue('choose_state', sessionScope.tag)}" /></option>
					<option value="0" <c:if test="${activeState == 0}" >selected</c:if>><c:out value="${applicationScope.languageManager.getLanguageValue('active_accounts', sessionScope.tag)}" /></option>
					<option value="1" <c:if test="${activeState == 1}" >selected</c:if>><c:out value="${applicationScope.languageManager.getLanguageValue('desactive_accounts', sessionScope.tag)}" /></option>
				</select>
				<select name="userId" class="select">
					<option value="<c:if test="${consult_accounts != null}">0</c:if><c:if test="${consult_accounts == null}">${sessionScope.user.idUser}</c:if>"><c:out value="${applicationScope.languageManager.getLanguageValue('choose_user', sessionScope.tag)}" /></option>
					<c:forEach items="${users}" var="user">
						<c:if test="${consult_accounts != null || user == sessionScope.user}">
							<option value="${user.idUser}" <c:if test="${activeUser != null && activeUser == user}">selected</c:if>><c:out value="${user.prenom} ${user.nom}" /></option>
						</c:if>
					</c:forEach>
				</select>
				<select name="accTypeId" class="select">
					<option value="0"><c:out value="${applicationScope.languageManager.getLanguageValue('choose_type', sessionScope.tag)}" /></option>
					<c:forEach items="${typesComptes}" var="type">
						<option value="${type.idTypeCompte}" <c:if test="${activeType != null && activeType == type}">selected</c:if>><c:out value="${type.nomType}" /></option>
					</c:forEach>
				</select>
				<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('research', sessionScope.tag)}" />" class="auth_button" />
			</fieldset>
		</form>
	</div>
</div>