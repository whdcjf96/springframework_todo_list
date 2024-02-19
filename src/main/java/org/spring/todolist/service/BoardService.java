package org.spring.todolist.service;

import lombok.RequiredArgsConstructor;
import org.spring.todolist.dto.BoardDTO;
import org.spring.todolist.dto.PageDTO;
import org.spring.todolist.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    int pagingLimit = 5; // 한 페이지당 보여줄 글 갯수
    int blockLimit=5; // 하단에 보여줄 페이지 번호 갯수

    public List<BoardDTO> pagingList(int page){
        int pagingStart = (page-1)*pagingLimit;
        Map<String, Integer> pagingParams = new HashMap<>();
        pagingParams.put("start",pagingStart);
        pagingParams.put("limit",pagingLimit);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
        return pagingList;
    }

    public PageDTO pagingParam(int page) {
        // 전체 글 갯수 조회
        int boardCount = boardRepository.boardCount();
        // 전체 페이지 갯수 계산(10/3=3.33333 => 4)
        int maxPage = (int) (Math.ceil((double) boardCount / pagingLimit));
        // 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)
        int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
        // 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)
        int endPage = startPage + blockLimit - 1;
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartPage(startPage);
        pageDTO.setEndPage(endPage);
        return pageDTO;
    }
}
