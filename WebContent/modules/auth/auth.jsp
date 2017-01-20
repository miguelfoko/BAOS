<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<c:import url="/ressources/jsp/header.jsp" />
		<style>
			html{background: rgba(35, 150, 100, 0.4);}
			body{margin: 150px auto auto auto; width: 500px; height: 300px; 
				box-shadow: 1px 1px 2px 3px rgba(20, 20, 20, 0.5); background: white; padding: 10px; border-radius: 5px;}
			#authHeader{width: 100%; height: 25px; text-align: center; background: rgba(35, 150, 50, 0.7); color: white;
						margin-top: -15px; border-radius: 5px 5px 0px 0px;}
			#authHeader h1{font-size: 17px; text-transform: uppercase;}
			.clr{clear: both;}
			#authBody{margin-top: 20px; }
			#authFooter{margin-top: 10px;}
			#authDesc{width: 170px; height: 183px; float: left; background: rgba(35, 150, 50, 0.55); color: white; box-shadow: 1px 1px 3px 1px rgba(35, 150, 50, 0.3); text-align: justify; font-size: 1.06em; padding: 5px; border-radius: 25px; border: 1px solid rgba(35, 150, 50, 0.8); }
			#form{width: 300px; margin-left: 15px; float: left;}
			.auth_label{line-height: 35px; font-size: 1.1em;}
			.auth_text_zone{border-radius: 3px; line-height: 25px; font-size: 1.05em; width: 100%; padding: 1px 5px 1px 3px; border: 1px solid rgba(35, 150, 50, 0.7);}
			.auth_button{background: rgba(35, 150, 50, 0.7); color: white; line-height: 25px; font-size: 1.05em; width: 50%; padding: 1px 5px 1px 3px; border: 1px solid rgba(35, 150, 50, 0.7); float: left; }
			.auth_text_zone:focus{box-shadow: 1px 1px 3px 1px rgba(35, 150, 50, 0.3); border: 1px solid #D69A2B;}
			.auth_button:hover{border: 1px solid #D69A2B; background: #D69A2B;}
			.lang{margin: 0px 0px 0px -35px; float: right;}
			.links{margin: 0px 0px 0px -35px;}
			.lang li, .links li{margin: 5px; display: block; float: left;}
			#authFooter{padding-top: 8px; border-top: 3px solid rgba(35, 150, 50, 0.8);}
			.lang li a, .links li a{text-decoration: none; color: rgba(35, 150, 50, 1);}
			.lang li a:hover, .links li:hover{color: #D69A2B;}
			#authBody{border-top: 3px solid rgba(35, 150, 50, 0.8); padding-top: 10px;}
			#message{text-align: center; padding: 0px 5px; color: white; border-radius: 5px; width: 600px; margin-left: -48px; line-height: 30px; background: #D69A2B; margin-top: -43px; position: absolute;}
			.draggable .dragHandle{cursor: move;}
		</style>
	</head>
	<body class="draggable">
		<div id="wrapper">
			<c:if test="${message != null}">
				<div id="message">
					<em><c:out value="${message}" /></em>
				</div>
			</c:if>
			<div id="authForm" class="clr">
				<div id="authHeader" class="dragHandle">
					<h1><c:out value="${title}" /></h1>
				</div>
				<div id="authBody" class="clr">
					<div id="authDesc">
						<p><c:out value="${applicationScope.languageManager.getLanguageValue('auth_desc', sessionScope.tag)}" escapeXml="false" /></p>
					</div>
					<div id="form">
						<form method="post" action="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('auth')}" />" name="authForm" class="form">
							<label class="auth_label"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_login', sessionScope.tag)}" /></label>
							<input type="text" name="login" value="<c:out value="${param.login}" />" required class="auth_text_zone" placeholder="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_login_holder', sessionScope.tag)}" />" /><br />
							<label class="auth_label"><c:out value="${applicationScope.languageManager.getLanguageValue('auth_pass', sessionScope.tag)}" /></label>
							<input type="password" name="pass" class="auth_text_zone" /><br /><br />
							<c:if test="${redirect != null}">
								<input type="hidden" name="redirect" value="<c:out value="${redirect}" />" />
							</c:if>
							<input type="submit" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_connect', sessionScope.tag)}" />" class="auth_button" />
							<input type="reset" value="<c:out value="${applicationScope.languageManager.getLanguageValue('auth_reset', sessionScope.tag)}" />" class="auth_button" />
						</form>
					</div>
				</div>
				<div class="clr"></div>
				<div id="authFooter" class="clr">
					<ul class="links">
						<li><a href="<c:url value="index.jsp" />"><c:out value="${applicationScope.languageManager.getLanguageValue('index', sessionScope.tag)}" /></a></li>
						<c:if test="${sessionScope.user != null }">
							<li><a href="<c:url value="index.jsp?module=${applicationScope.encryptor.encrypt('auth')}&action=${applicationScope.encryptor.encrypt('logout')}" />"><c:out value="${applicationScope.languageManager.getLanguageValue('logout', sessionScope.tag)}" /></a></li>
						</c:if>
					</ul>
					<ul class="lang">
						<c:forEach items="${langItems}" var="item">
							<li><c:out value="${item}" escapeXml="false" /></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				$('.draggable').draggable({handle: '.dragHandle'});
			});
		</script>
	</body>
</html>