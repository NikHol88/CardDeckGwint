
package org.example.service;

import org.example.component.AllCardAllPlayers;
import org.example.repository.CardRepository;
import org.example.component.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RandomCreateTeamCard {



    @Autowired
    AllCardAllPlayers allCard;
    public RandomCreateTeamCard(){

    }
    public List<Card> createTeamCard(String namefrakt) {
List<Card> allcard=allCard.getAllcard();
        List<Card> frakt = new ArrayList<Card>();
        Set<Card> cardSet = new HashSet<Card>();
        LinkedList<Card> coloda = new LinkedList<Card>();
        int f=0;
switch (namefrakt){
    case ("Королевства севера"):f=0;break;
    case ("Скоятели"):f=3;break;
    case ("Нильфгаард"):f=1;break;
    case ("Чудовища"):f=2;break;

}
        for (int i = 0; i < allcard.size(); i++) {
            if (allcard.get(i).getFrakt() == f||allcard.get(i).getFrakt()==5) {
                frakt.add(allcard.get(i));

            }

        }
        int point = 0;
        int x = 0;
        while (point <= 100) {
            Random random = new Random();
            cardSet.add(frakt.get(random.nextInt(frakt.size())));
            //coloda.addFirst(frakt.get(random.nextInt(frakt.size())));
            point = point + cardSet.iterator().next().getPoint();
            //System.out.println(cardSet);
        }
        coloda.addAll(cardSet);
        return coloda;

    }
}

/*  public List<Card> creareColoda(){

        }

    }*//*

@Autowired
    public void setAllcard(CardToFile cardToFile) throws IOException {

    this.allcard = cardToFile.createlistCard();
    }

    public List<Card> getAllcard() {
        return allcard;
    }

    public List<Card> getFrakt() {
        return frakt;
    }

    public void setFrakt(List<Card> frakt) {
        this.frakt = frakt;
    }

    public List<Card> getColoda() {
        return coloda;
    }

    public void setColoda(List<Card> coloda) {
        this.coloda = coloda;
    }
}
*/
