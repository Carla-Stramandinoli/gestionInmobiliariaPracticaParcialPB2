package ar.edu.unlam.pb2.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Inmobiliaria {

	protected List<Propiedad> propiedades;
	public List<Operacion> operaciones;
	public List<Persona> personas;
	
	public Inmobiliaria() {
		this.propiedades = new ArrayList<>();
		this.operaciones = new ArrayList<>();
		this.personas = new ArrayList<>();
	}

	public Boolean agregarPropiedad(Propiedad propiedad) {
		return this.propiedades.add(propiedad);

	}

	public abstract Double obetenerPrecio(Propiedad propiedad);

	public abstract Boolean agregarCliente(Cliente cliente);


}
