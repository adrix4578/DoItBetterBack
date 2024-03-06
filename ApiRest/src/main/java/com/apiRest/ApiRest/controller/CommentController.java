package com.apiRest.ApiRest.controller;

import com.apiRest.ApiRest.CommentService;
import com.apiRest.ApiRest.RoutineService;
import com.apiRest.ApiRest.UserService;
import com.apiRest.ApiRest.model.Comment;
import com.apiRest.ApiRest.model.Routine;
import com.apiRest.ApiRest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/comments")
public class CommentController {
    @Autowired
    private RoutineService routineService;
    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment createComment(  @RequestBody Map<String,Object> body  ){
        Routine tempRoutine = routineService.getRoutineById(Long.parseLong(body.get("routine_Id").toString()) );
        Comment comment =  new Comment(tempRoutine,"");
        return commentService.createComment(comment);
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getComments();
    }

    @GetMapping("{id}")
    public Comment searchCommentByID(@PathVariable("id") Long id){
        return commentService.getCommentById(id);
    }

    @DeleteMapping("{id}")
    public void deleteCommentByID(@PathVariable("id") Long id){
        routineService.deleteRoutine(id);
    }

}
