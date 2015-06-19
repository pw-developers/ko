package dao;

import java.util.List;

public abstract class AbstractJpaDAO<T> {

	private Class<T> clazz;

	public final void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(final long id) {
		return JpaUtil.getEntityManager().find(clazz, id);
	}

	public List<T> findAll() {
		return JpaUtil.getEntityManager().createQuery("from " + clazz.getName(), clazz).getResultList();
	}

	public void create(final T entity) {
		try {
			JpaUtil.beginTransaction();
			JpaUtil.getEntityManager().persist(entity);
			JpaUtil.commit();
		} catch (Exception e){
			JpaUtil.rollback();
		}
	}

	public T update(final T entity) {
		return JpaUtil.getEntityManager().merge(entity);
	}

	public void delete(final T entity) {
		try {
			JpaUtil.beginTransaction();
			JpaUtil.getEntityManager().remove(entity);
			JpaUtil.commit();
		} catch (Exception e){
			JpaUtil.rollback();
		}
	}

	public void deleteById(final long entityId) {
		final T entity = findOne(entityId);
		delete(entity);
	}

}