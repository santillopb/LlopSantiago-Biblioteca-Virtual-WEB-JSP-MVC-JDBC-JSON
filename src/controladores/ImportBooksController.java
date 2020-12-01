package controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modelo.Libro;
import modelo.Modelo;

/**
 * Servlet implementation class ImportBooksController
 */
@WebServlet("/ImportBooksController")
public class ImportBooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportBooksController() {
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
		Modelo m = new Modelo();	
		
		//Iniciamos
		JsonParser parser = new JsonParser();
		//Ruta del fichero
		FileReader fr = new FileReader("/home/santi/eclipse-workspace/LlopSantiago Biblioteca Virtual WEB JSP MVC JDBC JSON/WebContent/books.json");
        //Declaramos objeto "books"
		JsonObject books = parser.parse(fr).getAsJsonObject();
        //Declaramos ArrayList de books
        JsonArray arrBooks = books.get("books").getAsJsonArray();
        
        //Recorremos ArrayList books
        for(JsonElement element: arrBooks) {
        	//Convertimos elemento y asignamos a objeto
        	JsonObject object = element.getAsJsonObject();
        	//Asignamos en vbles los datos de los objetos
        	String isbn = object.get("isbn").getAsString();
        	String titulo = object.get("title").getAsString();
        	String subtitulo = object.get("subtitle").getAsString();
        	String autor = object.get("author").getAsString();
        	String fechaPublicacion = object.get("published").getAsString();
        	String editorial = object.get("publisher").getAsString();
        	int paginas = object.get("pages").getAsInt();
        	String descripcion = object.get("description").getAsString();
        	String paginaWeb = object.get("website").getAsString();
        	String categoria = object.get("category").getAsString();
        	
        	/*response.getWriter().append("ISBN: " + isbn);
        	response.getWriter().append("\nTítulo: " + titulo);
        	response.getWriter().append("\nSubtítulo: " + subtitulo);
        	response.getWriter().append("\nAutor: " + autor);
        	response.getWriter().append("\nFecha: " + fechaPublicacion);
        	response.getWriter().append("\nEditorial: " + editorial);
        	response.getWriter().append("\nPáginas: " + String.valueOf(paginas));
        	response.getWriter().append("\nDescripción: " + descripcion);
        	response.getWriter().append("\nPágina web: " + paginaWeb);
        	response.getWriter().append("\nCategoría: " + categoria);
        	response.getWriter().append("\n----------------------------\n");*/
        	
        	//Declaramos objeto libro y asignamos los campos
        	Libro libro = new Libro(isbn, titulo, subtitulo, autor, fechaPublicacion, editorial, paginas, descripcion, paginaWeb, categoria);
        	//Insertamos el libro a la base de datos
        	m.setLibro(libro);
        	
        	
        }      
        request.getRequestDispatcher("importBooks.jsp").forward(request, response);
	}
}
