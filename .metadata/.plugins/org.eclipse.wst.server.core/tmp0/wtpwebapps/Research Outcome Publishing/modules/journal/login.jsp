<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'un client</title>
<link type="text/css" rel="stylesheet" href="modules/journal/inc/style.css" />
</head>
<body>
	<div>
		<form method="post" action="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('journal')}" />&o=${applicationScope.encryptor.encrypt('ModJournal')}">
			<fieldset>
				<legend>Journal Information</legend>
				<label for="journalOrConfName">${journal_name}<span class="requis">*</span></label> <input
					type="text" id="journalOrConfName" name="journalOrConfName" value="" size="30"
					maxlength="30" /> <br /> <label for="journalOrConfName">${journal_type } <span class="requis">*</span></label> 
					<select id="journalOrConfType" name="journalOrConfType">
					    <option>${journal_choose_type }</option>
					    <option>Journal</option>
					    <option>Conference</option>
					</select>
					 <br /> 
					 <label for="journalOrConfState">${journal_state} <span class="requis">*</span>
				</label> <input type="text" id="journalOrConfState" name="journalOrConfState" value=""
					size="30" maxlength="30" /> 
					<br /> 
					 <label for="journalOrConfLogo">${journal_logo}
				</label> <input type="text" id="journalOrConfLogo" name="journalOrConfLogo" value=""
					size="30" maxlength="30" />
					<br /> 
					 <label for="journalOrConfShortDesc">${journal_short_desc}
				</label> 
				<input type="text" id="journalOrConfShortDesc" name="journalOrConfShortDesc" value=""
					size="30" maxlength="100" />
					<br /> 
					 <label for="journalOrConfLongDesc">${journal_long_desc}
				</label> 
				<textarea rows="6" cols="70" id="journalOrConfLongDesc" name="journalOrConfLongDesc">
                   ${journal_long_desc_text}
                </textarea> 
			</fieldset>
			<input type="submit" value="${journal_creation_submit_button }" /> 
			<input type="reset"	value="${journal_creation_cancel_button }" /> <br />
		</form>
	</div>
</body>
</html>