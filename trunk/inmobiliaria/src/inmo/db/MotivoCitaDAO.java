package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class MotivoCitaDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(MotivoCitaDAO.class);
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";

	public void save(MotivoCita transientInstance) {
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

	public void delete(MotivoCita persistentInstance) {
		log.debug("deleting MotivoCita instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MotivoCita findById(java.lang.Integer id) {
		log.debug("getting MotivoCita instance with id: " + id);
		try {
			MotivoCita instance = (MotivoCita) getSession().get(
					"inmo.db.MotivoCita", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MotivoCita instance) {
		log.debug("finding MotivoCita instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.MotivoCita")
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
		log.debug("finding MotivoCita instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MotivoCita as model where model."
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
		log.debug("finding all MotivoCita instances");
		try {
			String queryString = "from MotivoCita";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MotivoCita merge(MotivoCita detachedInstance) {
		log.debug("merging MotivoCita instance");
		try {
			MotivoCita result = (MotivoCita) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MotivoCita instance) {
		log.debug("attaching dirty MotivoCita instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MotivoCita instance) {
		log.debug("attaching clean MotivoCita instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (MotivoCita instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}