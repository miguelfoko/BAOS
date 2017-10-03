$(document).ready(function() {
	$('.cmd').bind('mouseover', function() {
		$(this).find('.cmdCircle').stop().animate({
			'border-width' : '0.1em'
		}, 200);
	});

	$('.cmd').bind('mouseout', function() {
		$(this).find('.cmdCircle').stop().animate({
			'border-width' : '0.3em'
		}, 200);
	});
});

function showDiv(value) {
	document.getElementById(value).setAttribute("style",
			"display:inline-block;");
}
function hideDiv(value) {
	document.getElementById(value).setAttribute("style", "display:none;");
}
function getDate() {
	alert("start");
	Date today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;
	var yy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		dd = '0' + mm;
	}
	document.getElementById("start").setAttribute("min",
			yy + '-' + mm + '/' + dd);
}

function showData(value) {
	$.ajax({
		url : "ModElearning?o=ajaxMonitorCourse&d=" + value,
		type : "GET",
		async : true
	});
}
function showData2(value) {
	$.ajax({
		url : "ModElearning?o=ajaxSubscribeCourse&d=" + value,
		type : "GET",
		async : true
	});
}
