package ar.edu.unlam.pb2.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.entidades.Casa;
import ar.edu.unlam.pb2.entidades.Cliente;
import ar.edu.unlam.pb2.entidades.Inquilino;
import ar.edu.unlam.pb2.entidades.Propiedad;
import ar.edu.unlam.pb2.entidades.Propietario;

public class InmobiliariaTest {

	private InmobiliariaImpl inmobiliaria;

	@Before
	public void init() {
		this.inmobiliaria = new InmobiliariaImpl();
	}

	@Test
	public void dadoQueTengoUnaInmobiliariaSePuedeDarDeAltaUnaCasaYCuandoObtengoSuCodigoEs1() {
		Propiedad casa = new Casa("Ramos mejia");

		assertTrue(this.inmobiliaria.agregarPropiedad(casa));
		Integer codigoEsperado = 3;
		assertEquals(codigoEsperado, casa.getCodigo());
	}

	@Test
	public void dadoQueTengoUnaInmobiliariaSePuedeDarDeAltaDosCasaYCuandoObtengoSuCodigoObtengoParaUnaCasaNumUnoYParaLaOtraNumDos() {
		Propiedad casa = new Casa("Ramos mejia");
		Propiedad otraCasa = new Casa("Ramos mejia");

		this.inmobiliaria.agregarPropiedad(casa);
		this.inmobiliaria.agregarPropiedad(otraCasa);

		Integer codigoEsperadoCasa = 1;
		Integer codigoEsperadoOtraCasa = 2;

		assertEquals(codigoEsperadoCasa, casa.getCodigo());
		assertEquals(codigoEsperadoOtraCasa, otraCasa.getCodigo());
	}

