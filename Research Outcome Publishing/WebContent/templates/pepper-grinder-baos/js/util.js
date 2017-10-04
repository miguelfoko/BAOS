//Variables and functions
var pgb_close_status_bar = function(event){
	$('#pgb-status-container').fadeOut(1000);
	return false;
};
var pgb_close_status_action_bar = function(){
	$('#pgb-status-action-row').fadeOut(500);
	return false;
};
var update_status_bar = function(row){
	var num_showing = 0;
	$('#pgb-status-container > .row > .pgb-status-real-container > .pgb-status-row').each(function(){
		if($(this).css('display') !== 'none' && (!row || $(this).attr('id') !== row.attr('id')))
			num_showing++;
	});
	if(num_showing == 0){
		pgb_close_status_bar();
		return false;
	}
	if(num_showing == 1){
		pgb_close_status_action_bar();
	}
	return false;
};
var pgb_close_status = function(event){
	var row = $($(this).attr('data-target'));
	row.fadeOut(500);
	update_status_bar(row);
	return false;
};

//Initialisation
$(document).ready(function(){
	$('.pgb-status-bar-closer').click(pgb_close_status_bar);
	$('.pgb-status-closer').click(pgb_close_status);
	update_status_bar();
	
	$('#pgb-status-container').fadeIn(1500);
	
	$(".pgb-accordeon-item").on("shown.bs.collapse", function(){
		var toggle = $(this.parentNode).find('.pgb-toggle-sign');
		toggle.removeClass('glyphicon-plus');
		toggle.addClass('glyphicon-minus');
	});
	
	$(".pgb-accordeon-item").on("hidden.bs.collapse", function(){
		var toggle = $(this.parentNode).find('.pgb-toggle-sign');
		toggle.removeClass('glyphicon-minus');
		toggle.addClass('glyphicon-plus');
	});
});