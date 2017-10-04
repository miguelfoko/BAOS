<c:choose>
	<c:when test="${courseTaught == true}">
		<c:choose>
			<c:when test="${userCourse!=null && userCourse.size()>= 1}">
				<table>
					<c:forEach items="${userCourse}" var="uC">
						<p>
							<a
								href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('viewCourse')}&d=${applicationScope.encryptor.encrypt(uC['courseId'])}"><c:out
									value="${uC['courseName']}" /></a>
						</p>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<c:out
					value="${applicationScope.languageManager.getLanguageValue('el_no_courseTaught', sessionScope.tag)}" />
			</c:otherwise>
		</c:choose>
</c:when>
</c:choose>
<c:choose>
	<c:when test="${courseDirected == true}">
		<c:choose>
			<c:when test="${monitorCourse!=null && monitorCourse.size()>= 1}">
				<h4 class="subtitle">
					<c:out
						value="${applicationScope.languageManager.getLanguageValue('el_monitor_mycourse', sessionScope.tag)}" />
				</h4>
				<c:forEach items="${monitorCourse}" var="uC">
					<p>
						<a
							href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('viewCourse')}&d=${applicationScope.encryptor.encrypt(uC['courseId'])}"><c:out
								value="${uC['courseName']}" /></a>
					</p>
				</c:forEach>
			</c:when>
			<c:otherwise>
			<c:out
					value="${applicationScope.languageManager.getLanguageValue('el_no_courseDirected', sessionScope.tag)}" />
			
			</c:otherwise>
		</c:choose>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${courseFollowed == true}">
		<c:choose>
			<c:when test="${studentCourse!=null && studentCourse.size()>= 1}">
				<h4 class="subtitle">
					<c:out
						value="${applicationScope.languageManager.getLanguageValue('el_student_mycourse', sessionScope.tag)}" />
				</h4>
				<c:forEach items="${studentCourse}" var="uC">
					<p>
						<a
							href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('viewCourse')}&d=${applicationScope.encryptor.encrypt(uC['courseId'])}"><c:out
								value="${uC['courseName']}" /></a>
						<a
							href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('viewExams')}&d=${applicationScope.encryptor.encrypt(uC['courseId'])}"><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_write', sessionScope.tag)}" /></a>
					</p>
				</c:forEach>
			</c:when>
			<c:otherwise>
			<c:out
					value="${applicationScope.languageManager.getLanguageValue('el_no_courseFollowed', sessionScope.tag)}" />
			
			</c:otherwise>
		</c:choose>
	</c:when>
</c:choose>
