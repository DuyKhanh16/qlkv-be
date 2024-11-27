package org.example.qlkv.controller;

import org.example.qlkv.DTO.*;
import org.example.qlkv.service.JwtService;
import org.example.qlkv.service.QLNDuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/auth/api/user")
public class UserControler {
    @Autowired
    private QLNDuserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public UserControler(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody CreateUserDTO newUser) {
        boolean result = userService.createNewUser(newUser);
        if (result) {
            return  new ResponseEntity<>(
                    new ApiResponse("Thành công",null),
                    HttpStatus.CREATED
            );
        }
        return new ResponseEntity<>(
                new ApiResponse("Tên đăng nhập đã tồn tại",null),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword (@RequestBody ResetPasswordDTO newPassword) {
        return new ResponseEntity<>(
                new ApiResponse("Thay đổi mật khẩu thành công",null),
                HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser (@RequestBody UserLoginDTO userLogin) {
        String loginName=userLogin.getLoginName();
        String password=userLogin.getPassword();
        UserLoginResponsi user= userService.loginUser(loginName,password);
        if (user==null) {
            return new ResponseEntity<>(
                    new ApiResponse<>("Sai tên tài khoản hoặc mật khẩu",null)
                    ,HttpStatus.BAD_REQUEST
            );
        }
        String token = jwtService.generateToken(user);
        return  new ResponseEntity<>(
                new ResponseLogin<>("Đăng nhập thành công",user,token)
                ,HttpStatus.OK);
    }

}
