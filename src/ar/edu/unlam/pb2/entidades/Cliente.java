package ar.edu.unlam.pb2.entidades;

public class Cliente extends Persona {

	public String dni;

	public Cliente(String nombre, String dni) {
		super(nombre);
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

}
