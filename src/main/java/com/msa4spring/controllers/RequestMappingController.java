package com.msa4spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController: REST API 방식을 사용하는 "컨트롤러 역할을 할거예요"
    //컨트롤러: 브라우저 요청을 받는 역할(메소드 받은 요청처리) REST API: 데이터를 JSON 형태로 주고받는 방식.
// @RequestMapping: 클래스 레벨의 맵핑(클래스 레벨로 받을 파라미터를 묶음)
    // mapping: 특정한 URL로 요청이 들어왔을 때(request) 어떤 메소드를 실행할지 연결(mapping)하는 것. vue 라우터의 기능과 유사
@RestController
@RequestMapping("/api")
public class RequestMappingController {

    // @ ~ Mapping("이 내용이 링크에 포함돼있으면"): ~ 요청이 들어왔을 때 {} 처리할 것
        // /api/test/로 GET요청 시
    @GetMapping("/test")
    public String test() {
        return "GET 테스트";
    }

        // /api/test/로 POST요청 시
    @PostMapping("/test")
    public String testPost() {
        return "Post 테스트";
    }
}
