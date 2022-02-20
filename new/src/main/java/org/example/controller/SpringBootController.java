package org.example.controller;

import org.example.component.AllCardAllPlayers;
import org.example.repository.CardRepository;
import org.example.service.MapToPlayer;
import org.example.component.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class SpringBootController {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    MapToPlayer mapToPlayer;
    @Autowired
    AllCardAllPlayers allCardAllPlayers;

   // @Autowired
  //  CardToFile cardToFile;
    @GetMapping("/123")
    public String sayHello(/*@RequestParam(value = "name",required=false)  String name,
                           @RequestParam(value="frakt",required = false) String surname*/){

        System.out.println("hello   ");
        return "load";
    }
    @PostMapping("/load")
    public String loadPlayer(@RequestBody MultiValueMap<String, String> formData) {
        //System.out.println(formData.get("name"));
        try{
            String formname = String.valueOf(formData.get("name"));
       Player player = allCardAllPlayers.getPlayerMap().get(formname);
       int i = player.getId();
System.out.println(allCardAllPlayers.getPlayerMap().get(formname));
            String loadfile = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<form class=\"guruweba_example_form\" name=\"feedback\" method=\"POST\" action=\"/save\">\n" +
                    "\n" +
                    "    <div>"+formname+"</div>\n" +
                    "    <input type=\"text\" name=\"name\" required=\"required\">\n" +
                    "    <div>Карты</div>\n" +
                    "\n" +
                    "    <textarea name=\"message\">"+player.getCards() + "\n" +
                    "    </textarea>\n" +
                    "    <input type=\"submit\" name=\"submit_btn\" value=\"Создать\">\n" +
                    "</form>\n" +
                    "<div></div>\n" +
                    "<form class=\"guruweba_example_form\" name=\"feedback\" method=\"GET\" action=\"/save\">\n" +
                    "    <input type=\"submit\" name=\"submit_btn\" value=\"Загрузить\">\n" +
                    "</form>\n" +
                    "<div></div>\n" +
                    "<form class=\"guruweba_example_form\" name=\"feedback\" method=\"GET\" action=\"/sqlcom\">\n" +
                    "    <input type=\"submit\" name=\"submit_btn\" value=\"SQL\">\n" +
                    "</form>\n" +
                    "</body>\n" +
                    "</html>";
            String name = "D:\\INI\\New_Project2\\CardDeckGwint\\new\\src\\main\\resources\\templates\\load"+i+".html";
            String namefile ="load"+i;
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(name);
                out.write(loadfile.getBytes());
                out.close();
                System.out.println("fos");

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return namefile;}
        catch (Exception e) {
            e.printStackTrace();
       return "error"; }


    }
    @PostMapping("/save")
    public String save(@RequestBody MultiValueMap<String, String> formData){
        System.out.println("player save");
        System.out.println(formData);
        Player player = mapToPlayer.toPlayer(formData);
        int i = allCardAllPlayers.getPlayerList().size()-1;
        System.out.println(i);
player.setId(allCardAllPlayers.getPlayerList().get(i).getId()+1);
allCardAllPlayers.addToPlayerList(player);
allCardAllPlayers.addToMap(player);
System.out.println(player.getCards());
       cardRepository.playerAdd(player);

return "index";
    }
    @GetMapping("/sqlcom")
    public String sqlCom() throws IOException {
        //cardRepository.sqlDelPlayer();
       // System.out.println("SQL");

        return "index";
    }

/*   @PostMapping("/calc")
    public String getVaules(@G){
        String text = ("/calc.html");
        return text;
   }*/
}
