package modelo;

public class Libro {
	//Atributos
	private String isbn;
	private String titulo;
	private String subtitulo;
	private String autor;
	private String fechaPublicacion;
	private String editorial;
	private int paginas;
	private String descripcion;
	private String paginaWeb;
	private String categoria;
	
	// Constructor
	public Libro(String isbn, String titulo, String subtitulo, String autor, String fechaPublicacion, String editorial,
			int paginas, String descripcion, String paginaWeb, String categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.editorial = editorial;
		this.paginas = paginas;
		this.descripcion = descripcion;
		this.paginaWeb = paginaWeb;
		this.categoria = categoria;
	}

	// Getters y setters
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}

