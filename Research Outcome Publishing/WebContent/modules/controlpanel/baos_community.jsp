<div class="row">
	<div class="col-md-12">
		<legend class="control-legend control-green"><span class="glyphicon glyphicon-sunglasses"></span> <c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_community_news', sessionScope.tag)}" /></legend>
	</div>
	<div class="col-md-12 text-center desc-row">
		<c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_community_news_desc', sessionScope.tag)}" escapeXml="false" />
	</div>
	<div class="col-md-12 desc-row">
		<div class="col-md-4 image-and-desc">
			<div class="col-md-4 text-center"><img src="<c:url value="/modules/controlpanel/images/news.jpg" />" alt="" /></div>
			<div class="col-md-8"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_learning_news', sessionScope.tag)}" escapeXml="false" /></div>
		</div>
		<div class="col-md-4 image-and-desc">
			<div class="col-md-4 text-center"><img src="<c:url value="/modules/controlpanel/images/community.jpg" />" alt="" /></div>
			<div class="col-md-8"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_learning_community', sessionScope.tag)}" escapeXml="false" /></div>
		</div>
		<div class="col-md-4 image-and-desc">
			<div class="col-md-4 text-center"><img src="<c:url value="/modules/controlpanel/images/assistance.jpg" />" alt="" /></div>
			<div class="col-md-8"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_learning_assistance', sessionScope.tag)}" escapeXml="false" /></div>
		</div>
	</div>
	<div class="col-md-12 pull-right desc-row get-started-row">
		<div class="col-md-2 col-md-offset-10"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />"><button class="baosButton btn btn-success"><c:out value="${applicationScope.languageManager.getLanguageValue('get_started', sessionScope.tag)}" /> <span class="glyphicon glyphicon-menu-right"></span></button></a></div>
	</div>
</div>