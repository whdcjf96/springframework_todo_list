package org.spring.todolist.service;

import lombok.RequiredArgsConstructor;
import org.spring.todolist.dto.CommentDTO;
import org.spring.todolist.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(CommentDTO commentDTO){
        commentRepository.save(commentDTO);
    }

    public List<CommentDTO> findAll(Long boardId){
        return commentRepository.findAll(boardId);
    }
}
