package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class OrganizacionDAO extends BaseHibernateDAO
{
	private static final Log log = LogFactory.getLog(OrganizacionDAO.class);

	// property constants

	public void save(Organizacion transientInstance) {
		log.debug("saving Organizacion instance");
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

	public void delete(Organizacion persistentInstance) {
		log.debug("deleting Organizacion instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Organizacion findById(java.lang.Integer id) {
		log.debug("getting Organizacion instance with id: " + id);
		try {
			Organizacion instance = (Organizacion) getSession().get("inmo.db.Organizacion", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Organizacion instance) {
		log.debug("finding Organizacion instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Organizacion").add(
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
		log.debug("finding Organizacion instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Organizacion as model where model."
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
		log.debug("finding all Organizacion instances");
		try {
			String queryString = "from Organizacion";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Organizacion merge(Organizacion detachedInstance) {
		log.debug("merging Organizacion instance");
		try {
			Organizacion result = (Organizacion) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Organizacion instance) {
		log.debug("attaching dirty Organizacion instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Organizacion instance) {
		log.debug("attaching clean Organizacion instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void update (Organizacion instance)
	{
		getSession().beginTransaction();
		getSession().update(instance); 
		getSession().getTransaction().commit();
	}
}
