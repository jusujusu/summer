package com.exam.basic.Util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

//날짜 관련 클래스
//지정한 날짜와 현재 날짜를 비교해서 ~분전, ~시간전, ~일전, ~개월전, ~년전
@Component
public class DateUtil {

    //날짜(Date)형식(Format)수정(modify)하는 메소드
    //modDate 변환하고 싶은 날짜정보(수정일/등록일)
    public String formatModDate(LocalDateTime modDate) {
        LocalDateTime now = LocalDateTime.now(); //현재 시간정보 읽기

        //수정일과 now간의 분차를 구해서 minutes에 저장
        //60분까지, 65->1시간
        long minutes = ChronoUnit.MINUTES.between(modDate, now); //분 차이값
        long hours = ChronoUnit.HOURS.between(modDate, now);    //시간 차이값
        long days = ChronoUnit.DAYS.between(modDate, now);      //일 차이값
        long months = ChronoUnit.MONTHS.between(modDate, now);  //월 차이값
        long years = ChronoUnit.YEARS.between(modDate, now);    //년 차이값

        if (minutes < 60) { // 등록한 날짜가 1시간 전이면
            return minutes + "분전";
        } else if (hours < 24) { // 60분 이상, 24시간 전이면
            return hours + "시간전";
        } else if (days < 31) { // 24시간 이상, 31일 전이면
            return days + "일전";
        } else if (months < 12) { // 31일 이상, 12개월 전이면
            return months + "개월전";
        }else {
            return years + "년전";
        }
    }
}
