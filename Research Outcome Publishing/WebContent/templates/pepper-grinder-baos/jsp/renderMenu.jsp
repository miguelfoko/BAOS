<c:if test="${menuToRender != null && menuToRender.menuItems != null && !empty menuToRender.menuItems}">
	<div class="panel panel-info ui-widget-content">
		<div class="panel-heading ui-widget-content">
			<h3 class="panel-title">
				<a class="accordion-toggle" href="<c:out value="#pgb-side-menu-${menuToRender.menuId}-${menuId + menuToRender.menuId}" />" data-parent="#pgb-left-aside-menu-bar" data-toggle="collapse">
					<c:if test="${menuToRender.menuTitleIcon != null}"><span class="glyphicon glyphicon-<c:out value="${menuToRender.menuTitleIcon}" />"></span></c:if>
					<c:out value="${menuToRender.menuTitle}" />
					<c:if test="${menuToRender.menuTitleBadge != null}"><c:out value="${menuToRender.menuTitleBadge}" escapeXml="false" /></c:if>
					<span class="glyphicon glyphicon-<c:choose><c:when test="${pgbfirst}">minus</c:when><c:otherwise>plus</c:otherwise></c:choose> pgb-toggle-sign" style="float:right;"></span>
				</a>
			</h3>
		</div>
		<ul id="<c:out value="pgb-side-menu-${menuToRender.menuId}-${menuId + menuToRender.menuId}" />" class="list-group collapse <c:if test="${pgbfirst}">in<c:set var="pgbfirst" value="${false}" scope="request" /></c:if> ui-widget-content pgb-accordeon-item">
			<c:forEach var="item" items="${menuToRender.menuItems}">
				<c:set var="menuItemToRender" value="${item}" scope="request" />
				<c:set var="menuItemLevel" value="${1}" scope="request" />
				<c:import url="${menuItemRenderer}" />
			</c:forEach>
		</ul>
	</div>
</c:if>