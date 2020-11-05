import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static models.DB.sql2o;
import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[]args) {
        port(getHerokuAssignedPort());
        staticFileLocation( "/public");


        get("/", (request, response) -> {


            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Animal> allAnimals = (ArrayList<Animal>) Animal.all();
            ArrayList<Sighting> allSighting = (ArrayList<Sighting>) Sighting.all();

            model.put("allSighting", allSighting);
            model.put("allAnimals", allAnimals);


            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());




        post("/post_sighting", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String age = req.queryParams("age");
            String healthy = req.queryParams("healthy");
            String endangered = req.queryParams("endangered");
            String location = req.queryParams("location");
            String ranger = req.queryParams("ranger");

            Animal newAnimal = new Animal(name, age,endangered,healthy, sql2o);
            Sighting newSighting = new Sighting(location,ranger);
            newAnimal.save();
            newSighting.save();
//            System.out.println(newAnimal);
            return new ModelAndView(model, "postsuccessful.hbs");
        }, new HandlebarsTemplateEngine());
    }




}
