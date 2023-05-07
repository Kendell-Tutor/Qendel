package com.qendel.authenticationservice.security.config;



import com.qendel.authenticationservice.service.impl.AppUserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final AppUserServiceImpl appUserService;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/v1/users/**").hasAnyRole("STUDENT", "TUTOR", "ADMIN")
                .antMatchers("/api/v1/users/admin/**").hasRole("ADMIN")
                .antMatchers("/api/v1/users/tutor/**").hasAnyRole("TUTOR", "ADMIN")//.hasAnyRole("TUTOR", "ADMIN")
                .antMatchers("/api/v1/users/student/**").hasAnyRole("STUDENT", "TUTOR", "ADMIN")//.hasAnyRole("STUDENT", "TUTOR", "ADMIN")
                .antMatchers("/api/v1/registration/**").permitAll()
                .antMatchers("/api/v1/users/students/video/all").permitAll()//todo --> temporary for uploading video only
                .antMatchers("/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .sessionFixation().migrateSession()
//                .maximumSessions(1).expiredUrl("/login?expired")
//                .maxSessionsPreventsLogin(false)
//                .and()
//                .and()
//                .csrf().disable()
//                .authorizeRequests()
//                    .antMatchers("/api/v*/registration/**")
//                    .permitAll()
//                .anyRequest()
//                .authenticated().and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}
