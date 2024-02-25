package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //save 메소드에 객체를 넣어주면 INSERT SQL이 자동으로 날라간다!
    //svae 되고 난 후의 User는 id가 들어 있다!
    @Transactional
    public void saveUser(UserCreateRequest request){
        User u =userRepository.save(new User(request.getName(),request.getAge()));
    }
    //아래 있는 함수가 시작될 때 start transaction; 을 해준다(트랜젝션을 시작!)
    //함수가 예외 없이 잘 끝났다면 commit , 혹시라도 문제가 있으면 rollback -> 함수가 한몸!!
    //주의사항: 트랜젝션은 IOException과 같은 Checked Exception은 롤백이 일어나지 않는다.
    @Transactional(readOnly = true)
    public List<UserResponse> getUser(){
       List<User> users= userRepository.findAll(); //findAll을 사용하면 모든 데이터를 가져온다! -> select * from User
       return userRepository.findAll().stream()
               .map(user -> new UserResponse(user.getId(),user.getName(),user.getAge()))
               .collect(Collectors.toList());
       /*
       return userRepository.findAll().stream()
       .map(UserResponse::new)
       .collect(Collectors.toList());
       */
    }
    @Transactional
    public void updateUser(UserUpdateRequest request){
        //select * from user where id = ?;
        //Optional<User>
        //findById를 사용하면 id를 기준으로 1개의 데이터를 가져온다.
        //Optional의 orElseThrow를 사용해 User가 없다면 예외를 던진다.
        User user=userRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        //객체를 업데이트 해주고, save 메소드를 호출한다.
        //그러면 자동으로 UPDATE SQL이 날라가게 된다.
        user.updateName(request.getName());
        //userRepository.save(user); ->영속성 컨텍스트(변경을 자동 감지해서 자동저장)
    }
    @Transactional
    public void deleteUser(String name){
        //select * from user where name = ?;
        User user = userRepository.findByName(name)
                        .orElseThrow(IllegalArgumentException::new);

    userRepository.delete(user); //주어지는 데이터를 db에서 제거한다!
        /*
        if (!userRepository.existByName(name)){
            throw new IllegalArgumentException();
        }
        */
    }
}
//save: 주어지는 객체를 저장하거나 업데이트 시켜준다.
//findAll: 주어지는 객체가 매핑된 테이블의 모든 데이터를 가져온다.
//findById: id를 기준으로 특정한 1개의 데이터를 가져온다.

//Spring Date JPA는 복잡한 JPA코드를 스프링과 함께 쉽게 사용할 수 있도록 도와주는 라이브러리