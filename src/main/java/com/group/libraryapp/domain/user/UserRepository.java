package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository를 상속받는 것 만으로도 스프링 빈으로 관리가 된다!
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name); //반환타입은 User이다. 유저가 없다면, null이 반환된다.
    //함수 이름만 작성하면,알아서 SQL이 조립된다!! 이때 함수이름이 매우매우중요!!! if find라고 작성되면, 1개의 데이터만 반환됨
    //By 뒤에 붙는 필드 이름으로 SELECT 쿼리의 WHERE 문이 작성된다.

    //boolean existByName(String name);

 //   long countByAge(Integer age); //해당 나이를 가진 유저의 수를 모두 세서 반환!
}
