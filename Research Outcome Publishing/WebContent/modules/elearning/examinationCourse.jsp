<h4 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('el_click_write', sessionScope.tag)}" />
</h4>
<br>
<c:choose>
	<c:when test="${examinationCourse!=null && examinationCourse.size()>= 1}">
		<table>
			<c:forEach items="${examinationCourse}" var="eC">
				<p>
					<a
						href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('examSheet')}&d=${applicationScope.encryptor.encrypt(eC['examinationId'])}"><c:out
							value="${eC['examinationName']}" /></a>
					<br>
				</p>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<c:out
			value="${applicationScope.languageManager.getLanguageValue('el_no_examination', sessionScope.tag)}" />
	</c:otherwise>
</c:choose>



