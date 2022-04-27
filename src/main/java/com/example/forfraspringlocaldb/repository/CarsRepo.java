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
    public void addCar(Cars car){
        String sql = "INSERT INTO person (id, first_name, last_name) VALUES(?, ?, ?)";
        template.update(sql, Cars.getCarId(), Cars.getCarModel(), Cars.getCarBrand());
    }
    public Cars findCarByCarId(int id){
        String sql = "SELECT * FROM person WHERE id = ?";
        RowMapper<Cars> rowMapper = new BeanPropertyRowMapper<>(Cars.class);
        Cars car = template.queryForObject(sql, rowMapper, id);
        return car;
    }
}
