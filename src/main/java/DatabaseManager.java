import classes.Comment;
import classes.Event;
import classes.Eventattendee;
import classes.Like;
import classes.Post;
import classes.User;
import com.google.common.hash.Hashing;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

@Transactional
public class DatabaseManager {
    Session session;
    public DatabaseManager(Session session) {
        this.session = session;
    }

    public String addUser(String[] clientSays){
        String s = "";

        try{
            Transaction transaction = session.beginTransaction();

            Query q = session.createQuery("From User where name=:n");
            q.setParameter("n", clientSays[2]);
            if (!q.getResultList().isEmpty()){
                throw new RuntimeException();
            }

            String password = Hashing.sha256().hashString(clientSays[3], StandardCharsets.UTF_8).toString();
            User user = new User(clientSays[2], password);
            session.persist(user);
            transaction.commit();

            s = user.getName();
        } catch (RuntimeException e){
            s = "no";
        }

        return s;
    }

    public String addEvent(String[] clientSays, User sender){
        Transaction transaction = session.beginTransaction();

        LocalDateTime startDate = LocalDateTime.parse(clientSays[4]);
        LocalDateTime endDate = LocalDateTime.parse(clientSays[5]);

        Event event = new Event(clientSays[2], clientSays[3], startDate, endDate, clientSays[6], clientSays[7], sender);
        session.persist(event);
        transaction.commit();

        return event.getId().toString();
    }

    public String addPost(String[] clientSays, User sender){
        Transaction transaction = session.beginTransaction();
        Post post = new Post(clientSays[2], clientSays[3], sender);
        session.persist(post);
        transaction.commit();

        return post.getId().toString();
    }

    public String addLike(User u, String pId){
        Transaction transaction = session.beginTransaction();

        Post post;
        try(EntityManager entityManager = session.getEntityManagerFactory().createEntityManager()) {
            Query q = entityManager.createQuery("from Post where id=:p");
            q.setParameter("p", pId);
            post = (Post) q.getResultList().getFirst();

            Like l = new Like(post, u);
            session.persist(l);
            transaction.commit();

            return l.getId().toString();
        }
    }

    public String addEventAttendee(User u, String eId){
        Transaction transaction = session.beginTransaction();

        Event ev;
        try(EntityManager entityManager = session.getEntityManagerFactory().createEntityManager()) {
            Query q = entityManager.createQuery("from Event where id=:p");
            q.setParameter("p", eId);
            ev = (Event) q.getResultList().getFirst();

            Eventattendee ea = new Eventattendee(ev, u);
            session.persist(ea);
            transaction.commit();

            return ea.getId().toString();
        }
    }

    public String addComment(String[] clientSays, User sender){
        Transaction transaction = session.beginTransaction();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();

        Post p;
        Query q = entityManager.createQuery("from Post where id=:p");
        q.setParameter("p", clientSays[2]);
        p = (Post) q.getResultList().getFirst();

        Comment comment = new Comment(sender, p, clientSays[3]);

        session.persist(comment);
        transaction.commit();

        return comment.getId().toString();
    }

    public List<Post> getPosts(String[] clientSays){
        List<Post> send = null;
        try(EntityManager entityManager = session.getEntityManagerFactory().createEntityManager()) {
            Query q = entityManager.createQuery("from Post");
            send = q.getResultList();
        } catch (NullPointerException e) {
            System.out.println("Empty post list");
        }

        return send;
    }

    public List getEvents(String[] clientSays){
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        Query q = entityManager.createQuery("from Event where endTime>:n");
        q.setParameter("n", LocalDateTime.now());
        return q.getResultList();
    }

