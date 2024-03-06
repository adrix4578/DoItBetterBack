package com.apiRest.ApiRest.model;



import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "routine_id")
    private Routine ownerRoutine;
    private String content;

    public Comment(Routine ownerRoutine, String content) {
        this.ownerRoutine = ownerRoutine;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Routine getOwnerRoutine() {
        return ownerRoutine;
    }

    public void setOwnerRoutine(Routine ownerRoutine) {
        this.ownerRoutine = ownerRoutine;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
