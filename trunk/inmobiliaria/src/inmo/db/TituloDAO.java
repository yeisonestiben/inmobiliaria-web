package inmo.db;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

@SuppressWarnings("rawtypes")
public class TituloDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TituloDAO.class);
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";

	public void save(Titulo transientInstance) {
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

	public void delete(Titulo persistentInstance) {
		log.debug("deleting Titulo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Titulo findById(java.lang.Integer id) {
		log.debug("getting Titulo instance with id: " + id);
		try {
			Titulo instance = (Titulo) getSession().get("inmo.db.Titulo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Titulo instance) {
		log.debug("finding Titulo instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Titulo").add(
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
		log.debug("finding Titulo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Titulo as model where model."
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

	public List findByDescripcion(Object descripcion) {
		return findByProperty(DESCRIPCION, descripcion);
	}

	public List findAll() {
		log.debug("finding all Titulo instances");
		try {
			String queryString = "from Titulo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Titulo merge(Titulo detachedInstance) {
		log.debug("merging Titulo instance");
		try {
			Titulo result = (Titulo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Titulo instance) {
		log.debug("attaching dirty Titulo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Titulo instance) {
		log.debug("attaching clean Titulo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (Titulo instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}