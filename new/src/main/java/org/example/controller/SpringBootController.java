package org.example.controller;

import org.example.component.AllCardAllPlayers;
import org.example.repository.CardRepository;
import org.example.component.Player;
import org.example.service.CardToFile;
import org.example.service.ContrToRep;
import org.example.service.PlayerSerice;
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
    PlayerSerice playerSerice;
    @Autowired
    AllCardAllPlayers allCardAllPlayers;
@Autowired
    ContrToRep contrToRep;
    @Autowired
    CardToFile cardToFile;
    @GetMapping("/123")
    public String sayHello(/*@RequestParam(value = "name",required=false)  String name,
                           @RequestParam(value="frakt",required = false) String surname*/){

        System.out.println("hello   ");
        return "load";
    }
    @PostMapping ("/load")
    public String loadPlayer(@RequestBody MultiValueMap<String, String> formData) {
      String load =playerSerice.loadPlayer(formData);
      System.out.println(load);
      return load;
    }
    @PostMapping("/save")
    public String save(@RequestBody MultiValueMap<String, String> formData){
        System.out.println("player save");
        System.out.println(formData);
    playerSerice.savePlayer(formData);

return "index";
    }
    @GetMapping("/sqlcom")
    public String sqlCom() throws IOException {
        contrToRep.getCardRepository().sqlDelPlayer();
        contrToRep.getCardRepository().sqlUpdateListCard(cardToFile.createlistCard());
       // System.out.println("SQL");

        return "index";
    }

/*   @PostMapping("/calc")
    public String getVaules(@G){
        String text = ("/calc.html");
        return text;
   }*/
}
