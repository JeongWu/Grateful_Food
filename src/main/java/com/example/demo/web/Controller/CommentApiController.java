package com.example.demo.web.Controller;

import com.example.demo.domain.Comments;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.CommentService;
import com.example.demo.web.Request.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
    public class CommentApiController {

        private final CommentService commentService;;
            //아작스통신으로 값을 넘겨줘서 저장.
            @PostMapping("/api/guest/comment") //guest 댓글을 저장함
            public Long save(@RequestBody CommentSaveRequestDto requestDto){
                return commentService.save(requestDto);
            }

            @PostMapping("/api/chairman/comment") //사장 댓글을 저장함
            public Long saveChairman(@RequestBody CommentSaveRequestDto requestDto){
            return commentService.save(requestDto);
            }

    }
