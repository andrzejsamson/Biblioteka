package pl.samson.Library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user123")
                .roles("USER")
                .build();
        UserDetails librarian = User.withDefaultPasswordEncoder()
                .username("librarian")
                .password("librarian123")
                .roles("LIBRARIAN")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, librarian, admin);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/library/all").permitAll()
                .antMatchers(HttpMethod.GET, "/api/library/searchId").permitAll()
                .antMatchers(HttpMethod.GET, "/api/library/searchTitle").permitAll()
                .antMatchers(HttpMethod.GET, "/api/library/searchAuthor").permitAll()
                .antMatchers(HttpMethod.PATCH, "/api/library/reservation").permitAll()
                .antMatchers(HttpMethod.PATCH, "/api/library/loan").hasAnyRole("LIBRARIAN", "ADMIN")
                .antMatchers(HttpMethod.PATCH, "/api/library/returnBook").hasAnyRole("LIBRARIAN", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/library/addBook").hasAnyRole("LIBRARIAN", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/library/changeBook").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/library/deleteBook").hasRole("ADMIN")
                .and().formLogin().permitAll()
                .and().logout().permitAll()
                .and().csrf().disable();
    }
}
