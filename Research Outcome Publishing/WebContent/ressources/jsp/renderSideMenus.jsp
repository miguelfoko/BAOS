<c:if test="${!empty sideMenus}">
	<c:if test="${menuRenderer == null}">
		<c:set var="menuRenderer" value="/ressources/jsp/renderMenu.jsp" scope="request" />
	</c:if>
	<c:if test="${menuItemRenderer == null}">
		<c:set var="menuItemRenderer" value="/ressources/jsp/renderMenuItem.jsp" scope="request" />
	</c:if>
	<c:if test="${menuId == null}">
		<c:set var="menuId" value="9689" scope="request" />
	</c:if>
	<c:forEach var="item" items="${sideMenus}">
		<c:set var="menuToRender" value="${item}" scope="request" />
		<c:import url="${menuRenderer}" />
		<c:set var="menuId" value="${menuId+5}" scope="request" />
	</c:forEach>
</c:if>