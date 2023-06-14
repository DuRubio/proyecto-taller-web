package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Evento;

import java.time.LocalDate;
import java.util.List;


public interface RepositorioEvento {

    public void save(Evento evento);

    Evento buscarPorId(Long id);

    Evento buscarPorNombre(String nombre);

    List<Evento> buscarPorTipoDeEvento(String tipo);

    List<Evento> buscarPorFechaDeEvento(LocalDate fecha);

    List<Evento> buscarPorLocalidadDeEvento(String localidad);

    public List<Evento> findAll() ;

    List<Evento> buscarEventosConFiltros(LocalDate fecha, String ciudad, String tipo);

	public List<Evento> findFirst4Events();

	public List<Evento> findEventosPorMisPreferencias();

	
}