	@Test
	public void dadoQueTengoUnaInmobiliariaConUnaCasaCuandoConsultoSuPrecioObtengoCincuentaMil() {
		Propiedad casa = new Casa("Ramos mejia");

		Double precioEsperado = 50000.0;
		Double precioObtenido = this.inmobiliaria.obetenerPrecio(casa);

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueTengoUnaInmobiliariaConUnaCasaPuedoModificarSuPrecioATreintaMil() {
		Propiedad casa = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(casa);
		
		Double nuevoPrecio = 30000.0;
		casa.setPrecio(nuevoPrecio);	
		
		assertEquals(nuevoPrecio, casa.getPrecioDeVenta());
	}

	@Test
	public void dadoQueTengoUnaInmobiliariaConUnaCasaCuandoRealizoUnaVentaDeLaMismaObtengoQueSuPropietarioCambio() {
		Propiedad casa = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(casa);

		Propietario propietarioCasa = new Propietario("Carlos");
		casa.setPropietario(propietarioCasa);

		Propietario propietarioNuevo = new Propietario("Mariano");

		this.inmobiliaria.hacerVenta(casa, propietarioNuevo);

		String nombrePropietarioCasa = propietarioCasa.getNombre();
		String nombreNuevoPropietarioCasa = casa.getPropietario().getNombre();

		assertNotEquals(nombreNuevoPropietarioCasa, nombrePropietarioCasa);
	}

	@Test
	public void dadoQueTengoUnaInmobiliariaConUnaCasaPuedoRealizarLaVentaDeLaMismaAOtroPropietario() {
		Propiedad casa = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(casa);

		Propietario propietarioCasa = new Propietario("Carlos");
		casa.setPropietario(propietarioCasa);

		Propietario comprador = new Propietario("Mariano");

		Boolean ventaRealizada = this.inmobiliaria.hacerVenta(casa, comprador);
		assertTrue(ventaRealizada);
	}

	@Test
	public void dadoQueTengoUnaInmobiliariaConUnaCasaNoPuedoRealizarLaVentaDeLaMismaAElMismoPropietario() {
		Propiedad casa = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(casa);

		Propietario propietarioCasa = new Propietario("Carlos");
		casa.setPropietario(propietarioCasa);

		Propietario comprador = propietarioCasa;

		Boolean ventaRealizada = this.inmobiliaria.hacerVenta(casa, comprador);
		assertFalse(ventaRealizada);
	}

	@Test
	public void dadoQueTengoUnaInmobiliariaConUnaCasaPuedoRealizarElAlquilerDeLaMismaAUnInquilonoMayorDeDieciochoAnios() {
		Propiedad casa = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(casa);

		Propietario propietarioCasa = new Propietario("Carlos");
		casa.setPropietario(propietarioCasa);

		Inquilino inquilinoNuevo = new Inquilino("Mariano", 20);

		Boolean alquilerRealizado = this.inmobiliaria.hacerAlquiler(casa, inquilinoNuevo);
		assertTrue(alquilerRealizado);
	}

	@Test
	public void dadoQueTengoUnaInmobiliariaConDosCasaPuedoRealizarUnaPermutaEntreLosDosPropietariosDeLasCasas() {
		Propiedad casa = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(casa);
		Propietario propietarioCasaUno = new Propietario("Carlos");
		casa.setPropietario(propietarioCasaUno);

		Propiedad otraCasa = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(otraCasa);
		Propietario propietarioCasaDos = new Propietario("Martin");
		otraCasa.setPropietario(propietarioCasaDos);

		Boolean permutaRalizada = this.inmobiliaria.hacerPermuta(casa, otraCasa);
		assertTrue(permutaRalizada);
	}
	
	@Test
	public void dadoQueTengoUnaInmobiliariaPuedoAgregarUnCliente() {
		Cliente cliente = new Cliente("Carla", "30853224");

		assertTrue(this.inmobiliaria.agregarCliente(cliente));
	
	}
	
	@Test
	public void dadoQueTengoUnaInmobiliariaNoPuedoAgregarDosClientesConElMismoDni() {
		Cliente cliente = new Cliente("Carla", "30853224");
		Cliente otroCliente = new Cliente("Pedro", "30853224");
		
		assertTrue(this.inmobiliaria.agregarCliente(cliente));
		assertFalse(this.inmobiliaria.agregarCliente(otroCliente));
	}
	
	@Test
	public void dadoQueTengoUnaInmobiliariaPuedoOrdenarLasPropiedadesPorPrecioDescendente() {
		Propiedad casa = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(casa);
		
		Propiedad casa2 = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(casa2);
		casa2.setPrecio(2.0);
		
		List<Propiedad> listaDePropiedades = this.inmobiliaria.listarPropiedadesPorPrecio();
		Double precioPropiedad1 = listaDePropiedades.get(0).getPrecioDeVenta();
		Double precioPropiedad2 = listaDePropiedades.get(1).getPrecioDeVenta();
		
		assertTrue(precioPropiedad1 < precioPropiedad2);	
	}
	
	@Test
	public void dadoQueTengoUnaInmobiliariaPuedoOrdenarLasPropiedadesPorUbicacion() {
		Propiedad casa = new Casa("Flores");
		this.inmobiliaria.agregarPropiedad(casa);
		
		Propiedad casa2 = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(casa2);
		
		List<Propiedad> listaDePropiedades = this.inmobiliaria.listarPropiedadesPorUbicacion();
		String ubicacionPropiedad1 = listaDePropiedades.get(0).getUbicacion();
		String ubicacionPropiedad2 = listaDePropiedades.get(1).getUbicacion();
		
		assertTrue(ubicacionPropiedad1.compareTo(ubicacionPropiedad2) <= 0);	
	}
	
	@Test
	public void dadoQueTengoUnaInmobiliariaPuedoBuscarLasPropiedadesQueSuPrecioDeVentaEstaEntreDosYQuinceMil() {
		Propiedad casa = new Casa("Flores");
		this.inmobiliaria.agregarPropiedad(casa);
		casa.setPrecio(3000.0);
		
		Propiedad casa2 = new Casa("Ramos mejia");
		this.inmobiliaria.agregarPropiedad(casa2);
		casa2.setPrecio(12000.0);
		
		Propiedad casa3 = new Casa("San justo");
		this.inmobiliaria.agregarPropiedad(casa3);
		
		
		List<Propiedad> listaDePropiedadesPorRango = this.inmobiliaria.buscarPropiedadesPorRango(2000.0, 15000.0);

		assertTrue(listaDePropiedadesPorRango.contains(casa));
		assertTrue(listaDePropiedadesPorRango.contains(casa2));

	}
}
