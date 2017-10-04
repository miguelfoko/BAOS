<htm>
<head>

<meta name="description" content="jquery section scrolling plugin"/>
    <meta name="robots" content="noodp"/>
    <link type="text/css" rel="stylesheet" href="modules/controlpanel/css/materialize.css" media="screen,projection" />

    <link rel="stylesheet" type="text/css" href="modules/controlpanel/css/prism.css">


    <link rel="stylesheet" type="text/css" href="modules/controlpanel/css/section-scroll.css">
    <link rel="stylesheet" type="text/css" href="modules/controlpanel/css/style.css">
    
<SCRIPT LANGUAGE="JavaScript">
	var num = 1
	img1 = new Image()
	img1.src = "modules/controlpanel/images/img/1.jpg"
	img2 = new Image()
	img2.src = "modules/controlpanel/images/img/2.jpg"
	img3 = new Image()
	img3.src = "modules/controlpanel/images/img/3.jpg"
	img4 = new Image()
	img4.src = "modules/controlpanel/images/img/4.jpg"
	img5 = new Image()
	img5.src = "modules/controlpanel/images/img/5.jpg"

	text1 = "Text for Picture One"
	text2 = "Text for Picture Two"
	text3 = "Text for Picture Three"
	text4 = "Text for Picture Four"
	text5 = "Text for Picture Five"

	function slideshowUp() {
		num = num + 1
		if (num == 6) {
			num = 1
		}
		document.mypic.src = eval("img" + num + ".src")
		document.joe.burns.value = eval("text" + num)
	}

	function slideshowBack() {
		num = num - 1
		if (num == 0) {
			num = 5
		}
		document.mypic.src = eval("img" + num + ".src")
		document.joe.burns.value = eval("text" + num)
	}
</SCRIPT>
</head>
<body>

<div class="hero-unit scrollable-section" data-section-title="Welcome">
  <CENTER>
	<div id="slideshow1">
   <div>
     <img src="modules/controlpanel/images/img/1.jpg" BORDER=0 HEIGHT="300"
		WIDTH="100%">
		<H1>UN BLABLABLA QUI PRESENTE LE MODULE DU E-LEARNING AVEC DES IMAGES QUI VONT AVEC</H1>
   </div>
   <div>
     <img src="modules/controlpanel/images/img/2.jpg" BORDER=0 HEIGHT="300"
		WIDTH="100%">
		<H1>DEUX BLABLABLA QUI PRESENTENT LE MODULE DU E-LEARNING AVEC DES IMAGES QUI VONT AVEC</H1>
   </div>
   <div>
     <img src="modules/controlpanel/images/img/3.jpg" BORDER=0 HEIGHT="300"
		WIDTH="100%">
		<H1>TROIS BLABLABLA QUI PRESENTENT LE MODULE DU E-LEARNING AVEC DES IMAGES QUI VONT AVEC</H1>
   </div>
   <div>
     <img src="modules/controlpanel/images/img/4.jpg" BORDER=0 HEIGHT="300"
		WIDTH="100%">
		<H1>QUATRE BLABLABLA QUI PRESENTENT LE MODULE DU E-LEARNING AVEC DES IMAGES QUI VONT AVEC</H1>
   </div>
   <div>
     <img src="modules/controlpanel/images/img/5.jpg" BORDER=0 HEIGHT="300"
		WIDTH="100%">
		<H1>CINQ BLABLABLA QUI PRESENTENT LE MODULE DU E-LEARNING AVEC DES IMAGES QUI VONT AVEC</H1>
   </div>
   
</div>
<h1>PRESENTATION DE QUELQUES COURS 0 CE NIVEAU, PUIS SPECIFICATION DU RESTE DE COURS 
SUR UN LIEN CLIQUABLE</h1>
</CENTER>

</div>
<br><br>
<section class="scrollable-section what-is-this" data-section-title="What is this">
<CENTER>
	<a href="#"><IMG SRC="modules/controlpanel/images/img/1.jpg" NAME="mypic" BORDER=0 HEIGHT="350"
		WIDTH="100%">
	</a>
	<p>
	<FORM NAME="joe">
		<INPUT TYPE="text" WIDTH="100" NAME="burns"
			VALUE="Text For Picture One" editable="false">
	</FORM>
<H1>PRESENTATION DES AUTRES FONCTIONNALITES DU SITE</H1>
<!-- 	<A HREF="JavaScript:slideshowBack()"> Back</A> <A -->
<!-- 		HREF="JavaScript:slideshowUp()"> Next</A> -->
</CENTER>
    </section>
    <br><br>
     <section class="scrollable-section" data-section-title="HTML">
    </section>
    
    <br><br>
     <section class="scrollable-section" data-section-title="Call and Customize">
       
    </section>
    <script type="text/javascript" src="modules/controlpanel/js/jquery.min.js"></script>
    <script type="text/javascript" src="modules/controlpanel/js/prism.js"></script>
    <script type="text/javascript" src="modules/controlpanel/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="modules/controlpanel/js/jquery.section-scroll.js"></script>
    <script type="text/javascript" src="modules/controlpanel/js/materialize.min.js"></script>



    <script type="text/javascript">
        $(document).ready(function () {
            $('body').sectionScroll({
                easing: 'easeInOutQuart',
                scrollDuration: 1200
            });


            $('body').on('section-reached', function() {
                var section_title = $('body').sectionScroll.activeSection.data('section-title');
                Materialize.toast('In view: ' + section_title, 1000);
            })

        })
    </script>
    
<!-- The Image and Form Codes are Below -->
<script type="text/javascript">
$("#slideshow > div:gt(0)").hide();

setInterval(function() {
  $('#slideshow > div:first')
    .fadeOut(1000)
    .next()
    .fadeIn(1000)
    .end();
    //.appendTo('#slideshow');
}, 5000);
</script>

<script type="text/javascript">
$("#slideshow1 > div:gt(0)").hide();

setInterval(function() {
  $('#slideshow1 > div:first')
    .fadeOut(3000)
    .next()
    .fadeIn(3000)
    .end()
     .appendTo('#slideshow1');
}, 15000);
</script>

</body>
</htm>