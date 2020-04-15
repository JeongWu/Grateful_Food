package com.example.demo.web.Response;

import com.example.demo.domain.Comments;
import lombok.Builder;
import lombok.Getter;


//작성정보를 보여줌
@Getter
public class CommentResponseDto {
    private Long id;
    private String User_comment;
    private String Guest_comment;

    @Builder
    public CommentResponseDto(Comments entity) {
        this.id = entity.getId();
        this.Guest_comment = entity.getGuest_comment();
        this.User_comment = entity.getUser_comment();
    }


}
