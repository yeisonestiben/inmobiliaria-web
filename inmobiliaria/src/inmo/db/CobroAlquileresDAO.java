package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class CobroAlquileresDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(CobroAlquileresDAO.class);
	// property constants
	public static final String MONTO = "monto";
	public static final String INTERES = "interes";

	public void save(CobroAlquileres transientInstance) {
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

	public void delete(CobroAlquileres persistentInstance) {
		log.debug("deleting CobroAlquileres instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CobroAlquileres findById(java.lang.Integer id) {
		log.debug("getting CobroAlquileres instance with id: " + id);
		try {
			CobroAlquileres instance = (CobroAlquileres) getSession().get(
					"inmo.db.CobroAlquileres", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CobroAlquileres instance) {
		log.debug("finding CobroAlquileres instance by example");
		try {
			List results = getSession().createCriteria(
					"inmo.db.CobroAlquileres").add(Example.create(instance))
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
		log.debug("finding CobroAlquileres instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CobroAlquileres as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMonto(Object monto) {
		return findByProperty(MONTO, monto);
	}

	public List findByInteres(Object interes) {
		return findByProperty(INTERES, interes);
	}

	public List findAll() {
		log.debug("finding all CobroAlquileres instances");
		try {
			String queryString = "from CobroAlquileres";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CobroAlquileres merge(CobroAlquileres detachedInstance) {
		log.debug("merging CobroAlquileres instance");
		try {
			CobroAlquileres result = (CobroAlquileres) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CobroAlquileres instance) {
		log.debug("attaching dirty CobroAlquileres instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CobroAlquileres instance) {
		log.debug("attaching clean CobroAlquileres instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (CobroAlquileres instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}