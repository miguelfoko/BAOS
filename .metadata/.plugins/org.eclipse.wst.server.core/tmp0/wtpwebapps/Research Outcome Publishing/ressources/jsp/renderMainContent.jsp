<c:if test="${contentToRender != null}">
	<div id="content-<c:out value="${contentId}" />">
		<c:import url="${contentToRender}" />
	</div>
</c:if>