package aplicacion.servicios;

import java.util.Scanner;

/**
 * Implementación de la interfaz menu
 * @author csi22
 *
 */
public class ImplMenu implements InterfazMenu {

	@Override
	public int Menu() {
		// Scanner para leer
		Scanner sc = new Scanner(System.in);
		
		// Mostramos el menu
		int opcion = -1;
		do {
			System.out.println("1. Crear Usuario");
			System.out.println("2. Mostrar usuarios desde fichero");
			System.out.println("0. Salir");
			System.out.print("Introduzca una opción: ");
			opcion = sc.nextInt();
			
			if(opcion < 0 || opcion > 2)
				System.err.println("** Error: El valor no está dentro del rango **");
		} while (opcion < 0 || opcion > 2);
		
		// Devolvemos la opcion
		return opcion;
	}

}
