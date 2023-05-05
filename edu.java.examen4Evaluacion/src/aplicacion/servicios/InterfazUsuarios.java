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
	
	
	public void mostrarUsuariosFichero(String ruta);
}
