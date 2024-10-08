package ar.edu.unlam.pb2.entidades;

public class Permuta extends Operacion {

	public Boolean realizarPermuta(Propiedad propiedadUno, Propiedad propiedadDos) {
		Boolean permutaRealizada = false;
		if(propiedadUno.getPropietario() != null 
				&& propiedadDos.getPropietario() != null 
				&& propiedadUno.getPropietario() != propiedadDos.getPropietario()) {
			propiedadUno.setPropietario(propiedadDos.getPropietario());
			propiedadDos.setPropietario(propiedadUno.getPropietario());
			permutaRealizada = true;
		}
		return permutaRealizada;
	}
}
