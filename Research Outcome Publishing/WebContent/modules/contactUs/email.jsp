<div class="row">
	<div class="col-md-12">
		<h4><c:out value="${applicationScope.languageManager.getLanguageValue('cu_email', sessionScope.tag)}" />: dev.miu.baos@gmail.com</h4>
	</div>
</div>

<form method="post" action="#" name="subUploadPaperForm" class="form col-md-12">
	<legend><c:out value="${applicationScope.languageManager.getLanguageValue('cu_legend_form', sessionScope.tag)}" /></legend>
			<div id="form-title-group" class="form-group <c:if test="${addPaperTitleError != null}">has-error</c:if>">
					<label class="auth_label control-label" for="userName"><c:out value="${applicationScope.languageManager.getLanguageValue('cu_name_form', sessionScope.tag)}" /><span class="required">*</span></label>
					<input type="text" name="userName" id="userName"  required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('cu_name_form_placeholder', sessionScope.tag)}" />" />
			</div>
			<div id="form-abstract-group" class="form-group <c:if test="${addPaperAbstractError != null}">has-error</c:if>">
					<label class="auth_label control-label" for="userMessage"><c:out value="${applicationScope.languageManager.getLanguageValue('cu_message_form', sessionScope.tag)}" /><span class="required">*</span></label>
					<textarea name="userMessage" id="userMessage" required class="auth_text_zone form-control" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('cu_message_form_holder', sessionScope.tag)}" />"><c:out value="${param.paperTitle}" /></textarea>
					<span class="help-block" id="paperAbstractError"><c:out value="${addPaperAbstractError}" /></span>
					<input type="hidden" id="addPaperAbstractError" value="<c:out value="${applicationScope.languageManager.getLanguageValue('pub_paper_abstract_error', sessionScope.tag)}" />" />
			</div>


</form>
<script type="text/javascript">
		$(document).ready(function(){
			tinymce.init({
					selector: '#userMessage',
					menubar: 'edit format',
					autosave_interval: '20s',
					language: '<c:out value="${sessionScope.tag}" />',
					plugins: [
					          'autolink link spellchecker',
					          'wordcount',
					          'contextmenu paste textcolor'
					 ]
				});
			});
</script>