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

function verifForm3(f){
	var news_title = verifPseudo(f.news_title);
	var news_key = verifPseudo(f.news_key);
	var news_language = verifPseudo(f.news_language);
	var news_state = verifState(f.news_state);
	var news_content = verifPseudo(f.news_content);
	//if(journalOrConfName && mailOk && ageOk)
	if(news_title && news_key&&news_language&&news_state&&news_content)
		return true;
	else{
		alert("Veuillez remplir correctement tous les champs");
		return false;
	}
}
