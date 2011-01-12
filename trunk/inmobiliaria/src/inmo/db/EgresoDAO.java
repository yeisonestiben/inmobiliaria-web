package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;


@SuppressWarnings("rawtypes")
public class EgresoDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(EgresoDAO.class);
	// property constants
	public static final String MONTO = "monto";
	public static final String NUMERO_COMPROBANTE = "numeroComprobante";

	public void save(Egreso transientInstance) {
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

	public void delete(Egreso persistentInstance) {
		log.debug("deleting Egreso instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Egreso findById(java.lang.Integer id) {
		log.debug("getting Egreso instance with id: " + id);
		try {
			Egreso instance = (Egreso) getSession().get("inmo.db.Egreso", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Egreso instance) {
		log.debug("finding Egreso instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Egreso").add(
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
		log.debug("finding Egreso instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Egreso as model where model."
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

	public List findByNumeroComprobante(Object numeroComprobante) {
		return findByProperty(NUMERO_COMPROBANTE, numeroComprobante);
	}

	public List findAll() {
		log.debug("finding all Egreso instances");
		try {
			String queryString = "from Egreso";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Egreso merge(Egreso detachedInstance) {
		log.debug("merging Egreso instance");
		try {
			Egreso result = (Egreso) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Egreso instance) {
		log.debug("attaching dirty Egreso instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Egreso instance) {
		log.debug("attaching clean Egreso instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (Egreso instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}