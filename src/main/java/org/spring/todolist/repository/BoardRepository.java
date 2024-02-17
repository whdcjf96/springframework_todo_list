package org.spring.todolist.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.spring.todolist.dto.BoardDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;
    public int save(BoardDTO dto){
        return sql.insert("Board.save",dto);
    }

    public List<BoardDTO> findAll(){
        return sql.selectList("Board.findAll");
    }

    public BoardDTO findById(Long id){
        return sql.selectOne("Board.findById",id);
    }
}
