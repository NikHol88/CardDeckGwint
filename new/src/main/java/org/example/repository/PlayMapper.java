package org.example.repository;

import org.example.component.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayMapper implements RowMapper {
    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Player(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("cards"));
    }
}
