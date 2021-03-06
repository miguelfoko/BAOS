<div id="home_slideshow">
	<div class="slide">
		<a href=""><img alt="" src="<c:url value="/modules/controlpanel/images/img/baos-cover.png" />" /></a>
		<a href="" class="cover-button-left"><button class="baosButton btn btn-danger"><c:out value="${applicationScope.languageManager.getLanguageValue('learn_more_about_baos', sessionScope.tag)}" /> <span class="glyphicon glyphicon-menu-right"></span></button></a>
	</div>
	<div class="slide">
		<div class="cover-desc"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_baos_learning_short_desc', sessionScope.tag)}" escapeXml="false" /></div>
		<a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />"><img alt="" src="<c:url value="/modules/controlpanel/images/img/elearning.png" />" /></a>
		<a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />" class="cover-button-right-top"><button class="baosButton btn btn-danger"><c:out value="${applicationScope.languageManager.getLanguageValue('get_started', sessionScope.tag)}" /> <span class="glyphicon glyphicon-menu-right"></span></button></a>
	</div>
</div>