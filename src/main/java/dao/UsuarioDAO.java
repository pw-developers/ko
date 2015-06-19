package dao;

import admin.Usuario;

public class UsuarioDAO extends AbstractJpaDAO<Usuario> {
	public UsuarioDAO(){
		super();
		setClazz(Usuario.class);
	}
}
