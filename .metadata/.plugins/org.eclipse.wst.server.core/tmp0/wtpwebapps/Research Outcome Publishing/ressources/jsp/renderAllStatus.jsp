<c:if test="${!empty statusList}">
	<c:if test="${statusRenderer == null}">
		<c:set var="statusRenderer" value="/ressources/jsp/renderStatus.jsp" scope="request" />
	</c:if>
	<c:if test="${statusId == null}">
		<c:set var="statusId" value="102689" scope="request" />
	</c:if>
	<c:if test="${statusList.size() > 1}">
		<div id="pgb-status-action-row" class="row">
			<div class="col-md-2 col-md-offset-10 text-right">
				<button class="btn btn-primary btn-sm pgb-status-bar-closer" type="button">
	              <span class="glyphicon glyphicon-eye-close"></span>
	              <c:out value="${applicationScope.languageManager.getLanguageValue('close_all', sessionScope.tag)}" />
	            </button>
			</div>
		</div>
	</c:if>
	<c:forEach var="item" items="${statusList}">
		<c:set var="statusToRender" value="${item}" scope="request" />
		<c:import url="${statusRenderer}" />
		<c:set var="menuId" value="${statusId+25}" scope="request" />
	</c:forEach>
</c:if>