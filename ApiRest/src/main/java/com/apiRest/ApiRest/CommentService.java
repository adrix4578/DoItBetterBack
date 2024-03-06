package com.apiRest.ApiRest;

import com.apiRest.ApiRest.model.Comment;
import com.apiRest.ApiRest.model.Routine;
import com.apiRest.ApiRest.repository.CommentRepository;
import com.apiRest.ApiRest.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;


    public Comment createComment(Comment comment){

        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id){
        Optional<Comment> optionalRoutine = commentRepository.findById(id);
        return  optionalRoutine.get();
    }

    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }


}
