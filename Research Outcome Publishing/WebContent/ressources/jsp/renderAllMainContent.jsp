<c:if test="${!empty includeList}">
	<c:if test="${mainContentRenderer == null}">
		<c:set var="mainContentRenderer" value="/ressources/jsp/renderMainContent.jsp" scope="request" />
	</c:if>
	<c:if test="${contentId == null}">
		<c:set var="contentId" value="9689" scope="request" />
	</c:if>
	<c:forEach var="item" items="${includeList}">
		<c:set var="contentToRender" value="${item}" scope="request" />
		<c:import url="${mainContentRenderer}" />
		<c:set var="menuId" value="${contentId+5}" scope="request" />
	</c:forEach>
</c:if>