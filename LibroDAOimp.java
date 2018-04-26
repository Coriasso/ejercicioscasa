package com.iesvirgendelcarmen.ejercicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOimp implements LibroDAO{


	private static Connection conexion = Conexion.getInstanceOf();





	@Override
	public List<LibroDTO> listarTodosLibros() {

		List<LibroDTO> listaLibros = new ArrayList<>();
		//creamos objetos Statement que seleccione todos los datos de todos los libros
		String sql = "SELECT * FROM libro;";

		try (Statement st = conexion.createStatement()){

			// Se crea el objeto ResultSet.
			// Es una especie de tabla que se guarda en memoria

			ResultSet resultset = st.executeQuery(sql);

			// .next() moverá el puntero al siguiente index si existe, devolviendo true o false

			while (resultset.next()) {

			// .getString devuelve la cadena de la columna que se indica. Empieza en 1, no en 0 y en ese caso el 1 es el id.
				LibroDTO libro = new LibroDTO(resultset.getString(2),
						resultset.getString(3),
						resultset.getString(4),
						resultset.getString(5));
				
				listaLibros.add(libro);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return listaLibros;
	}

	@Override
	public List<LibroDTO> listarLibrosDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrarLibro(String nombreLibro, String nombreAutor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarCategoriaLibro(LibroDTO libro, String nombreCategoria) {
		//Contabilizamos los cambios que se han hecho
		int updates = 0;
		
		//  UPDATE libro SET categoria='Seguridad' WHERE nombre = 'Santa Tecla';
		
		//Creamos una sentencia prpatada para evitar inyeciones SQL
		//luego se sustituiran los ?
		
		String sql = "UPDATE libro SET categoria = ? where nombre = ?;";
		
		try (PreparedStatement pst = conexion.prepareStatement(sql)){
			//Sustituimos los ? por los valores que deseemos
			
			pst.setString(1, nombreCategoria);
			pst.setString(2, libro.getNombre());
			updates = pst.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return updates != 0;
	}

	@Override
	public boolean insertarLibro(LibroDTO libro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertarListaLibros(List<LibroDTO> listaLibros) {
		// TODO Auto-generated method stub
		return false;
	}


}
