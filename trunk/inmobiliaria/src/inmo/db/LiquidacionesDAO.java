package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class LiquidacionesDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(LiquidacionesDAO.class);

	// property constants

	public void save(Liquidaciones transientInstance) {
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

	public void delete(Liquidaciones persistentInstance) {
		log.debug("deleting Liquidaciones instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Liquidaciones findById(java.lang.Integer id) {
		log.debug("getting Liquidaciones instance with id: " + id);
		try {
			Liquidaciones instance = (Liquidaciones) getSession().get(
					"inmo.db.Liquidaciones", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Liquidaciones instance) {
		log.debug("finding Liquidaciones instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Liquidaciones")
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
		log.debug("finding Liquidaciones instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Liquidaciones as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Liquidaciones instances");
		try {
			String queryString = "from Liquidaciones";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Liquidaciones merge(Liquidaciones detachedInstance) {
		log.debug("merging Liquidaciones instance");
		try {
			Liquidaciones result = (Liquidaciones) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Liquidaciones instance) {
		log.debug("attaching dirty Liquidaciones instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Liquidaciones instance) {
		log.debug("attaching clean Liquidaciones instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (Liquidaciones instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}