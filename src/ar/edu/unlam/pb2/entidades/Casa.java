package ar.edu.unlam.pb2.entidades;

public class Casa extends Propiedad {
	
	private static final Double PRECIO_VENTA_BASE = 50000.0;

	public Casa(String ubicacion) {
		super(PRECIO_VENTA_BASE, ubicacion);
	}
	
	@Override
	public Double getPrecioDeVenta() {
		return precioDeVenta;
	}

	@Override
	public void setPrecio(Double nuevoPrecio) {
		precioDeVenta = nuevoPrecio;
	}
	
}
