package jp.ac.igakilab.springbootsamples;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
/**
 * BasicConfiguration {noop}はエンコードしていない平文のパスワードを使うとき用（ほんとはだめ）
 * 参考：https://qiita.com/delaware/items/f30452007f6c6bd6e09d
 */
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER").and().withUser("admin")
        .password("{noop}admin").roles("USER", "ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/sample").permitAll();
    http.authorizeRequests().antMatchers("/api/streaming").permitAll();
    http.authorizeRequests().antMatchers("/api/sse").permitAll();
    http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
  }
}
