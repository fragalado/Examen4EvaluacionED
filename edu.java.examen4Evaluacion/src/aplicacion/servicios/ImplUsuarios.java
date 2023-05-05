package aplicacion.servicios;

import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.Propietarios;
import aplicacion.entidades.Usuarios;
import aplicacion.entidades.Veterinarios;

/**
 * Implementación de la interfaz usuarios
 * @author csi22
 *
 */
public class ImplUsuarios implements InterfazUsuarios {

	@Override
	public List<Usuarios> crearUsuario(List<Usuarios> listaBD) {
		// codigoIdentificador, nombre, apellidos, esVeterinario, numeroColegiado/numeroMascotas
		
		// Scanner para leer los datos
		Scanner sc = new Scanner(System.in);
		
		// Declaramos un objeto de tipo Usuario
		Usuarios u;
		
		// Pedimos el nombre
		System.out.print("Introduzca el nombre del usuario: ");
		String nombre = sc.nextLine();
		
		// Pedimos los apellidos
		System.out.print("Introduzca los apellidos del usuario: ");
		String apellidos = sc.nextLine();
		
		// Pedimos si es veterinario
		String opcion;
		boolean esVeterinario=false;
		
		do {
			System.out.print("Introduzca si el usuario es veterinario o no [s=Si/n=No]: ");
			opcion = sc.next().toLowerCase();
			
			if(!opcion.equals("s") && !opcion.equals("n"))
				System.err.println("** Error: No se ha introducido una opción válida **");
		} while (!opcion.equals("s") && !opcion.equals("n"));
		
		// Controlamos si es veterinario o no
		if(opcion.equals("s"))
			esVeterinario=true;
		else if(opcion.equals("n"))
			esVeterinario=false;
		
		
		// Pedimos el numeroColegiado o numeroMascotas
		// Pediremos uno u otro dependiendo del valor de esVeterinario
		if(esVeterinario) {
			System.out.print("Introduzca el numero de colegiado: ");
			u = new Veterinarios(obtieneCodigoIdentificador(listaBD), nombre, apellidos, esVeterinario, sc.next());
		} else {
			System.out.print("Introduzca el numero de mascotas: ");
			u = new Propietarios(obtieneCodigoIdentificador(listaBD), nombre, apellidos, esVeterinario, sc.nextInt());
		}
		
		// Devolvemos la lista actualizada
		listaBD.add(u);
		return listaBD;
	}
	
	/**
	 * Método que obtiene el último codigoIdentificador de la lista y lo devuelve sumandole 1
	 * @param listaBD
	 * @return
	 */
	private int obtieneCodigoIdentificador(List<Usuarios> listaBD) {
		
		int id=0;
		
		for (Usuarios aux : listaBD) {
			if(aux.getCodigoIdentificador() > id)
				id = aux.getCodigoIdentificador();
		}
		
		// Devolvemos el ultimo codigoIdentificador + 1
		return id+1;
	}

	
	@Override
	public void mostrarUsuariosFichero(String ruta) {
		// Inicializamos la interfaz de ficheros
		InterfazFicheros intF = new ImplFicheros();
		
		// Bucle para recorrer la lista que devuelve el método leeFichero
		for (Usuarios aux : intF.leeFichero(ruta)) {
			System.out.println("[Id="+aux.getCodigoIdentificador() + "; Nombre=" +aux.getNombre() + "; Apellidos=" + aux.getApellidos() + "; EsVeterinario=" + aux.isEsVeterinario() + ";" + aux.toString() + "]");
		}
		
	}

}
