package ar.edu.unlam.pb2.entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Operacion {
	
	public List<Propiedad> propiedades;

	public Operacion() {
		this.propiedades = new ArrayList<>();
	}
}

