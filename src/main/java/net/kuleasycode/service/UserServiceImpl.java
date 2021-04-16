package net.kuleasycode.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import net.kuleasycode.entity.RoleEntity;
import net.kuleasycode.entity.UserEntity;
import net.kuleasycode.repository.RoleRepository;
import net.kuleasycode.repository.UserRepository;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    public UserDetails loadUserByUsername(String userId) {
    	UserEntity userEntity = userRepository.findByUserNameAndEnabled(userId);
        if (StringUtils.isEmpty(userEntity)) {
            throw new UsernameNotFoundException("Invalid username or password or not online.");
        }
        //org.springframework.security.core.userdetails.User là một implement của UserDetails gồm 3 tham số username password và grantedAuthority
		return new org.springframework.security.core.userdetails.User(userEntity.getUserName(),
				userEntity.getPassword(), getAuthority(userEntity));
    }

    private List<SimpleGrantedAuthority> getAuthority(UserEntity userEntity) {
    	List<SimpleGrantedAuthority> result = new ArrayList<>();
    	// using query native
//    	Set<RoleEntity> entities = roleRepository.findByUserName(userEntity.getUserName());
//    	for (RoleEntity roleEntity : entities) {
//    		if (userEntity.getRolesOauth().isEmpty()) {
//    			throw new UsernameNotFoundException("user invalid");
//    		}
//    		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleEntity.getRoleId()); 
//    		result.add(authority);
//    	}
    	for (RoleEntity roleEntity : userEntity.getRolesOauth()) {
    		if (userEntity.getRolesOauth().isEmpty()) {
    			throw new UsernameNotFoundException("user invalid");
    		}
    		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleEntity.getRoleId()); 
    		result.add(authority);
    	}
    	return result;
    }
}
