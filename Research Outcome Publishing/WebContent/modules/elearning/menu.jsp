<div id="menuJournal">
	<ul>
		<li><a
			href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('createCourse')}"><c:out value="${applicationScope.languageManager.getLanguageValue('el_create_course', sessionScope.tag)}"/></a></li>
		<li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('subscribeCourse')}"><c:out value="${applicationScope.languageManager.getLanguageValue('el_subscribe_course', sessionScope.tag)}"/></a></li>
		<li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('monitorCourse')}"><c:out value="${applicationScope.languageManager.getLanguageValue('el_monitor_course', sessionScope.tag)}"/></a></li>
	</ul>
</div>