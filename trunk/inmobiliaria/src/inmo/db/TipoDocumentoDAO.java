package inmo.db;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class TipoDocumentoDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TipoDocumentoDAO.class);
	// property constants
	public static final String TIPO = "tipo";
	public static final String DESCRIPCION = "descripcion";

	public void save(TipoDocumento transientInstance) {
		log.debug("saving Cliente instance");
		try {
                	getSession().beginTransaction();
			getSession().save(transientInstance);
                        getSession().getTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TipoDocumento persistentInstance) {
		log.debug("deleting TipoDocumento instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TipoDocumento findById(java.lang.Integer id) {
		log.debug("getting TipoDocumento instance with id: " + id);
		try {
			TipoDocumento instance = (TipoDocumento) getSession().get(
					"inmo.db.TipoDocumento", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TipoDocumento instance) {
		log.debug("finding TipoDocumento instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.TipoDocumento")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TipoDocumento instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TipoDocumento as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTipo(Object tipo) {
		return findByProperty(TIPO, tipo);
	}

	public List findByDescripcion(Object descripcion) {
		return findByProperty(DESCRIPCION, descripcion);
	}

	public List findAll() {
		log.debug("finding all TipoDocumento instances");
		try {
			String queryString = "from TipoDocumento";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TipoDocumento merge(TipoDocumento detachedInstance) {
		log.debug("merging TipoDocumento instance");
		try {
			TipoDocumento result = (TipoDocumento) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TipoDocumento instance) {
		log.debug("attaching dirty TipoDocumento instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipoDocumento instance) {
		log.debug("attaching clean TipoDocumento instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (TipoDocumento instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}