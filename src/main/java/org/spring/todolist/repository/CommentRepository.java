package org.spring.todolist.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.spring.todolist.dto.CommentDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    private final SqlSessionTemplate sql;

    public void save(CommentDTO commentDTO){
        sql.insert("Comment.save",commentDTO);
    }

    public List<CommentDTO> findAll(Long boardId){
        return sql.selectList("Comment.findAll",boardId);
    }

}
