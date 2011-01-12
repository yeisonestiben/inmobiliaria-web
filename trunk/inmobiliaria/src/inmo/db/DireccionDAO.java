package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class DireccionDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(DireccionDAO.class);
	// property constants
	public static final String CALLE = "calle";
	public static final String NRO = "nro";
	public static final String PISO = "piso";
	public static final String DEPARTAMENTO = "departamento";
	public static final String CPP = "cpp";

	public void save(Direccion transientInstance)  {
		log.debug("saving Quejas instance");
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

	public void delete(Direccion persistentInstance) {
		log.debug("deleting Direccion instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Direccion findById(java.lang.Integer id) {
		log.debug("getting Direccion instance with id: " + id);
		try {
			Direccion instance = (Direccion) getSession().get(
					"inmo.db.Direccion", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Direccion instance) {
		log.debug("finding Direccion instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Direccion")
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
		log.debug("finding Direccion instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Direccion as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCalle(Object calle) {
		return findByProperty(CALLE, calle);
	}

	public List findByNro(Object nro) {
		return findByProperty(NRO, nro);
	}

	public List findByPiso(Object piso) {
		return findByProperty(PISO, piso);
	}

	public List findByDepartamento(Object departamento) {
		return findByProperty(DEPARTAMENTO, departamento);
	}

	public List findByCpp(Object cpp) {
		return findByProperty(CPP, cpp);
	}

	public List findAll() {
		log.debug("finding all Direccion instances");
		try {
			String queryString = "from Direccion";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Direccion merge(Direccion detachedInstance) {
		log.debug("merging Direccion instance");
		try {
			Direccion result = (Direccion) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Direccion instance) {
		log.debug("attaching dirty Direccion instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Direccion instance) {
		log.debug("attaching clean Direccion instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (Direccion instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}