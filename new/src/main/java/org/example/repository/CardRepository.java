
package org.example.repository;



import org.example.component.Card;
import org.example.component.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardRepository  {
   JdbcTemplate jdbcTemplate;
   @Autowired
   public CardRepository(JdbcTemplate jdbcTemplate){
       this.jdbcTemplate = jdbcTemplate;


   }
    public void sqladdList(List<Card> cardList) {
        String card = "INSERT INTO \"allCard\".\"gwCard\"(\n" +
                "    id, point, carttype, skill, geroes, frakt, cardpath)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        List<Object[]> listValuesArgs = new ArrayList<>();
        cardList.forEach(cardqwe ->
                listValuesArgs.add(new Object[]{cardqwe.getId(), cardqwe.getPoint(), cardqwe.getCarttype(),
                        cardqwe.getSkill(), cardqwe.isGeroes(), cardqwe.getFrakt(), cardqwe.getCardpath()}));

        jdbcTemplate.batchUpdate(card, listValuesArgs);

    }
    public void sqlUpdateListCard(List<Card> cardList) {
        String card = "INSERT INTO \"allCard\".\"gwCard\"(\n" +
                "    id, point, carttype, skill, geroes, frakt, cardpath)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
String del ="DELETE FROM \"allCard\".\"gwCard\"\n";

jdbcTemplate.update(del);
        List<Object[]> listValuesArgs = new ArrayList<>();
        cardList.forEach(cardqwe ->
                listValuesArgs.add(new Object[]{cardqwe.getId(), cardqwe.getPoint(), cardqwe.getCarttype(),
                        cardqwe.getSkill(), cardqwe.isGeroes(), cardqwe.getFrakt(), cardqwe.getCardpath()}));

        jdbcTemplate.batchUpdate(card, listValuesArgs);

    }
public void playerAdd(Player player){
    String card = "INSERT INTO \"allCard\".\"players\"(\n" +
            "    id, name, password,  cards)\n" +
            "VALUES (?, ?, ?, ?);";
    List<Player> playerList = new ArrayList<Player>();
playerList.add(player);
    List<Object[]> listValuesArgs = new ArrayList<>();
    playerList.forEach(cardqwe ->
            listValuesArgs.add(new Object[]{cardqwe.getId(), cardqwe.getName(),cardqwe.getPassword(),cardqwe.getCards()}));

    jdbcTemplate.batchUpdate(card, listValuesArgs);

}

   public void sqlcreateTab(){
       String sqlcom = "create table \"allCard\".\"players\"\n" +
               "(\n" +
               "    id       integer,\n" +
               "    name    varchar(200),\n" +
               "   password varchar(200),\n" +
               "    cards varchar(200)\n" +
               ");";
       jdbcTemplate.update(sqlcom);
   }
    public void sqlDel(){
        String sqlcom = "drop table \"allCard\".\"players\"";

        jdbcTemplate.update(sqlcom);
    }
   public List<Card> getCard(){
       String sqlget = "select * from \"allCard\".\"gwCard\"\n  ";
               //"  where id=?";
       List<Card> cardList = new ArrayList<Card>();
cardList =jdbcTemplate.query(sqlget,new CardMapper());

       return cardList;
   }
    public List<Player> getAllPlayer(){
        String sqlget = "select * from \"allCard\".\"players\"\n  ";
        //"  where id=?";
        List<Player> playerList = new ArrayList<Player>();
        playerList =jdbcTemplate.query(sqlget,new PlayMapper());

        return playerList;
    }
    public void sqlDelPlayer(){
        String sqlcom = "delete  from \"allCard\".\"players\"\n "+
                "WHERE id > 0";

        jdbcTemplate.update(sqlcom);
    }
}

