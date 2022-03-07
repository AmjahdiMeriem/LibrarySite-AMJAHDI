<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Service.LivreServiceImpl"%>
<%@page import="Service.ILivreService"%>
<%@page import="Model.Livre"%>
<%@page import="Model.User"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by FreeHTML5.co" />
<meta name="keywords"
	content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="FreeHTML5.co" />

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<%@ include file="/Include/css.jsp"%>

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>

</head>
<body>

	<div class="gtco-loader"></div>

	<div id="page">


		<!-- <div class="page-inner"> -->
		<%@ include file="/Include/Nav.jsp"%>

		<header id="gtco-header" class="gtco-cover gtco-cover-sm"
			role="banner"
			style="background-image: url(Template/images/img_2.jpg)">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-12 col-md-offset-0 text-center">
						<div class="row row-mt-15em">

							<div class="col-md-12 mt-text animate-box"
								data-animate-effect="fadeInUp">
								<h1>Informations</h1>
							</div>

						</div>

					</div>
				</div>
			</div>
		</header>

		<%
			ILivreService livreService = new LivreServiceImpl();
			Livre livre = new Livre();
			Long ISBN = Long.valueOf(request.getParameter("id"));
			livre = livreService.findBookByISBN(ISBN);
			
		%>
		<div class="gtco-section border-bottom">
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center gtco-heading">

					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div></div>
					</div>
					<div class="col-md-4">
						<div class="price-box">
							<h2 class="pricing-plan">
								Titre :
								<%=livre.getTitre()%></h2>
							<div class="price">
								<sup class="currency">$</sup><%=livre.getPrix()%></div>

							<ul class="pricing-info">
								<li>Auteur : <%=livre.getAuteur()%></li>
								<li>Editeur : <%=livre.getEditeur()%></li>
								<li>Ann�e : <%=livre.getAnnee()%></li>
								<li>Description : <%=livre.getDescription()%></li>
							</ul>

							<c:if test="${ empty sessionScope.name}">
								<a
									href="Login.jsp?ISBN=<%=ISBN%>&page=<%="AjouterLivrePannierServlet"%>"
									class="btn btn-default btn-sm">Add Pannier</a>
							</c:if>
							<c:if test="${ !empty sessionScope.name}">
								<a href="./AjouterLivrePannierServlet?ISBN=<%=ISBN%>"
									class="btn btn-default btn-sm">Add to my basket</a>
							</c:if>
						</div>
					</div>
					<div class="col-md-4">
						<div></div>
					</div>
				</div>
			</div>
		</div>

		<!-- </div> -->

	</div>

	<!-- jQuery -->
	<%@ include file="/Include/js.jsp"%>

</body>
</html>

