package com.security.security_app;


    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.authentication.AuthenticationProvider;
    import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.NoOpPasswordEncoder;
    import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
    import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{
  @Autowired
  private UserDetailsService userDetailsService;
//  private MyUserDetailsService userDetailsService = new MyUserDetailsService();

  @Bean
  public AuthenticationProvider authProvider()
  {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService);
//    provider.setPasswordEncoder(new BCryptPasswordEncoder());
    provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    return provider;
  }



//  @Bean
//  @Override
//  protected UserDetailsService userDetailsService() {
//
//    List<UserDetails> users = new ArrayList<>();
//    users.add(User.withDefaultPasswordEncoder().username("maks").password("123").roles("USER").build());
//    return new InMemoryUserDetailsManager(users);
//
//  }
}
