package org.example.service;

import org.example.component.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class MapToPlayer {
    @Autowired
    RandomCreateTeamCard randomCreateTeamCard;
    public Player toPlayer(MultiValueMap<String, String> map){
        Player player = new Player();
        player.setName(String.valueOf(map.get("name")));
        player.setPassword(String.valueOf(map.get("password")));
player.setCards(randomCreateTeamCard.createTeamCard(String.valueOf(map.get("theme"))));
        return player;
    }
}
