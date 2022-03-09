
package org.example.service;

import org.example.component.Card;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = "singleton")
public class CardToFile {
    String name = "D:\\INI\\New_Project2\\CardDeckGwint\\new\\src\\main\\resources\\CardsAll.csv";

    public CardToFile() {

    }


   public List<Card> createlistCard()
            throws IOException {

        InputStream listValues = new FileInputStream(name);

        List<Card> records = new ArrayList<Card>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(listValues))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                Card card = new Card(
                        Integer.parseInt(values[0]),
                        Integer.parseInt(values[1]),
                        Integer.parseInt(values[2]),
                        Integer.parseInt(values[3]),
                        Boolean.parseBoolean(values[4]),
                        Integer.parseInt(values[5]),
                                               values[6]
                     //   values.length == 4 ? new BigInteger(values[3]) : null
                );

                records.add(card);
            }
listValues.close();
        } catch (Exception e) {
            System.out.println("Error while processing file - listValues.csv - " + e.getMessage());
        }
        return records;
    }
}
