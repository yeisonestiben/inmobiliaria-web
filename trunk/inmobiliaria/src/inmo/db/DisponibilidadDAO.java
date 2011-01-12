package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class DisponibilidadDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(DisponibilidadDAO.class);
	// property constants
	public static final String MONTO = "monto";

	public void save(Disponibilidad transientInstance) {
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

	public void delete(Disponibilidad persistentInstance) {
		log.debug("deleting Disponibilidad instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Disponibilidad findById(java.lang.Integer id) {
		log.debug("getting Disponibilidad instance with id: " + id);
		try {
			Disponibilidad instance = (Disponibilidad) getSession().get(
					"inmo.db.Disponibilidad", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Disponibilidad instance) {
		log.debug("finding Disponibilidad instance by example");
		try {
			List results = getSession()
					.createCriteria("inmo.db.Disponibilidad").add(
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
		log.debug("finding Disponibilidad instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Disponibilidad as model where model."
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
		log.debug("finding all Disponibilidad instances");
		try {
			String queryString = "from Disponibilidad";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Disponibilidad merge(Disponibilidad detachedInstance) {
		log.debug("merging Disponibilidad instance");
		try {
			Disponibilidad result = (Disponibilidad) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Disponibilidad instance) {
		log.debug("attaching dirty Disponibilidad instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Disponibilidad instance) {
		log.debug("attaching clean Disponibilidad instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (Disponibilidad instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}