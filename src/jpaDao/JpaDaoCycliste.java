package jpaDao;


import dao.DaoCycliste;
import entites.TCycliste;
import org.hibernate.query.Query;

public class JpaDaoCycliste extends JpaDao<TCycliste> implements DaoCycliste {

    @Override
    public long nombreDeCyclistes() {

        try {
            String listQuery = "SELECT COUNT(t) FROM "+TCycliste.class.getName()+" t where ";
            Query query = JpaDao.getSession().createQuery(listQuery);
            return (long) query.getSingleResult();
        }
        catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
}

