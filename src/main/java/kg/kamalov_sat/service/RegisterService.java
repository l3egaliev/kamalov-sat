package kg.kamalov_sat.service;

import kg.kamalov_sat.model.Role;
import kg.kamalov_sat.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserService service;
    private final PasswordEncoder encoder;

    public void register(User user){
        user.setRole(Role.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
        service.save(user);
    }
}
