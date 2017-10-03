$(document).ready(function() {
	
	$('#listOfJournals').change(function (){
		if ($('#listOfJournals').val() == 'modPublicationDefaultJournal') 
			$('#authorManagement').fadeOut(2000);
		else 
			$('#authorManagement').fadeIn(2000);
	});
	
	
	var validateAuthor = (function () {
		$('#guideForAuthors').fadeIn(2000);
		$('#requestEditor').fadeIn(2000);
		$('#suggestReviewer').fadeIn(2000);
	});
	
	$('.authorManagement').click(validateAuthor);
	
var validateReviewer = (function () {
	$('#paperInformations').fadeIn(2000);
});

$('.reviewerManagement').click(validateReviewer);


$('#requestEditor').change(function (){
	if ($('#requestEditor').val() == 'modPublicationDefault') 
		$('#paperInformations').fadeOut(2000);
	else 
		$('#paperInformations').fadeIn(2000);
});

});