    public String getUser(String[] clientSays){
        String s = "";
        try(EntityManager entityManager = session.getEntityManagerFactory().createEntityManager()){
            String password = Hashing.sha256().hashString(clientSays[3], StandardCharsets.UTF_8).toString();

            Query q = entityManager.createQuery("from User where name=:n AND password=:p");
            q.setParameter("n", clientSays[2]);
            q.setParameter("p", password);

            User user = (User) q.getResultList().getFirst();
            System.out.println(user);
            s = user.toString();
        } catch (NoSuchElementException e){
            s = "no";
        }

        return s;
    }

    public String getLike(User sender){
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();

        Query q = entityManager.createQuery("select post from Like where user=:n");
        q.setParameter("n", sender);
        System.out.println(q.getResultList().toString());

        return q.getResultList().toString();
    }

    public String getEventAttendees(User sender){
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();

        Query q = entityManager.createQuery("select event from Eventattendee where user=:n");
        q.setParameter("n", sender);

        return q.getResultList().toString();
    }

    public void removeLike(String[] clientSays, User sender){
        Transaction transaction = session.beginTransaction();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();

        User u;
        Post p;

        Query q = entityManager.createQuery("from User where name=:u");
        q.setParameter("u", sender.getName());
        u = (User) q.getResultList().getFirst();

        q = entityManager.createQuery("from Post where id=:p");
        q.setParameter("p", clientSays[2]);
        p = (Post) q.getResultList().getFirst();

        q = entityManager.createQuery("from Like where user=:u and post=:p");
        q.setParameter("u", u);
        q.setParameter("p", p);

        System.out.println(q.getResultList().getFirst());
        Like l = (Like) q.getResultList().getFirst();
        session.remove(l);
        transaction.commit();
    }

    public String getComments(String[] clientSays){
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();

        Query q = entityManager.createQuery("from Comment where idPost.id=:n");
        q.setParameter("n", clientSays[2]);

        return q.getResultList().toString();
    }

    public String add(String[] clientSays, User sender){
        String s = "";
        switch (clientSays[1].toLowerCase()){
            case "user" -> s = addUser(clientSays);
            case "event" -> s = addEvent(clientSays, sender);
            case "post" -> s = addPost(clientSays, sender);
            case "comment" -> s = addComment(clientSays, sender);
            case "join" -> s = addEventAttendee(sender, clientSays[2]);
            case "like" -> s = addLike(sender, clientSays[2]);
        }

        return s;
    }

    public String load(String[] clientSays, User sender) {
        String s = "";
        switch (clientSays[1].toLowerCase()){
            case "post" -> s = getPosts(clientSays).toString();
            case "event" -> s = getEvents(clientSays).toString();
            case "user" -> s = getUser(clientSays);
            case "like" -> s = getLike(sender);
            case "evat" -> s = getEventAttendees(sender);
            case "comment" -> s = getComments(clientSays);
            case "bio" -> s = getBio(sender);
        }

        System.out.println(s);
        return s;
    }

    public String edit(String[] clientSays, User sender){
        String s = "";
        switch (clientSays[1].toLowerCase()){
            case "bio" -> s = editBio(clientSays, sender);
            case "postimg" -> s = editPostImg(clientSays);
        }

        return s;
    }

    public String editBio(String[] clientSays, User sender){
        Transaction transaction = session.beginTransaction();
        sender.setBio(clientSays[2]);
        transaction.commit();
        return clientSays[2];
    }

    public String editPostImg(String[] clientSays){
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();

        Query q = entityManager.createQuery("from Post where id=:n");
        q.setParameter("n", clientSays[2]);

        Post p = (Post) q.getResultList().getFirst();
        p.setImage(clientSays[3]);

        return clientSays[3];
    }

    public String getBio(User sender){
        return sender.getBio();
    }

    public void remove(String[] clientSays, User sender){
        switch (clientSays[1].toLowerCase()){
            case "like" -> removeLike(clientSays, sender);
        }
    }

    public User loadFullUser(String username){
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();

        Query q = entityManager.createQuery("from User where name=:n");
        q.setParameter("n", username);

        return (User) q.getResultList().getFirst();
    }
}
