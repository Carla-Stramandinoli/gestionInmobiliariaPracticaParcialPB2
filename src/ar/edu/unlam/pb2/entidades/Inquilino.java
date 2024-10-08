package ar.edu.unlam.pb2.entidades;

public class Inquilino extends Persona{

	public Integer edad;
	
	public Inquilino(String nombre, Integer edad) {
		super(nombre);
		this.edad = edad;
	}
	
	public Integer getEdad() {
		return this.edad;
	}
}
