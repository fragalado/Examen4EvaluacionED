package aplicacion.controladores;

import java.util.ArrayList;
import java.util.List;

import aplicacion.entidades.Propietarios;
import aplicacion.entidades.Usuarios;
import aplicacion.entidades.Veterinarios;
import aplicacion.servicios.ImplFicheros;
import aplicacion.servicios.ImplMenu;
import aplicacion.servicios.ImplUsuarios;
import aplicacion.servicios.InterfazFicheros;
import aplicacion.servicios.InterfazMenu;
import aplicacion.servicios.InterfazUsuarios;

/**
 * Clase Menu que contiene el método principal
 * @author csi22
 *
 */
public class Menu {

	public static void main(String[] args) {
		
		// Lista donde guardaremos los objetos Usuarios
		List<Usuarios> listaBD = new ArrayList<>();
		
		// Inicializamos la interfaz menu y usuarios
		InterfazMenu intM = new ImplMenu();
		InterfazUsuarios intU = new ImplUsuarios();
		
		// Inicializamos la interfaz ficheros
		InterfazFicheros intF = new ImplFicheros();
		
		// Mostramos el menu
		int opcion = -1;
		do {
			try {
				opcion = intM.Menu();
			} catch (Exception e) {
				System.err.println("** Error: No se ha introducido el formato correcto **");
			}
			
			switch (opcion) {
			case 1:
				// Crea Usuario
				try {
					listaBD = intU.crearUsuario(listaBD);
					intF.escribeFicheroSobreescribiendo("c:\\zDatosPrueba\\examen4EvaluacionED.txt", listaBD);
				} catch (Exception e) {
					System.err.println("** Error: No se ha podido crear el usuario **");
				}
				break;
			case 2:
				// Mostrar usuarios desde fichero
				try {
					intU.mostrarUsuariosFichero("c:\\zDatosPrueba\\examen4EvaluacionED.txt");
				} catch (Exception e) {
					System.err.println("** Error: No se ha podido mostrar los usuarios **");
				}
				break;
			case 0:
				// Salir
				System.out.println("Saliendo...");
				break;
			}
		} while (opcion != 0);
	}

}
