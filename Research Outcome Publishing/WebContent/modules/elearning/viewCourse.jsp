<h2 class="subtitle">
	<c:out value="${currentCourse['courseName']}" />
</h2>
<br>
<br>

<c:choose>
	<c:when test="${baoUser != null}">

		<h4 class="subtitle">
			<c:out
				value="${applicationScope.languageManager.getLanguageValue('el_timetable', sessionScope.tag)}" />
		</h4>
		<p>
			<a
				href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('timetableCourse')}"><c:out
					value="${applicationScope.languageManager.getLanguageValue('el_timetable_course', sessionScope.tag)}" /></a>
		</p>
		<section class="col-sm-8 table-responsive">
			<table class="table table-bordered table-striped">
				<tr>
					<Th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_jour', sessionScope.tag)}" /></Th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_start_time', sessionScope.tag)}" /></th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_end_time', sessionScope.tag)}" /></th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_edit', sessionScope.tag)}" /></th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_delete', sessionScope.tag)}" /></th>
				</tr>
				<c:choose>
					<c:when test="${timetableCourseSize >= 1}">

						<c:forEach items="${timetableCourse}" var="tC">
							<tr>
								<td><c:out value="${tC['timetableDay']}" /></td>
								<td><c:out value="${tC['timetableStartTime']}" /></td>
								<td><c:out value="${tC['timetableEndTime']}" /></td>
								<td><a
									href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('timetableCourse')}"><c:out
											value="${applicationScope.languageManager.getLanguageValue('el_edit', sessionScope.tag)}" /></a></td>
								<td><a
									href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('timetableCourse')}"><c:out
											value="${applicationScope.languageManager.getLanguageValue('el_delete', sessionScope.tag)}" /></a></td>
							</tr>
						</c:forEach>

					</c:when>
					<c:otherwise>
						<tr>
							<td colspan=5><c:out
									value="${applicationScope.languageManager.getLanguageValue('el_no_timetable', sessionScope.tag)}" /></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</section>
		<br>
		<br>
		<br>
		<h4 class="subtitle">
			<c:out
				value="${applicationScope.languageManager.getLanguageValue('el_monitor', sessionScope.tag)}" />
		</h4>
		<p>
			<a
				href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('monitorCourse')}&d=${applicationScope.encryptor.encrypt(uC['courseId'])}"><c:out
					value="${applicationScope.languageManager.getLanguageValue('el_monitor_course', sessionScope.tag)}" /></a>
		</p>
		<section class="col-sm-8 table-responsive">
			<table class="table table-bordered table-striped">
				<tr>
					<Th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_name', sessionScope.tag)}" /></Th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_surname', sessionScope.tag)}" /></th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_email', sessionScope.tag)}" /></th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_edit', sessionScope.tag)}" /></th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_delete', sessionScope.tag)}" /></th>
				</tr>
				<c:choose>
					<c:when test="${monitorCourseSize >= 1}">

						<c:forEach items="${monitorCourse}" var="mC">
							<tr>
								<td><c:out value="${mC['userName']}" /></td>
								<td><c:out value="${mC['userSurname']}" /></td>
								<td><c:out value="${mC['userEmail']}" /></td>
								<td><a
									href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('timetableCourse')}"><c:out
											value="${applicationScope.languageManager.getLanguageValue('el_edit', sessionScope.tag)}" /></a></td>
								<td><a
									href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('timetableCourse')}"><c:out
											value="${applicationScope.languageManager.getLanguageValue('el_delete', sessionScope.tag)}" /></a></td>
							</tr>
						</c:forEach>

					</c:when>
					<c:otherwise>
						<tr>
							<td colspan=5><c:out
									value="${applicationScope.languageManager.getLanguageValue('el_no_monitor', sessionScope.tag)}" />
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</section>
		<br>
		<br>
		<br>
		<h4 class="subtitle">
			<c:out
				value="${applicationScope.languageManager.getLanguageValue('el_lesson', sessionScope.tag)}" />
		</h4>
		<p>
			<a
				href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('lessonCourse')}&d=${applicationScope.encryptor.encrypt(uC['courseId'])}"><c:out
					value="${applicationScope.languageManager.getLanguageValue('el_lesson_course', sessionScope.tag)}" /></a>
		</p>
		<section class="col-sm-8 table-responsive">
			<table class="table table-bordered table-striped">
				<tr>
					<Th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_name', sessionScope.tag)}" /></Th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_start_time', sessionScope.tag)}" /></th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_end_time', sessionScope.tag)}" /></th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_edit', sessionScope.tag)}" /></th>
					<th><c:out
							value="${applicationScope.languageManager.getLanguageValue('el_delete', sessionScope.tag)}" /></th>
				</tr>
				<c:choose>
					<c:when test="${lessonCourseSize >= 1}">

						<c:forEach items="${lessonCourse}" var="lC">
							<tr>
								<td><a
									href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('viewLesson')}&d=${applicationScope.encryptor.encrypt(lC['lessonId'])}"><c:out
											value="${lC['lessonName']}" /></a></td>
								<td><c:out value="${lC['lessonStartTime']}" /></td>
								<td><c:out value="${lC['lessonEndTime']}" /></td>
								<td><a
									href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('timetableCourse')}"><c:out
											value="${applicationScope.languageManager.getLanguageValue('el_edit', sessionScope.tag)}" /></a></td>
								<td><a
									href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('timetableCourse')}"><c:out
											value="${applicationScope.languageManager.getLanguageValue('el_delete', sessionScope.tag)}" /></a></td>
							</tr>
						</c:forEach>

					</c:when>
					<c:otherwise>
						<tr>
							<td colspan=5><c:out
									value="${applicationScope.languageManager.getLanguageValue('el_no_lesson', sessionScope.tag)}" /></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</section>
	</c:when>
	<c:otherwise>
		<a
			href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('login')}" />"><c:out
				value="${applicationScope.languageManager.getLanguageValue('logout_title', sessionScope.tag)}" /></a>
	</c:otherwise>
</c:choose>
