package com.msa4spring.requests;

import jakarta.validation.constraints.*;

public record ValidationRequest(
        @NotBlank(message = "이메일 필수")
        String email,

        @NotBlank(message = "비밀번호 필수")
        @Size(min = 5, max = 20, message = "비밀번호 5~20글자 허용")
        String password,

        // @NotBlank: 값이 NULL인지, 공백인지 확인. Integer는 공백 못 넣으므로 사용불가
        @NotNull(message = "나이 필수")
        @Min(0)
        @Max(200)
        Integer age,

        @NotBlank(message = "이름은 필수입니다")
        @Pattern(regexp = "^[가-힣]{2,50}$", message = "한글이름만 가능")
        String name
) {

}
