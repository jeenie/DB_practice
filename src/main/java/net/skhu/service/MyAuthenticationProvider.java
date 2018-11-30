package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import net.skhu.dto.User;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{
	@Autowired UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String loginId=authentication.getName();
		String passwd=authentication.getCredentials().toString();
		return authenticate(loginId, passwd);
	}
	
	public Authentication authenticate(String loginId, String password) throws AuthenticationException {
		User user = userService.login(loginId, password);
		if(user == null) return null;
		return new MyAuthenticaion(loginId, password, user);
	}
	
	@Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
	
	public class MyAuthenticaion extends UsernamePasswordAuthenticationToken {
        private static final long serialVersionUID = 1L;
        User user;

        public MyAuthenticaion (String loginId, String passwd, User user) {
            super(loginId, passwd);
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

}
