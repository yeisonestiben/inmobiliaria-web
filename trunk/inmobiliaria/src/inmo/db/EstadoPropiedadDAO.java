package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class EstadoPropiedad.
 * 
 * @see inmo.db.EstadoPropiedad
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("rawtypes")
public class EstadoPropiedadDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(EstadoPropiedadDAO.class);
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String DESCIPCION = "descipcion";

	public void save(EstadoPropiedad transientInstance) {
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

	public void delete(EstadoPropiedad persistentInstance) {
		log.debug("deleting EstadoPropiedad instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EstadoPropiedad findById(java.lang.Integer id) {
		log.debug("getting EstadoPropiedad instance with id: " + id);
		try {
			EstadoPropiedad instance = (EstadoPropiedad) getSession().get(
					"inmo.db.EstadoPropiedad", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EstadoPropiedad instance) {
		log.debug("finding EstadoPropiedad instance by example");
		try {
			List results = getSession().createCriteria(
					"inmo.db.EstadoPropiedad").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EstadoPropiedad instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EstadoPropiedad as model where model."
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

	public List findByDescipcion(Object descipcion) {
		return findByProperty(DESCIPCION, descipcion);
	}

	public List findAll() {
		log.debug("finding all EstadoPropiedad instances");
		try {
			String queryString = "from EstadoPropiedad";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EstadoPropiedad merge(EstadoPropiedad detachedInstance) {
		log.debug("merging EstadoPropiedad instance");
		try {
			EstadoPropiedad result = (EstadoPropiedad) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EstadoPropiedad instance) {
		log.debug("attaching dirty EstadoPropiedad instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EstadoPropiedad instance) {
		log.debug("attaching clean EstadoPropiedad instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (EstadoPropiedad instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}