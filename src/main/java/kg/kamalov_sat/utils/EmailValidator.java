package kg.kamalov_sat.utils;

import kg.kamalov_sat.model.User;
import kg.kamalov_sat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailValidator implements Validator {
    private final UserService userService;

    @Autowired
    public EmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
    }

    public void validate(User user, Errors errors) {
        if (userService.isExistsEmail(user.getEmail())) {
            errors.rejectValue("email", "", "Такой email уже существует");
        }
    }
}
