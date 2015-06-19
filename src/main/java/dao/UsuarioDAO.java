package dao;

import admin.Usuario;

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
}
