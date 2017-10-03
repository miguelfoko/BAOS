<%-- <c:import url="/modules/elearning/menu.jsp" /> --%>
<h2 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('elearning', sessionScope.tag)}" />
</h2>

<c:choose>
	<c:when test="${userCourseSize >= 1}">
		<h4 class="subtitle">
			<c:out
				value="${applicationScope.languageManager.getLanguageValue('el_click_course', sessionScope.tag)}" />
		</h4>
		<c:forEach items="${userCourse}" var="uC">
			<p>
				<a
					href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('subscribeCourse')}&d=${applicationScope.encryptor.encrypt(uC['courseId'])}"><c:out
						value="${uC['courseName']}" /></a>
			</p>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<c:out
			value="${applicationScope.languageManager.getLanguageValue('el_no_course_now', sessionScope.tag)}" />
	</c:otherwise>
</c:choose>

