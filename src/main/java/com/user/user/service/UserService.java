package com.user.user.service;

import com.user.user.domain.User;
import com.user.user.dto.request.updatePwRequest;
import com.user.user.dto.request.userCreateRequest;
import com.user.user.dto.response.findAllRequestDto;
import com.user.user.dto.response.findRequestDto;
import com.user.user.repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final userRepository userRepository;

    public void singUp(userCreateRequest userCreateRequest){
        userRepository.findByEmail(userCreateRequest.getEmail()).ifPresent(a->{throw new IllegalArgumentException("이미 존재하는 이메일 입니다.");});
        userRepository.save(userCreateRequest.createToEntity());
    }

    public List<findAllRequestDto> findAll(){
        return userRepository.findAll().stream().map(user-> findAllRequestDto.fromEntity(user)).collect(Collectors.toList());
    }

    public findRequestDto find(Long id) {
        User user = getOrElseThrow(id);

        return findRequestDto.fromEntity(user);
    }

    public String updatePw (updatePwRequest updatePwRequest){
        User user = userRepository.findByEmail(updatePwRequest.getEmail()).orElseThrow(()->{throw new NoSuchElementException("존재하지 않는 유저입니다.");});
        if(user.getPassword().equals(updatePwRequest.getPassword())){
        return "기존 비밀번호와 동일합니다.";
        }else{
        user.changePassword(updatePwRequest.getPassword());
        return "비밀번호 변경이 완료되었습니다.";
        }
    }
    public User getOrElseThrow(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("해당 유저가 존재하지 않습니다.");
        });
    }

    public String delete(Long id){
        User user = getOrElseThrow(id) ;

        if(user.isLeaveYn()){
            return "이미 탈퇴된 유저입니다.";
        }
        else{
       user.leave();
       return "회원 탈퇴가 완료되었습니다.";

        }
    }
}
