<%@page import="modelo.Libro"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Modelo"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biblioteca virtual</title>
</head>
<body>
	<h1>Libros</h1>
	<% 	Modelo m = new Modelo();
		List<Libro> libros = m.getLibros();
		
		for(Libro l : libros) {
			%>
			<p><%=l.getTitulo() %></p>
	<%
			
		}
	%>
</body>
</html>