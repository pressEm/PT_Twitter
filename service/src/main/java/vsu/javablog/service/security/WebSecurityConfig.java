package vsu.javablog.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    //    @Autowired
//    UserService userService;
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public WebSecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("|||| " + bCryptPasswordEncoder.encode("user"));
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests()
            .antMatchers("/friends/**").hasRole("USER")
            .anyRequest().permitAll()
            .and()
            .httpBasic();
    }



//        httpSecurity
//            .csrf()
//            .disable()
//            .authorizeRequests()
            //Доступ только для не зарегистрированных пользователей
//            .antMatchers("/registration").not().fullyAuthenticated()
            //Доступ только для пользователей с ролью Администратор
//            .antMatchers("/users/**").hasRole("ADMIN")
//            .antMatchers("/users/**").hasRole("ADMIN")
//
//            .antMatchers("/friends/**").hasRole("USER")
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic();
            //Доступ разрешен всем пользователей
//            .antMatchers("/", "/resources/**").permitAll()
            //Все остальные страницы требуют аутентификации
//            .anyRequest().authenticated()
//            .and()
//            //Настройка для входа в систему
//            .formLogin()
//            .loginPage("/login")
//            //Перенарпавление на главную страницу после успешного входа
//            .defaultSuccessUrl("/")
//            .permitAll()
//            .and()
//            .logout()
//            .permitAll()
//            .logoutSuccessUrl("/");
//    }
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
//    }


//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
}
