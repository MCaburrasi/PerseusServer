import classes.Comment;
import classes.Event;
import classes.Opinion;
import classes.Post;
import classes.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Protocol {
    private Session session;

    public Protocol(Session session){
        this.session = session;
    }

    public String processIn(String[] clientSaysSmall, User sender){

        Object u = null;
        String[] clientSays = Arrays.copyOf(clientSaysSmall, 10);
        if (clientSays[0].equalsIgnoreCase("Add")){
            Transaction transaction = session.beginTransaction();
            if (clientSays[1].equalsIgnoreCase("User")) {
                u = new User(clientSays[2], clientSays[3], clientSays[4]);
            } else if (clientSays[1].equalsIgnoreCase("Event")) {
                LocalDateTime startDate = LocalDateTime.parse(clientSays[4]);
                LocalDateTime endDate = LocalDateTime.parse(clientSays[5]);

                u = new Event(clientSays[2], clientSays[3], startDate, endDate, clientSays[6], clientSays[7], sender);
            } else if (clientSays[1].equalsIgnoreCase("Post")){
                u = new Post(clientSays[2], clientSays[3], sender, null); //clientSays[4] //Parsea clienteSays4 al evento con ese id usando una busqueda hql
            } else if (clientSays[1].equalsIgnoreCase("Comment")){
                u = new Comment(sender, null, clientSays[4]);
            } else if (clientSays[1].equalsIgnoreCase("Opinion")){
                u = new Opinion(sender, null, clientSays[4], Integer.parseInt(clientSays[5]));
            }
            session.persist(u);
            transaction.commit();

        } else if (clientSays[0].equalsIgnoreCase("Load")) {
            List list = null;
            EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
            if (clientSays[1].equalsIgnoreCase("Post")){
                list = entityManager.createQuery("from Post").getResultList();
            } else if (clientSays[1].equalsIgnoreCase("Event")) {
                list = entityManager.createQuery("from Event").getResultList();
            } else if (clientSays[1].equalsIgnoreCase("Article")){
                list = entityManager.createQuery("from Article").getResultList();
            }
            assert list != null;
            return list.toString();
        }

        return null;
    }
}


//Server commands ["Command", "What applies to", {Data in order}]
//Ex.: ["Add", "User", "Name1", "Password", "mail", "pfp", "banner", ""]
//                     "Not actual password"      "Images, figure out"