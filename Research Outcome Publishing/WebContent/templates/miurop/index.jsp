<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<c:import url="/ressources/jsp/header.jsp" />
		<link rel="stylesheet" href="<c:url value="/templates/miurop/css/style.css" />" type="text/css" />
		<script type="text/javascript" src="<c:url value="/templates/miurop/js/util.js" />"></script>
	</head>
	<body>
		<header id="header">
			<section id="headercontent">
				<section id="headertopbar">
					<div id="logo">
						<a href="<c:url value="index.jsp" />" class="logoLink">
							<img src="<c:url value="/ressources/images/logo-rop.png" />" alt="logo-rop" />
						</a>
					</div>
					<div id="websiteTitle">
						<h1>
							<a href="<c:url value="index.jsp" />">
							Research Outcome Publishing<sup>&reg;</sup>
							</a>
						</h1>
					</div>
					<div id="searchbar">
						<form id="searchform" action="">
							<input type="text" id="searchkey" name="searchkey" placeholder="Find..." />
						</form>
					</div>
					<div id="profilebar">
						<div class="profilebutton">
							<a href="<c:url value="index.jsp" />">Log In</a>
						</div>
						<div class="profilebutton">
							<a href="<c:url value="index.jsp" />">Register</a>
						</div>
					</div>
				</section>
				<section id="headernavbar">
					<nav id="mainnav">
						<ul class="hmenu menu">
							<li>Home</li>
							<li>About ROP</li>
							<li>Journal</li>
							<li>Books Publishing</li>
							<li>Contact ROP</li>
							<li>E-learning</li>
							<li>News &amp; Announcements</li>
							<li>ROP Webmail</li>
						</ul>
					</nav>
				</section>
			</section>
		</header>
		<section id="content">
			<section id="mainwrapper">
				<aside id="leftblock">
					<div class="leftcontent">
						<h4 class="lefttitle">NJPS Home</h4>
						<nav class="sidenav">
							<ul class="vmenu menu">
								<li>Contact</li>
								<li>Aims &amp; Scope</li>
								<li>Previous Issues</li>
								<li>Current Issues</li>
								<li>Forthcoming Issues</li>
							</ul>
						</nav>
					</div>
					<div class="leftcontent">
						<h4 class="lefttitle">About NJPS</h4>
						<nav class="sidenav">
							<ul class="vmenu menu">
								<li>Section Policies</li>
								<li>Publication Ethics</li>
								<li>Why Publishing with NJPS</li>
								<li>Open Access Statements</li>
								<li>Should be Known</li>
							</ul>
						</nav>
					</div>
					<div class="leftcontent">
						<h4 class="lefttitle">Editorial Board</h4>
						<nav class="sidenav">
							<ul class="vmenu menu">
								<li>Editorial Staff</li>
								<li>Editorial Information</li>
								<li>Submit a Report</li>
								<li>Become a Board Member</li>
							</ul>
						</nav>
					</div>
					<div class="leftcontent">
						<h4 class="lefttitle">Authors</h4>
						<nav class="sidenav">
							<ul class="vmenu menu">
								<li>Guide for Authors</li>
								<li>Training for Authors</li>
								<li>Submit a Manuscript</li>
								<li>Copyright &amp; Permissions</li>
								<li>Manuscript Template</li>
								<li>Article Processing Charges</li>
							</ul>
						</nav>
					</div>
					<div class="leftcontent">
						<h4 class="lefttitle">Reviewers</h4>
						<nav class="sidenav">
							<ul class="vmenu menu">
								<li>Reviewer Guideline</li>
								<li>Reviewer Acknowledgment</li>
								<li>Submit a Report</li>
								<li>Update your Information</li>
								<li>Join as a Reviewer</li>
							</ul>
						</nav>
					</div>
					<div class="leftcontent">
						<h4 class="lefttitle">Librarians</h4>
						<nav class="sidenav">
							<ul class="vmenu menu">
								<li>General Information</li>
								<li>Subscription</li>
								<li>Online Agreement Form</li>
							</ul>
						</nav>
					</div>
					<div class="leftcontent">
						<h4 class="lefttitle">Abstracting &amp; Indexing</h4>
						<nav class="sidenav">
							<ul class="vmenu menu">
								<li>DOAJ (Open Access)</li>
								<li>CrossRef</li>
								<li>Scopus</li>
								<li>Google Scholar</li>
								<li>Index Copernicus</li>
								<li>African Index Medicus</li>
								<li>EBSCO</li>
								<li>Mechanical and Transportation Engineering</li>
								<li>CZ3 Electronic Journal Library</li>
							</ul>
						</nav>
					</div>
					<div class="leftcontent">
						<h4 class="lefttitle">Students</h4>
						<nav class="sidenav">
							<ul class="vmenu menu">
								<li>Physics</li>
								<li>Mathematics</li>
								<li>Student membership</li>
							</ul>
						</nav>
					</div>
					<div class="leftcontent">
						<h4 class="lefttitle">Handy Links</h4>
						<nav class="sidenav">
							<ul class="vmenu menu">
								<li>For Readers Interest</li>
								<li>Health</li>
								<li>Workshops</li>
							</ul>
						</nav>
					</div>
				</aside>
				<section id="mainblock">
					<c:forEach var="page" items="${listeInclude}">
						<c:import url="${page}" />
					</c:forEach>
				</section>
			</section>
			<footer id="footer">
				<ul>
					<c:forEach	var="module" items="${modules}">
						<li><a href="<c:url value="/?m=${encryptor.encrypt(module)}" />"><c:out value="${module}" /></a></li>
					</c:forEach>
				</ul>
			</footer>
		</section>
	</body>
</html>