package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService  {

    @Autowired
    RepositorioEvento repoEvento;
    @Override
    public boolean validarNombre(String nombre) {
       return !nombre.isEmpty();
    }

    @Override
    public boolean validarLocalidad(String localidad) {
        return !localidad.isEmpty();
    }

    @Override
    public void save(Evento evento) {

    }

    @Override
    public Evento buscarPorId(Long id) {
        return null;
    }

    @Override
    public Evento buscarPorNombre(String nombre) {
        return repoEvento.buscarPorNombre(nombre);
    }

    @Override
    public List<Evento> buscarPorTipoDeEvento(TipoDeEvento tipoDeEvento) {
        return repoEvento.buscarPorTipoDeEvento(tipoDeEvento);
    }

    @Override
    public List<Evento> buscarPorFecha(LocalDate fechaEvento) {
        return repoEvento.buscarPorFechaDeEvento(fechaEvento);
    }

    @Override
    public List<Evento> buscarPorCiudad(String ciudad) {
       return repoEvento.buscarPorLocalidadDeEvento(ciudad);
    }

    @Override
    public List<Evento> getEventos() {
        return repoEvento.findAll();
    }
}
