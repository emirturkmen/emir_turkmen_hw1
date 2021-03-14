/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package emir_turkmen_hw1;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        Logger logger = getLogger(App.class);

        int port = Integer.parseInt(System.getenv("PORT"));
        port(port);
        logger.error("Current port number:" + port);



        get("/", (req, res) -> "Bil 481 HW1");

        get("/compute",
            (rq, rs) -> {
              Map<String, String> map = new HashMap<String, String>();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());

            post("/compute", (req, res) -> {     
                String input1 = req.queryParams("input1");
                java.util.Scanner sc1 = new java.util.Scanner(input1);
                sc1.useDelimiter("[;\r\n]+");
                java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
                while (sc1.hasNext())
                {
                  int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                  inputList.add(value);
                }
                sc1.close();
                System.out.println(inputList);
      
      
                String input2 = req.queryParams("input2").replaceAll("\\s","");
                int input2AsInt = Integer.parseInt(input2);

                String input3 = req.queryParams("input3").replaceAll("\\s","");
                int input3AsInt = Integer.parseInt(input3);

                String input4 = req.queryParams("input4").replaceAll("\\s","");
                int input4AsInt = Integer.parseInt(input4);
      
                boolean result = App.searchNumberBetweenIndexesiandj(inputList, input2AsInt, input3AsInt, input4AsInt);
      
                Map<String, Boolean> map = new HashMap<String, Boolean>();
                map.put("result", result);
                return new ModelAndView(map, "compute.mustache");
              }, new MustacheTemplateEngine());
      
        


    }

    public static boolean searchNumberBetweenIndexesiandj(ArrayList<Integer> arr, Integer i, Integer j, Integer number){
        if(arr.size()==0 || i<0 || j>arr.size()-1 || i>j){
            return false;
        }
        for(int x = i; x<=j;x++)
            if(arr.get(x)== number)
                return true;
        return false;
    }
}