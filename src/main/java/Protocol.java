import classes.Comment;
import classes.Event;
import classes.Post;
import classes.User;

import java.time.LocalDateTime;

public class Protocol {
    public Protocol(){}

    public void processIn(String[] clientSays, User sender){
        if (clientSays[0].equalsIgnoreCase("Add")){
            if (clientSays[1].equalsIgnoreCase("User")) {
                User u = new User(clientSays[2], clientSays[3], clientSays[4]);
            } else if (clientSays[1].equalsIgnoreCase("Event")) {
                LocalDateTime startDate = LocalDateTime.parse(clientSays[4]);
                LocalDateTime endDate = LocalDateTime.parse(clientSays[4]);

                Event u = new Event(clientSays[2], clientSays[3], startDate, endDate, clientSays[6], clientSays[7], sender);
            } else if (clientSays[1].equalsIgnoreCase("Post")){
                Post u = new Post(clientSays[2], sender, null); //clientSays[4] //Parsea clienteSays4 al evento con ese id con una busqueda hql
            } else if (clientSays[1].equalsIgnoreCase("Comment")){
                Comment u = new Comment(sender, null, clientSays[3]);
            }
        }
    }
}


//Server commands ["Command", "What applies to", {Data in order}]
//Ex.: ["Add", "User", "Name1", "Password", "mail", "pfp", "banner", ""]
//                     "Not actual password"      "Images, figure out"