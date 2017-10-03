<c:if test="${contentToRender != null}">
	<div id="pgb-main-content-<c:out value="${contentId}" />" class="pgb-content-row row ui-widget-content">
		<div class="col-md-12 pgb-right-corner-shadow">
			<c:import url="${contentToRender}" />
		</div>
	</div>
</c:if>