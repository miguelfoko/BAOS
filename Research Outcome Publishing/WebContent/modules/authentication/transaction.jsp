<c:choose>
	<c:when test="${transactionList == null || empty transactionList}">
		<div class="row">
			<h4><c:out value="${applicationScope.languageManager.getLanguageValue('auth_no_transaction', sessionScope.tag)}" /></h4>
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach items="${transactionList}" var="notif">
			<div class="row auth_notification">
				A transaction
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose>
<div class="row">
	<div class="col-md-12">
		<a class="baosButton btn btn-default" href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('test-payment')}" />">Test Payment</a>
	</div>
</div>