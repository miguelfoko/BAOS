$(document).ready(function(){
	$('.cmd').bind('mouseover', function(){
		$(this)
			.find('.cmdCircle')
			.stop()
			.animate({'border-width' : '0.1em'}, 200);
	});
	
	$('.cmd').bind('mouseout', function(){
		$(this)
			.find('.cmdCircle')
			.stop()
			.animate({'border-width' : '0.3em'}, 200);
	});
});