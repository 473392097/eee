import com.lanou.bean.CrmClasses;
import com.lanou.bean.CrmPost;
import com.lanou.bean.CrmStaff;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.metamodel.EntityType;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanouhn on 17/8/16.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

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

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
//        String  hql = "from CrmClasses";
//        Query query = session.createQuery(hql);
//        List<CrmClasses> crmClassesList = query.list();
//        System.out.println(crmClassesList);

          String hql = "from CrmClasses ";
          Query query = session.createQuery(hql);
          List<CrmStaff> crmClassesList = query.list();
          System.out.println(crmClassesList);

    }
}