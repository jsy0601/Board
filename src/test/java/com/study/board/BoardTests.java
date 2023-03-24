package com.study.board;

import com.study.board.entity.Board;
import com.study.board.entity.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {
        //1.게시글 파라미터 생성
        Board params = Board.builder()
                .title("제목")
                .content("내용")
                .writer("서연")
                .hits(3)
                .deleteYn('Y')
                .build();

        //2. 게시글 저장
        boardRepository.save(params);

        //3. 1번 게시글 정보 조회
        Board entity = boardRepository.findById((long) 2).get();
        assertThat(entity.getTitle()).isEqualTo("제목");
        assertThat(entity.getContent()).isEqualTo("내용");
        assertThat(entity.getWriter()).isEqualTo("서연");
    }

    @Test
    void findAll() {
        //1.전체 게시글 수 조회
        long boardsCount = boardRepository.count();

        //2.전체 게시글 리스트 조회
        List<Board> boards = boardRepository.findAll();
    }

    @Test
    void delete() {
        //1.게시글 조회
        Board entity = boardRepository.findById((long) 1).get();

        //2.게시글 삭제
        boardRepository.delete(entity);
    }
}
