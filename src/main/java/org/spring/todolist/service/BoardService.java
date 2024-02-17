package org.spring.todolist.service;

import lombok.RequiredArgsConstructor;
import org.spring.todolist.dto.BoardDTO;
import org.spring.todolist.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public int save(BoardDTO dto){
        return boardRepository.save(dto);
    }
}
