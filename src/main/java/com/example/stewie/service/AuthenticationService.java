package com.example.stewie.service;

import com.example.stewie.dto.base.GeneralResponse;
import com.example.stewie.dto.request.AuthenticationRequest;
import com.example.stewie.dto.response.AuthenticationResponse;
import com.example.stewie.entity.User;
import com.example.stewie.entity.UserRole;
import com.example.stewie.repository.BaseRepository;
import com.example.stewie.repository.UserRepository;
import com.example.stewie.security.CustomUserDetail;
import com.example.stewie.service.base.AbstractGeneralService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.example.stewie.entity.UserRole.ADMIN;
import static com.example.stewie.entity.UserRole.USER;

@Service
public class AuthenticationService extends AbstractGeneralService<AuthenticationRequest, User, AuthenticationResponse> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    public AuthenticationService(BaseRepository<User> entityRepository) {
        super(entityRepository);
    }

    public GeneralResponse<AuthenticationResponse> register(AuthenticationRequest dto){
        User user = this.convertToEntity(dto);
        user.setEncoderString(passwordEncoder.encode(dto.getPassword()));
        user.setUserRole(USER);
        user.setCreatedAt(new Date());
        userRepository.save(user);
        return GeneralResponse.ofCreate(this.convertToDto(user), "Created success!");
    }

    public GeneralResponse<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest){
        var token = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        CustomUserDetail userDetail = (CustomUserDetail) authenticationManager.authenticate(token).getPrincipal();
        return GeneralResponse.ofSuccess(this.convertToDto(userDetail.getUser()), "Success!");
    }



    @Override
    public User convertToEntity(AuthenticationRequest dto) {
        return User.builder()
                .username(dto.getUsername())
                .encoderString(dto.getPassword())
                .build();
    }

    @Override
    public AuthenticationResponse convertToDto(User entity) {
        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(new CustomUserDetail(entity)))
                .build();
    }

    @PostConstruct
    public void createAdmin(){
        User user = User.builder()
                .username("admin")
                .encoderString(passwordEncoder.encode("123456"))
                .userRole(ADMIN)
                .build();
        userRepository.save(user);
    }


    @PreDestroy
    public void deleteAdmin(){
        User admin = userRepository.findUserByUsername("admin").get();
        userRepository.delete(admin);
    }
}
