package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class TituloXEmpleadoDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TituloXEmpleadoDAO.class);

	// property constants

	public void save(TituloXEmpleado transientInstance) {
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

	public void delete(TituloXEmpleado persistentInstance) {
		log.debug("deleting TituloXEmpleado instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TituloXEmpleado findById(inmo.db.TituloXEmpleadoId id) {
		log.debug("getting TituloXEmpleado instance with id: " + id);
		try {
			TituloXEmpleado instance = (TituloXEmpleado) getSession().get(
					"inmo.db.TituloXEmpleado", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TituloXEmpleado instance) {
		log.debug("finding TituloXEmpleado instance by example");
		try {
			List results = getSession().createCriteria(
					"inmo.db.TituloXEmpleado").add(Example.create(instance))
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
		log.debug("finding TituloXEmpleado instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TituloXEmpleado as model where model."
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
		log.debug("finding all TituloXEmpleado instances");
		try {
			String queryString = "from TituloXEmpleado";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TituloXEmpleado merge(TituloXEmpleado detachedInstance) {
		log.debug("merging TituloXEmpleado instance");
		try {
			TituloXEmpleado result = (TituloXEmpleado) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TituloXEmpleado instance) {
		log.debug("attaching dirty TituloXEmpleado instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TituloXEmpleado instance) {
		log.debug("attaching clean TituloXEmpleado instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (TituloXEmpleado instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}