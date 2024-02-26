package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.homework.FruitInformation;
import com.group.libraryapp.dto.homework.FruitResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FruitSqlRepository implements FruitRepository{

    private final JdbcTemplate jdbcTemplate;

    public FruitSqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public FruitInformation save(FruitInformation information) {
        String sql="insert into fruits(name,warehousingDate,price,sales) values(?,?,?,?)";
        jdbcTemplate.update(sql,information.getName(),information.getWarehousingDate(),information.getPrice(),information.getSales());
        return information;
    }

    @Override
    public void fruitId(Long id) {
        String sql="select * from fruits where id =? ";
        boolean empty = jdbcTemplate.query(sql, ((rs, rowNum) -> 0), id).isEmpty();
        if (empty){
            throw new IllegalArgumentException();
        }

    }

    @Override
    public FruitResponse salesPrice(String name) {
        String readsql="select * from fruits where name = ? ";
        boolean empty = jdbcTemplate.query(readsql, ((rs, rowNum) -> 0), name).isEmpty();
        if (empty){
            throw new IllegalArgumentException();
        }
        String notSales="select coalesce(sum(price),0) from fruits where name = ? and sales = 0";
        String Sales="select coalesce(sum(price),0) from fruits where name = ? and sales = 1";

        return new FruitResponse(jdbcTemplate.queryForObject(Sales, Long.class,name),jdbcTemplate.queryForObject(notSales, Long.class,name));
    }
}
