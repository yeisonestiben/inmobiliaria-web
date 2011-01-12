package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class DireccionXPersonaDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
	.getLog(DireccionXPersonaDAO.class);

	// property constants

	public void save(DireccionXPersona transientInstance) {
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

	public void delete(DireccionXPersona persistentInstance) {
		log.debug("deleting DireccionXPersona instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DireccionXPersona findById(inmo.db.DireccionXPersonaId id) {
		log.debug("getting DireccionXPersona instance with id: " + id);
		try {
			DireccionXPersona instance = (DireccionXPersona) getSession().get(
					"inmo.db.DireccionXPersona", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(DireccionXPersona instance) {
		log.debug("finding DireccionXPersona instance by example");
		try {
			List results = getSession().createCriteria(
			"inmo.db.DireccionXPersona").add(Example.create(instance))
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
		log.debug("finding DireccionXPersona instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DireccionXPersona as model where model."
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
		log.debug("finding all DireccionXPersona instances");
		try {
			String queryString = "from DireccionXPersona";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DireccionXPersona merge(DireccionXPersona detachedInstance) {
		log.debug("merging DireccionXPersona instance");
		try {
			DireccionXPersona result = (DireccionXPersona) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DireccionXPersona instance) {
		log.debug("attaching dirty DireccionXPersona instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DireccionXPersona instance) {
		log.debug("attaching clean DireccionXPersona instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void update (DireccionXPersona instance)
	{
		getSession().beginTransaction();
		getSession().update(instance); 
		getSession().getTransaction().commit();
	}
}