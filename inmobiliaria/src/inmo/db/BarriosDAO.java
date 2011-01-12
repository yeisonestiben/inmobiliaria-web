package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class BarriosDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(BarriosDAO.class);
	// property constants
	public static final String NOMBRE = "nombre";

	public void save(Barrios transientInstance) {
		log.debug("saving Barrios instance");
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

	public void delete(Barrios persistentInstance) {
		log.debug("deleting Barrios instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Barrios findById(java.lang.Integer id) {
		log.debug("getting Barrios instance with id: " + id);
		try {
			Barrios instance = (Barrios) getSession()
					.get("inmo.db.Barrios", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Barrios instance) {
		log.debug("finding Barrios instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Barrios").add(
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
		log.debug("finding Barrios instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Barrios as model where model."
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
		log.debug("finding all Barrios instances");
		try {
			String queryString = "from Barrios";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Barrios merge(Barrios detachedInstance) {
		log.debug("merging Barrios instance");
		try {
			Barrios result = (Barrios) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Barrios instance) {
		log.debug("attaching dirty Barrios instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Barrios instance) {
		log.debug("attaching clean Barrios instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (Barrios instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}