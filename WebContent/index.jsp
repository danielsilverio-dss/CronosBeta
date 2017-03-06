<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crono</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<%@ include file="snippets/imports.jsp" %>
</head>
<body>



<header>Crono</header>
<nav>
	<ul>
		<li><a href="Servlet?page=cronograma.jsp">			<button>Cronograma		</button></a></li>
		<li><a href="Servlet?page=cadastrarCapitulo.jsp">	<button>Capítulos		</button></a></li>
		<li><a href="Servlet?page=personagem.jsp">			<button>Personagens		</button></a></li>
		<li><a href="Servlet?page=eventos.jsp">				<button>Eventos			</button></a></li>
	</ul>
</nav>

<div class="sombra"><p></p></div>

<main>
	
	<jsp:include page="WEB-INF/jsp/${page == null? 'emptyPage.jsp' : page}"></jsp:include>
	
</main>
<footer></footer>


<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>

<script type="text/javascript" src="js/scriptjq.js"></script>

</body>
</html>