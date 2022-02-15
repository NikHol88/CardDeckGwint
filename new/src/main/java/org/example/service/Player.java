
package org.example.service;


import org.example.repository.Card;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//@Component
public class Player {
    int id;
    String name;

    String cards;

public Player(){}

    public Player(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCards() {
        return cards;
    }
//@Autowired
   /* public void setCards(RandomCreateTeamCard randomCreateTeamCard) {
    List<Card> cardList = randomCreateTeamCard.getColoda();
        String cards ="";
        for (int i = 0; i < cardList.size(); i++) {
            cards=cards+","+String.valueOf(cardList.get(i).getId());

        }

        String replace = cards.substring(1);

        this.cards = replace;
    }*/
}

