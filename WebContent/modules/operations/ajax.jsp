<c:if test="${compte == null}">
	<span class="resultLin"><c:out value="${comptesInactifs.size()} ${applicationScope.languageManager.getLanguageValue('choose_valid_account', sessionScope.tag)}" /></span>
</c:if>
<c:if test="${compte != null}">
	<div class="compte">
		<h5 class="title"><c:out value="${compte.nomCompte}"/></h5>
		<div class="infoCompte">
			<span class="infoLine">
				<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('type', sessionScope.tag)} :" /></label>
				<span class="anInfo"><c:out value="${compte.idTypeCompte.nomType}"/></span>
			</span>
			<span class="infoLine">
				<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('solde_min', sessionScope.tag)} :" /></label>
				<span class="anInfo"><c:out value="${compte.getAmount(compte.idTypeCompte.soldeMin)} FCFA"/></span>
			</span>
			<span class="infoLine">
				<label class="infoLabel"><c:out value="${applicationScope.languageManager.getLanguageValue('solde_max', sessionScope.tag)} :" /></label>
				<span class="anInfo">
					<c:if test="${compte.idTypeCompte.soldeMax != 0}">
						<c:out value="${compte.getAmount(compte.idTypeCompte.soldeMax)} FCFA"/>
					</c:if>
					<c:if test="${compte.idTypeCompte.soldeMax == 0}">
						<c:out value="${applicationScope.languageManager.getLanguageValue('no_limit', sessionScope.tag)}"/>
					</c:if>
				</span>
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
</c:if>