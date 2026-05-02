import classes.Article;
import classes.Comment;
import classes.Event;
import classes.HibernateUtil;
import classes.Opinion;
import classes.Post;
import classes.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class Protocol {
    public Protocol(){}

    public List<Object> processIn(String[] clientSays, User sender){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object u = null;
        if (clientSays[0].equalsIgnoreCase("Add")){
            if (clientSays[1].equalsIgnoreCase("User")) {
                u = new User(clientSays[2], clientSays[3], clientSays[4]);
            } else if (clientSays[1].equalsIgnoreCase("Event")) {
                LocalDateTime startDate = LocalDateTime.parse(clientSays[4]);
                LocalDateTime endDate = LocalDateTime.parse(clientSays[4]);

                u = new Event(clientSays[2], clientSays[3], startDate, endDate, clientSays[6], clientSays[7], sender);
            } else if (clientSays[1].equalsIgnoreCase("Post")){
                u = new Post(clientSays[2], sender, null); //clientSays[4] //Parsea clienteSays4 al evento con ese id con una busqueda hql
            } else if (clientSays[1].equalsIgnoreCase("Comment")){
                u = new Comment(sender, null, clientSays[4]);
            } else if (clientSays[1].equalsIgnoreCase("Opinion")){
                u = new Opinion(sender, null, clientSays[4], Integer.parseInt(clientSays[5]));
            }
            session.persist(u);
        } else if (clientSays[0].equalsIgnoreCase("Load")) {
            List<Object> list = null;
            EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
            if (clientSays[1].equalsIgnoreCase("Post")){
                list = entityManager.createQuery("from User").getResultList();
            } else if (clientSays[1].equalsIgnoreCase("Event")) {
                list = entityManager.createQuery("from Event").getResultList();
            } else if (clientSays[1].equalsIgnoreCase("Article")){
                list = entityManager.createQuery("from Article").getResultList();
            }
            return list;
        }


        session.close();
        return null;
    }
}


//Server commands ["Command", "What applies to", {Data in order}]
//Ex.: ["Add", "User", "Name1", "Password", "mail", "pfp", "banner", ""]
//                     "Not actual password"      "Images, figure out"