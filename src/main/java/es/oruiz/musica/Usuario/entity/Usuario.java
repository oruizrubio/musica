package es.oruiz.musica.Usuario.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Data
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cdi_usuario")
	private int cdiUsuario;

	private String administrador;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="nombre_completo")
	private String nombreCompleto;

	private String password;

	private String usuario;

	public Usuario() {
		System.out.println("Inicializando usuario");
	}
/*
	public int getCdiUsuario() {
		return this.cdiUsuario;
	}

	public void setCdiUsuario(int cdiUsuario) {
		this.cdiUsuario = cdiUsuario;
	}

	public String getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
*/
}