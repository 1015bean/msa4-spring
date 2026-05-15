package com.msa4spring.errors;

import com.msa4spring.responses.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.List;

// Exception 클래스(전역의 예외처리를 담당(커스텀 가능)하는 클래스)) 생성
// 예외처리 시 로그 작성되도록: @Slf4j
// 레스트풀한 예외처리 담당 클래스: @RestControllerAdvice

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 예외처리를 실행할 메소드: @ExceptionHandler(처리대상이 되는 예외)
        // .class: 해당 클래스의 설계 정보(여기서는 객체 타입정보: Exception타입)

    // 1. 유효성 검사 예외 처리 (@Valid, @Validatied)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO<List<String>>> validationHandle(MethodArgumentNotValidException e) {

            // .getBindingResult(): 에러 검증 결과 반환
            // .getAllErrors(): BindingResult 안의 모든 에러 목록을 반환(List형식)
        List<String> errorMsglist = e.getBindingResult()
                .getAllErrors()
                    // 에러목록(List<ObjectError>)에서 에러메세지만 뽑아오기 위해, 스트림객체생성;.map활용;다시리스트타입으로돌림
                        // "::" 메소드 레퍼런스 특정 메소드를 대신 전달하는 문법, = error -> error.getDefaultMessage()
                .stream()
                .map(ObjectError::getDefaultMessage)
                //.collect(Collectors.joining(", ")); 스트링타입으로 출력하고 싶을 때
                .toList();

        ResponseDTO<List<String>> responseDTO = ResponseDTO.<List<String>>builder()
                .code("E01")
                .msg("유효성 검사 실패: ")
                .data(errorMsglist)
                .build();

        return  ResponseEntity.status(400).body(responseDTO);
    }

    // 2. DB 관련 예외 핸들러
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ResponseDTO<String>> sqlExceptionHandler(SQLException e) {
        log.error(e.getMessage());

        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder()
                .code("E99")
                .msg("서버 에러 발생")
                .data("현재 서비스 이용 불가합니다 \n 잠시후 다시 이용해 주십시오.")
                .build();

        return ResponseEntity.status(500).body(responseDTO);
    }

    // 3. 다른 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<String>> othersHandling(Exception e) {

        log.error(e.getMessage());

        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder()
                .code("E99")
                .msg("서버 에러 발생")
                .data("현재 서비스 이용 불가합니다 \n 잠시후 다시 이용해 주십시오.")
                .build();

        return ResponseEntity.status(500).body(responseDTO);
    }

}
