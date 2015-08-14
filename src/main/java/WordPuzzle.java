import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class WordPuzzle {
    public static void main(String[] args) {
      String layout = "templates/layout.vtl";
      //staticFileLocation("/public");

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/wordpuzzleform.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    }

    public static String encryptWord(String userWord){
      String uppercaseUserWord = userWord.toUpperCase();
      return "A";
    }


}
