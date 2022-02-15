package org.example.repository;

import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CardMapper implements RowMapper {
    @Override
    public Card mapRow(ResultSet  resultSet, int rowNum) throws SQLException {
        return new Card(resultSet.getInt("id"),
                resultSet.getInt("point"),
                resultSet.getInt("carttype"),
                resultSet.getInt("skill"),
                resultSet.getBoolean("geroes"),
                resultSet.getInt("frakt"),
                resultSet.getString("cardpath")
        );
    }
}
