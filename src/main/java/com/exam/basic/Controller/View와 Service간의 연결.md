Controller 검증
Form이 있는 페이지만 검증이 가능
1. 입력폼에 반드시 DTO를 전달
2. 입력처리에서 검증처리
3. 수정폼은 수정 할 DTO 전달(작성x)
4. 수정처리에서 검증처리

전달하는 값의 변수는 주고받는 변수명이 동일하게
public String text(BoardDTO boardDTO, Model model){
        model.addAttribute("boardDTO") (검증 O)
        model.addAttribute("data", ...) (검증 X)
}

기존 입력폼
@GetMapping("/board/insert")
public String text(Model model){
    return "board/insert"
}

검증 입력폼
@GetMapping("/board/insert")
public String text(Model model){
    model.addAttribute("boardDTO", new BoardDTO())
    return "board/insert"
}