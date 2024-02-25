package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.Fruit;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller의 역할은 API의 진입 지점으로써 HTTP Body를 객체로 변환하고 있다.
//Controller에서 getter가 있는 객체를 반환하면 JSON이 된다!!!
@RestController
public class UserController {

    private final UserServiceV2 userService;


    @Autowired
    public UserController(UserServiceV2 userServiceV1){
        this.userService = userServiceV1;
    }
    //private final List<User> users=new ArrayList<>();

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
       // users.add(new User(request.getName(), request.getAge()));
        //String sql="INSERT INTO user(name,age) VALUES(?,?)";
        //jdbcTemplate.update(sql,request.getName(),request.getAge());
        userService.saveUser(request);
    }

    @GetMapping("/fruit")
    public Fruit fruit(){
        return new Fruit("바나나",2000);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        /*List<UserResponse> responses = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
        responses.add(new UserResponse(i+1,users.get(i)));
        }
        return responses;*/

        //String sql="select * from user";
       /*return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
            @Override  //유저 정보를 유저 response로 바꿔주는 함수
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id=rs.getLong("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");

                return new UserResponse(id,name,age);
            }
        });
        //유저 정보를 유저 response로 바꿔주는 함수
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id=rs.getLong("id");
            String name=rs.getString("name");
            int age=rs.getInt("age");

            return new UserResponse(id,name,age);
        });*/
        return userService.getUser();
    }
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
    userService.updateUser(request);

    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }


}
