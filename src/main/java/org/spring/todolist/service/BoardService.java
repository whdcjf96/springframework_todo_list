package org.spring.todolist.service;

import lombok.RequiredArgsConstructor;
import org.spring.todolist.dto.BoardDTO;
import org.spring.todolist.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public int save(BoardDTO dto){
        return boardRepository.save(dto);
    }

    public List<BoardDTO> findAll(){
        return boardRepository.findAll();
    }

    public BoardDTO findById(Long id){
        return boardRepository.findById(id);
    }

    public void updateHits(Long id){
         boardRepository.updateHits(id);
    }

    public void delete(Long id){
        boardRepository.delete(id);
    }

    public void update(BoardDTO boardDTO){
        boardRepository.update(boardDTO);
    }
}
