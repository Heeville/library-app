package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository의 역할은 SQL을 사용해 실제 DB와의 통신을 담당한다.
//SQL을 직접 작성하면 SQL구문 오류가 컴파일 시점에 발견되지 않고, 런타임 시점에 발견된다
@Repository
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id){
    String readSql="select * from user where id = ? ";
    return  jdbcTemplate.query(readSql,(rs,rowNum) -> 0, id).isEmpty();

}

public void updateUser(String name,long id){
    String sql="update user set name = ? where id = ?";
    jdbcTemplate.update(sql,name,id);
}

public boolean isUserNotExist(String name){
    String readSql="select * from user where name = ? ";
    return jdbcTemplate.query(readSql,(rs,rowNum) -> 0, name).isEmpty();
}

public void deleteUser(String name){
    String sql="delete from user where name = ? ";
    jdbcTemplate.update(sql,name);
}
public void CreateUser(String name, Integer age){
    String sql="INSERT INTO user(name,age) VALUES(?,?)";
    jdbcTemplate.update(sql,name,age);
}
public List<UserResponse> getUser(){
    String sql="select * from user";

    return jdbcTemplate.query(sql, (rs, rowNum) -> {
        long id=rs.getLong("id");
        String name=rs.getString("name");
        int age=rs.getInt("age");

        return new UserResponse(id,name,age);
    });
}

}
