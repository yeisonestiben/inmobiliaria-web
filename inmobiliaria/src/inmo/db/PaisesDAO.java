package inmo.db;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;


@SuppressWarnings("rawtypes")
public class PaisesDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(PaisesDAO.class);
	// property constants
	public static final String NOMBRE = "nombre";

	public void save(Paises transientInstance) {
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

	public void delete(Paises persistentInstance) {
		log.debug("deleting Paises instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Paises findById(java.lang.Integer id) {
		log.debug("getting Paises instance with id: " + id);
		try {
			Paises instance = (Paises) getSession().get("inmo.db.Paises", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Paises instance) {
		log.debug("finding Paises instance by example");
		try {
			List results = getSession().createCriteria("inmo.db.Paises").add(
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
		log.debug("finding Paises instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Paises as model where model."
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
		log.debug("finding all Paises instances");
		try {
			String queryString = "from Paises";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Paises merge(Paises detachedInstance) {
		log.debug("merging Paises instance");
		try {
			Paises result = (Paises) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Paises instance) {
		log.debug("attaching dirty Paises instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
			getSession().connection().commit();
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		} catch (SQLException e)
		{
			System.out.println("SQL Exception");
		}
	}

	public void attachClean(Paises instance) {
		log.debug("attaching clean Paises instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update (Paises instance)
	{
			getSession().beginTransaction();
			getSession().update(instance); 
			getSession().getTransaction().commit();
	}
}