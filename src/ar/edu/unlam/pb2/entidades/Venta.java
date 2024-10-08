package ar.edu.unlam.pb2.entidades;


public class Venta extends Operacion {

	public Boolean realizarVenta(Propiedad propiedad, Propietario propietarioNuevo) {
		Boolean ventaRealizada = false;
		if(propiedad.getPropietario().getNombre().equals(propietarioNuevo.getNombre())) {
			 ventaRealizada = false;
		} else {
			propiedad.setPropietario(propietarioNuevo);
			ventaRealizada = true;
		}
		return ventaRealizada;
	}
	
}
