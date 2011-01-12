package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class PersonaDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(PersonaDAO.class);
	// property constants
	public static final String APELLIDO = "apellido";
	public static final String NOMBRES = "nombres";
	public static final String NUMERO_DOCUMENTO = "numeroDocumento";

	public void save(Persona transientInstance) {
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

	public void delete(Persona persistentInstance) {
		log.debug("deleting Persona instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Persona findById(java.lang.Integer id) {
		log.debug("getting Persona instance with id: " + id);
		try {
			Persona instance = (Persona) getSession()
			.get("inmo.db.Persona", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Persona instance) {
		log.debug("finding Persona instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Persona").add(
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
		log.debug("finding Persona instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Persona as model where model."
				+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByApellido(Object apellido) {
		return findByProperty(APELLIDO, apellido);
	}

	public List findByNombres(Object nombres) {
		return findByProperty(NOMBRES, nombres);
	}

	public List findByNumeroDocumento(Object numeroDocumento) {
		return findByProperty(NUMERO_DOCUMENTO, numeroDocumento);
	}

	public List findAll() {
		log.debug("finding all Persona instances");
		try {
			String queryString = "from Persona";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Persona merge(Persona detachedInstance) {
		log.debug("merging Persona instance");
		try {
			Persona result = (Persona) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Persona instance) {
		log.debug("attaching dirty Persona instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Persona instance) {
		log.debug("attaching clean Persona instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void update (Persona instance)
	{
		getSession().beginTransaction();
		getSession().update(instance); 
		getSession().getTransaction().commit();
	}
}