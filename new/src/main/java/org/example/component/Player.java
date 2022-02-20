
package org.example.component;


import java.util.List;

public class Player {
    int id;
    String name;
String password;
    String cards;

public Player(){}

    public Player(int id, String name, String password, String cards) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.cards = cards;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



   public void setCards(List<Card> cardList ) {

        String cards ="";
        for (int i = 0; i < cardList.size(); i++) {
            cards=cards+","+String.valueOf(cardList.get(i).getId());

        }

        String replace = cards.substring(1);

        this.cards = replace;
    }
}

