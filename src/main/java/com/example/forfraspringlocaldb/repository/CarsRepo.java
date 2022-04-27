package com.example.forfraspringlocaldb.repository;

import com.example.forfraspringlocaldb.model.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class CarsRepo {

    // todo hvordan ??

    @Autowired
    JdbcTemplate template;

    public List<Cars> fetchAll(){

        String sql = "SELECT * FROM kailua_car_rental.cars";
        RowMapper<Cars> rowMapper = new BeanPropertyRowMapper<>(Cars.class);
        return template.query(sql, rowMapper);

    }


}
