package dao;

import java.util.ArrayList;

import javax.persistence.Query;

import admin.Usuario;
import java.util.List;

public class UsuarioDAO extends AbstractJpaDAO<Usuario> {
	
	private static UsuarioDAO instance = null;
	
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}
	
	private UsuarioDAO(){
		super();
		setClazz(Usuario.class);
	}
	
	public static boolean validaUsuario(String login, String senha){
		List userList = (List) findOne(login, senha);
		
		//Se nao for NULL ou 0, retornara apenas um registro
		if(userList != null && userList.size() > 0 
				&& ((Usuario) userList.get(0)).getLogin().equals(login) 
				&& ((Usuario) userList.get(0)).getSenha().equals(senha)){
			return true;
		}else{
			return false;
		}
	}
	
	private static List findOne(String login, String senha){
		Query query = JpaUtil.getEntityManager().createQuery("from Usuario where login = :vlogin and senha = :vsenha");
		query.setParameter("vlogin", login);
		query.setParameter("vsenha", senha);
		return query.getResultList();
	}
}
