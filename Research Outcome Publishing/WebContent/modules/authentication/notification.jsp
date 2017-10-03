<<<<<<< HEAD
<h1>Notification</h1>
=======
<c:choose>
	<c:when test="${notificationList == null || empty notificationList}">
		<div class="row">
			<h4><c:out value="${applicationScope.languageManager.getLanguageValue('auth_no_notification', sessionScope.tag)}" /></h4>
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach items="${notificationList}" var="notif">
			<div class="row auth_notification <c:if test="${notif.notificationState == 1}">alert alert-<c:choose><c:when test="${'Information'.equals(notif.notificationType) || 'Question'.equals(notif.notificationType)}">info</c:when><c:when test="${'Advert'.equals(notif.notificationType)}">success</c:when><c:otherwise>danger</c:otherwise></c:choose></c:if>">
				<c:choose>
					<c:when test="${notif.notificationLink != null}">
						<a class="col-md-12" href="index.jsp?<c:url value="${notif.notificationLink}" />">
							<div class="col-md-9"><h4><c:out value="${notif.notificationTitle}" /></h4></div>
							<div class="col-md-3 pull-right"><span><c:out value="${notif.notificationDate}" /></span></div>
							<div class="col-md-12"><p><c:out value="${notif.notificationMessage}" escapeXml="false" /></p></div>
						</a>
					</c:when>
					<c:otherwise>
						<div class="col-md-9"><h4><c:out value="${notif.notificationTitle}" /></h4></div>
						<div class="col-md-3 pull-right"><span><c:out value="${notif.notificationDate}" /></span></div>
						<div class="col-md-12"><p><c:out value="${notif.notificationMessage}" escapeXml="false" /></p></div>
					</c:otherwise>
				</c:choose>
			</div>
		</c:forEach>
		<script type="text/javascript">
			$(document).ready(function(){
				$.ajax({
					'url' : 'index.jsp',
					'type' : 'GET',
					'data' : {'m' : $('#modAuthenticationEncryptedName').val(), 'o' : $('#actionReadEncryptedName').val()},
					'dataType' : 'html',
					'success' : function(data){
						
					}
				});
			});
		</script>
	</c:otherwise>
</c:choose>
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
