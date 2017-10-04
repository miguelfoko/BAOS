package org.apache.jsp.modules.controlpanel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/ressources/jsp/taglibs.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<htm>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta name=\"description\" content=\"jquery section scrolling plugin\"/>\r\n");
      out.write("    <meta name=\"robots\" content=\"noodp\"/>\r\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"modules/controlpanel/css/materialize.css\" media=\"screen,projection\" />\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"modules/controlpanel/css/prism.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"modules/controlpanel/css/section-scroll.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"modules/controlpanel/css/style.css\">\r\n");
      out.write("    \r\n");
      out.write("<SCRIPT LANGUAGE=\"JavaScript\">\r\n");
      out.write("\tvar num = 1\r\n");
      out.write("\timg1 = new Image()\r\n");
      out.write("\timg1.src = \"modules/controlpanel/images/img/1.jpg\"\r\n");
      out.write("\timg2 = new Image()\r\n");
      out.write("\timg2.src = \"modules/controlpanel/images/img/2.jpg\"\r\n");
      out.write("\timg3 = new Image()\r\n");
      out.write("\timg3.src = \"modules/controlpanel/images/img/3.jpg\"\r\n");
      out.write("\timg4 = new Image()\r\n");
      out.write("\timg4.src = \"modules/controlpanel/images/img/4.jpg\"\r\n");
      out.write("\timg5 = new Image()\r\n");
      out.write("\timg5.src = \"modules/controlpanel/images/img/5.jpg\"\r\n");
      out.write("\r\n");
      out.write("\ttext1 = \"Text for Picture One\"\r\n");
      out.write("\ttext2 = \"Text for Picture Two\"\r\n");
      out.write("\ttext3 = \"Text for Picture Three\"\r\n");
      out.write("\ttext4 = \"Text for Picture Four\"\r\n");
      out.write("\ttext5 = \"Text for Picture Five\"\r\n");
      out.write("\r\n");
      out.write("\tfunction slideshowUp() {\r\n");
      out.write("\t\tnum = num + 1\r\n");
      out.write("\t\tif (num == 6) {\r\n");
      out.write("\t\t\tnum = 1\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.mypic.src = eval(\"img\" + num + \".src\")\r\n");
      out.write("\t\tdocument.joe.burns.value = eval(\"text\" + num)\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction slideshowBack() {\r\n");
      out.write("\t\tnum = num - 1\r\n");
      out.write("\t\tif (num == 0) {\r\n");
      out.write("\t\t\tnum = 5\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.mypic.src = eval(\"img\" + num + \".src\")\r\n");
      out.write("\t\tdocument.joe.burns.value = eval(\"text\" + num)\r\n");
      out.write("\t}\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"hero-unit scrollable-section\" data-section-title=\"Welcome\">\r\n");
      out.write("  <CENTER>\r\n");
      out.write("\t<div id=\"slideshow1\">\r\n");
      out.write("   <div>\r\n");
      out.write("     <img src=\"modules/controlpanel/images/img/1.jpg\" BORDER=0 HEIGHT=\"300\"\r\n");
      out.write("\t\tWIDTH=\"100%\">\r\n");
      out.write("\t\t<H1>UN BLABLABLA QUI PRESENTE LE MODULE DU E-LEARNING AVEC DES IMAGES QUI VONT AVEC</H1>\r\n");
      out.write("   </div>\r\n");
      out.write("   <div>\r\n");
      out.write("     <img src=\"modules/controlpanel/images/img/2.jpg\" BORDER=0 HEIGHT=\"300\"\r\n");
      out.write("\t\tWIDTH=\"100%\">\r\n");
      out.write("\t\t<H1>DEUX BLABLABLA QUI PRESENTENT LE MODULE DU E-LEARNING AVEC DES IMAGES QUI VONT AVEC</H1>\r\n");
      out.write("   </div>\r\n");
      out.write("   <div>\r\n");
      out.write("     <img src=\"modules/controlpanel/images/img/3.jpg\" BORDER=0 HEIGHT=\"300\"\r\n");
      out.write("\t\tWIDTH=\"100%\">\r\n");
      out.write("\t\t<H1>TROIS BLABLABLA QUI PRESENTENT LE MODULE DU E-LEARNING AVEC DES IMAGES QUI VONT AVEC</H1>\r\n");
      out.write("   </div>\r\n");
      out.write("   <div>\r\n");
      out.write("     <img src=\"modules/controlpanel/images/img/4.jpg\" BORDER=0 HEIGHT=\"300\"\r\n");
      out.write("\t\tWIDTH=\"100%\">\r\n");
      out.write("\t\t<H1>QUATRE BLABLABLA QUI PRESENTENT LE MODULE DU E-LEARNING AVEC DES IMAGES QUI VONT AVEC</H1>\r\n");
      out.write("   </div>\r\n");
      out.write("   <div>\r\n");
      out.write("     <img src=\"modules/controlpanel/images/img/5.jpg\" BORDER=0 HEIGHT=\"300\"\r\n");
      out.write("\t\tWIDTH=\"100%\">\r\n");
      out.write("\t\t<H1>CINQ BLABLABLA QUI PRESENTENT LE MODULE DU E-LEARNING AVEC DES IMAGES QUI VONT AVEC</H1>\r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("</div>\r\n");
      out.write("<h1>PRESENTATION DE QUELQUES COURS 0 CE NIVEAU, PUIS SPECIFICATION DU RESTE DE COURS \r\n");
      out.write("SUR UN LIEN CLIQUABLE</h1>\r\n");
      out.write("</CENTER>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<br><br>\r\n");
      out.write("<section class=\"scrollable-section what-is-this\" data-section-title=\"What is this\">\r\n");
      out.write("<CENTER>\r\n");
      out.write("\t<a href=\"#\"><IMG SRC=\"modules/controlpanel/images/img/1.jpg\" NAME=\"mypic\" BORDER=0 HEIGHT=\"350\"\r\n");
      out.write("\t\tWIDTH=\"100%\">\r\n");
      out.write("\t</a>\r\n");
      out.write("\t<p>\r\n");
      out.write("\t<FORM NAME=\"joe\">\r\n");
      out.write("\t\t<INPUT TYPE=\"text\" WIDTH=\"100\" NAME=\"burns\"\r\n");
      out.write("\t\t\tVALUE=\"Text For Picture One\" editable=\"false\">\r\n");
      out.write("\t</FORM>\r\n");
      out.write("<H1>PRESENTATION DES AUTRES FONCTIONNALITES DU SITE</H1>\r\n");
      out.write("<!-- \t<A HREF=\"JavaScript:slideshowBack()\"> Back</A> <A -->\r\n");
      out.write("<!-- \t\tHREF=\"JavaScript:slideshowUp()\"> Next</A> -->\r\n");
      out.write("</CENTER>\r\n");
      out.write("    </section>\r\n");
      out.write("    <br><br>\r\n");
      out.write("     <section class=\"scrollable-section\" data-section-title=\"HTML\">\r\n");
      out.write("    </section>\r\n");
      out.write("    \r\n");
      out.write("    <br><br>\r\n");
      out.write("     <section class=\"scrollable-section\" data-section-title=\"Call and Customize\">\r\n");
      out.write("       \r\n");
      out.write("    </section>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"modules/controlpanel/js/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"modules/controlpanel/js/prism.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"modules/controlpanel/js/jquery.easing.1.3.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"modules/controlpanel/js/jquery.section-scroll.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"modules/controlpanel/js/materialize.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(document).ready(function () {\r\n");
      out.write("            $('body').sectionScroll({\r\n");
      out.write("                easing: 'easeInOutQuart',\r\n");
      out.write("                scrollDuration: 1200\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            $('body').on('section-reached', function() {\r\n");
      out.write("                var section_title = $('body').sectionScroll.activeSection.data('section-title');\r\n");
      out.write("                Materialize.toast('In view: ' + section_title, 1000);\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("    \r\n");
      out.write("<!-- The Image and Form Codes are Below -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(\"#slideshow > div:gt(0)\").hide();\r\n");
      out.write("\r\n");
      out.write("setInterval(function() {\r\n");
      out.write("  $('#slideshow > div:first')\r\n");
      out.write("    .fadeOut(1000)\r\n");
      out.write("    .next()\r\n");
      out.write("    .fadeIn(1000)\r\n");
      out.write("    .end();\r\n");
      out.write("    //.appendTo('#slideshow');\r\n");
      out.write("}, 5000);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(\"#slideshow1 > div:gt(0)\").hide();\r\n");
      out.write("\r\n");
      out.write("setInterval(function() {\r\n");
      out.write("  $('#slideshow1 > div:first')\r\n");
      out.write("    .fadeOut(3000)\r\n");
      out.write("    .next()\r\n");
      out.write("    .fadeIn(3000)\r\n");
      out.write("    .end()\r\n");
      out.write("     .appendTo('#slideshow1');\r\n");
      out.write("}, 15000);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</htm>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
