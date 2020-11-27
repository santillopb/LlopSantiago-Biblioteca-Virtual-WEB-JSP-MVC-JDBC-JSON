package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataConnection {
	private String usuario;
	private String password;
	
	private Connection conn;

	public DataConnection(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	// Metodo que se conecta a la base de datos
	// y devuelve un objeto de conexion a la misma
	public Connection getConn() throws ClassNotFoundException {
		String urlConnection;
		Properties infoConnection;
		
		urlConnection = "jdbc:mysql://localhost:3306/biblioteca";
		
		infoConnection = new Properties();
		infoConnection.put("user", this.usuario);
		infoConnection.put("password", this.password);
		
		
		try {
			// Registrar el driver de conexion a la base de datos
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(urlConnection, infoConnection);
			System.out.println("Conexion establecida");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		return conn;
	}

	// Metodo que recupera todos los registros de la tabla
	// libros
	public ResultSet dameLibros() throws SQLException {
		ResultSet rs = null;
		String query = "SELECT * FROM biblioteca.libros";
		
		// El siguiente objeto contendra la consulta a lanzar
		// ligada a la conexion a la base de datos o esquema.
		Statement stmt;
		
		// Hay que conectarse a la base de datos
		// para a traves de la conexion obtenida lanzar las consultas
		try {
			conn = getConn();
			stmt = conn.createStatement();
			
			// Para todas las consultas de seleccion
			// se utiliza el metodo executeQuery(),
			// para todas la demas (INSERT, UPDATE, DELETE)
			// se utiliza el metodo executeUpdate()
			rs = stmt.executeQuery(query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}	

	// Metodo que inserta un libro en la base de datos
	public void insertaLibro(Libro l) throws SQLException {
		String query = "INSERT INTO `biblioteca`.`libros` "
				+ "(`isbn`, `titulo`, `subtitulo`, "
				+ "`autor`, `fechaPublicacion`, "
				+ "`editorial`, `paginas`, `descripcion`, "
				+ "`paginaWeb`, `categoria`) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stmt;
		try {
			conn = getConn();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, l.getIsbn());
			stmt.setString(2, l.getTitulo());
			stmt.setString(3, l.getSubtitulo());
			stmt.setString(4, l.getAutor());
			stmt.setString(5, l.getFechaPublicacion());
			stmt.setString(6, l.getEditorial());
			stmt.setInt(7, l.getPaginas());
			stmt.setString(8, l.getDescripcion());
			stmt.setString(9, l.getPaginaWeb());
			stmt.setString(10, l.getCategoria());
			stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}









