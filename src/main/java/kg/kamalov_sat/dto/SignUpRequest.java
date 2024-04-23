package kg.kamalov_sat.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpRequest {
    @Size(min = 2, max = 50, message = "Имя пользователя должно содержать от 2 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Имя пользователя должно содержать только буквы")
    private String firstname;

    @Size(min = 5, max = 50, message = "Фамилия пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Фамилия пользователя должно содержать только буквы")
    private String lastname;

    @Size(min = 5, max = 255, message = "Адрес электронной почты должен содержать от 5 до 255 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустыми")
    @Email(message = "Email адрес должен быть в формате user@example.com")
    private String email;

    @Size(min = 8, max = 30, message = "Длина пароля должна быть от 8 до 30 символов")
    private String password;
}
