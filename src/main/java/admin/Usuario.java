package admin;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)  
    //@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "login", length = 20, unique = true, nullable = false)
	private String login;
	
	@Column(name = "email", length = 40, nullable = false)
	private String email;
	
	@Column(name = "nome", length = 40, nullable = false)
	private String nome;
	
	@Column(name = "sobreNome", length = 40, nullable = false)
	private String sobreNome;
	
	@Column(name = "senha", length = 20, nullable = false)
	private String senha;
	
	//Construtores
	public Usuario(){}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//Outros metodos
}
