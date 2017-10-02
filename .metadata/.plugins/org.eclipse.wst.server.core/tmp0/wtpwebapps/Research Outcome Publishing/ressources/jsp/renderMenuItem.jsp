<c:if test="${menuItemToRender != null}">
	<li>
		<a href="<c:url value="${menuItemToRender.menuItemLink}" />" target="${menuItemToRender.menuItemTarget}" title="${menuItemToRender.menuItemTitle}"><c:out value="${menuItemToRender.menuItemName}" /></a>
		<c:if test="${menuItemLevel < 2 && menuItemToRender.subItems != null && !empty menuItemToRender.subItems}">
			<ul class="vmenu submenu">
				<c:forEach var="item" items="${menuItemToRender.subItems}">
					<c:set var="menuItemToRender" value="${item}" scope="request" />
					<c:set var="menuItemLevel" value="${2}" scope="request" />
					<c:import url="${menuItemRenderer}" />
				</c:forEach>
			</ul>
		</c:if>
	</li>
</c:if>