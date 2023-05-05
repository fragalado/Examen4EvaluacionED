package aplicacion.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import aplicacion.entidades.Propietarios;
import aplicacion.entidades.Usuarios;
import aplicacion.entidades.Veterinarios;

/**
 * Implementación de la interfaz Ficheros
 * @author csi22
 *
 */
public class ImplFicheros implements InterfazFicheros {

	@Override
	public List<Usuarios> leeFichero(String ruta) {
		// Lista que devolveremos con los objetos creados a partir del fichero
		List<Usuarios> lista = new ArrayList<>();
		
		// Variables para leer el fichero
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			String[] vAux;
			// Leemos la primera linea
			linea = br.readLine();
			while((linea = br.readLine()) != null) {
				// Ej linea: 1;Fran;Gallego Dorado;true;234567;null
				// Ej linea2: 2;Fran;Gallego Dorado;false;null;2
				vAux = linea.split(";"); // Guardamos la linea separada por ";" en un vector
				
				// Declaramos un objetos de tipo Usuarios
				Usuarios u;
				
				int id = Integer.valueOf(vAux[0]);
				String nombre = vAux[1];
				String apellidos = vAux[2];
				boolean esVeterinario = Boolean.valueOf(vAux[3]);
				
				String numeroColegiado;
				int numeroMascotas;
				if(esVeterinario) {
					numeroColegiado = vAux[4];
					u = new Veterinarios(id, nombre, apellidos, esVeterinario, numeroColegiado);
				} else {
					numeroMascotas = Integer.valueOf(vAux[5]);
					u = new Propietarios(id, nombre, apellidos, esVeterinario, numeroMascotas);
				}
				
				// Añadimos a la lista el objeto creado
				lista.add(u);
				
			}
		} catch (Exception e) {
			System.err.println("** Error: No se ha podido abrir el fichero **");
		} finally {
			// Cerramos el fichero
			try {
				if(fr != null)
					fr.close();
			} catch (Exception e) {
				System.err.println("** Error: No se ha podido cerrar el fichero **");
			}
		}
		
		return lista;
	}

	@Override
	public void escribeFicheroSobreescribiendo(String ruta, List<Usuarios> listaBD) {
		
		// Variables necesarias para escribir en un fichero
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);
			
			// Escribimos la cabecera;
			pw.println("Id;Nombre;Apellidos;EsVeterinario;NumeroColegiado;NumeroMascotas");
			// Escribimos los datos de la lista
			for (Usuarios aux : listaBD) {
				pw.print(aux.getCodigoIdentificador() + ";" + aux.getNombre() + ";" + aux.getApellidos() + ";" + aux.isEsVeterinario() + ";");
				
				if(aux.isEsVeterinario()) {
					pw.println(aux.toString().split("=")[1] + ";null");
				}
				else
					pw.println("null;" + aux.toString().split("=")[1]);
			}
			
		} catch (Exception e) {
			System.err.println("** Error: No se ha podido abrir el fichero **");
		} finally {
			// Cerramos el fichero
			try {
				if(fw != null)
					fw.close();
			} catch (Exception e) {
				System.err.println("** Error: No se ha podido cerrar el fichero **");
			}
		}
		
	}

}
