package org.spring.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.spring.todolist.dto.BoardDTO;
import org.spring.todolist.dto.CommentDTO;
import org.spring.todolist.dto.PageDTO;
import org.spring.todolist.service.BoardService;
import org.spring.todolist.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO dto){
        int saveResult = boardService.save(dto);
        if(saveResult>0){
            return "redirect:/board/";
        }else{
            return "save";
        }
    }

    @GetMapping("/")
    public String findAll(Model model){
       List<BoardDTO> boardDTOList = boardService.findAll();
       model.addAttribute("boardList",boardDTOList);
       return "list";
    }

    @GetMapping
    public String findById(@RequestParam("id") Long id,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           Model model) {
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        model.addAttribute("page", page);
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList", commentDTOList);
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        boardService.delete(id);
        return "redirect:/board/";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO= boardService.findById(id);
        model.addAttribute("board",boardDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model){
        boardService.update(boardDTO);
        BoardDTO dto =  boardService.findById(boardDTO.getId());
        model.addAttribute("board",dto);
        return "detail";
    }

//    /board/paging?page=2
//    처음 페이지 요청은 1페이지를 보여줌
    @GetMapping("/paging")
    public String pagingList(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page){
        List<BoardDTO> pagingList = boardService.pagingList(page);
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
        return "paging";
    }



}
