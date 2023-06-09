package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Usuario;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioImpl implements RepositorioUsuario  {

    private SessionFactory sessionFactory;
    @Autowired
    public RepositorioUsuarioImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    public boolean save(Usuario usuario) {
        sessionFactory.getCurrentSession().save(usuario);
        return true;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return sessionFactory.getCurrentSession().get(Usuario.class, id);
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        return sessionFactory.getCurrentSession().get(Usuario.class, correo);
    }
}
