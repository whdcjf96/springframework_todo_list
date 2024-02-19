package org.spring.todolist.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.spring.todolist.dto.BoardDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void updateHits(Long id){
         sql.update("Board.updateHits",id);
    }

    public void delete(Long id){
        sql.delete("Board.delete",id);
    }

    public void update(BoardDTO boardDTO){
         sql.update("Board.update",boardDTO);
    }

    public List<BoardDTO> pagingList(Map<String,Integer> pagingParams){

        return sql.selectList("Board.pagingList",pagingParams);
    }

    public int boardCount(){
        return sql.selectOne("Board.boardCount");
    }
}
