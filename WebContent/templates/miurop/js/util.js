$(document).ready(function(){
	ropopenclose = function(){
		var parent = this.parentNode;
		if($(parent).hasClass('closed')){
			$(parent).find('.sidenav').animate({'display' : 'block', 'height' : 'show'}, 300);
			$(this).removeClass('plus');
			$(this).addClass('minus');
			$(parent).removeClass('closed');
		}else{
			$(parent).find('.sidenav').animate({'display' : 'none', 'height' : 'hide'}, 300);
			$(this).removeClass('minus');
			$(this).addClass('plus');
			$(parent).addClass('closed');
		}
	};
	$(document.querySelectorAll('#leftblock .leftcontent')).each(function(){
		$(this).addClass('closed');
		$(this).find('.lefttitle').removeClass('minus').addClass('plus');
		$(this).find('.sidenav').css({'display' : 'none'});
		$(this).find('.lefttitle').click(ropopenclose);
	});
	$(document.querySelector('#leftblock .leftcontent:nth-child(1)')).removeClass('closed');
	$(document.querySelector('#leftblock .leftcontent:nth-child(1)')).find('.lefttitle').removeClass('plus').addClass('minus');
	$(document.querySelector('#leftblock .leftcontent:nth-child(1)')).find('.sidenav').css({'display' : 'block'});
});