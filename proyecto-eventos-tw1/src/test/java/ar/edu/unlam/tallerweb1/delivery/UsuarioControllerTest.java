package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Usuario;
import ar.edu.unlam.tallerweb1.domain.UsuarioService;
import ar.edu.unlam.tallerweb1.domain.UsuarioServiceImpl;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuarioImpl;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioControllerTest {


    public static final String CORREO_VALIDO="example@example.com";
    public static final String CORREO_INVALIDO="example.example.com";
    public static final String CLAVE_VALIDO="Dada123";
    public static final String CLAVE_INVALIDO="dadada";
    private UsuarioController usuarioController;
    private DatosRegistracion datosRegistracion;
    private DatosRegistracion datosRegistracion2;
    private DatosRegistracion datosRegistracion3;
    private UsuarioService servicioRegistracion ;
    private DatosLogin usuarioValido;


    @Before
    public void inicializacion(){
        this.datosRegistracion = new DatosRegistracion(CORREO_VALIDO, CLAVE_VALIDO);
        this.datosRegistracion2 = new DatosRegistracion(CORREO_INVALIDO, CLAVE_VALIDO);
        this.datosRegistracion3 = new DatosRegistracion(CORREO_VALIDO, CLAVE_INVALIDO);
        this.usuarioValido = new DatosLogin(CORREO_VALIDO, CLAVE_VALIDO);
        this.servicioRegistracion = mock(UsuarioServiceImpl.class);
        this.usuarioController = new UsuarioController(servicioRegistracion);
    }

   @Test
    public void queAlTocarRegistrarAparezcaLaPantallaRegistro(){

        ModelAndView mav = cuandoQuiereRegistrarse();
        aparezcaVistaRegistro(mav);
    }

    @Test
    public void queSePuedaRegistrarUnUsuarioConDatosCorrectosYLoLleveALogin(){
        dadoQueNoExisteUnUsuario(datosRegistracion, true);
        ModelAndView mav = cuandoSeRegistra(datosRegistracion);
        entoncesElRegistroEsExitoso(mav);
    }

    @Test
    public void queNoSePuedaRegistrarUnUsuarioConMailIncorrectoYEnvieMensaje(){
        dadoQueNoExisteUnUsuario(datosRegistracion2, false);
        ModelAndView mav = cuandoSeRegistra(datosRegistracion2);
        entoncesElRegistroNoEsExitoso(mav);

    }

    @Test
    public void queNoSePuedaRegistrarUnUsuarioConClaveIncorrectoYEnvieMensaje(){
        dadoQueNoExisteUnUsuario(datosRegistracion2, false);
        ModelAndView mav = cuandoSeRegistra(datosRegistracion2);
        entoncesElRegistroNoEsExitoso(mav);

    }

    @Test
    public void queNoSePuedaRegistrarUnMailYaRegistradoYEnvieMensaje(){
        dadoQueExisteUnUsuarioRegistrado(usuarioValido);
        ModelAndView mav = cuandoSeRegistra(datosRegistracion);
        entoncesLoLlevaALoginyRecibeMensaje(mav);
    }

    @Test
    public void queAccedaAlLogin(){
        ModelAndView mav = cuandoQuieroAcceder();
        entoncesAccedoAlLogin(mav);
    }

    @Test
    public void queSePuedaLogearConDatosCorrectosYLoLleveAHome(){
        dadoQueExisteUnUsuario(usuarioValido, true);
        ModelAndView mav = cuandoSeLogea(usuarioValido);
        entoncesLoLlevaAHome(mav);

    }





    private void entoncesLoLlevaALoginyRecibeMensaje(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Usuario existente");
    }

    private void dadoQueExisteUnUsuario(DatosLogin usuarioValido, boolean retornoDeseado) {
        when(servicioRegistracion.compararMail(usuarioValido.getCorreo())).thenReturn(retornoDeseado);
        when(servicioRegistracion.compararClave(usuarioValido.getCorreo(),usuarioValido.getClave())).thenReturn(retornoDeseado);
    }

    private void dadoQueExisteUnUsuarioRegistrado(DatosLogin usuarioValido) {
        Usuario usuario = new Usuario();
        when(servicioRegistracion.obtenerUsuarioPorCorreo(usuarioValido.getCorreo())).thenReturn(usuario);

    }

    private void dadoQueNoExisteUnUsuario(DatosRegistracion datosRegistracion, boolean retorno) {
        when(servicioRegistracion.validarMail(datosRegistracion.getCorreo())).thenReturn(retorno);
        when(servicioRegistracion.validarClave(datosRegistracion.getClave())).thenReturn(retorno);
        when(servicioRegistracion.guardarUsuario(datosRegistracion)).thenReturn(retorno);
    }

    private void entoncesElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");

    }

    private void entoncesLoLlevaAHome(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("home");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Login exitoso");
    }

    private ModelAndView cuandoQuieroAcceder() {
        return usuarioController.getVistaLogin();
    }

    private void entoncesAccedoAlLogin(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("login");
        assertThat(mav.getModel().get("datosLogin")).isNotNull();
        DatosLogin dl = (DatosLogin) mav.getModel().get("datosLogin");
        assertThat(dl.getCorreo()).isNull();
        assertThat(dl.getClave()).isNull();
    }

    private void entoncesElRegistroNoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registrarse");
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Registro fallido, mail o clave inválido");

    }

    private ModelAndView cuandoSeRegistra(DatosRegistracion datosRegistracion) {
        return usuarioController.registrarUsuario(datosRegistracion);
    }

    private ModelAndView cuandoSeLogea(DatosLogin usuarioValido) {
        return usuarioController.logearUsuario(usuarioValido);
    }



    private void aparezcaVistaRegistro(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("registrarse");
    }

  private ModelAndView cuandoQuiereRegistrarse() {
        return usuarioController.getVistaRegistro();
    }



}
