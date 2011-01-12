package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class PropietarioDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(PropietarioDAO.class);

	// property constants

	public void save(Propietario transientInstance) {
		log.debug("saving Propietario instance");
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

	public void delete(Propietario persistentInstance) {
		log.debug("deleting Propietario instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Propietario findById(java.lang.Integer id) {
		log.debug("getting Propietario instance with id: " + id);
		try {
			Propietario instance = (Propietario) getSession().get(
					"inmo.db.Propietario", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Propietario instance) {
		log.debug("finding Propietario instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Propietario")
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
		log.debug("finding Propietario instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Propietario as model where model."
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
		log.debug("finding all Propietario instances");
		try {
			String queryString = "from Propietario";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Propietario merge(Propietario detachedInstance) {
		log.debug("merging Propietario instance");
		try {
			Propietario result = (Propietario) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Propietario instance) {
		log.debug("attaching dirty Propietario instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Propietario instance) {
		log.debug("attaching clean Propietario instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void update (Propietario instance)
	{
		getSession().beginTransaction();
		getSession().update(instance); 
		getSession().getTransaction().commit();
	}
}