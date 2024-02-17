package org.spring.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.spring.todolist.dto.BoardDTO;
import org.spring.todolist.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

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

}
