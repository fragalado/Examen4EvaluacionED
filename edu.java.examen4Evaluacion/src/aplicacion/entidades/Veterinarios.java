package aplicacion.entidades;

/**
 * Clase Veterinarios, hereda de Usuarios
 * @author csi22
 *
 */
public class Veterinarios extends Usuarios {
	
	// Atributos
	
	private String numeroColegiado = "aaaaaaaaaaaaaaaaaaaaa";
	
	// Constructores
	
	public Veterinarios(int codigoIdentificador, String nombre, String apellidos, boolean esVeterinario, String numeroColegiado) {
		super(codigoIdentificador, nombre, apellidos, esVeterinario);
		this.numeroColegiado = numeroColegiado;
	}

	// Getters
	
	public String getNumeroColegiado() {
		return numeroColegiado;
	}


	
	// toString
	
	@Override
	public String toString() {
		return "numeroColegiado=" + numeroColegiado;
	}
}
