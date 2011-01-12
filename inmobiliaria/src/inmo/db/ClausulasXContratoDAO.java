package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class ClausulasXContratoDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(ClausulasXContratoDAO.class);

	// property constants

	public void save(ClausulasXContrato transientInstance) {
		log.debug("saving ClausulasXContrato instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ClausulasXContrato persistentInstance) {
		log.debug("deleting ClausulasXContrato instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ClausulasXContrato findById(java.lang.Integer id) {
		log.debug("getting ClausulasXContrato instance with id: " + id);
		try {
			ClausulasXContrato instance = (ClausulasXContrato) getSession()
					.get("inmo.db.ClausulasXContrato", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ClausulasXContrato instance) {
		log.debug("finding ClausulasXContrato instance by example");
		try {
			List results = getSession().createCriteria(
					"inmo.db.ClausulasXContrato").add(Example.create(instance))
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
		log.debug("finding ClausulasXContrato instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ClausulasXContrato as model where model."
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
		log.debug("finding all ClausulasXContrato instances");
		try {
			String queryString = "from ClausulasXContrato";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ClausulasXContrato merge(ClausulasXContrato detachedInstance) {
		log.debug("merging ClausulasXContrato instance");
		try {
			ClausulasXContrato result = (ClausulasXContrato) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClausulasXContrato instance) {
		log.debug("attaching dirty ClausulasXContrato instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClausulasXContrato instance) {
		log.debug("attaching clean ClausulasXContrato instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (ClausulasXContrato instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}