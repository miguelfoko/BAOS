function surligne(champ, erreur){
	   if(erreur)
	      champ.style.backgroundColor = "#fba";
	   else
	      champ.style.backgroundColor = "";
	}
function verifPseudo(champ){
	if(champ.value.length < 2 || champ.value.length > 25){
		surligne(champ, true);
		return false;
	}else{
		surligne(champ, false);
		return true;
	}
}

function verifState(champ){
	if(isNaN(champ.value)||champ.value.length==0){
		champ.value="";
		surligne(champ, true);
		return false;
	}
	var val=parseInt(champ.value);
	if(val < 0 || val > 1){
		surligne(champ, true);
		return false;
	}else{
		surligne(champ, false);
		return true;
	}
}

function verifState1(champ){
	if(isNaN(champ.value)||champ.value.length==0){
		champ.value="";
		surligne(champ, true);
		return false;
	}
	var val=parseInt(champ.value);
	if(val <=0){
		surligne(champ, true);
		return false;
	}else{
		surligne(champ, false);
		return true;
	}
}

function verifState2(champ){
	if(isNaN(champ.value)||champ.value.length==0){
		champ.value="";
		surligne(champ, true);
		return false;
	}
	var val=parseInt(champ.value);
	if(val <50||val>100){
		surligne(champ, true);
		return false;
	}else{
		surligne(champ, false);
		return true;
	}
}


function verifForm(f){
	var journalOrConfName = verifPseudo(f.journalOrConfName);
	//if(journalOrConfName && mailOk && ageOk)
	if(journalOrConfName)
		return true;
	else{
		alert("Veuillez remplir correctement tous les champs");
		return false;
	}
}

function verifForm2(f){
	var journalOrConfName = verifPseudo(f.journalOrConfName);
	var journalOrConfState = verifState(f.journalOrConfState);
	//if(journalOrConfName && mailOk && ageOk)
	if(journalOrConfName && journalOrConfState)
		return true;
	else{
		alert("Veuillez remplir correctement tous les champs");
		return false;
	}
}

function verifFormX(f){
	var journalOrConfName = verifPseudo(f.journalOrConfName);
	if(journalOrConfName)
		return true;
	else{
		alert("Veuillez remplir correctement tous les champs");
		return false;
	}
}

function verifForm3(f){
	var journal_review_name = verifPseudo(f.journal_review_name);
	var journal_review_condition_max_reviewer = verifState1(f.journal_review_condition_max_reviewer);
	var journal_review_condition_paper_success_percent = verifState2(f.journal_review_condition_paper_success_percent);
	var journal_review_condition_max_paper_allowed = verifState1(f.journal_review_condition_max_paper_allowed);
	var journal_review_condition_accept_without_editor = verifPseudo(f.journal_review_condition_accept_without_editor);
	//if(journalOrConfName && mailOk && ageOk)
	if(journal_review_name && journal_review_condition_max_reviewer&&journal_review_condition_paper_success_percent&&
			journal_review_condition_max_paper_allowed&&journal_review_condition_accept_without_editor)
		return true;
	else{
		alert("Veuillez remplir correctement tous les champs");
		return false;
	}
}

function verifForm4(f){
	var journal_volume_issue_identifier = verifPseudo(f.journal_volume_issue_identifier);
	var journal_volume_issue_state = verifState(f.journal_volume_issue_state);
	//if(journalOrConfName && mailOk && ageOk)
	if(journal_volume_issue_identifier && journal_volume_issue_state)
		return true;
	else{
		alert("Veuillez remplir correctement tous les champs");
		return false;
	}
}
