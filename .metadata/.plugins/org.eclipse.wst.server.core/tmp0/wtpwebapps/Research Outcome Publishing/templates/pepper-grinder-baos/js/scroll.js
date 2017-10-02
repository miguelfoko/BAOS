var scrollToTop = {
	setting :  {startline : 300, scrollto :  0, scrollduration : 700, fadeduration : [500, 100]},
	controlHTML :  '<span class="glyphicon glyphicon-circle-arrow-up"></span>',
	controlOffsets :  {offsetx : 50, offsety : 20},
	anchorKeyword :  '#scroll-top',

	state :  {isvisible : false, shouldvisible : false},

	goUp : function(){
		if (!this.cssfixedsupport)
			this.$control.css({opacity : 0});
		var dest = isNaN(this.setting.scrollto)? this.setting.scrollto  :  parseInt(this.setting.scrollto);
		if (typeof dest=="string" && jQuery('#'  +  dest).length==1)
			dest = jQuery('#' + dest).offset().top;
		else
			dest = 0;
		this.$body.animate({scrollTop :  dest}, this.setting.scrollduration);
	},

	keepFixed : function(){
		var $window = jQuery(window);
		var controlx = $window.scrollLeft()  +  $window.width()  -  this.$control.width()  -  this.controlOffsets.offsetx;
		var controly = $window.scrollTop()  +  $window.height()  -  this.$control.height()  -  this.controlOffsets.offsety;
		this.$control.css({left : controlx + 'px', top : controly + 'px'});
	},

	controlAction : function(){
		var scrolltop = jQuery(window).scrollTop();
		if (!this.cssfixedsupport)
			this.keepFixed();
		this.state.shouldvisible = (scrolltop>= this.setting.startline)? true  :  false;
		if (this.state.shouldvisible && !this.state.isvisible){
			this.$control.stop().animate({opacity : 1}, this.setting.fadeduration[0]);
			this.state.isvisible = true;
		}
		else if (this.state.shouldvisible==false && this.state.isvisible){
			this.$control.stop().animate({opacity : 0}, this.setting.fadeduration[1]);
			this.state.isvisible = false;
		}
	},
	
	start : function(params){
		jQuery(document).ready(function($){
			var scrollTopObj = scrollToTop;
			var internetExplorer = document.all;
			scrollTopObj.cssfixedsupport = !internetExplorer || internetExplorer && document.compatMode=="CSS1Compat" && window.XMLHttpRequest;
			scrollTopObj.$body = (window.opera)? (document.compatMode=="CSS1Compat"? $('html')  :  $('body'))  :  $('html,body');
			scrollTopObj.$control = $('<div id = "pgb-scrolltop-control">' + scrollTopObj.controlHTML + '</div>')
				.css({position : scrollTopObj.cssfixedsupport? 'fixed'  :  'absolute', bottom : scrollTopObj.controlOffsets.offsety, right : scrollTopObj.controlOffsets.offsetx, opacity : 0, cursor : 'pointer'})
				.attr({title : params.scrollTitle})
				.click(function(){scrollTopObj.goUp(); return false;})
				.appendTo('#pgb-return-to-top');
			if (document.all && !window.XMLHttpRequest && scrollTopObj.$control.text()!='')
				scrollTopObj.$control.css({width : scrollTopObj.$control.width()});
			scrollTopObj.controlAction();
			$('a[href = "'  +  scrollTopObj.anchorKeyword  + '"]').click(function(){
				scrollTopObj.goUp();
				return false;
			});
			$(window).bind('scroll resize', function(e){
				scrollTopObj.controlAction();
			});
		});
	}
};