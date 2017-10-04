<h4 class="subtitle">
	<c:out value="${examination['examinationName']}" />
</h4>
<br>
<c:choose>
	<c:when test="${isExamOpened == false}">
		<c:out
			value="${applicationScope.languageManager.getLanguageValue('el_examination_not_opened', sessionScope.tag)}" />
	</c:when>
	<c:otherwise>
	<c:choose>
		<c:when test="${isExamPassed == true}">
			<c:out
				value="${applicationScope.languageManager.getLanguageValue('el_examination_passed', sessionScope.tag)}" />
		</c:when>
		<c:otherwise>
		
		<c:choose>
			<c:when test="${questions!=null && questions.size()>= 1}">
				<table>
					<c:forEach items="${questions}" var="q">
						<p>
								<c:out
									value="${q['questionContent']}" />
						</p>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>



