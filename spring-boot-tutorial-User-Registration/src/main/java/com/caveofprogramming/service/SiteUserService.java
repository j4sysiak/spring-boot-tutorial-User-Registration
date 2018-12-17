package com.caveofprogramming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.caveofprogramming.model.SiteUser;
import com.caveofprogramming.model.SiteUserDao;

@Service
public class SiteUserService implements UserDetailsService {
	
	@Autowired
	private SiteUserDao siteUserDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	 
	public void register(SiteUser user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		siteUserDao.save(user);
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		SiteUser user = siteUserDao.findByEmail(email);
		 
		if(user == null) {
			return null;
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String password = user.getPassword();
		 
		return new User(email, password, auth);
	}
}




































