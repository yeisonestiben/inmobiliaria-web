package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class EstadoCobro.
 * 
 * @see inmo.db.EstadoCobro
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("rawtypes")
public class EstadoCobroDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(EstadoCobroDAO.class);
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";

	public void save(EstadoCobro transientInstance) {
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

	public void delete(EstadoCobro persistentInstance) {
		log.debug("deleting EstadoCobro instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EstadoCobro findById(java.lang.Integer id) {
		log.debug("getting EstadoCobro instance with id: " + id);
		try {
			EstadoCobro instance = (EstadoCobro) getSession().get(
					"inmo.db.EstadoCobro", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EstadoCobro instance) {
		log.debug("finding EstadoCobro instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.EstadoCobro")
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
		log.debug("finding EstadoCobro instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EstadoCobro as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNombre(Object nombre) {
		return findByProperty(NOMBRE, nombre);
	}

	public List findByDescripcion(Object descripcion) {
		return findByProperty(DESCRIPCION, descripcion);
	}

	public List findAll() {
		log.debug("finding all EstadoCobro instances");
		try {
			String queryString = "from EstadoCobro";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EstadoCobro merge(EstadoCobro detachedInstance) {
		log.debug("merging EstadoCobro instance");
		try {
			EstadoCobro result = (EstadoCobro) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EstadoCobro instance) {
		log.debug("attaching dirty EstadoCobro instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EstadoCobro instance) {
		log.debug("attaching clean EstadoCobro instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (EstadoCobro instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}