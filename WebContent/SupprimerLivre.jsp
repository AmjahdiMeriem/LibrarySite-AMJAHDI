<!DOCTYPE HTML>
<%@page import="Model.GenreLivre"%>
<%@page import="Service.GenreLivreServiceImpl"%>
<%@page import="Service.IGenreLivreService"%>
<%@page import="Model.LangueLivre"%>
<%@page import="Service.LangueLivreServiceImpl"%>
<%@page import="Service.ILangueLivreService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="Model.Livre"%>
<%@ page import="Service.LivreServiceImpl"%>
<%@ page import="Service.ILivreService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

</head>
<!-- ----------------------------------------------------------------------------------------------------------- -->
<body>

	<div class="gtco-loader"></div>

	<div id="page">

		<!-- ----------------------------------------------------------------------------------------------------------- -->

		<%@ include file="/Include/Nav.jsp"%>

		<!-- ----------------------------------------------------------------------------------------------------------- -->
		<header id="gtco-header" class="gtco-cover gtco-cover-md"
			role="banner"
			style="background-image: url(Template/images/img_2.jpg)">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row row-mt-15em" style="margin-top: 15%">
					<div class="col-md-7 mt-text animate-box"
						data-animate-effect="fadeInUp"></div>
					<div class="col-md-4 col-md-push-1 animate-box"
						data-animate-effect="fadeInRight">
						<div class="form-wrap">
							<div class="tab">
								<%
									ILangueLivreService langueService = new LangueLivreServiceImpl();
									List<LangueLivre> langues = langueService.findLangueAll();
									IGenreLivreService genreService = new GenreLivreServiceImpl();
									List<GenreLivre> genres = genreService.findGenreLivre();
								%>

								<div class="tab-content">
									<div class="tab-content-inner active" data-content="signup">
										<h3>
											<%
												
											%>
											Search for a book
										</h3>
										<form action="#">
											<div class="row form-group">
												<div class="col-md-12">
													<label for="Kind">Kind</label> <select name="Kind"
														id="Kind" class="form-control">
														<option value=""></option>
														<%
															for (int i = 0; i < genres.size(); i++) {
														%>
														<option
															value=<%=String.valueOf(genres.get(i).getIdGenreLivre())%>><%=genres.get(i).getNomGenreLivre()%></option>

														<%
															}
														%>
													</select>
												</div>
											</div>
											<div class="row form-group">
												<div class="col-md-12">
													<label for="Language">Language</label> <select
														name="Language" id="Language" class="form-control">
														<option value=""></option>
														<%
															for (int i = 0; i < langues.size(); i++) {
														%>
														<option
															value=<%=String.valueOf(langues.get(i).getIdLangueLivre())%>><%=langues.get(i).getNomLangueLivre()%></option>
														<%
															}
														%>

													</select>

												</div>
											</div>

											<div class="row form-group">
												<div class="col-md-12">
													<input type="submit" class="btn btn-primary btn-block"
														value="Search">
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!-- ----------------------------------------------------------------------------------------------------------- -->
		<%
			List<Livre> livres = new ArrayList<Livre>();
			ILivreService livresService = new LivreServiceImpl();
			livres = livresService.findBookAll();
		%>

		<div class="gtco-section">
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
						<h2></h2>
					</div>
				</div>
				<div class="row">
					<%
						for (int i = 0; i < livres.size(); i++) {
					%>
					<div class="col-lg-4 col-md-4 col-sm-6">

						<figure>
							<img src=<%="Template/images/" + livres.get(i).getUrlImage()%>
								alt="Image" class="img-responsive">
						</figure>
						<div class="fh5co-text">
							<h3><%=livres.get(i).getTitre()%></h3>
							<p><%=livres.get(i).getDescription()%></p>
							<a href="./SupprimerLivreServlet?id=<%=livres.get(i).getISBN()%>"><p>
									<span class="btn btn-primary">Delete</span>
								</p></a>
						</div>
					</div>
					<%
						}
					%>

				</div>

			</div>
		</div>
		<!-- -------------------------------------------------------------------------------------------------------------- -->
		<!-- </div> -->

	</div>

	<%@ include file="/Include/js.jsp"%>

</body>
</html>

