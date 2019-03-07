package org.redcabbage.garden.org.redcabbage.garden.repos;

import org.redcabbage.garden.model.Bed;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.redcabbage.garden.model.Bed.GardenLocation.back;
import static org.redcabbage.garden.model.Bed.GardenLocation.front;

@Component("bedRepo")
public class JDBCBedRepo implements BedRepo {
    private final JdbcTemplate jdbcTemplate;

    public JDBCBedRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Bed> getAllBeds() {
        return null;
    }

    @Override
    public List<Bed> findByName(String name) {
        return null;
    }

    @Override
    public Bed getBed(int id) {
        final List vals = new ArrayList(3);
        String name;
        Bed.GardenLocation frontOrBack;

        jdbcTemplate.query("select id, name, frontorback from bed", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                vals.add(rs.getInt(1));
                vals.add(rs.getString(2));
                switch (rs.getInt(3)) {
                    case 0: vals.add(front); break;
                    case 1: vals.add(back); break;
                    default: assert false;
                }
            }
        });

        return new Bed((Integer)(vals.get(0)),
                vals.get(1).toString(),
                (Bed.GardenLocation)(vals.get(2)));
    }

    @Override
    public int addBed(Bed bed) {
        return -1;
    }

    @Override
    public void updateBed(Bed bed) {

    }
}
