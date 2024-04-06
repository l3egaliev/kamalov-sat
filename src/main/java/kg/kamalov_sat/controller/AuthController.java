package kg.kamalov_sat.controller;

import jakarta.validation.Valid;
import kg.kamalov_sat.dto.SignUpRequest;
import kg.kamalov_sat.model.User;
import kg.kamalov_sat.service.RegisterService;
import kg.kamalov_sat.utils.EmailValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final RegisterService registerService;
    private final EmailValidator emailValidator;

    @GetMapping("/login")
    public String login(){
            return "auth/login";
    }


    @GetMapping("/auth/register")
    public String register(@ModelAttribute("register_user") SignUpRequest request){
        return "auth/registration";
    }

    @PostMapping("/auth/register")
    public String register(@ModelAttribute("register_user") @Valid SignUpRequest request,
                           BindingResult bd){
        User user = convertToUser(request);
        emailValidator.validate(user, bd);

        if (bd.hasErrors()){
            return "auth/registration";
        }

        registerService.register(user);
        return "redirect:/login";
    }

    private User convertToUser(SignUpRequest request){
        return User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();
    }
}
