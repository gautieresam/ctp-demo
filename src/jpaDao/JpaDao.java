package jpaDao;
import dao.Dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public abstract class JpaDao<T> implements Dao<T> {

    private static final SessionFactory ourSessionFactory;
    private static final String entityManagerName="JPA";
    private static Session session;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    // COnstructeur par défaut pour la création de session
    public JpaDao(){session=getSession();}

    @Override
    public boolean create(T obj) {
        Transaction tx = null ;
        tx=session.beginTransaction();
        session.save(obj);
        tx.commit();
        return true;
    }

    @Override
    public T find (Class c,int id) {

        T obj = (T) session.load(c,id);
        return obj;
    }

    @Override
    public List<T> findAll(Class c){
        //jpql
        try {
            String listQuery = "SELECT t FROM "+c.getName()+" t";
            Query query = session.createQuery(listQuery);
            List<T> resListe = query.getResultList();
            return resListe;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    @Override
    public boolean update(T obj) {
        Transaction tx = null ;
        tx=session.beginTransaction();

        session.update(obj);
        tx.commit();

        return false;
    }

    @Override
    public boolean delete(T obj) {
        // Ajouter un if pour renvoyer faux si ça marche pas
        Transaction tx = null ;
        tx=session.beginTransaction();
        session.remove(obj);
        tx.commit();

        return true;
    }

    @Override
    public boolean deleteAll() {


        return false;
    }

    @Override
    public void close() /* qui permet de fermer la connexion à la base de données ou le fichier. */ {
        session.close();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        Transaction tx = null ;
        tx=session.beginTransaction();

        try {

            // GET & LOAD sur une référence
            /*
            TExCascadeRef uneRef = session.get(TExCascadeRef.class,1);
            session.refresh(uneRef);
            tx.commit();

            tx = session.beginTransaction();
            uneRef.setLibRef("Reference 222");
            tx.commit();

            tx = session.beginTransaction();
            session.refresh(uneRef);
            System.out.println("La valeur a été changé en base : "+uneRef.getLibRef());
            tx.commit();

             */


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            tx.rollback();
            System.out.println("capth ex ");
        }
        finally {
            session.close();
        }

    }
}


