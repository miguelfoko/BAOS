/**
 * @product MIU Slideshow
 * @author Ndadji Maxime
 * @project MIU Web Projects
 * @license http://www.gnu.org/copyleft/gpl.html GNU/GPL
 * @version 1.0
 * @dependencies jQuery, jQuery UI
 *
 *
 *********************************************************
 *            Using MIUSlideshow function                *
 *********************************************************
 *
 * <div id="slideshow_id">
 *	<div class="slide">Slide 1 HTML content</div>
 *	<div class="slide">Slide 2 HTML content</div>
 * </div>
 *
 * <script type="text/javascript">
 *	jQuery(document).ready(function(){
 *		var v = MIUSlideshow({
 *			element : "#slideshow_id",
 *			height : "200px",
 *			param 3 : value 3,
 *			param n : value n
 *		});
 *	});
 * </script>
 */
function MIUSlideshow(params){
	this.version = "v1.0";
	this.author = "Ndadji Maxime";
	
	if(params != null && params.element != null && jQuery(params.element) != null){
		var slideShow = jQuery(params.element);
		var height = params.height ? params.height : "250px";
		slideShow.find("div.slide").wrapAll("<div class=\"slide_inner\"></div>");
		slideShow.find("div.slide_inner").wrapAll("<div class=\"slide_viewport\"></div>");
		slideShow.html('<div class="slide_control left_control_wrapper">'
						+'<div class="slide_helper"></div>'
						+'<a href="#" class="slide_control_link left_control"></a>'
					  +'</div>'
					  	+'<div class="slide_control right_control_wrapper">'
					  	+'<div class="slide_helper"></div>'
					  	+'<a href="#" class="slide_control_link right_control"></a>'
					  +'</div>'
					  +slideShow.html());
		var slides = slideShow.find("div.slide");
		var viewPort = slideShow.find("div.slide_viewport");
		var slideWidth = parseInt(viewPort.css("width").substring(0, viewPort.css("width").length - 2), 10);
		var effect = params.effect ? params.effect : "easeInOutBounce";
		var currentSlide = 1;
		var animate = (params.animate != null) ? params.animate : true;
		var duration = params.duration ? params.duration : 8000;
		var autoHideArrows = (params.autoHideArrows  != null) ? params.autoHideArrows : true;
		
		slideShow.find("div.slide_viewport, div.slide_inner").css("height", height);
		slideShow.find("div.slide_control").css({"height" : height, "lineHeight" : height});
		slideShow.find("div.slide_inner").css("width", (slideWidth * slides.length)+"px");
		slides.css({"width" : (slideWidth)+"px", "height" : (parseInt(height.substring(0, height.length - 2), 10) - 20)+"px", "margin" : "0px", "float" : "left", "padding" : "0px", "marginLeft" : "0px"});
		
		/*var updateSlides = function(){
			slides.css({"visibility" : "hidden"});
			slideShow.find("div.slide_inner > div.slide:nth-child("+currentSlide+")").css("visibility", "visible");
		};
		updateSlides();*/
		
		slideShow.find("div.right_control_wrapper").css("marginLeft", (slideWidth - 32)+"px");
	
		var selectToShow = function(){
			var selector = "";
			if(slides.length > 1){
				if(currentSlide == 1)
					selector = "div.right_control_wrapper";
				else{
					if(currentSlide == slides.length)
						selector = "div.left_control_wrapper";
					else
						selector = "div.left_control_wrapper, div.right_control_wrapper";
				}
			}
			return selector;
		};
		
		var selectToHide = function(){
			var selector = "";
			if(slides.length == 1)
				selector = "div.left_control_wrapper, div.right_control_wrapper";
			else{
				if(slides.length > 1){
					if(currentSlide == 1)
						selector = "div.left_control_wrapper";
					else{
						if(currentSlide == slides.length)
							selector = "div.right_control_wrapper";
					}
				}
			}
			return selector;
		};
		
		var updateArrows = function(){
			slideShow.find(selectToHide()).fadeOut(300, effect);
			slideShow.find(selectToShow()).fadeIn(300, effect);
		};
		
		updateArrows();
		slideShow.find("div.slide_control").css({"display" : (autoHideArrows ? "none" : "block")});
		
		var nextSlide = function(){
			if(currentSlide < slides.length){
				slideShow.find("div.slide_inner").animate({"marginLeft" : (-slideWidth * currentSlide)+"px"}, 800, effect);
				currentSlide++;
				//updateSlides();
			}
			return false;
		};
		
		prevSlide = function(){
			if(currentSlide > 1){
				currentSlide--;
				slideShow.find("div.slide_inner").animate({"marginLeft" : (-slideWidth * (currentSlide - 1))+"px"}, 800, effect);
				//updateSlides();
			}
			return false;
		};
		
		var direction = "";
		var animationInterval = null;
		var doAnimation = function(){
			if(currentSlide == 1)
				direction = "right";
			else{
				if(currentSlide == slides.length)
					direction = "left";
			}
			if(direction == "right")
				nextSlide();
			else
				prevSlide();
			if(!autoHideArrows)
				updateArrows();
		};
		
		if(animate)
			animationInterval = setInterval(doAnimation, duration);
		
		slideShow.find("a.right_control").click(function(){
			nextSlide();
			updateArrows();
			return false;
		});
		
		slideShow.find("a.left_control").click(function(){
			prevSlide();
			updateArrows();
			return false;
		});
		
		var hoverTimeout = null;
		slideShow.mouseover(function(){
			clearTimeout(hoverTimeout);
			clearInterval(animationInterval);
			slideShow.find("div.right_control_wrapper").css("marginLeft", (parseInt(viewPort.css("width").substring(0, viewPort.css("width").length - 2), 10) - 32)+"px");
			slideShow.find(selectToShow()).fadeIn(300, effect);
		});
		
		slideShow.mouseout(function(){
			hoverTimeout = setTimeout(function(){
				if(autoHideArrows)
					slideShow.find("div.slide_control").fadeOut(300, effect);
				else{
					slideShow.find(selectToHide()).fadeOut(300, effect);
				}
			}, 500);
			if(animate){
				animationInterval = setInterval(doAnimation, duration);
			}
		});
		
		jQuery(window).bind('resize', function(e){
			slideWidth = parseInt(viewPort.css("width").substring(0, viewPort.css("width").length - 2), 10);
			slides.css("width" , (slideWidth)+"px");
			slideShow.find("div.slide_inner").css("width", (slideWidth * slides.length)+"px");
		});
	}
	return this;
}