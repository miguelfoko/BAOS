<div class="row">
	<div class="col-md-12">
		<legend class="control-legend control-green"><span class="glyphicon glyphicon-file"></span> <c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_publishing', sessionScope.tag)}" /></legend>
	</div>
	<div class="col-md-12 text-center desc-row">
		<c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_learning_desc', sessionScope.tag)}" escapeXml="false" />
	</div>
	<div class="col-md-12 desc-row">
		<div class="col-md-4 image-and-desc">
			<div class="col-md-4"><img src="<c:url value="/modules/controlpanel/images/easy.png" />" alt="" /></div>
			<div class="col-md-8"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_learning_easy', sessionScope.tag)}" escapeXml="false" /></div>
		</div>
		<div class="col-md-4 image-and-desc">
			<div class="col-md-4"><img src="<c:url value="/modules/controlpanel/images/quality.jpg" />" alt="" /></div>
			<div class="col-md-8"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_learning_quality', sessionScope.tag)}" escapeXml="false" /></div>
		</div>
		<div class="col-md-4 image-and-desc">
			<div class="col-md-4"><img src="<c:url value="/modules/controlpanel/images/tracking.png" />" alt="" /></div>
			<div class="col-md-8"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_learning_tracking', sessionScope.tag)}" escapeXml="false" /></div>
		</div>
	</div>
	<!-- <div class="col-md-12 text-center desc-row">
		<div class="col-md-6 image-and-desc">
			<div class="col-md-4"><img src="<c:url value="/modules/controlpanel/images/assistance.jpg" />" alt="" /></div>
			<div class="col-md-8"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_learning_assistance', sessionScope.tag)}" escapeXml="false" /></div>
		</div>
	</div> -->
	<div class="col-md-12 pull-right desc-row get-started-row">
		<div class="col-md-2 col-md-offset-10"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />"><button class="baosButton btn btn-success"><c:out value="${applicationScope.languageManager.getLanguageValue('get_started', sessionScope.tag)}" /></button></a></div>
	</div>
</div>