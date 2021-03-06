package net.skhu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import net.skhu.dto.User;
import net.skhu.service.MyAuthenticationProvider.MyAuthenticaion;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String loginId = authentication.getName();
		String passwd = authentication.getCredentials().toString();
		return authenticate(loginId, passwd);
	}

	public Authentication authenticate(String loginId, String password) throws AuthenticationException {
		User user = userService.login(loginId, password);
		if (user == null)
			return null;
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		String role = "";
		switch (user.getUserType()) {
		case "관리자":
			role = "ROLE_ADMIN";
			break;
		case "교수":
			role = "ROLE_PROFESSOR";
			break;
		case "학생":
			role = "ROLE_STUDENT";
			break;
		}
		grantedAuthorities.add(new SimpleGrantedAuthority(role));
		return new MyAuthenticaion(loginId, password, grantedAuthorities, user);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	public class MyAuthenticaion extends UsernamePasswordAuthenticationToken {
		private static final long serialVersionUID = 1L;
		User user;

		public MyAuthenticaion(String loginId, String passwd, List<GrantedAuthority> grantedAuthorities, User user) {
			super(loginId, passwd, grantedAuthorities);
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
