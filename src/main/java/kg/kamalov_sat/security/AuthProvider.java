package kg.kamalov_sat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthProvider implements AuthenticationProvider {
    private final UserDetailsServiceImpl service;

    @Autowired
    public AuthProvider(UserDetailsServiceImpl userDetailsService) {
        this.service = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        UserDetails userDetails = service.loadUserByUsername(email);
        String password = authentication.getCredentials().toString();
        if(!userDetails.getPassword().equals(password)){
            throw new BadCredentialsException("Email or password incorrect");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
