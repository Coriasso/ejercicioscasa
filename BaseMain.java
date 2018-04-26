package com.iesvirgendelcarmen.ejercicio;


import java.util.List;

public class BaseMain {

	public static void main(String[] args) {
		
		/*Connection c = Conexion.getInstanceOf();
		
		String sql = "Select * from libro";
		try {
			Statement st = c.prepareStatement(sql);
			System.out.println(st.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		LibroDAOimp baseLibros = new LibroDAOimp();
		List<LibroDTO> listaLibros = baseLibros.listarTodosLibros();
		
		
		for(int i = 0; i < listaLibros.size(); i++) {
			
			System.out.printf("%s %s  %s %s%n%n",listaLibros.get(i).getNombre(),listaLibros.get(i).getCategoria(),
					listaLibros.get(i).getAutor(), listaLibros.get(i).getEditorial());

		}
		
		
		LibroDTO librito = new LibroDTO("Santa Tecla", null, null, null);
		System.out.println(baseLibros.actualizarCategoriaLibro(librito, "Redes"));
		
		listaLibros = baseLibros.listarTodosLibros();
		
	
		for(int i = 0; i < listaLibros.size(); i++) {
			
			System.out.printf("%s %s  %s %s%n%n",listaLibros.get(i).getNombre(),listaLibros.get(i).getCategoria(),
					listaLibros.get(i).getAutor(), listaLibros.get(i).getEditorial());

		}

	}

}
