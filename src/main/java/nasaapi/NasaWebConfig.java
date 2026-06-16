package nasaapi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NasaWebConfig {
    private Map<String, String> result;

    public NasaWebConfig() {
        result = null;
    }

    public String getArticleOTD(){
        StringBuilder informationstring = new StringBuilder();

        if (result == null){
            System.out.println("Connecting to Nasa API");
            try {
                URL url=new URL("https://api.nasa.gov/planetary/apod?api_key=Ga32pzrfVwmyTKi7tgqumuQt1YSKYaZsEuoecSw6");
                HttpURLConnection con=(HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                int responsecode=con.getResponseCode();

                if(responsecode!=200) {
                    informationstring.append("Error ").append(responsecode);
                } else{
                    Scanner sc=new Scanner(url.openStream());
                    while(sc.hasNext()){
                        informationstring.append(sc.nextLine());
                    }
                    sc.close();

                    result = new ObjectMapper().readValue(informationstring.toString(), HashMap.class);
                    System.out.println(result);
                    result.remove("media_type");
                    result.remove("url");
                    result.remove("date");
                    result.remove("service_version");
                    System.out.println(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        informationstring = new StringBuilder("title=" + result.get("title") + "|explanation=" + result.get("explanation") + "|hdurl=" + result.get("hdurl"));
        return informationstring.toString();
    }
}
