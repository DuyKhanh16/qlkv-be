package org.example.qlkv.controller;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.experimental.NonFinal;
import org.example.qlkv.DTO.*;
import org.example.qlkv.DTO.request.IntrospectRequest;
import org.example.qlkv.DTO.response.IntrospectResponse;
import org.example.qlkv.config.NimbusJWTConfig;
import org.example.qlkv.service.QLNDuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Controller
@RequestMapping("/auth/api/user")
public class UserControler {
    @Autowired
    private QLNDuserService userService;

    private final NimbusJWTConfig nimbusJWTConfig;

    public UserControler(NimbusJWTConfig nimbusJWTConfig) {
        this.nimbusJWTConfig = nimbusJWTConfig;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody CreateUserDTO newUser) {
        boolean result = userService.createNewUser(newUser);
        if (result) {
            return new ResponseEntity<>(
                    new ApiResponse("Thành công", null),
                    HttpStatus.CREATED
            );
        }
        return new ResponseEntity<>(
                new ApiResponse("Tên đăng nhập đã tồn tại", null),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordDTO newPassword) {
        return new ResponseEntity<>(
                new ApiResponse("Thay đổi mật khẩu thành công", null),
                HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO request) {
        UserLoginResponsi user = userService.loginUser(request.getLoginName(), request.getPassword());
        if (user == null) {
            return new ResponseEntity<>(
                    new ApiResponse<>("Sai tên tài khoản hoặc mật khẩu", null)
                    , HttpStatus.BAD_REQUEST
            );
        }

        var token =nimbusJWTConfig.generateToken(request.getLoginName());
        return new ResponseEntity<>(

                new ResponseLogin<>("Đăng nhập thành công", user, token)
                , HttpStatus.OK);
    }

    @PostMapping("/introspect")
    ResponseEntity<IntrospectResponse> authenticate (@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result =nimbusJWTConfig.introspect(request);
        return new ResponseEntity<>(
                result,
                HttpStatus.OK
        );
    };




}
