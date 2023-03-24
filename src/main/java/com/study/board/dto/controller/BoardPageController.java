package com.study.board.dto.controller;

//import com.study.security.UserDetailsImpl;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardPageController {

    //    게시글 리스트 페이지
    @GetMapping("/list")
    public String openBoardList(Model model) {
        model.addAttribute("username");
        return "board/list";
    }

    //    게시글 등록 페이지
    @GetMapping("/write")
    public String openBoardWrite(@RequestParam(required = false) final Long id, Model model) {
        model.addAttribute("id", id);
        return "board/write";
    }

    //    게시글 상세 페이지
    @GetMapping("/view/{id}")
    public String openBoardView(@PathVariable final Long id, Model model) {
        model.addAttribute("id", id);
        return "board/view";
    }
}
