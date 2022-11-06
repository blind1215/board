package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply(){
        IntStream.rangeClosed(1,300).forEach(i->{
            long bno = (long)(Math.random()*100)+1;

            Board board = Board.builder().bno(bno).build();

            Reply reply = Reply.builder()
                    .text("Reply......"+i)
                    .board(board)
                    .replyer("guest")
                    .build();

            replyRepository.save(reply);
        });
    }

    @Test
    public void readReply(){
        Optional<Reply> result = replyRepository.findById(1L);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());
    }


}
