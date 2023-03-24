package com.study.board.entity;

import com.study.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String writer;

    private int hits;

    private char deleteYn;

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime modifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //연관관계 편의 메서드
    public void setUser(User user) {
        this.user = user;
        user.getBoards().add(this);
    }

    @Builder
    public Board(String title, String content, String writer, int hits, char deleteYn) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.deleteYn = deleteYn;
    }

    //    게시글 수정
    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.modifiedDate = LocalDateTime.now();
    }

    //    조회 수 증가
    public void increaseHits() {
        this.hits++;
    }

    //    게시글 삭제
    public void delete() {
        this.deleteYn = 'Y';
    }
}
