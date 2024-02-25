package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;

import javax.persistence.*;

@Entity
public class UserLoanHistory {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=null;

@ManyToOne //(N:1 관계) 내가 N임! User가 1이고!
private User user;

private String bookName;

private boolean isReturn;  //boolean으로 처리하면, tinynt에 잘 매핑된다!

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    protected UserLoanHistory(){}

    public void doReturn(){
        this.isReturn=true;
    }

    public String getBookName(){
        return this.bookName;
    }
}
//연관관계의 주인: Table을 보았을 때 누가 관계의 주도권을 가지고 있는가!!
//연관관계의 주인의 값이 설정되어야만 진정한 데이터가 저장된다.
//연관관계의 주인이 아닌 쪽에 mappedby를 해야한다!!
//연관관계의 주인의 setter가 사용되어야만 테이블 연결