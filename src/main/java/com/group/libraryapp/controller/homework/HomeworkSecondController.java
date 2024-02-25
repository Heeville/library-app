package com.group.libraryapp.controller.homework;

import com.group.libraryapp.dto.homework.FruitId;
import com.group.libraryapp.dto.homework.FruitInformation;
import com.group.libraryapp.dto.homework.FruitResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class HomeworkSecondController {

    private final JdbcTemplate jdbcTemplate;

    public HomeworkSecondController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //문제1
    @PostMapping("/api/v1/fruit")
    public FruitInformation fruitInformation(@RequestBody FruitInformation information){
        String sql="insert into fruits(name,warehousingDate,price,sales) values(?,?,?,?)";
        jdbcTemplate.update(sql,information.getName(),information.getWarehousingDate(),information.getPrice(),information.getSales());
        return information;
    }

    //문제2
    @PutMapping("/api/v1/fruit")
    public void fruitId(@RequestBody FruitId fruitId){
        String sql="select * from fruits where id =? ";
        boolean empty = jdbcTemplate.query(sql, ((rs, rowNum) -> 0), fruitId.getId()).isEmpty();
        if (empty){
            throw new IllegalArgumentException();
        }
    }

    //문제3
    @GetMapping("/api/v1/fruit/stat")
    public FruitResponse fruitResponse(@RequestParam String name){
        String readsql="select * from fruits where name = ? ";
        boolean empty = jdbcTemplate.query(readsql, ((rs, rowNum) -> 0), name).isEmpty();
        if (empty){
            throw new IllegalArgumentException();
        }
        String notSales="select coalesce(sum(price),0) from fruits where name = ? and sales = 0";
        String Sales="select coalesce(sum(price),0) from fruits where name = ? and sales = 1";

        //jdbcTemplate.queryForObject(notSales, Long.class);
        //jdbcTemplate.queryForObject(Sales, Long.class);

        return new FruitResponse(jdbcTemplate.queryForObject(Sales, Long.class,name),jdbcTemplate.queryForObject(notSales, Long.class,name));
    }



}
