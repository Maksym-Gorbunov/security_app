package com.security.security_app;


    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
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
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{
  @Autowired
  private UserDetailsService userDetailsService;

  //for oAyth2
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
            .csrf().disable()
            .authorizeRequests().antMatchers("/login").permitAll()
            .anyRequest().authenticated();

  }



  // For own auth
  /*
  @Bean
  public AuthenticationProvider authProvider()
  {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(new BCryptPasswordEncoder());
    //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    return provider;
  }


  // Add this method if you want use own login page, else remove and use default
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
            .csrf().disable()
            .authorizeRequests().antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login").permitAll()
            .and()
            .logout().invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/logout-success").permitAll();

  }
  */




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
