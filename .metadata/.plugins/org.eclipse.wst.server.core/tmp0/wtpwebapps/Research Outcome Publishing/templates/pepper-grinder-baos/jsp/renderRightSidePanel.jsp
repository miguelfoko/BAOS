<div class="panel panel-info ui-widget-content">
	<c:if test="${panelToRender.sidePanelTitle != null}">
		<div class="panel-heading ui-widget-content">
			<h3 class="panel-title">
				<c:if test="${panelToRender.sidePanelTitleIcon != null}"><span class="glyphicon glyphicon-<c:out value="${panelToRender.sidePanelTitleIcon}" />"></span></c:if>
				<c:out value="${panelToRender.sidePanelTitle}" />
				<c:if test="${panelToRender.sidePanelTitleBadge != null}"><c:out value="${panelToRender.sidePanelTitleBadge}" escapeXml="false" /></c:if>
			</h3>
		</div>
	</c:if>
	<div id="<c:out value="pgb-right-side-panel-${panelToRender.sidePanelId}-${panelId + panelToRender.sidePanelId}" />" class="ui-widget-content">
		<c:forEach var="panelToRenderContent" items="${panelToRender.sidePanelContent}">
			<div id="<c:out value="pgb-right-side-panel-content-${panelToRenderContent.spContentId}" />" class="panel-body"> 
				<c:choose>
					<c:when test="${panelToRenderContent.spContentLink}"><c:import url="${panelToRenderContent.spContentValue}" /></c:when>
					<c:otherwise><c:out value="${panelToRenderContent.spContentValue}" escapeXml="false" /></c:otherwise>
				</c:choose>
			</div>
		</c:forEach>
	</div>
</div>