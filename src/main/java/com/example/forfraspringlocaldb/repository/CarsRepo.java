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

    public void addCar(Cars c) {
        String sql = "INSERT INTO cars (id, car_brand, car_model) VALUES (?,?,?)";
        template.update(sql, c.getCarId(), c.getCarBrand(), c.getCarModel());
    }

    public Cars findCarById(int id){
        String sql = "SELECT FROM cars WHERE id = ?";
        RowMapper<Cars> rowMapper = new BeanPropertyRowMapper<>(Cars.class);
        Cars c = template.queryForObject(sql, rowMapper, id);
        return c;
    }


    public Boolean deleteCar(int id) {
        String sql = "DELETE FROM cars WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public void updateCar(int id, Cars c) {
        String sql = "UPDATE car Set car_brand = ?, car_model = ? WHERE id = ?";
        template.update(sql, c.getCarBrand(), c.getCarModel(), c.getCarId());
    }
}




