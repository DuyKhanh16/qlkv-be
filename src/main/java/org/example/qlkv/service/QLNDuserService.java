package org.example.qlkv.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.persistence.Tuple;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.example.qlkv.DTO.CreateUserDTO;
import org.example.qlkv.DTO.UserLoginResponsi;
import org.example.qlkv.DTO.request.IntrospectRequest;
import org.example.qlkv.DTO.response.IntrospectResponse;
import org.example.qlkv.entity.QLNDUser;
import org.example.qlkv.repository.QLNDuserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class QLNDuserService {

    @Autowired
    private QLNDuserRepository userRepository;

    public Boolean createNewUser(CreateUserDTO userNew) {
//         Kiểm tra user đã tồn tại chưa
        QLNDUser checkUser = userRepository.findByLoginName(userNew.getLoginName());
        if (checkUser != null) {
            return false;
        }
        //add user

        QLNDUser user = new QLNDUser();
        user.setLoginName(userNew.getLoginName());
        user.setPassword(BCrypt.hashpw(userNew.getPassword(), BCrypt.gensalt()));
        user.setFullName(userNew.getFullName());
        user.setDepartment(userNew.getDepartment());
        user.setStatus("ACTIVE");
        user.setCreateDate(String.valueOf(LocalDate.now()));
        user.setMangUser(String.valueOf(userRepository.findByLoginName(userNew.getMangUser()).getId()));
        userRepository.save(user);
        return true;
    }

    public UserLoginResponsi loginUser(String loginName, String password) {
        List<Tuple> reuslt = userRepository.getUserLogin(loginName);
        if (!reuslt.isEmpty()) {
            Tuple tuple = reuslt.get(0);
            UserLoginResponsi user = new UserLoginResponsi(tuple.get("loginName",String.class),tuple.get("fullName", String.class), tuple.get("password", String.class), tuple.get("Name", String.class));
            boolean checkPassword = BCrypt.checkpw(password, user.getPassword());
            if (!checkPassword) {
                return null;
            }
            return user;
        }
        return null;
    }





}
