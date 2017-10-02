package rop.miu.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.ROPDaoException;



/**
 * 
 * @author garrik brel
 * @author Ndadji Maxime
 */
public class ROPCrudDao {

	private static SessionFactory sessionFactory;
	private static final ThreadLocal<Session> threadSession=new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> threadTransaction=new ThreadLocal<Transaction>();
    
    static {
    	try{
    		sessionFactory= new AnnotationConfiguration().configure(ROPConstants.DAO_FILE).buildSessionFactory();
    	}catch(Throwable ex){
    		throw new ExceptionInInitializerError(ex);
    	}
    }
    
    protected static void closeSession() throws HibernateException {
    	Session session = threadSession.get();
    	try{
    		threadSession.set(null);
    		if(session != null && session.isOpen()){
    			session.close();
    		}
    	}catch(HibernateException ex){
    		throw ex;
    	}
    }
    
    protected static void beginTransaction() throws HibernateException {
    	Transaction transaction = threadTransaction.get();
    	try{
    		if(transaction == null){
    			transaction=getSession().beginTransaction();
    			threadTransaction.set(transaction);
    		}
    	}catch(HibernateException ex){
    		ex.printStackTrace();
    		throw ex;
    	}
    }
    
    protected static Session getSession() {
    	Session session = threadSession.get();
    	try{
    		if(session == null){
    			session = getSessionFactory().openSession();
    		}
    		threadSession.set(session);
    	}catch(HibernateException ex){
    		throw ex;
    	}
    	return session;
    }
    
    private static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    
    protected static void commitTransaction() throws HibernateException {
    	Transaction transaction = threadTransaction.get();
    	try{
    		if(transaction!=null && !transaction.wasCommitted()&& !transaction.wasRolledBack()){
    			transaction.commit();
    		}
			threadTransaction.set(null);
    	}catch(HibernateException ex){
    		rollBackTransaction();
    		throw ex;
    	}
    }
    
    protected static void rollBackTransaction() throws HibernateException {
    	Transaction transaction = threadTransaction.get();
    	threadTransaction.set(null);
    	try{
    		if(transaction!=null && !transaction.wasCommitted() &&!transaction.wasRolledBack()){
    			transaction.rollback();
    		}
    	}catch(HibernateException ex){
    		throw ex;
    	}finally{
    		closeSession();
    	}
    }
    
    
    public static Object getById(Class<?> c, Serializable id) throws ROPDaoException{
    	Object o;
    	try{
    		Session s = getSession();
    		o = s.get(c, id);
    	}catch(Exception e){
    		throw new ROPDaoException(e);
    	}finally{
    		closeSession();
    	}
    	return o;
    }
    
    public static Object saveOrUpdate(Object obj) throws ROPDaoException {
    	try{
   		 	beginTransaction();
   		 	Session s = getSession();
   		 	Object o = s.merge(obj);
   		 	commitTransaction();
   		 	s.clear();
   		 	return o;
	   	 }catch(Exception e){
	   		 	rollBackTransaction();
	   		 	throw new ROPDaoException(e);
	   	 }finally{
	   		 closeSession();
	   	 }
    }
    
    public static void save(Object obj) throws ROPDaoException {
    	try{
   		 	beginTransaction();
   		 	Session s = getSession();
   		 	s.persist(obj);
   		 	commitTransaction();
   		 	s.clear();
	   	 }catch(Exception e){
	   		 	rollBackTransaction();
	   		 	throw new ROPDaoException(e);
	   	 }finally{
	   		 closeSession();
	   	 }
    }
    
    public static void delete(Object obj) throws ROPDaoException {
    	try{
   		 	beginTransaction();
   		 	Session s = getSession();
   		 	s.delete(obj);
   		 	commitTransaction();
   		 	s.clear();
	   	 }catch(Exception e){
	   		 	rollBackTransaction();
	   		 	throw new ROPDaoException(e);
	   	 }finally{
	   		 closeSession();
	   	 }
    }
    
    public static void update(Object obj) throws ROPDaoException {
    	try{
   		 	beginTransaction();
   		 	Session s = getSession();
   		 	s.update(obj);
   		 	commitTransaction();
   		 	s.clear();
	   	 }catch(Exception e){
	   		 	rollBackTransaction();
	   		 	throw new ROPDaoException(e);
	   	 }finally{
	   		 closeSession();
	   	 }
    }
    
    public static void refresh(Object obj) throws ROPDaoException {
    	try{
   		 	beginTransaction();
   		 	Session s = getSession();
   		 	s.refresh(obj);
   		 	commitTransaction();
   		 	s.clear();
	   	 }catch(Exception e){
	   		 	rollBackTransaction();
	   		 	throw new ROPDaoException(e);
	   	 }finally{
	   		 closeSession();
	   	 }
    }
    
	@SuppressWarnings("rawtypes")
	public static List selectManyElements(String query, Object ... params) throws HibernateException{
    	Session s = getSession();
    	Query q = s.createQuery(query);
    	for(int i = 0; i < params.length; i++){
    		q.setParameter(i, params[i]);
		}
    	List l = q.list();
    	closeSession();
    	return l;
    }
    
	@SuppressWarnings("rawtypes")
    public static List selectManyElementsSql(String sqlQuery, Object ... params) throws HibernateException{
    	Session s = getSession();
    	SQLQuery q = s.createSQLQuery(sqlQuery);
    	for(int i = 0; i < params.length; i++){
    		q.setParameter(i, params[i]);
		}
    	List l = q.list();
    	closeSession();
    	return l;
    }
	
	public static Object selectSingleElement(String query, Object ... params) throws HibernateException{
		Session s = getSession();
    	Query q = s.createQuery(query);
    	for(int i = 0; i < params.length; i++){
    		q.setParameter(i, params[i]);
		}
    	Object l = q.uniqueResult();
    	closeSession();
    	return l;
	}
	
	public static Object selectSingleElementSql(String sqlQuery, Object ... params) throws HibernateException{
		Session s = getSession();
    	SQLQuery q = s.createSQLQuery(sqlQuery);
    	for(int i = 0; i < params.length; i++){
    		q.setParameter(i, params[i]);
		}
    	Object l = q.uniqueResult();
    	closeSession();
    	return l;
	}
	
	public static int executeInsUpdDelCreQuery(String query, Object ... params) throws ROPDaoException{
		try{
   		 	beginTransaction();
			Session s = getSession();
	    	Query q = s.createQuery(query);
	    	for(int i = 0; i < params.length; i++){
	    		q.setParameter(i, params[i]);
			}
	    	int l = q.executeUpdate();
	    	commitTransaction();
		 	s.clear();
	    	return l;
		}catch(Exception e){
   		 	rollBackTransaction();
   		 	throw new ROPDaoException(e);
	   	}finally{
	   		closeSession();
	   	}
	}
	
	public static int executeInsUpdDelCreSQLQuery(String sqlQuery, Object ... params) throws ROPDaoException{
		try{
   		 	beginTransaction();
			Session s = getSession();
	    	SQLQuery q = s.createSQLQuery(sqlQuery);
	    	for(int i = 0; i < params.length; i++){
	    		q.setParameter(i, params[i]);
			}
	    	int l = q.executeUpdate();
	    	commitTransaction();
		 	s.clear();
		 	return l;
	   	 }catch(Exception e){
	   		 	rollBackTransaction();
	   		 	throw new ROPDaoException(e);
	   	 }finally{
	   		 closeSession();
	   	 }
	}
}
