package pl.coderslab.sport_book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.sport_book.service.UserDetailsService;
import pl.coderslab.sport_book.service.impl.UserDetailsServiceImpl;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsServiceImpl customUserDetailsService() {
//        return new UserDetailsServiceImpl();
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("Select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("Select u.username, r.role from users u join users_roles ur on u.id=ur.user_id join role r on r.role_id=ur.roles_role_id where u.username=?")
                .passwordEncoder(passwordEncoder());
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN","USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/home").fullyAuthenticated()
//                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().fullyAuthenticated()
            .and().formLogin().defaultSuccessUrl("/home");
//            .loginPage("/login");
    }
}

