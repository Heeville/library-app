package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Entity: 스프링이 User 객체와 user 테이블을 같은 것으로 바라본다.
@Entity //저장되고, 관리되어야 하는 데이터
public class User {
    @Id //이 필드를 primary 키로 간주한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //primary key는 자동 생성되는 값이다.
    private Long id=null;

    @Column(nullable = false,length=20,name="name") //name varchar(20)
    private String name;
    //Column은 생략 할 수도 있다!!(완전히 동일하면 ㅋㅌ)
    private Integer age;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistoryList=new ArrayList<>();

    //JPA를 사용하기 위해서는 기본 생성자가 꼮 필요하다!!!
    protected User(){}
    //@Column은 객체의 필드와 테이블의 필드를 매핑한다!
    //null이 들어갈 수 있는지 여부, 길이 제한, DB에서의 column 이름 등등...

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public User(String name, Integer age) {
        if (name==null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.",name));
        }
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void updateName(String name) {
        this.name=name;
    }

    public void loanBook(String bookName){
        this.userLoanHistoryList.add(new UserLoanHistory(this,bookName));
    }

    public void returnBook(String bookName){
        UserLoanHistory targetHistory=this.userLoanHistoryList.stream()
                .filter(history->history.getBookName().equals(bookName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        targetHistory.doReturn();
    }
}
//영속성 컨텍스트란 테이블과 매핑된 Entity 객체를 관리/보관하는 역할
//스프링에서는 트랜잭션을 사용하면 영속성 컨텍스트가 생겨나고, 트랜잭션이 종료되면 영속성 컨텍스트가 종료된다.

//영속성 컨텍스트의 특수 능력 4가지
//1. 변경 감지: 영속성 컨텍스트 안에서 불러와진 Entity는 명시적으로 save하지 않더라도 변경을 감지해 자동으로 저장된다.
//2. 쓰기 지연: DB의 INSERT/UPDATE/DELETE SQL을 바로 날리는 것이 아니라, 트랜잭션이 commit될 때 모아서 한번만 날린다.
//3. 1차 캐싱: ID를 기준으로 Entity를 기억한다!
//3~ 이렇게 캐싱된 객체(영속성 컨텍스트가 잠깐 저장한 객체)는 완전히 동일하다!
//3~ (자바로 따지면 객체 인스턴스의 주소까지 동일하다는 의미)
//4. 지연 로딩: 꼭 필요한 순간에 데이터를 로딩한다!!