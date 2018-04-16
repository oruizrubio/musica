package es.oruiz.musica.Usuario.boundary;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;

import es.oruiz.musica.JpaService;
import es.oruiz.musica.Usuario.controler.UsuarioService;
import es.oruiz.musica.Usuario.entity.Usuario;
import es.oruiz.musica.util.SessionUtils;

@Stateless
@JpaService
public class UsuarioServiceJpa implements UsuarioService {
	@PersistenceContext
	private EntityManager em;
	private JinqJPAStreamProvider streams;

	@PostConstruct
	private void init() {
		streams = new JinqJPAStreamProvider( em.getMetamodel());
	}
	
	public JPAJinqStream<Usuario> getStream() {
		return streams.streamAll(em, Usuario.class);
	}
	
	public UsuarioServiceJpa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validarUsuario(Usuario pUsuario) {
		System.out.println("UsuarioServiceJpa.validarUsuario");
		String nombre = pUsuario.getUsuario();
		String clave = pUsuario.getPassword();
		System.out.println("UsuarioServiceJpa.validarUsuario "+ nombre + " " + clave);
		if (nombre != null && clave != null) {
			JPAJinqStream<Usuario> query = getStream();
			
			if (nombre != null) {
				query = query.where(usuario -> usuario.getUsuario().toUpperCase().contains(nombre.toUpperCase()) 
						&& usuario.getPassword().toUpperCase().contains(clave.toUpperCase()) );
			}
			System.out.println("UsuarioServiceJpa.validarUsuario "+query.count());
			if (query.count() == 1) {
				HttpSession sesion = SessionUtils.getSession();
				sesion.setAttribute("username", nombre);
			}
		}
	}

}
