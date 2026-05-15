package com.msa4spring.requests;

import jakarta.validation.constraints.NotNull;

public record EmployeesStoreRequest(
        @NotNull(message = "이름 필수")
        String name,

        @NotNull(message = "생일 필수")
        String birth,

        @NotNull(message = "성별 필수")
        String gender
) {
}
