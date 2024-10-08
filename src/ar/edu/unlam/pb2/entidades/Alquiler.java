package ar.edu.unlam.pb2.entidades;

public class Alquiler extends Operacion{

	public Boolean realizarAlquiler(Propiedad propAlquilar, Propietario propietario, Inquilino inquilino) {
		Boolean alquilerRealizado = false;
		if(propAlquilar.getPropietario().equals(propietario) && inquilino.getEdad() >= 18) {
			propAlquilar.setInquilino(inquilino);
			alquilerRealizado = true;
		} 
		return alquilerRealizado;
	}
}
