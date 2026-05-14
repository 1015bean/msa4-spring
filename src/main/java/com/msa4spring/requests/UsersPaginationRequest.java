package com.msa4spring.requests;

public record UsersPaginationRequest(
        // DTO클래스에서 파라미터 설정
            // 파라미터의 데이터 타입은 참조 타입(객체타입)으로 설정
            // : 파라미터의 디폴트값을 설정할 때 조건에 (파라미터 == null) 널값을 넣어서 편하게 설정하기 위함
        String page
        ,Integer limit
) {
    // 생성자 오버라이드: 파라미터 값을 유저가 안보냈을 경우, 디폴트로 적용할 값 설정
    public UsersPaginationRequest(String page, Integer limit) {
            // 삼항연산자: ()가 true면 왼쪽값, false면 오른쪽 값
        this.page = (page == null || page.isBlank()) ? "1" : page;
        this.limit = (limit == null) ? 10 : limit;
    }
}
