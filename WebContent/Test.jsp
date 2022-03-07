<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test validation AJAX</title>
<script type="text/javascript">
var requete;

function valider() {
   var donnees = document.getElementById("donnees");
   var url = "valider?valeur=" + escape(donnees.value);
   if (window.XMLHttpRequest) {
       requete = new XMLHttpRequest();
   } else if (window.ActiveXObject) {
       requete = new ActiveXObject("Microsoft.XMLHTTP");
   }
   requete.open("GET", url, true);
   requete.onreadystatechange = majIHM;
   requete.send(null);
}

function majIHM() {
  var message = "";

  if (requete.readyState == 4) {
    if (requete.status == 200) {
      // exploitation des données de la réponse
      var messageTag = requete.responseXML.getElementsByTagName("message")[0];
      message = messageTag.childNodes[0].nodeValue;
      mdiv = document.getElementById("validationMessage");
      if (message == "invalide") {
         mdiv.innerHTML = "<img src='images/invalide.gif'>";
      } else {
         mdiv.innerHTML = "<img src='images/valide.gif'>";
      }
    }
  }
}


</script>
</head>
<body>
<table>
	<tr>
		<td>Valeur :</td>
		<td nowrap><input type="text" id="donnees" name="donnees" size="30"
			onkeyup="valider();"></td>
		<td>
		<div id="validationMessage"></div>
		</td>
	</tr>
</table>
</body>
</html>