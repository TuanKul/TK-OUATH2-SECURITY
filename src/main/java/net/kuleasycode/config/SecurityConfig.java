package net.kuleasycode.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableWebSecurity//thuộc spring security, quản lý các user, kích hoạt spring security với spring boot or mvc
@EnableGlobalMethodSecurity(prePostEnabled = true)// để hỗ trợ chạy dc các "#oauth2.hasScope('eligible_dsa_web') OR hasAuthority('ROLE_ADMIN')"
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Resource(name = "userService")
    private UserDetailsService userDetailsService;//check user dùng có trong db hk sau nếu có sẽ lấy các roles
    
    //5
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Autowired
	@Qualifier("dataSource")
	DataSource dataSource;
    
    //1
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    //10
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//HttpSecurity là đối tượng chính của spring security, tương tự như Builder pattern
    	//authorizeRequests(): khai báo đường dẫn của request
    	//permitAll() cho phép tất cả user dc truy cập
    	//nếu ta đã dùng csrf thì mặc định sẽ có thêm CSRF token, nên hk cần cấu hình thêm gì nữa
        http
                .csrf().disable()
                .anonymous().disable()
                .authorizeRequests()
                .antMatchers("/api-docs/**").permitAll();
    }

    //4
    @Bean
    public TokenStore tokenStore() {
    	return new JdbcTokenStore(dataSource);
    }

    //2
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    //3
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
