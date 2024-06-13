package com.exam.basic.Util;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//View 하단에 페이지 버튼을 제어할 값들을 계산처리
// 변수는 값만 저장, 배열은 값들을 저장 => 변수명 1개
// Map은 키(변수명), 값을 저장 => 변수명 여러개, 값 여러개
@Component
public class PageUtil {

    // [<<][<][1][2][3][>][>>]
    // [<<] 첫 페이지, [>>] 마지막 페이지
    // [<] 현재 페이지(5)의 앞 페이지(4), [>] 현재 페이지(6)의 다음 페이지(6)
    // [1][2] 이동 가능한 페이지 번호, [3] 현재 페이지 선택 불가
    // 데이터베이스 0,1,2,3,4,5,6....
    // 화면페이지   1,2,3,4,5,6,7....
    public static Map<String, Integer> Pagination(Page<?> page) {
        int currentPage = page.getNumber()+1 ; //현재 페이지번호(데이터베이스 번호를 화면에 맞게)
        int totalPages = page.getTotalPages(); //전체 페이지 수
        int blockLimit = 10; // 사용자마음대로(화면에 출력할 페이지 번호 갯수)

        //화면에 출력할 페이지 정보를 작성(알고리즘)
        Map<String, Integer> pageinfo = new HashMap<>(); // <키의 데이터형, 값의 데이터형>
        // 첫페이지 [<<] 생략, 항상 1
        //시작 번호 [1]...
        int startPage = Math.max(1, currentPage - blockLimit / 2); // 1, 중간값 중에서 큰값을 선택해서 사용
        //끝 번호 ...[10]
        int endPage = Math.min(startPage + blockLimit - 1, totalPages);
        //현재 페이지의 앞 페이지 번호 [<]
        int prevPage = Math.max(1, currentPage - 1);
        //현재 페이지의 다음 페이지 번호 [>]
        int nextPage = Math.min(currentPage + 1, totalPages);
        //마지막 페이지 [>>]
        int lastPage = totalPages;

        //Controller에 값을 전달
        pageinfo.put("startPage", startPage);       //[1]...
        pageinfo.put("endPage", endPage);           //,,,[10]
        pageinfo.put("prevPage", prevPage);         //[<]
        pageinfo.put("currentPage", currentPage);
        pageinfo.put("nextPage", nextPage);         //[>]
        pageinfo.put("lastPage", lastPage);         //[>>]

        return pageinfo;

    }

}
//Application에 선언된 Bean(변수)을 읽을 때 인식이 안되는 문제
//Bean을 이용할 때는 Service에 작성해서 이용