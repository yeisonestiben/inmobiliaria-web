package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class PropiedadesDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(PropiedadesDAO.class);
	// property constants
	public static final String AMBIENTES = "ambientes";
	public static final String DORMITORIOS = "dormitorios";
	public static final String BANIOS = "banios";
	public static final String PATIO_M2 = "patioM2";
	public static final String PARCELA_M2 = "parcelaM2";
	public static final String CUBIERTO_M2 = "cubiertoM2";

	public void save(Propiedades transientInstance) {
		log.debug("saving Propiedades instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Propiedades persistentInstance) {
		log.debug("deleting Propiedades instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Propiedades findById(java.lang.Integer id) {
		log.debug("getting Propiedades instance with id: " + id);
		try {
			Propiedades instance = (Propiedades) getSession().get(
					"inmo.db.Propiedades", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Propiedades instance) {
		log.debug("finding Propiedades instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Propiedades")
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
		log.debug("finding Propiedades instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Propiedades as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAmbientes(Object ambientes) {
		return findByProperty(AMBIENTES, ambientes);
	}

	public List findByDormitorios(Object dormitorios) {
		return findByProperty(DORMITORIOS, dormitorios);
	}

	public List findByBanios(Object banios) {
		return findByProperty(BANIOS, banios);
	}

	public List findByPatioM2(Object patioM2) {
		return findByProperty(PATIO_M2, patioM2);
	}

	public List findByParcelaM2(Object parcelaM2) {
		return findByProperty(PARCELA_M2, parcelaM2);
	}

	public List findByCubiertoM2(Object cubiertoM2) {
		return findByProperty(CUBIERTO_M2, cubiertoM2);
	}

	public List findAll() {
		log.debug("finding all Propiedades instances");
		try {
			String queryString = "from Propiedades";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Propiedades merge(Propiedades detachedInstance) {
		log.debug("merging Propiedades instance");
		try {
			Propiedades result = (Propiedades) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Propiedades instance) {
		log.debug("attaching dirty Propiedades instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Propiedades instance) {
		log.debug("attaching clean Propiedades instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (Propiedades instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}