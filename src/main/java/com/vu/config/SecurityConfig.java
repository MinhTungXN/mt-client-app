package com.vu.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.vu.constant.ParameterConstant;
import com.vu.constant.SecurityConstant;
import com.vu.constant.UrlConstant;
import com.vu.repository.UserRepository;
import com.vu.security.UserDetailsServiceImpl;

@EnableAutoConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
@ComponentScan(basePackageClasses = {UserDetailsServiceImpl.class, UserRepository.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsServiceImpl userDetailsService;
	
	public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();
		
		//Pages not require login
		httpSecurity.authorizeRequests().antMatchers(UrlConstant.B2C_DEFAULT_URL,
				UrlConstant.CSS_FILES_PATH_URL, UrlConstant.JS_FILES_PATH_URL,
				UrlConstant.B2C_HOME_URL, UrlConstant.B2C_LOGIN_URL,
				UrlConstant.B2C_LOGOUT_URL, UrlConstant.ADMIN_HOME_URL
		).permitAll();
		
		// Pages require login with roles: ROLE_USER, ROLE_ADMIN. 
		// If not login yet, redirect to /login
		httpSecurity.authorizeRequests().antMatchers(
				UrlConstant.B2C_DEFAULT_URL, UrlConstant.B2C_FILES_PATH_URL,
				UrlConstant.USER_FILE_PATH_URL, UrlConstant.B2C_USER_PROFILE_URL
		).access(SecurityConstant.REQUIRED_LOGIN_ANY_ROLES);
		
		// Pages require login with role: ROLE_ADMIN. 
		// If not login at admin role yet, redirect to /login
		httpSecurity.authorizeRequests().antMatchers(
				UrlConstant.ADMIN_FILE_PATH_URL
		).access(SecurityConstant.REQUIRED_LOGIN_ADMIN_ROLE);
		
		// When user login with ROLE_USER, but try to 
		// access pages require ROLE_ADMIN, redirect to /error-403
		httpSecurity.authorizeRequests()
					.and().exceptionHandling()
		.accessDeniedPage(UrlConstant.B2C_ACCESS_DENIED_URL);
		
		// Configure login page (check login by spring security)
		httpSecurity.authorizeRequests()
                .and().formLogin()
                .loginProcessingUrl(UrlConstant.SECURITY_CHECK_URL)
                .loginPage(UrlConstant.B2C_LOGIN_URL)
                .defaultSuccessUrl(UrlConstant.B2C_USER_PROFILE_URL)
                .failureUrl(UrlConstant.LOGIN_FAILURE_URL)
                .usernameParameter(ParameterConstant.USERNAME_PARAMETER)
                .passwordParameter(ParameterConstant.PASSWORD_PARAMETER)
                .and().logout()
                .logoutUrl(UrlConstant.B2C_LOGOUT_URL)
                .logoutSuccessUrl(UrlConstant.LOGOUT_SUCCESS_URL);
		
		// Configure remember me (save token in database)
		httpSecurity.authorizeRequests()
                .and().rememberMe()
                    .tokenRepository(this.persistentTokenRepository())
                    .tokenValiditySeconds(ParameterConstant.TOKEN_VALIDITY_SECONDS);
	}
	
	// Token stored in memory (of web server)
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }
}
