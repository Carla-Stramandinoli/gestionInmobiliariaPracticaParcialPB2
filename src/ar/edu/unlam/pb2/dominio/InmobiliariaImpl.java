package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ar.edu.unlam.pb2.entidades.Alquiler;
import ar.edu.unlam.pb2.entidades.Cliente;
import ar.edu.unlam.pb2.entidades.Inmobiliaria;
import ar.edu.unlam.pb2.entidades.Inquilino;
import ar.edu.unlam.pb2.entidades.Permuta;
import ar.edu.unlam.pb2.entidades.Persona;
import ar.edu.unlam.pb2.entidades.Propiedad;
import ar.edu.unlam.pb2.entidades.Propietario;
import ar.edu.unlam.pb2.entidades.Venta;

public class InmobiliariaImpl extends Inmobiliaria {

	public Double obetenerPrecio(Propiedad propiedad) {
		return propiedad.getPrecioDeVenta();
	}

	public Boolean hacerVenta(Propiedad propiedad, Propietario comprador) {
		Venta venta = new Venta();
		if (venta.realizarVenta(propiedad, comprador)) {
			this.operaciones.add(venta);
			return true;
		}
		return false;
	}

	public Boolean hacerAlquiler(Propiedad propiedad, Inquilino inquilinoNuevo) {
		Alquiler alquiler = new Alquiler();
		if (alquiler.realizarAlquiler(propiedad, propiedad.getPropietario(), inquilinoNuevo)) {
			this.operaciones.add(alquiler);
			return true;
		}
		return false;
	}

	public Boolean hacerPermuta(Propiedad propiedadUno, Propiedad propiedadDos) {
		Permuta permuta = new Permuta();
		if (permuta.realizarPermuta(propiedadUno, propiedadDos)) {
			this.operaciones.add(permuta);
			return true;
		}
		return false;
	}

	public Boolean agregarCliente(Cliente clienteAgregar) {
		for (Persona cliente : this.personas) {
			if (cliente instanceof Cliente && ((Cliente) cliente).getDni().equals(clienteAgregar.getDni())) {
				return false;
			}
		}
		this.personas.add(clienteAgregar);
		return true;
	}

	public List<Propiedad> listarPropiedadesPorPrecio() {
		// Ordenar la lista de propiedades por precio de venta (de menor a mayor)
		this.propiedades.sort(new Comparator<Propiedad>() {
			@Override
			public int compare(Propiedad propiedad1, Propiedad propiedad2) {
				return propiedad1.getPrecioDeVenta().compareTo(propiedad2.getPrecioDeVenta());
			}
		});
		return this.propiedades;
	}

	public List<Propiedad> listarPropiedadesPorUbicacion() {
		this.propiedades.sort(new Comparator<Propiedad>() {
			@Override
			public int compare(Propiedad propiedad1, Propiedad propiedad2) {
				return propiedad1.getUbicacion().compareTo(propiedad2.getUbicacion());

			}
		});
		return this.propiedades;

	}

	public List<Propiedad> buscarPropiedadesPorRango(Double minimo, Double maximo) {
		List<Propiedad> propiedadesDentroDelRango = new ArrayList<>();
		for (Propiedad propiedad : this.propiedades) {
			if(propiedad.getPrecioDeVenta() >= minimo && propiedad.getPrecioDeVenta() <= maximo) {
				propiedadesDentroDelRango.add(propiedad);
			}
		}
		return propiedadesDentroDelRango;
	}
}
