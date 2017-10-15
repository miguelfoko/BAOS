<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<c:import url="/ressources/jsp/header.jsp" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="<c:url value="/ressources/bootstrap/css/bootstrap.min.css" />" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/ressources/jquery-ui/theme/pepper-grinder/theme.css" />" />
		<link rel="stylesheet" href="<c:url value="/templates/pepper-grinder-baos/css/style.css" />" type="text/css" />
		<script type="text/javascript" src="<c:url value="/templates/pepper-grinder-baos/js/util.js" />"></script>
	</head>
	<body class="ui-widget ">
		<nav id="pgb-header-bar" class="navbar navbar-default ui-widget-content navbar-fixed-top">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#pgb-top-navbar">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="index.jsp">
		      	<img src="<c:url value="/ressources/images/logo-baos.png" />" alt="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_logo', sessionScope.tag)}" />" />
		      </a>
		    </div>
		    <div class="collapse navbar-collapse ui-widget-content" id="pgb-top-navbar">
		      <ul class="nav navbar-nav">
		        <li>
		        	<div id="pgb-top-menu-more" class="dropdown">
					    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
					    	<span class="glyphicon glyphicon-th"></span> <c:out value="${applicationScope.languageManager.getLanguageValue('auth_menu', sessionScope.tag)}" />
					    	<span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu">
					      <li><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> <c:out value="${applicationScope.languageManager.getLanguageValue('auth_home', sessionScope.tag)}" /></a></li>
					      <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_journals', sessionScope.tag)}" /></a></li>
		                  <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_learning', sessionScope.tag)}" /></a></li>
		        		  <!-- <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}&action=${applicationScope.encryptor.encrypt('paperSubmission')}" />">Paper Submission</a></li> -->
					      <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('contactUs')}&a=${applicationScope.encryptor.encrypt('aboutUs')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_about', sessionScope.tag)}" /></a></li>
					    </ul>
				  	</div>
		        </li>
		        <li class="pgb-to-hide-870"><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> <c:out value="${applicationScope.languageManager.getLanguageValue('auth_home', sessionScope.tag)}" /></a></li>
			    <li class="pgb-to-hide-970"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_journals', sessionScope.tag)}" /></a></li>
			    <li class="pgb-to-hide-1070"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('elearning')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_learning', sessionScope.tag)}" /></a></li>
	            <li class="pgb-to-hide-1200"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('contactUs')}&a=${applicationScope.encryptor.encrypt('aboutUs')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_about', sessionScope.tag)}" /></a></li>
	            <!-- <li class="pgb-to-hide-1200"><a href="#">News</a></li> -->
		      </ul>
		      <form id="pgb-search-nav-bar" class="navbar-form navbar-right">
		        <div class="form-group input-group">
		          <input type="text" class="form-control" placeholder="Search..">
		          <span class="input-group-btn">
		            <button class="btn btn-default" type="button">
		              <span class="glyphicon glyphicon-search pgb-color-green"></span>
		            </button>
		          </span>        
		        </div>
		        <input type="hidden" id="modAuthenticationEncryptedName" value="<c:out value="${applicationScope.encryptor.encrypt('authentication')}" />" />
				<input type="hidden" id="actionUnreadEncryptedName" value="<c:out value="${applicationScope.encryptor.encrypt('unread-notifications')}" />" />
				<input type="hidden" id="actionReadEncryptedName" value="<c:out value="${applicationScope.encryptor.encrypt('read-notifications')}" />" />
		      </form>
		      <c:choose>
			      <c:when test="${baoUser == null}">
				      <ul id="pgb-profile-nav-bar" class="nav navbar-nav navbar-right">
				        <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('login')}"><span class="glyphicon glyphicon-log-in pgb-color-green"></span> <c:out value="${applicationScope.languageManager.getLanguageValue('auth_login', sessionScope.tag)}" /></a></li>
				      </ul>
			      </c:when>
			      <c:otherwise>
					  <div id="pgb-profile-nav-bar" class="nav navbar-nav navbar-right">
					  	<div id="pgb-top-profile-dropdown" class="dropdown">
						    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
						    	<c:choose>
									<c:when test="${baoUser.additionalInfoId.userAvatar != null || baoUser.additionalInfoId.userAvatarType == 'gravatar'}">
										<c:choose>
											<c:when test="${baoUser.additionalInfoId.userAvatarType == 'gravatar' || baoUser.additionalInfoId.userAvatarType == null}">
												<img class="pgb-top-avatar" src="https://www.gravatar.com/avatar/<c:out value="${applicationScope.encryptor.md5HexEmail(baoUser.userEmail)}?s=120" />" alt="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_avatar', sessionScope.tag)}" />" />
											</c:when>
											<c:otherwise>
												<img class="pgb-top-avatar" src="<c:url value="/ressources/images/avatars/${baoUser.additionalInfoId.userAvatar}" />" alt="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_avatar', sessionScope.tag)}" />" />
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<img class="pgb-top-avatar" src="<c:url value="/ressources/images/avatars/default.png" />" alt="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_avatar', sessionScope.tag)}" />" />
									</c:otherwise>
								</c:choose>
								<span class="caret pgb-profile-avatar-caret"></span>
								<span class="badge baos-notification-badge pgb-baos-notification-badge-top pgb-background-red"></span>
						    </button>
						    <ul class="dropdown-menu">
						      <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('profile')}"><c:out value="${applicationScope.languageManager.getLanguageValue('profile_title', sessionScope.tag)}" /></a></li>
						      <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('edit-profile')}"><c:out value="${applicationScope.languageManager.getLanguageValue('edit_profile', sessionScope.tag)}" /></a></li>
						      <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('notification')}"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_notification', sessionScope.tag)}" /> <span class="badge baos-notification-badge pgb-baos-notification-badge-menu pgb-background-red"></span></a></li>
						      <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('research')}"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_research_summary', sessionScope.tag)}" /></a></li>
						      <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('courses')}"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_courses_summary', sessionScope.tag)}" /></a></li>
						      <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('transaction')}"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_transaction', sessionScope.tag)}" /></a></li>
						      <li><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('authentication')}" />&o=${applicationScope.encryptor.encrypt('logout')}"><c:out value="${applicationScope.languageManager.getLanguageValue('logout_title', sessionScope.tag)}" /></a></li>
						    </ul>
					  	</div>
					  </div>
			      </c:otherwise>
		      </c:choose>
		    </div>
		</nav>
		<c:if test="${!empty statusList}">
			<div id="pgb-status-container" class="container-fluid ui-state-hover">
				<div class="row">
					<div class="pgb-status-real-container col-md-10 col-md-offset-1">
						<c:set var="statusRenderer" value="/templates/pepper-grinder-baos/jsp/renderStatus.jsp" scope="request" />
						<c:import url="/ressources/jsp/renderAllStatus.jsp" />
					</div>
				</div>
			</div>
		</c:if>
		<section id="pgb-main-container" class="container-fluid">
			<div id="pgb-main-content-row" class="row content">
				<c:if test="${!empty sideMenus || !empty leftSidePanels}">
					<aside id="pgb-left-aside" class="col-md-2 col-md-offset-1">
						<div id="pgb-left-aside-menu-bar" class="panel-group">
							<c:set var="menuRenderer" value="/templates/pepper-grinder-baos/jsp/renderMenu.jsp" scope="request" />
							<c:set var="menuItemRenderer" value="/templates/pepper-grinder-baos/jsp/renderMenuItem.jsp" scope="request" />
							<c:set var="pgbfirst" value="${true}" scope="request" />
							<c:import url="/ressources/jsp/renderSideMenus.jsp" />
							<c:set var="leftSidePanelRenderer" value="/templates/pepper-grinder-baos/jsp/renderLeftSidePanel.jsp" scope="request" />
							<c:set var="rightSidePanelRenderer" value="/templates/pepper-grinder-baos/jsp/renderRightSidePanel.jsp" scope="request" />
							<c:import url="/ressources/jsp/renderSidePanels.jsp" />
						</div>
					</aside>
				</c:if>
				<section id="pgb-main-section" class="<c:choose><c:when test="${!empty rightSidePanels && (!empty sideMenus || !empty leftSidePanels)}">col-md-6</c:when><c:when test="${!empty rightSidePanels && empty sideMenus && empty leftSidePanels}">col-md-8 col-md-offset-1</c:when><c:when test="${empty rightSidePanels && (!empty sideMenus || !empty leftSidePanels)}">col-md-8</c:when><c:otherwise>col-md-8 col-md-offset-2</c:otherwise></c:choose>">
					<c:set var="mainContentRenderer" value="/templates/pepper-grinder-baos/jsp/renderMainContent.jsp" scope="request" />
					<c:import url="/ressources/jsp/renderAllMainContent.jsp" />
				</section>
				<c:if test="${!empty rightSidePanels}">
					<aside id="pgb-right-aside" class="col-md-2">
						<div id="pgb-right-aside-panel-group" class="panel-group">
							<c:set var="sideOfPanels" value="right" scope="request" />
							<c:import url="/ressources/jsp/renderSidePanels.jsp" />
						</div>
					</aside>
				</c:if>
			</div>
		</section>
		<footer id="pgb-footer-container" class="container-fluid ui-widget-content">
			<div id="pgb-footer-top-row" class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="col-md-3">
						<div class="row">
							<div class="col-md-12">
								<h4><c:out value="${applicationScope.languageManager.getLanguageValue('cu_contact_us', sessionScope.tag)}" /></h4>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<ul class="list-group">
									<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('contactUs')}&a=${applicationScope.encryptor.encrypt('aboutUs')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_about', sessionScope.tag)}" /></a></li>
									<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('contactUs')}&a=${applicationScope.encryptor.encrypt('ourContacts')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('cu_contacts', sessionScope.tag)}" /></a></li>
									<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('contactUs')}&a=${applicationScope.encryptor.encrypt('email')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('cu_by_email', sessionScope.tag)}" /></a></li>
									<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('contactUs')}&a=${applicationScope.encryptor.encrypt('terms')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('cu_terms', sessionScope.tag)}" /></a></li>
									<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('contactUs')}&a=${applicationScope.encryptor.encrypt('privacy')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('cu_privacy', sessionScope.tag)}" /></a></li>
									<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('contactUs')}&a=${applicationScope.encryptor.encrypt('siteMap')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('cu_site_map', sessionScope.tag)}" /></a></li>
						      		<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('contactUs')}&a=${applicationScope.encryptor.encrypt('developpers')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('cu_developpers', sessionScope.tag)}" /></a></li>
						      		
			                  	</ul>
					    	</div>
						</div>
						
					</div>
					<div class="col-md-3">
						<div class="row">
							<div class="col-md-12">
								<h4><c:out value="${applicationScope.languageManager.getLanguageValue('pages_researchers', sessionScope.tag)}" /></h4>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<ul class="list-group">
									<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('publications')}" />&action=${applicationScope.encryptor.encrypt('articlesOfAJournal')}&id_journal=${journal['journalOrConfId']}"><c:out value="${applicationScope.languageManager.getLanguageValue('pages_submit', sessionScope.tag)}" /></a></li>
									<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('pages')}&a=${applicationScope.encryptor.encrypt('findBooks')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pages_find_books', sessionScope.tag)}" /></a></li>
									<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('pages')}&a=${applicationScope.encryptor.encrypt('guideForAutors')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pages_guide_for_authors', sessionScope.tag)}" /></a></li>
			                  	</ul>
					    	</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="row">
							<div class="col-md-12">
								<h4><c:out value="${applicationScope.languageManager.getLanguageValue('pages_elearning', sessionScope.tag)}" /></h4>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<ul class="list-group">								
									<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('pages')}&a=${applicationScope.encryptor.encrypt('aboutELearning')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pages_about_elearning', sessionScope.tag)}" /></a></li>
						      		<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('pages')}&a=${applicationScope.encryptor.encrypt('guideForTeachers')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pages_guide_for_teachers', sessionScope.tag)}" /></a></li>
						      		<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('pages')}&a=${applicationScope.encryptor.encrypt('guideForMonitors')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pages_guide_for_monitors', sessionScope.tag)}" /></a></li>
						      		<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('pages')}&a=${applicationScope.encryptor.encrypt('guideForStudents')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pages_guide_for_students', sessionScope.tag)}" /></a></li>
			                  	</ul>
					    	</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="row">
							<div class="col-md-12">
								<h4><c:out value="${applicationScope.languageManager.getLanguageValue('pages_help_and_support', sessionScope.tag)}" /></h4>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<ul class="list-group">
						      		<li class="list-group-item"><a href="<c:url value="index.jsp?m=${applicationScope.encryptor.encrypt('pages')}&a=${applicationScope.encryptor.encrypt('helpAndSupport')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('pages_help_and_support_question', sessionScope.tag)}" /></a></li>
			                  	</ul>
					    	</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<h4><c:out value="${applicationScope.languageManager.getLanguageValue('pages_follow_baos', sessionScope.tag)}" /></h4>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 text-center">
								<div class="btn-group">
									<a class="btn btn-default btn-sm" href="#"><img src="<c:url value="/templates/pepper-grinder-baos/images/facebook.png" />" alt="Facebook"  width="30px" height="30px" /></a>
									<a class="btn btn-default btn-sm" href="#"><img src="<c:url value="/templates/pepper-grinder-baos/images/linkedin.png" />" alt="Linkedin" width="30px" height="30px" /></a>
									<a class="btn btn-default btn-sm" href="#"><img src="<c:url value="/templates/pepper-grinder-baos/images/twitter.png" />" alt="Twitter" width="30px" height="30px" /></a>
									<a class="btn btn-default btn-sm" href="#"><img src="<c:url value="/templates/pepper-grinder-baos/images/youtube.png" />" alt="Youtube" width="30px" height="30px" /></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="pgb-footer-bottom-row" class="row">
				<div class="col-md-10 col-md-offset-1">
					<div id="pgb-copyright" class="col-md-9">
						<c:out value="${applicationScope.languageManager.getLanguageValue('copyright', sessionScope.tag)} ${configManager.currentYear} ${configManager.platformTitle} ${applicationScope.languageManager.getLanguageValue('all_right_reserved', sessionScope.tag)}" escapeXml="false" />
					</div>
					<div id="pgb-language" class="col-md-2 text-center">
						<c:forEach var="langLink" items="${langItems}">
							<c:out value="${langLink}" escapeXml="false" />
						</c:forEach>
					</div>
					<div id="pgb-return-to-top" class="col-md-1 text-center">
						<a href="#scroll-top"><span class="glyphicon glyphicon-chevron-up"></span></a>
					</div>
				</div>
			</div>
		</footer>
		<script type="text/javascript" src="<c:url value="/ressources/bootstrap/js/bootstrap.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/templates/pepper-grinder-baos/js/scroll.js" />"></script>
		<script type="text/javascript">
			scrollToTop.start({
				scrollTitle : '',
			});
		</script>
	</body>
</html>