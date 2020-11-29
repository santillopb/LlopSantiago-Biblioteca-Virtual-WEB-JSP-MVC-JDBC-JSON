package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.Modelo;

/**
 * Servlet implementation class CreaLibroController
 */
@WebServlet("/CreaLibroController")
public class CreaLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaLibroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String subtitulo = request.getParameter("subtitulo");
		String autor = request.getParameter("autor");
		String fechaPublicacion = request.getParameter("fechaPublicacion");
		String editorial = request.getParameter("editorial");
		int paginas = Integer.parseInt(request.getParameter("paginas"));
		String descripcion = request.getParameter("descripcion");
		String paginaWeb = request.getParameter("paginaWeb");
		String categoria = request.getParameter("categoria");
		
		/*response.getWriter().append("ISBN: " + isbn);
		response.getWriter().append("\nTitulo: " + titulo);
		response.getWriter().append("\nSubitulo: " + subtitulo);
		response.getWriter().append("\nFecha Publicacion: " + fechaPublicacion);
		response.getWriter().append("\nEditorial: " + editorial);
		response.getWriter().append("\nPáginas: " + paginas);
		response.getWriter().append("\nDescripción: " + descripcion);
		response.getWriter().append("\nPágina web: " + paginaWeb);
		response.getWriter().append("\nCategoría: " + categoria);*/

		 /*"isbn": "9781491950296",
	      "title": "Programming JavaScript Applications",
	      "subtitle": "Robust Web Architecture with Node, HTML5, and Modern JS Libraries",
	      "author": "Eric Elliott",
	      "published": "2014-07-01T00:00:00.000Z",
	      "publisher": "O'Reilly Media",
	      "pages": 254,
	      "description": "Take advantage of JavaScript's power to build robust web-scale or enterprise applications that are easy to extend and maintain. By applying the design patterns outlined in this practical book, experienced JavaScript developers will learn how to write flexible and resilient code that's easier-yes, easier-to work with as your code base grows.",
	      Take advantage of JavaScript's power to build robust web-scale or enterprise applications that are easy to extend and maintain. By applying the design patterns outlined in this practical book, experienced JavaScript developers will learn how to write flexible and resilient code that's easier-yes, easier-to work with as your code base grows.
	      "website": "http://chimera.labs.oreilly.com/books/1234000000262/index.html",
	      "category": "Drama"*/
		
		Libro libro = new Libro(isbn, titulo, subtitulo, autor, fechaPublicacion, editorial, paginas, descripcion, paginaWeb, categoria);
		Modelo m = new Modelo();
		m.setLibro(libro);
		
		request.getRequestDispatcher("librocreadoOK.jsp").forward(request, response);
	}

}
