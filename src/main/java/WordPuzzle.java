import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class WordPuzzle {
    //Create static Master variable
    static String userEntryMaster;

    public static void main(String[] args) {
      ProcessBuilder process = new ProcessBuilder();
      Integer port;
      if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
      } else {
         port = 4567;
      }
      setPort(port);
      
      String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/wordpuzzleform.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/guessword", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/wordpuzzleoutput.vtl");

        String userEntry = request.queryParams("userWord");
        //pass results of form entry to master variable
        userEntryMaster = formReturn(userEntry);

        String userOutput = encryptWord(userEntry);

        model.put("userEntry", userEntry);
        model.put("userOutput", userOutput);
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/answer", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/wordpuzzleanswer.vtl");

        //put results of form entry into hashmap
        model.put("userEntryMaster", userEntryMaster);

        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    }

    public static String encryptWord(String userWord){
      String userWordUpperCase = userWord.toUpperCase();
      char [] userWordArray = userWordUpperCase.toCharArray();

      for (Integer i = 0; i < userWord.length(); i++) {
        if (userWordArray[i] == 'A') {
          userWordArray[i] = '-';
        } else if (userWordArray[i] == 'E') {
          userWordArray[i] = '-';
        } else if (userWordArray[i] == 'I') {
          userWordArray[i] = '-';
        } else if (userWordArray[i] == 'O') {
          userWordArray[i] = '-';
        } else if (userWordArray[i] == 'U') {
          userWordArray[i] = '-';
        }
      }

      String output = new String(userWordArray);
      return output;

      //First attempt at logic : Functions fine, but wanted to use for loop
      // userWordUpperCase = userWordUpperCase.replace("A", "-");
      // userWordUpperCase = userWordUpperCase.replace("E", "-");
      // userWordUpperCase = userWordUpperCase.replace("I", "-");
      // userWordUpperCase = userWordUpperCase.replace("O", "-");
      // userWordUpperCase = userWordUpperCase.replace("U", "-");
      // return userWordUpperCase;
    }

    //pass user entry into method updating master variable to allow access in other pages
    public static String formReturn(String userEntry) {
      userEntryMaster = userEntry;
      return userEntryMaster;
    }
}
