package com.iesvirgendelcarmen.ejercicio;

/*id INTEGER PRIMARY KEY AUTOINCREMENT,
nombre TEXT,
autor TEXT,
editorial TEXT,
categoria TEXT,
FOREIGN KEY(categoria) REFERENCES categoria(tipo) ON DELETE CASCADE ON UPDATE CASCADE
*/

public class LibroDTO {

	private String nombre;
	private String autor;
	private String editorial;
	private String categoria;
	
	
	public LibroDTO(String nombre, String autor, String editorial, String categoria) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.editorial = editorial;
		this.categoria = categoria;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "LibroDTO [nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", categoria="
				+ categoria + "]";
	}
	
	
	
	
}
