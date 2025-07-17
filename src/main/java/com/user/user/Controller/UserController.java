package com.user.user.Controller;

import com.user.user.domain.User;
import com.user.user.dto.request.updatePwRequest;
import com.user.user.dto.request.userCreateRequest;
import com.user.user.dto.response.findAllRequestDto;
import com.user.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<String> singUp(@RequestBody userCreateRequest userCreateRequest){
       this.userService.singUp(userCreateRequest);
       return new ResponseEntity<>("회원가입 완료", HttpStatus.CREATED);
    }
    //회원 목록 조회

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable(value = "id")Long id){
       return new ResponseEntity<>(userService.find(id),HttpStatus.ACCEPTED);
    }

    //회원 전체 목록조회
    @GetMapping("/findAll")
    public List<findAllRequestDto> findAll(){
        return this.userService.findAll();
    }

    @PatchMapping("/updatePw")
    public ResponseEntity<String> updatePw(@RequestBody updatePwRequest updatePwRequest){

        return new ResponseEntity<>(userService.updatePw(updatePwRequest), HttpStatus.ACCEPTED);
    }

    //회원 탈퇴
    @PatchMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id")Long id){

        return new ResponseEntity<>(userService.delete(id), HttpStatus.ACCEPTED);
    }

}
