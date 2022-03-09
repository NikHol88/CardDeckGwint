package org.example.service;

import org.example.component.AllCardAllPlayers;
import org.example.component.Player;
import org.example.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class PlayerSerice {
    @Autowired
    RandomCreateTeamCard randomCreateTeamCard;
    @Autowired
    AllCardAllPlayers allCardAllPlayers;
    @Autowired
    CardRepository cardRepository;
    private Player toPlayer(MultiValueMap<String, String> map){
        Player player = new Player();
        player.setName(String.valueOf(map.get("name").get(0)));
        player.setPassword(String.valueOf(map.get("password").get(0)));
player.setCards(randomCreateTeamCard.createTeamCard(String.valueOf(map.get("theme"))));
        return player;
    }
    public void savePlayer(MultiValueMap<String, String> formData){
        Player player = toPlayer(formData);
        int i = allCardAllPlayers.getPlayerList().size()-1;
        System.out.println(i);
        player.setId(allCardAllPlayers.getPlayerList().get(i).getId()+1);
        allCardAllPlayers.addToPlayerList(player);
        allCardAllPlayers.addToMap(player);
        System.out.println(player.getCards());
        cardRepository.playerAdd(player);
    }
    public String loadPlayer(MultiValueMap<String, String> formData){
        try{
            String formname = String.valueOf(formData.get("name").get(0));
            Player player = allCardAllPlayers.getPlayerMap().get(formname);

            int i = player.getId();
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
            System.out.println(namefile+"!!!");
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
            return "error1"; }


         }
}
