package com.msa4spring.controllers;

import com.msa4spring.responses.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResponseEntityController {

    // res 메소드의 데이터타입: ResponseEntity<ResponseDTO<String>>
        // => .code("E99"), .msg("서버 에러 발생") 값을 담은 responseDTO 객체,를 body로 가지는 ResponseEntity를 반환한다
    @GetMapping("/res")
    public ResponseEntity<ResponseDTO<String>> res() {
        // *체이닝 메소드: 클래스.메소드 (메소드처리후 반환된 값).메소드 (메소드처리후 반환된 값).메소드 ,,,
            // DTO파일에 @Build 어노테이션: 생성자(역할을 하는 메소드) & 메소드(setter역할) 자동 생성
                // @Build가 만들어준 생성자(인스턴스를 하나 반환하는 메소드) "builder": ResponseDTO<String>타입 객체를 반환
        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder()
                // @Build가 만들어준 메소드(setter 역할): 위에서 반환된 객체의 code 필드에 "00" 값을 넣어줌
                .code("00")
                // @Build가 만들어준 메소드(setter 역할): 위에서 반환된 객체의 msg 필드에 "정상 처리" 값을 넣어줌
                .msg("정상 처리")
                // @Build가 만들어준 메소드(setter 역할): 위에서 반환된 객체의 data 필드에 "데이터 입니다" 값을 넣어줌
                .data("데이터 입니다")
                // @Build가 만들어준 메소드(): 위에서 값 3가지 넣어준 객체(responseDTO)를 반환
                .build();


        return ResponseEntity.status(300).body(responseDTO);
    }
}
