<c:if test="${leftSidePanelRenderer == null}">
	<c:set var="leftSidePanelRenderer" value="/ressources/jsp/renderLeftSidePanel.jsp" scope="request" />
</c:if>
<c:if test="${rightSidePanelRenderer == null}">
	<c:set var="rightSidePanelRenderer" value="/ressources/jsp/renderRightSidePanel.jsp" scope="request" />
</c:if>
<c:if test="${sideOfPanels == null}">
	<c:set var="sideOfPanels" value="left" scope="request" />
</c:if>
<c:if test="${panelId == null}">
	<c:set var="panelId" value="21894" scope="request" />
</c:if>
<c:choose>
	<c:when test="${sideOfPanels.equalsIgnoreCase('left')}">
		<c:if test="${!empty leftSidePanels}">
			<c:forEach var="item" items="${leftSidePanels}">
				<c:set var="panelToRender" value="${item}" scope="request" />
				<c:import url="${leftSidePanelRenderer}" />
				<c:set var="panelId" value="${panelId+5}" scope="request" />
			</c:forEach>
		</c:if>
	</c:when>
	<c:otherwise>
		<c:if test="${!empty rightSidePanels}">
			<c:forEach var="item" items="${rightSidePanels}">
				<c:set var="panelToRender" value="${item}" scope="request" />
				<c:import url="${rightSidePanelRenderer}" />
				<c:set var="panelId" value="${panelId+5}" scope="request" />
			</c:forEach>
		</c:if>
	</c:otherwise>
</c:choose>