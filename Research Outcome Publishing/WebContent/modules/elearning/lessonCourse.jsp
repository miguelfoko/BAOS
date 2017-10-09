<h4 class="subtitle">
	<c:out
		value="${applicationScope.languageManager.getLanguageValue('el_lesson_course', sessionScope.tag)}" />
</h4>

<c:choose>
	<c:when test="${baoUser != null}">
		<div id="elForm" class="2-b_article 1st-b_article b_article">
			<div id="form" class="row">
				<form enctype="multipart/form-data" method="post"
					action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />&o=${applicationScope.encryptor.encrypt('LessonCourse')}"
					name="elForm" class="form col-md-12">
					<div class="form-group">
						<label class="el_label auth_label control-label" for="icon"><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_icon', sessionScope.tag)}" /><span class="required">*</span></label>
						<input type="file" name="icon" id="icon" class="el_text_zone auth_text_zone form-control" 
							value="<c:out value="${param.file}" />" required
							placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_icon', sessionScope.tag)}" />" />
					</div>
					<div class="form-group">
						<label class="el_label auth_label control-label" for="name"><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_name', sessionScope.tag)}" /><span class="required">*</span></label>
						<input type="text" name="name" id="name"
							value="<c:out value="${param.name}" />" required
							class="el_text_zone auth_text_zone form-control"
							placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_name', sessionScope.tag)}" />" />
					</div>
					<div class="form-group">
						<label class="el_label auth_label control-label" for="start"><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_start_time', sessionScope.tag)}" /><span class="required">*</span></label>
						<input type="date" name="start" id="start" class="el_text_zone auth_text_zone form-control"
							value="<c:out value="${dateToday}"/>"  min="<c:out value="${dateToday}"/>" required
							placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_start_time', sessionScope.tag)}" />" />
					</div>
					<div class="form-group">
						<label class="el_label auth_label control-label" for="end"><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_end_time', sessionScope.tag)}" /><span class="required">*</span></label>
						<input type="date" name="end" id="end" class="el_text_zone auth_text_zone form-control"
							value="<c:out value="${dateToday}"/>"  min="<c:out value="${dateToday}"/>" required
							placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_end_time', sessionScope.tag)}" />" />
					</div>
					<div class="form-group">
						<label class="el_label auth_label control-label" for="level"><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_diff_level', sessionScope.tag)}" /><span class="required">*</span></label>
						<input type="number" name="level" id="level" class="el_text_zone auth_text_zone form-control"
							min=1 value="<c:out value="${param.level}" />" required
							placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_diff_level', sessionScope.tag)}" />" />
					</div>
					<div class="form-group">
						<label class="el_label auth_label control-label" for="file"><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_file', sessionScope.tag)}" /><span class="required">*</span></label>
						<input type="file" name="file" id="file" class="el_text_zone auth_text_zone form-control" min=1
							value="<c:out value="${param.file}" />" required
							placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_file', sessionScope.tag)}" />" />
					</div>
					<div class="form-group">
						<label class="el_label auth_label control-label" for="desc"><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_desc', sessionScope.tag)}" /><span class="required">*</span></label>
						<textarea name="desc" id="desc" cols=50 rows=5 class="el_text_zone auth_text_zone form-control"
							required
							placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_desc', sessionScope.tag)}" />">
							<c:out value="${param.desc}" />
						</textarea>
					</div>	
					<div class="form-group">	
						<label class="el_label auth_label control-label" for="content"><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_content', sessionScope.tag)}" /><span class="required">*</span></label>
						<textarea name="content" id="contenu" cols=50 rows=5 class="el_text_zone auth_text_zone form-control"
							required
							placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('el_content', sessionScope.tag)}" />">
							<c:out value="${param.content}" />
						</textarea>
					</div>
					<div class="form-group pull-right"> 
					<input type="submit"
						value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_submit', sessionScope.tag)}" />"
						class="el_button auth_button btn btn-success" /> <input type="reset"
						value="<c:out value="${applicationScope.languageManager.getLanguageValue('el_reset', sessionScope.tag)}" />"
						class="el_button auth_button btn btn-success" />
					</div>
					<c:if test="${lessonCourseError != null}">
						<em><c:out
								value="${applicationScope.languageManager.getLanguageValue('el_lesson_course_error', sessionScope.tag)}" /></em>
					</c:if>
				</form>
			</div>
		</div>
		<div id="regButtons" class="2-b_article lst-b_article b_article">

		</div>
	</c:when>
	<c:otherwise>
		<a
			href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}&o=${applicationScope.encryptor.encrypt('login')}" />"><c:out
				value="${applicationScope.languageManager.getLanguageValue('logout_title', sessionScope.tag)}" /></a>
	</c:otherwise>
</c:choose>