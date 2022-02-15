
package org.example.repository;



import org.example.*;
import org.example.service.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;
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
    public void sqladd(List<Card> cardList) {
        String card = "INSERT INTO \"allCard\".\"allCard\"(\n" +
                "    id, name, carttype, skill, geroes, frakt, cardpath)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        List<Object[]> listValuesArgs = new ArrayList<>();
        cardList.forEach(cardqwe ->
                listValuesArgs.add(new Object[]{cardqwe.getId(), cardqwe.getPoint(), cardqwe.getCarttype(),
                        cardqwe.getSkill(), cardqwe.isGeroes(), cardqwe.getFrakt(), cardqwe.getCardpath()}));

        jdbcTemplate.batchUpdate(card, listValuesArgs);

    }
public void playerAdd(Player player){
    String card = "INSERT INTO \"allCard\".\"players\"(\n" +
            "    id, name,  cards)\n" +
            "VALUES (?, ?, ?);";
    List<Player> playerList = new ArrayList<Player>();
playerList.add(player);
    List<Object[]> listValuesArgs = new ArrayList<>();
    playerList.forEach(cardqwe ->
            listValuesArgs.add(new Object[]{cardqwe.getId(), cardqwe.getName(),cardqwe.getCards()}));

    jdbcTemplate.batchUpdate(card, listValuesArgs);

}
    public void sqlPlayeradd(List<Player> cardList) {
        String card = "INSERT INTO \"allCard\".\"players\"(\n" +
                "    id, name,  cards)\n" +
                "VALUES (?, ?, ?);";

        List<Object[]> listValuesArgs = new ArrayList<>();
        cardList.forEach(cardqwe ->
                listValuesArgs.add(new Object[]{cardqwe.getId(), cardqwe.getName(),cardqwe.getCards()}));

        jdbcTemplate.batchUpdate(card, listValuesArgs);

    }

   public void sqlAdd(){
       String sqlcom = "create table \"allCard\".\"players\"\n" +
               "(\n" +
               "    id       integer,\n" +
               "    name    varchar(200),\n" +
               "    cards varchar(200)\n" +
               ");";
       jdbcTemplate.update(sqlcom);
   }
    public void sqlDel(){
        String sqlcom = "drop table \"allCard\".\"players\"";

        jdbcTemplate.update(sqlcom);
    }
   public List<Card> getCard(int i){
       String sqlget = "select * from \"allCard\".\"gwCard\"\n  "+
               "  where id=?";
       List<Card> cardList = new ArrayList<Card>();
cardList =jdbcTemplate.query(sqlget,new CardMapper(),i);
       return cardList;
   }

}

