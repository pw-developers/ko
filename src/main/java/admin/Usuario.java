package admin;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
	//Atributos
	@Id
	@Column(name = "login", length = 20, nullable = false)
	private String login;
	
	@Column(name = "senha", length = 20, nullable = false)
	private String senha;
	
	//Construtores
	public Usuario(){}

	//Getters and Setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//Outros metodos
}
