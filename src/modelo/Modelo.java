package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Modelo
 */
@Stateless
@LocalBean
public class Modelo {
	private List<Libro> libros; // Lista de libros
	private Libro libro; // Objeto libro

	/**
	 * Default constructor.
	 */
	public Modelo() {
		// TODO Auto-generated constructor stub
	}

	// Obtenemos ResultSet libros
	public List<Libro> getLibros() {
		// Invocar a la capa de datos, es decir,
		// instanciando (creando un objeto) la clase DataConnection
		DataConnection dataConnection = new DataConnection("sllop", "Temp2020$$");

		this.libros = new ArrayList<>();

		try {
			ResultSet rs = dataConnection.dameLibros();
			while (rs.next()) {
				String isbn, titulo, subtitulo, autor, fechaPublicacion, editorial, descripcion, paginaWeb, categoria;
				int paginas;

				isbn = rs.getString("isbn");
				titulo = rs.getString("titulo");
				subtitulo = rs.getString("subtitulo");
				autor = rs.getString("autor");
				fechaPublicacion = rs.getString("fechaPublicacion");
				editorial = rs.getString("editorial");
				paginas = rs.getInt("paginas");
				descripcion = rs.getString("descripcion");
				paginaWeb = rs.getString("paginaWeb");
				categoria = rs.getString("categoria");

				this.libros.add(new Libro(isbn, titulo, subtitulo, autor, fechaPublicacion, editorial, paginas,
						descripcion, paginaWeb, categoria));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros;
	}

	// Obtenemos ResultSet libros publicados antes del año 2013
	public List<Libro> getLibrosAntesAnyo(int anyo) {
		// Invocar a la capa de datos, es decir,
		// instanciando (creando un objeto) la clase DataConnection
		DataConnection dataConnection = new DataConnection("sllop", "Temp2020$$");

		this.libros = new ArrayList<>();

		try {
			ResultSet rs = dataConnection.dameLibrosAntesAnyo(anyo);
			while (rs.next()) {
				String isbn, titulo, subtitulo, autor, fechaPublicacion, editorial, descripcion, paginaWeb, categoria;
				int paginas;

				isbn = rs.getString("isbn");
				titulo = rs.getString("titulo");
				subtitulo = rs.getString("subtitulo");
				autor = rs.getString("autor");
				fechaPublicacion = rs.getString("fechaPublicacion");
				editorial = rs.getString("editorial");
				paginas = rs.getInt("paginas");
				descripcion = rs.getString("descripcion");
				paginaWeb = rs.getString("paginaWeb");
				categoria = rs.getString("categoria");

				this.libros.add(new Libro(isbn, titulo, subtitulo, autor, fechaPublicacion, editorial, paginas,
						descripcion, paginaWeb, categoria));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros;
	}

	
	public List<Libro> getLibrosPorCategoria(String pCategoria) {
		// Invocar a la capa de datos, es decir,
		// instanciando (creando un objeto) la clase DataConnection
		DataConnection dataConnection = new DataConnection("sllop", "Temp2020$$");

		this.libros = new ArrayList<>();

		try {
			ResultSet rs = dataConnection.dameLibrosPorCategoria(pCategoria);
			while (rs.next()) {
				String isbn, titulo, subtitulo, autor, fechaPublicacion, editorial, descripcion, paginaWeb, categoria;
				int paginas;

				isbn = rs.getString("isbn");
				titulo = rs.getString("titulo");
				subtitulo = rs.getString("subtitulo");
				autor = rs.getString("autor");
				fechaPublicacion = rs.getString("fechaPublicacion");
				editorial = rs.getString("editorial");
				paginas = rs.getInt("paginas");
				descripcion = rs.getString("descripcion");
				paginaWeb = rs.getString("paginaWeb");
				categoria = rs.getString("categoria");

				this.libros.add(new Libro(isbn, titulo, subtitulo, autor, fechaPublicacion, editorial, paginas,
						descripcion, paginaWeb, categoria));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Libro getLibroPorISBN(String pIsbn) {
		DataConnection dataConnection = new DataConnection("sllop", "Temp2020$$");
		
		try {
			ResultSet rs = dataConnection.dameLibroPorISBN(pIsbn);
			if(rs.next()) {
				String isbn, titulo, subtitulo, autor, fechaPublicacion, editorial, descripcion, paginaWeb, categoria;
				int paginas;

				isbn = rs.getString("isbn");
				titulo = rs.getString("titulo");
				subtitulo = rs.getString("subtitulo");
				autor = rs.getString("autor");
				fechaPublicacion = rs.getString("fechaPublicacion");
				editorial = rs.getString("editorial");
				paginas = rs.getInt("paginas");
				descripcion = rs.getString("descripcion");
				paginaWeb = rs.getString("paginaWeb");
				categoria = rs.getString("categoria");
				
				this.libro = new Libro(isbn, titulo, subtitulo, autor, fechaPublicacion, editorial, paginas, descripcion, paginaWeb, categoria);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return libro;
	}

	// Insertamos libro
	public void setLibro(Libro libro) {
		this.libro = libro;
		DataConnection dataConnection = new DataConnection("sllop", "Temp2020$$");

		try {
			dataConnection.insertaLibro(this.libro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Eliminamos libro
	public void eliminaLibro(Libro libro) {
		this.libro = libro;
		DataConnection dataConnection = new DataConnection("sllop", "Temp2020$$");

		try {
			dataConnection.eliminaLibro(this.libro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
