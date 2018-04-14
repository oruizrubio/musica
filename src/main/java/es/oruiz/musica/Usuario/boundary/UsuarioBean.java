package es.oruiz.musica.Usuario.boundary;

import java.io.Serializable;

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

//@Named("usuarioBean")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
	//@Getter
	//@Setter
	private Usuario usuario;
	
	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Inject 
	@JpaService
	private UsuarioService usuarioService;	
	
	public UsuarioBean() {
		// TODO Auto-generated constructor stub
	}

	public String validarUsuario() {
		System.out.println("UsuarioBean.validarUsuario");
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
