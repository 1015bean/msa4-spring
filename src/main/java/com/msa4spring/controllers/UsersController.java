package com.msa4spring.controllers;

import com.msa4spring.requests.PostFilterRequest;
import com.msa4spring.requests.UsersPaginationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersController {

    @GetMapping("/users")
    public String index(
            @RequestParam(value = "pa", required = false, defaultValue = "1") String page
            , @RequestParam String limit
    ) {
        // 쿼리 파라미터(url의 파라미터 부분: ?page=n&limit=n)로 요청이 들어 왔을 때 획득 방법: @RequestParam 어노테이션을 통해 획득
            // @RequestParam 추가 설정
            // value: 유저가 보내온 키 명과 우리가 설정한 파라미터 값이 다를 경우, 유저가 보내는 키명 = value
            // required: = false로 설정시, 해당 파라미터는 선택사항(필수X)
            // defaultValue: 필수x인 파라미터 값을 유저가 안보냈을 경우, 디폴트로 적용할 값
        return "GET users: " + page + ", " + limit;
    }

    @GetMapping("/users/{id}")
    public String show(
            @PathVariable String id
    ) {
        // 세그먼트 파라미터(url의 패스 부분,에서 값을 받기로 정해준 /절/: /users/{id} 의 {여기})로 요청이 들어 왔을 때 획득 방법: @PathVariable 어노테이션을 통해 획득
        // * 여기서 id는 백그라운드에서 다루기 위한 변수. 유저로부터 받는 값에 key는 특별히x
        return "GET users show: " + id;
    }

    @PostMapping("/users")
    public String store() {
        return "Post users";
    }

    //----------------------------------------------------------------------------------------------
    // DTO를 활용하여 파라미터 획득(쿼리 파라미터로 요청)
        // record를 활용하여 DTO클래스 생성
        // DTO클래스에서 파라미터 설정
    @GetMapping("/users/dto-param")
        public String dtoParam(
            UsersPaginationRequest usersPaginationRequest
        ) {
            return String.format("GET dtoParam: %s, %d", usersPaginationRequest.page(), usersPaginationRequest.limit());
        }

    // 세그먼트 파라미터 & Form Data를 DTO로 획득
    @GetMapping("/posts/{id}/filter/{categoryId}")
    public String postFilter(
            @ModelAttribute PostFilterRequest postFilterRequest
            ) {
        // 세그먼트 파라미터&form데이터 형식으로 DTO 요청이 들어 왔을 때 획득 방법: @ModelAttribute 어노테이션을 통해 획득
        return String.format("postFilter: %d, %d", postFilterRequest.id(), postFilterRequest.categoryId());
    }

    // JSON 데이터를 DTO로 획득
    @GetMapping("/posts/json")
    public String postsJson(
            @RequestBody PostFilterRequest postFilterRequest
            ) {
        return String.format("postJson: %d, %d", postFilterRequest.id(), postFilterRequest.categoryId());
    }
}
