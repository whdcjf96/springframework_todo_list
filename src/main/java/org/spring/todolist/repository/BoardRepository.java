package org.spring.todolist.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.spring.todolist.dto.BoardDTO;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;
    public int save(BoardDTO dto){
        return sql.insert("Board.save",dto);
    }
}
