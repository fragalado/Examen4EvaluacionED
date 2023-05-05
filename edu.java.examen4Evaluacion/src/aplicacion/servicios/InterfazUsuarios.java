package aplicacion.servicios;

import java.util.List;

import aplicacion.entidades.Usuarios;

/**
 * Interfaz que define los métodos que darán servicio a Usuarios
 * @author csi22
 *
 */
public interface InterfazUsuarios {
	
	/**
	 * Método que crea un objeto Usuarios con los datos introducidos y lo añade a la lista
	 * Devuelve la lista actualizada
	 * @param listaBD
	 * @return
	 */
	public List<Usuarios> crearUsuario(List<Usuarios> listaBD);
	
	/**
	 * Método que muestra por consola los objetos Usuarios que crea a partir de un fichero
	 * @param ruta
	 */
	public void mostrarUsuariosFichero(String ruta);
}
