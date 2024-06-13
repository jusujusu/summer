package com.exam.basic.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//환경설정을 위한 클래스
@Configuration
public class AppConfig {

    //변수 및 메소드를 환경설정에 등록
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    // 기존의 경우
    //ModelMapper modelMapper = new ModelMapper();
    //환경 설정시 => 미리 등록해 놓고 필요할 때만 사용
    //ModelMapper modelMapper;

}
