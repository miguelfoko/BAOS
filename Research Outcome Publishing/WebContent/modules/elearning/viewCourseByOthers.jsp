<h3 class="subtitle">
	<c:out value="${currentCourse['courseName']}" />
</h3>

<h3 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('el_start_time', sessionScope.tag)}" />
	:
	<c:out value="${currentCourse['courseStartTime']}" />
	<br />
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('el_length', sessionScope.tag)}" />
	:
	<c:out value="${currentCourse['courseLength']}" />
	<c:out value="${currentCourse['courseLengthUnit']}" />
	<br />
</H3>
<h3 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('el_timetable', sessionScope.tag)}" />
</H3>
<c:forEach items="${timetableCourse}" var="tC">
	<c:out value="${tC['timetableDay']}" />
	<c:out value="${tC['timetableStartTime']}" /> -
	<c:out value="${tC['timetableEndTime']}" />
	<br />
</c:forEach>

<h3 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('el_supervisor', sessionScope.tag)}" />
</h3>
<c:forEach items="${teacherCourse}" var="tC">
	<c:out value="${tC['userName']}" />
	<c:out value="${tC['userSurname']}" />
	(<c:out value="${tC['userEmail']}" />)
	<br />
</c:forEach>
<h3 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('el_monitor', sessionScope.tag)}" />
</h3>
<c:forEach items="${monitorCourse}" var="mC">
	<c:out value="${mC['userName']}" />
	<c:out value="${mC['userSurname']}" />
	(<c:out value="${mC['userEmail']}" />)
	<br />
</c:forEach>
<h3 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('el_lesson', sessionScope.tag)}" />
</h3>
<c:forEach items="${lessonCourse}" var="lC">
	<img src="<c:url value="${lC['lessonLogo']}"/>" width="100"
		height="100" />
	<a
		href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('viewLesson')}&d=${applicationScope.encryptor.encrypt(lC['lessonId'])}"><c:out
			value="${lC['lessonName']}" /></a>
	<c:out value="${lC['lessonDesc']}" />
	<br>
</c:forEach>


