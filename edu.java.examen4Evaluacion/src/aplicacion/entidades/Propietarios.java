package aplicacion.entidades;

/**
 * Clase Hija Propietarios
 * @author csi22
 *
 */
public class Propietarios extends Usuarios {

	// Atributos
	
	private int numeroMascotas = 0;
	
	// Constructores
	
	public Propietarios(int codigoIdentificador, String nombre, String apellidos, boolean esVeterinario, int numeroMascotas) {
		super(codigoIdentificador, nombre, apellidos, esVeterinario);
		this.numeroMascotas = numeroMascotas;
	}
	
	// Getters
	
	public int getNumeroMascotas() {
		return numeroMascotas;
	}

	// toString
	
	@Override
	public String toString() {
		return "numeroMascotas=" + numeroMascotas;
	}
}
