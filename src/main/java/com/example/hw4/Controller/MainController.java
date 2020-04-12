package com.example.hw4.Controller;
import com.sun.deploy.net.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.UUID;
import com.example.hw4.Model.api;
import com.example.hw4.Model.apiRepo;
@Controller
public class MainController {
    @Autowired
    apiRepo ARepo;

    @RequestMapping("/")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("index");

        String RandoChuck = "";
        String RandomFact = "";

        String apikey = "0d948c34c1msh65eab55129aff93p166296jsne6342e1beef4";
        try
        {
            URL url = new URL("https://matchilling-chuck-norris-jokes-v1.p.rapidapi.com/jokes/random");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-rapidapi-host",   "matchilling-chuck-norris-jokes-v1.p.rapidapi.com");
            connection.setRequestProperty("x-rapidapi-key", apikey);
            connection.connect();
            BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                json.append(line);
            }


            JSONObject obj = new JSONObject(json.toString());

            RandoChuck = obj.getString("value");
            RandomFact =  RandoChuck;

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        mv.addObject("Apilist", ARepo.findAll());
        mv.addObject("rando", RandomFact);

        return mv;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save( @RequestParam("old") String old){
        ModelAndView mv = new ModelAndView("redirect:/");
        api Save=new api() ;
       Save.setOld(old);

        ARepo.save(Save);
        mv.addObject("Apilist", ARepo.findAll());
        return mv;
    }


    @RequestMapping( value = "/delete/{old}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("old") String old){
        ModelAndView mv = new ModelAndView("redirect:/");
        ARepo.deleteById(old);

        return mv;
        //final check
    }
}
