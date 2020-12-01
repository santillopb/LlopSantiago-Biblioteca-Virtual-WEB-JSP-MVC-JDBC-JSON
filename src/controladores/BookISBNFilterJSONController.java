package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.Libro;
import modelo.Modelo;

/**
 * Servlet implementation class BooksISBNFilterJSONController
 */
@WebServlet("/BookISBNFilterJSONController")
public class BookISBNFilterJSONController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookISBNFilterJSONController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String isbn = request.getParameter("ISBN");
		//Realizamos la consulta a todos los libros publicados antes del año 2013
		//y lo asignamos a la lista de libros 
		Modelo m = new Modelo();
		Libro libro = m.getLibroPorISBN(isbn);

		Gson gson = new Gson();
		GsonBuilder gsonBuilder = new GsonBuilder();

		gson = gsonBuilder.setPrettyPrinting().disableHtmlEscaping().create();
		String JSON = gson.toJson(libro);
		response.getWriter().append(JSON);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
