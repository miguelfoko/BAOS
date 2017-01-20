<div id="cmdBox">
	<h4 class="cmdGroupTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('accounts', sessionScope.tag)}" /></h4>
	<a href="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('gestion')}" />" class="cmd">
		<strong class="cmdCircle acc_icon"></strong><br />
		<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('accounts', sessionScope.tag)}" /></strong>
	</a>
	
	<c:if test="${create_accounts != null}">
		<a href="<c:url value="index.jsp?module=" />" class="cmd">
			<strong class="cmdCircle cre_acc_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('create_accounts', sessionScope.tag)}" /></strong>
		</a>
		<a href="<c:url value="index.jsp?module=" />" class="cmd">
			<strong class="cmdCircle add_usr_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('add_customers', sessionScope.tag)}" /></strong>
		</a>
	</c:if>
	<c:if test="${delete_accounts != null}">
		<a href="<c:url value="index.jsp?module=" />" class="cmd">
			<strong class="cmdCircle del_acc_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('delete_accounts', sessionScope.tag)}" /></strong>
		</a>
	</c:if>
	<div class="clr"></div>
	<hr />
	<h4 class="cmdGroupTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('do_accounts_operations', sessionScope.tag)}" /></h4>
	<c:if test="${consult_accounts != null}">
		<a href="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('gestion')}&action=${applicationScope.encryptor.encrypt('all')}" />" class="cmd">
			<strong class="cmdCircle con_acc_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('consult_accounts', sessionScope.tag)}" /></strong>
		</a>
	</c:if>
	
	<c:if test="${deb_accounts != null}">
		<a href="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('operations')}&action=${applicationScope.encryptor.encrypt('debiter')}" />" class="cmd">
			<strong class="cmdCircle deb_acc_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('deb_accounts', sessionScope.tag)}" /></strong>
		</a>
	</c:if>
	
	<c:if test="${credit_accounts != null}">
		<a href="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('operations')}&action=${applicationScope.encryptor.encrypt('crediter')}" />" class="cmd">
			<strong class="cmdCircle cred_acc_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('credit_accounts', sessionScope.tag)}" /></strong>
		</a>
	</c:if>
	
	<c:if test="${transfert != null}">
		<a href="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('operations')}&action=${applicationScope.encryptor.encrypt('transferer')}" />" class="cmd">
			<strong class="cmdCircle trans_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('transf_accounts', sessionScope.tag)}" /></strong>
		</a>
	</c:if>
	
	<c:if test="${consult_op != null}">
		<a href="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('operations')}&action=${applicationScope.encryptor.encrypt('waiting')}" />" class="cmd">
			<strong class="cmdCircle val_op_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('waiting_operations', sessionScope.tag)}" /></strong>
		</a>
	</c:if>
	
	<c:if test="${general != null}">
		<a href="<c:url value="index.jsp?module=" />" class="cmd">
			<strong class="cmdCircle acc_type_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('create_accounts_type', sessionScope.tag)}" /></strong>
		</a>
	</c:if>
	<div class="clr"></div>
	<hr />
	<h4 class="cmdGroupTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('admin', sessionScope.tag)}" /></h4>
	<c:if test="${admin_access != null}">
		<a href="<c:url value="index.jsp?module=" />" class="cmd">
			<strong class="cmdCircle acc_admin_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('go_admin', sessionScope.tag)}" /></strong>
		</a>
	</c:if>
	
	<c:if test="${general != null}">
		<a href="<c:url value="index.jsp?module=" />" class="cmd">
			<strong class="cmdCircle acc_type_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('create_accounts_type', sessionScope.tag)}" /></strong>
		</a>
		<a href="<c:url value="index.jsp?module=" />" class="cmd">
			<strong class="cmdCircle man_usr_icon"></strong><br />
			<strong class="cmdTitle"><c:out value="${applicationScope.languageManager.getLanguageValue('manage_users', sessionScope.tag)}" /></strong>
		</a>
	</c:if>
	<div class="clr"></div>
</div>