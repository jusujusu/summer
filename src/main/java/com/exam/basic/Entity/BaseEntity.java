package com.exam.basic.Entity;

//공통적으로 사용할 필드를 작성
//다른 Entity에 추가를 위한 Entity

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
//이벤트 발생시 처리(날짜, 시간)
@EntityListeners(AuditingEntityListener.class)
//룸복을 이용해서 변수를 외부에서 사용가능하게 자동 생성
//get변수명 메소드를 자동생성
@Getter
@Setter

public abstract class BaseEntity {
//abstract 직접적으로 사용불가능 , extends를 이용해서 사용이 가능

    //자동으로 등록처리시 날짜 처리 메소드를 생성해서 결과값을 주입
    @CreatedDate
    private LocalDateTime regDate; //생성시 등록할 날짜/시간

    //수정시 날짜처리
    @LastModifiedDate
    private LocalDateTime modDate; //수정시 등록할 날짜/시간

    //생성자
    //클래스내의 변수는 클래스내에서만 사용 (private)
    //클래스내의 변수를 외부에서 사용하기 위해서 메소드 이용
    //외부 -> 변수에 값을 넣을 때는 set변수명()
    //변수 -> 외부로 보낼 때는 get변수명()
    //만들 때마나 getter, setter 만들어야 함
    //  -> 편하게 하려고 lombock 사용
}
