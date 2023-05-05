package aplicacion.entidades;

/**
 * Clase Padre Usuarios
 * @author csi22
 *
 */
public class Usuarios {
	
	// Atributos
	
	private int codigoIdentificador = 0; // Inicializamos los campos
	private String nombre = "aaaaaaaaaaaaaaaaaaaa";
	private String apellidos = "aaaaaaaaaaaaaaaaaaa";
	private boolean esVeterinario = false;

	
	// Constructores
	
	public Usuarios(int codigoIdentificador, String nombre, String apellidos, boolean esVeterinario) {
		super();
		this.codigoIdentificador = codigoIdentificador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.esVeterinario = esVeterinario;
	}
	
	// Getters
	
	public int getCodigoIdentificador() {
		return codigoIdentificador;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public boolean isEsVeterinario() {
		return esVeterinario;
	}
}
