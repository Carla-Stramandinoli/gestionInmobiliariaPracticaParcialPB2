package ar.edu.unlam.pb2.entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Propiedad {

	public Integer codigo;
	private static Integer ultimoCodigo = 0;
	protected Double precioDeVenta;
	protected String ubicacion;
	public List<Operacion> operaciones;
	public Propietario propietarios;
	public Inquilino inquilinos;

	public Propiedad(Double precioDeVenta, String ubicacion) {
		super();
		this.codigo = this.generarCodigo();
		this.operaciones = new ArrayList<>();
		this.precioDeVenta = precioDeVenta;
		this.ubicacion = ubicacion;
	}

	public Integer generarCodigo() {
		return ++ultimoCodigo;
	}

	public abstract Double getPrecioDeVenta();

	public Propietario getPropietario() {
		return propietarios;
	}

	public void setPropietario(Propietario propietarioNuevo) {
		propietarios = propietarioNuevo;
	}

	public Integer getCodigo() {
		return codigo;
	};
	
	public Propietario getInquilino() {
		return propietarios;
	}

	public void setInquilino(Inquilino inquilinoNuevo) {
		inquilinos = inquilinoNuevo;
	}

	public abstract void setPrecio(Double nuevoPrecio);

	public String getUbicacion() {
		return this.ubicacion;
	}
}
