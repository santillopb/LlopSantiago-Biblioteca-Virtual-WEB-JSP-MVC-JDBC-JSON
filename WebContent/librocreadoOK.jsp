<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libro añadido correctamente!</title>
</head>
<body>
	<p style="color: green">Libro añadido correctamente!</p>
	<button id="btn1">Volver a la pagina de inicio</button>
	<script type="text/javascript">
		document.getElementById("btn1").addEventListener("click", function () {
			// Tenemos que crear el Servlet (Controlador) para mostrar la pag login
			location.href = "HomePageController";
		});
	</script>
</body>
</html>