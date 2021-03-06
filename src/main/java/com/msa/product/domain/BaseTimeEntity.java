package com.msa.product.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
@MappedSuperclass - JPA Entity가 상속받을 경우 이 클래스의 필드들도 Column으로 인식(공통 Column을 생성해 중복을 제거하기 위함)
@EntityListeners - DB에 적용하기 이전에 커스텀 콜백을 요청하는 어노테이션
AuditingEntityListener - 생성과 수정 발생 정보를 캡처하는 JPA Entity Listener
*/
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
