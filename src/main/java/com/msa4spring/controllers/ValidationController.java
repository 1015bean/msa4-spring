package com.msa4spring.controllers;

import com.msa4spring.requests.ValidationRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ValidationController {
    @PostMapping("/validation")
    public String validation(
            @Valid @ModelAttribute ValidationRequest validationRequest
    ) {
        // @Valid 발리대이션 처리할 때, 발리대이션 대상이 되는 파라미터 앞에 붙여주는 어노테이션
        return String.format(
                "Email: %S, pw: %s, age: %d, name: %s"
                , validationRequest.email()
                , validationRequest.password()
                , validationRequest.age()
                , validationRequest.name()
        );
    }
}
