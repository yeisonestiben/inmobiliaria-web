package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Contacto.
 * 
 * @see inmo.db.Contacto
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("rawtypes")
public class ContactoDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ContactoDAO.class);
	// property constants
	public static final String NOMBRE = "nombre";

	public void save(Contacto transientInstance) {
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

	public void delete(Contacto persistentInstance) {
		log.debug("deleting Contacto instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Contacto findById(java.lang.Integer id) {
		log.debug("getting Contacto instance with id: " + id);
		try {
			Contacto instance = (Contacto) getSession().get("inmo.db.Contacto",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Contacto instance) {
		log.debug("finding Contacto instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Contacto").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Contacto instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Contacto as model where model."
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

	public List findAll() {
		log.debug("finding all Contacto instances");
		try {
			String queryString = "from Contacto";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Contacto merge(Contacto detachedInstance) {
		log.debug("merging Contacto instance");
		try {
			Contacto result = (Contacto) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Contacto instance) {
		log.debug("attaching dirty Contacto instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Contacto instance) {
		log.debug("attaching clean Contacto instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (Contacto instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}