<c:if test="${menuToRender != null && menuToRender.menuItems != null && !empty menuToRender.menuItems}">
	<div class="leftcontent">
		<h4 class="lefttitle"><c:out value="${menuToRender.menuTitle}" /></h4>
		<nav class="sidenav">
			<ul id="menu-<c:out value="${menuId + menuToRender.menuId}" />" class="vmenu menu">
				<c:forEach var="item" items="${menuToRender.menuItems}">
					<c:set var="menuItemToRender" value="${item}" scope="request" />
					<c:set var="menuItemLevel" value="${1}" scope="request" />
					<c:import url="${menuItemRenderer}" />
				</c:forEach>
			</ul>
		</nav>
	</div>
</c:if>