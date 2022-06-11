package com.studyisnthard.SIH.config;

import com.studyisnthard.SIH.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/читання", "/interesting").permitAll()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/news").hasRole("USER")
                .antMatchers("/граматика/**").permitAll()
                .antMatchers("/v1", "/v1/**").permitAll()
                .antMatchers("/testing", "/testing/**").permitAll()
                .antMatchers("/rest", "/rest/**", "/logout").permitAll()
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/test", "/**/*.js", "/**/*.css", "/pastsimple", "/**/*.svg", "/hello", "/граматика", "/словничок", "/reading").permitAll()
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}
