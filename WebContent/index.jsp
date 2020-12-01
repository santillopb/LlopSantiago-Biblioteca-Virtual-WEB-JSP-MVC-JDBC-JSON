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
<style>
	.info{
		display: none;
	}
</style>
</head>
<body>
	<!-- CONSULTA A LA TABLA LIBROS -->
	<h1>Libros</h1>
	<% 	Modelo m = new Modelo();
		List<Libro> libros = m.getLibros();
		//Declaramos un contador
		int i=0;
		for(Libro l : libros) {
			%>
			<h3><%=l.getTitulo() %></h3>
			<div class="info" data-indice="<%=i %>">
				<p>ISBN: <%=l.getIsbn() %></p>
				<p>Subtitulo: <%=l.getSubtitulo() %></p>
				<p>Autor: <%=l.getAutor() %></p>
				<p>Fecha publicación: <%=l.getFechaPublicacion() %></p>
				<p>Editorial: <%=l.getEditorial() %></p>
				<p>Páginas: <%=l.getPaginas() %></p>
				<p>Descripción: <%=l.getDescripcion() %></p>
				<p>Página web: <%=l.getPaginaWeb() %></p>
				<p>Categoría: <%=l.getCategoria() %></p>
			</div>
			<button class="muestraInfo" data-indice="<%=i %>">Mostrar más información ...</button>
			<!-- OPCIÓN PARA DAR DE BAJA UN LIBRO -->
			<form action="EliminaLibroController" method="get">
				<input type="hidden" name="isbn" value="<%=l.getIsbn() %>">
				<input type="submit" value="Eliminar libro">
			</form>
			<hr/>
	<%
			i++;
		}
	%>
	<!-- FORMULARIO CREAR REGISTRO LIBRO -->
	<fieldset>
		<legend> Formulario para añadir un libro</legend>
		<form action="CreaLibroController" method="post">
			<label for="isbn">ISBN: </label><input type="text" id="isbn" name="isbn" required>
			<label for="titulo">Título: </label><input type="text" id="titulo" name="titulo" required>
			<label for="subtitulo">Subtítulo: </label><input type="text" id="subtitulo" name="subtitulo" required>
			<label for="autor">Autor: </label><input type="text" id="autor" name="autor" required>
			<label for="fechaPublicacion">Fecha Publicación: </label><input type="text" id="fechaPublicacion" name="fechaPublicacion" required>
			<label for="editorial">Editorial: </label><input type="text" id="editorial" name="editorial" required>
			<label for="paginas">Páginas: </label><input type="number" id="paginas" name="paginas" required>
			<label for="descripcion">Descripción: </label><textarea rows="" cols="" id="descripcion" name="descripcion" required></textarea>
			<label for="paginaWeb">Página web: </label><input type="url" id="paginaWeb" name="paginaWeb" required>
			<label for="categoria">Categoría: </label>
			<select id="categoria" name="categoria" required>
				<option></option>
				<option value="Classic">Classic</option>
				<option value="Drama">Drama</option>
				<option value="Fantasy">Fantasy</option>
				<option value="Suspense">Suspense</option>
			</select>
			<input type="submit" value="Añadir libro">
		</form>
	</fieldset>
	<!-- BOTON IMPORTAR books.json A LA BASE DE DATOS -->
    <form action="ImportBooksController" method="post">
    	<input type="submit" value="Importar books.json">
    </form>
    <!-- FILTRAR LIBROS FORMATO JSON -->
    <h2>Filtrar libros en formato json</h2>
    <button id="btnAllBooks">Todos los libros</button>
    
    <label for="txfBeforeYear">Filtrar libros publicados antes del año: </label>
    <input type="number" id="txfBeforeYear">
    <button id="btnBeforeYear">Filtrar</button>
    
    <label for="categoryFilter">Filtrar por categoria: </label>
    <select id="categoryFilter" name="categoryFilter">
				<option></option>
				<option value="Classic">Classic</option>
				<option value="Drama">Drama</option>
				<option value="Fantasy">Fantasy</option>
				<option value="Suspense">Suspense</option>
			</select>
  
    <label for="txfISBNFilter">Filtrar libro por ISBN: </label>
    <input type="text" id="txfISBNFilter" name="txfISBNFilter">
    <button id="btnISBNFilter">Filtrar</button>
    
	<script type="text/javascript">
		//LISTA DE ENLACES MAS INFORMACION
		//SI CLICAMOS SOBRE UN ENLACE
		var muestraInfos = document.getElementsByClassName('muestraInfo');
		var infos = document.getElementsByClassName('info');
		//Indice boton clicado
		var index;
		for(var i=0; i<muestraInfos.length; i++) {
			muestraInfos[i].addEventListener("click", function(event) {
				
				index = event.target.getAttribute("data-indice");
				
				if(infos[index].style.display == "none") {
					infos[index].style.display = "block";
					event.target.innerHTML = "Mostrar menos información";
				} else if(infos[index].style.display == "block") {
					infos[index].style.display = "none";
					event.target.innerHTML = "Mostrar más información ...";
				} else {
					infos[index].style.display = "block";
					event.target.innerHTML = "Mostrar menos información";
				}
				
			})
			
		}
		//Filtros JSON
		var btnAllBooks, btnBeforeYear, categoryFilter, btnISBNFilter;
		var txfBeforeYear, txfISBNFilter;
		//Todos los libros
		btnAllBooks = document.getElementById('btnAllBooks');
		btnBeforeYear = document.getElementById('btnBeforeYear');
		categoryFilter = document.getElementById('categoryFilter');
		btnISBNFilter = document.getElementById('btnISBNFilter');
		
		
		
		
		btnAllBooks.addEventListener("click", function() {
			location.href = 'AllBooksJSONController';
		});
		
		btnBeforeYear.addEventListener("click", function() {
			txfBeforeYear = document.getElementById('txfBeforeYear').value;
			location.href = 'BooksBeforeYearJSONController?before=' + txfBeforeYear;
		});
		
		categoryFilter.addEventListener("change", function() {
			// Deteminar cual es la categoria seleccionada
			var indice = this.selectedIndex;
			
			var category = this.options[indice].value;
			location.href = 'BooksCategoryFilterJSONController?category=' + category;
		});
		
		btnISBNFilter.addEventListener("click", function() {
			txfISBNFilter = document.getElementById('txfISBNFilter').value;
			location.href = 'BookISBNFilterJSONController?ISBN=' + txfISBNFilter;
		})
			
	</script>
</body>
</html>