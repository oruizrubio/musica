package es.oruiz.musica.Usuario.boundary;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import es.oruiz.musica.JpaService;
import es.oruiz.musica.Usuario.controler.UsuarioService;
import es.oruiz.musica.Usuario.entity.Usuario;
import es.oruiz.musica.util.SessionUtils;
import lombok.Getter;
import lombok.Setter;

@Named("usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable{
	@Getter
	@Setter
	private Usuario usuario;
	
	@Inject 
	@JpaService
	private UsuarioService usuarioService;	
	
	public UsuarioBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void init() {
		usuario = new Usuario();
	}
	
	public String validarUsuario() {
		System.out.println("UsuarioBean.validarUsuario "+ usuario.getUsuario());
		usuarioService.validarUsuario(usuario);
		
		return "principal";
		//init();
	}	
	
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";		
	}
}
