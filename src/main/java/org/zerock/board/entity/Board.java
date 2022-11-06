package org.zerock.board.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer") // @ToString 은 항상 exclude
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;           //하나씩 늘려가는 시퀀스

    private String title;
    private String content;

    @ManyToOne (fetch = FetchType.LAZY) //명시적으로 Lazy 로딩 지정
    private Member writer; // 연관관계 지정 N:1 여기가 n 임 멤버테이블(1임)의 writer를 fk로 설정한것임

    //수정을 위한 메서드 추가
    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content){
        this.content = content;
    }
}
