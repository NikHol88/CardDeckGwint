package org.example.component;





public class Card {


    public int id;

    int  point;

    int carttype;

    int skill;

boolean geroes;

    int frakt;

String cardpath;

    public Card(int id, int point, int carttype,  int skill, boolean geroes,int frakt, String cardpath) {
        this.id = id;
        this.point = point;
        this.carttype = carttype;
        this.skill = skill;
        this.geroes = geroes;
        this.frakt = frakt;
        this.cardpath = cardpath;
    }

    public Card() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getCarttype() {
        return carttype;
    }

    public void setCarttype(int carttype) {
        this.carttype = carttype;
    }

    public int getFrakt() {
        return frakt;
    }

    public void setFrakt(int frakt) {
        this.frakt = frakt;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public boolean isGeroes() {
        return geroes;
    }

    public void setGeroes(boolean geroes) {
        this.geroes = geroes;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", point=" + point +
                ", carttype=" + carttype +
                ", frakt=" + frakt +
                ", skill=" + skill +
                ", geroes=" + geroes +
                '}';
    }

    public String getCardpath() {
        return cardpath;
    }

    public void setCardpath(String cardpath) {
        this.cardpath = cardpath;
    }
}
