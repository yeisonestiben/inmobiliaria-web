package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;


@SuppressWarnings("rawtypes")
public class IngresoDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(IngresoDAO.class);
	// property constants
	public static final String MONTO = "monto";

	public void save(Ingreso transientInstance) {
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

	public void delete(Ingreso persistentInstance) {
		log.debug("deleting Ingreso instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ingreso findById(java.lang.Integer id) {
		log.debug("getting Ingreso instance with id: " + id);
		try {
			Ingreso instance = (Ingreso) getSession()
					.get("inmo.db.Ingreso", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Ingreso instance) {
		log.debug("finding Ingreso instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Ingreso").add(
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
		log.debug("finding Ingreso instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ingreso as model where model."
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

	public List findAll() {
		log.debug("finding all Ingreso instances");
		try {
			String queryString = "from Ingreso";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ingreso merge(Ingreso detachedInstance) {
		log.debug("merging Ingreso instance");
		try {
			Ingreso result = (Ingreso) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ingreso instance) {
		log.debug("attaching dirty Ingreso instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ingreso instance) {
		log.debug("attaching clean Ingreso instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (Ingreso instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}