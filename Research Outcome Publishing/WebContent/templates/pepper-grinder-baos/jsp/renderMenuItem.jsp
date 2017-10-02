<c:if test="${menuItemToRender != null}">
	<li class="list-group-item">
		<c:set var="menuItemHasSubItems" value="${menuItemLevel < 2 && menuItemToRender.subItems != null && !empty menuItemToRender.subItems}" scope="request" />
		<c:choose>
			<c:when test="${menuItemHasSubItems}">
				<div class="dropdown pgb-submenu">
					<a class="dropdown-toggle" data-toggle="dropdown" href="<c:url value="${menuItemToRender.menuItemLink}" />" target="${menuItemToRender.menuItemTarget}" title="${menuItemToRender.menuItemTitle}">
						<c:if test="${menuItemToRender.menuItemIcon != null}"><span class="glyphicon glyphicon-<c:out value="${menuItemToRender.menuItemIcon}" />"></span></c:if>
						<c:out value="${menuItemToRender.menuItemName}" /> <span class="caret"></span>
						<c:if test="${menuItemToRender.menuItemBadge != null}"><c:out value="${menuItemToRender.menuItemBadge}" escapeXml="false" /></c:if>
					</a>
					<ul class="dropdown-menu">
						<c:forEach var="item" items="${menuItemToRender.subItems}">
							<c:set var="menuItemToRender" value="${item}" scope="request" />
							<c:set var="menuItemLevel" value="${2}" scope="request" />
							<c:import url="${menuItemRenderer}" />
						</c:forEach>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<a href="<c:url value="${menuItemToRender.menuItemLink}" />" target="${menuItemToRender.menuItemTarget}" title="${menuItemToRender.menuItemTitle}">
					<c:if test="${menuItemToRender.menuItemIcon != null}"><span class="glyphicon glyphicon-<c:out value="${menuItemToRender.menuItemIcon}" />"></span></c:if>
					<c:out value="${menuItemToRender.menuItemName}" />
				</a>
				<c:if test="${menuItemToRender.menuItemBadge != null}"><c:out value="${menuItemToRender.menuItemBadge}" escapeXml="false" /></c:if>
			</c:otherwise>
		</c:choose>
	</li>
</c:if>