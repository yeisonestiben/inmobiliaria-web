package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class PropiedadesXPropietarioDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(PropiedadesXPropietarioDAO.class);

	// property constants

	public void save(PropiedadesXPropietario transientInstance) {
		log.debug("saving PropiedadesXPropietario instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PropiedadesXPropietario persistentInstance) {
		log.debug("deleting PropiedadesXPropietario instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PropiedadesXPropietario findById(inmo.db.PropiedadesXPropietarioId id) {
		log.debug("getting PropiedadesXPropietario instance with id: " + id);
		try {
			PropiedadesXPropietario instance = (PropiedadesXPropietario) getSession()
					.get("inmo.db.PropiedadesXPropietario", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PropiedadesXPropietario instance) {
		log.debug("finding PropiedadesXPropietario instance by example");
		try {
			List results = getSession().createCriteria(
					"inmo.db.PropiedadesXPropietario").add(
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
		log.debug("finding PropiedadesXPropietario instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PropiedadesXPropietario as model where model."
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
		log.debug("finding all PropiedadesXPropietario instances");
		try {
			String queryString = "from PropiedadesXPropietario";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PropiedadesXPropietario merge(
			PropiedadesXPropietario detachedInstance) {
		log.debug("merging PropiedadesXPropietario instance");
		try {
			PropiedadesXPropietario result = (PropiedadesXPropietario) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PropiedadesXPropietario instance) {
		log.debug("attaching dirty PropiedadesXPropietario instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PropiedadesXPropietario instance) {
		log.debug("attaching clean PropiedadesXPropietario instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (PropiedadesXPropietario instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}