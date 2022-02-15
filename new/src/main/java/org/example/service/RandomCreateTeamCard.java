
package org.example.service;

import org.example.service.CardToFile;
import org.example.repository.Card;
import org.example.repository.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class RandomCreateTeamCard {

    List<Card> allcard;
    List<Card> frakt = new ArrayList<Card>();

    List<Card> coloda;
    public RandomCreateTeamCard(){

    }
    public void createTeamCard(List<Card> allcard) {
        this.allcard = allcard;
        Set<Card> cardSet = new HashSet<Card>();
        LinkedList<Card> coloda = new LinkedList<Card>();

        for (int i = 0; i < allcard.size(); i++) {
            if (allcard.get(i).getFrakt() == 2) {
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
            //System.out.println(coloda);
        }
        coloda.addAll(cardSet);
        this.coloda = coloda;

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
