import classes.User;
import nasaapi.NasaWebConfig;
import java.util.Arrays;
import java.util.Locale;

public class Protocol {
    private DatabaseManager dm;
    private NasaWebConfig nwc;

    public Protocol(DatabaseManager dm, NasaWebConfig nwc){
        this.dm = dm;
        this.nwc = nwc;
    }

    public String processIn(String[] clientSaysSmall, User sender, ManejadorCliente m){
        String[] clientSays = Arrays.copyOf(clientSaysSmall, 10);
        switch (clientSays[0].toLowerCase()){
            case "add" -> dm.add(clientSays, sender);
            case "load" -> { return dm.load(clientSays, sender); }
            case "nwc" -> {return nwc.getArticleOTD();}
            case "login" -> m.setUser(dm.loadFullUser(clientSays[1]));
            //case "del" -> dm.remove(clientSays, sender);
            case "edit" -> {return dm.edit(clientSays, sender);}
        }

        return null;
    }
}


//Server commands ["Command", "What applies to", {Data in order}]
//Ex.: ["Add", "User", "Name1", "Password", "mail", "pfp", "banner", ""]
//                     "Not actual password"      "Images, figure out"