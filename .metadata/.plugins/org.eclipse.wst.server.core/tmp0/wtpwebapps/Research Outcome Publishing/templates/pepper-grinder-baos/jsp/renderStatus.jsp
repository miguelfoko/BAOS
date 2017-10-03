<c:if test="${statusToRender != null}">
	<div id="pgb-status-row-<c:out value="${statusToRender.statusId}" />-<c:out value="${statusId + statusToRender.statusId}" />" class="pgb-status-row alert alert-<c:out value="${statusToRender.statusType.equals('primary') ? 'info' : statusToRender.statusType}" /> row">
		<div class="col-md-9 pgb-status-text">
			<c:if test="${statusToRender.statusIcon != null}">
				<button class="btn btn-<c:out value="${statusToRender.statusType}" /> btn pgb-status-closer" type="button" data-target="#pgb-status-row-<c:out value="${statusToRender.statusId}" />-<c:out value="${statusId + statusToRender.statusId}" />">
	              <span class="glyphicon glyphicon-<c:out value="${statusToRender.statusIcon}" />"></span>
	            </button>
			</c:if>
			<span><c:out value=" ${statusToRender.statusText}" escapeXml="false" /></span>
		</div>
		<div class="col-md-3 text-right">
			<div class="btn-group">
				<c:if test="${!empty statusToRender.statusActions}">
					<c:set var="statusActionId" value="83256" scope="request" />
					<c:forEach var="statusActionToRender" items="${statusToRender.statusActions}">
						<a id="status-<c:out value="${statusToRender.statusId}" />-<c:out value="${statusId + statusToRender.statusId}" />-action-<c:out value="${statusActionId}" />" class="btn btn-<c:out value="${statusActionToRender.statusActionType}" />" type="button" href="<c:out value="${statusActionToRender.statusActionLinkType == 0 ? statusActionToRender.statusActionValue : '#'}" />">
			              <span class="glyphicon glyphicon-<c:out value="${statusActionToRender.statusActionButtonIcon}" />"></span> <c:out value=" ${statusActionToRender.statusActionButtonText}" />
			            </a>
			            <c:if test="${statusActionToRender.statusActionLinkType == 1}">
				            <script type="text/javascript">
				            	$(document).ready(function(){
				            		$('#status-<c:out value="${statusToRender.statusId}" />-<c:out value="${statusId + statusToRender.statusId}" />-action-<c:out value="${statusActionId}" />').click(function(){
				            			return <c:out value="${statusActionToRender.statusActionValue};" escapeXml="false" />
				            		});
				            	});
				            </script>
			            </c:if>
						<c:set var="statusActionId" value="${statusActionId + 74}" scope="request" />
					</c:forEach>
				</c:if>
				<a class="btn btn-link pgb-status-closer" type="button" href="#" data-target="#pgb-status-row-<c:out value="${statusToRender.statusId}" />-<c:out value="${statusId + statusToRender.statusId}" />">
	              <span class="glyphicon glyphicon-remove"></span>
	            </a>
			</div>
		</div>
	</div>
</c:if>