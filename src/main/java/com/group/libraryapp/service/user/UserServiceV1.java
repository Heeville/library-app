package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//유저 서비스의 역할은 현재 유저가 있는 지, 없는 지 등을 확인하고 예외 처리를 해준다.
@Service
public class UserServiceV1 {
    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(UserCreateRequest userCreateRequest){
        userJdbcRepository.CreateUser(userCreateRequest.getName(),userCreateRequest.getAge());
    }

    public List<UserResponse> getUser(){

        return userJdbcRepository.getUser();
    }
    public void updateUser( UserUpdateRequest request){

    boolean isUserNotExist = userJdbcRepository.isUserNotExist(request.getId());
    if(isUserNotExist){
        throw new IllegalArgumentException();
    }

    userJdbcRepository.updateUser(request.getName(), request.getId());

}
    public void deleteUser(String name){

    if(userJdbcRepository.isUserNotExist(name)){
        throw new IllegalArgumentException();
    }

    userJdbcRepository.deleteUser(name);
}
}
