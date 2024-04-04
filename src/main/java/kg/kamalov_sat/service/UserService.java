package kg.kamalov_sat.service;

import kg.kamalov_sat.exception.EmailNotFoundException;
import kg.kamalov_sat.model.User;
import kg.kamalov_sat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repository;

    /**
     * Сохранение пользователя
     */
    @Transactional
    public void save(User user){
        repository.save(user);
    }

    public boolean isExistsEmail(String e){
        return repository.existsByEmail(e);
    }

    /**
     * Получение пользователя по email
     *
     * @return User
     */
    public User findByEmail(String email){
        System.out.println(email);
        return repository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User not found with email "+email));
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User currentUser(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.findByEmail(email);
    }
}
