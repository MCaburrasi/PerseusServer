package nasaapi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NasaWebConfig {

    public NasaWebConfig() {

    }

    public String getArticleOTD(){
        StringBuilder informationstring = new StringBuilder();
        try {
            URL url=new URL("https://api.nasa.gov/planetary/apod?api_key=Ga32pzrfVwmyTKi7tgqumuQt1YSKYaZsEuoecSw6");
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responsecode=con.getResponseCode();
            if(responsecode!=200) {
                informationstring.append("Error ").append(responsecode);
            }
            else{
                Scanner sc=new Scanner(url.openStream());
                while(sc.hasNext()){
                    informationstring.append(sc.nextLine());
                }
                sc.close();
                Map<String,Object> result = new ObjectMapper().readValue(informationstring.toString(), HashMap.class);
                result.remove("media_type");
                result.remove("url");
                result.remove("date");
                result.remove("service_version");

                informationstring = new StringBuilder(result.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return informationstring.toString();
    }
}
