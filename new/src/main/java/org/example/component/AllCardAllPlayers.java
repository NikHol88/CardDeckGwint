package org.example.component;

import org.example.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AllCardAllPlayers {
    List<Card> allcard;
    List<Player> playerList;
    Map<String,Player> playerMap = new HashMap<String,Player>();
    @Autowired
CardRepository cardRepository;
    public AllCardAllPlayers(CardRepository cardRepository) {
        this.allcard = cardRepository.getCard();
        this.playerList=cardRepository.getAllPlayer();
        for (int i = 0; i <playerList.size() ; i++) {

        playerMap.put(playerList.get(i).getName(),playerList.get(i));
        }
       // System.out.println(allcard);
       // System.out.println(playerList);

        System.out.println(playerMap);
    }

    public List<Card> getAllcard() {
        return allcard;
    }

    public void setAllcard(List<Card> allcard) {
        this.allcard = allcard;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
     public void addToPlayerList(Player player){
        playerList.add(player);
}
    public Map<String, Player> getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Map<String, Player> playerMap) {
        this.playerMap = playerMap;
    }
    public void addToMap(Player player){
        playerMap.put(player.getName(),player);

    }
}
