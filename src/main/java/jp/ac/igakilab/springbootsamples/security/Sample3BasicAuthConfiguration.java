package jp.ac.igakilab.springbootsamples.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Sample3BasicAuthConfiguration
 */
@Configuration
@EnableWebSecurity // securityモジュールを利用するためのアノテーション
public class Sample3BasicAuthConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // IDがuserでパスワードがpassword というアカウントを作成．ロールはUSER
    // 他のユーザも追加．なお，{noop}はハッシュ化されていないパスワードを使う場合に書く
    auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
    auth.inMemoryAuthentication().withUser("user2").password("{noop}password2").roles("USER");
    auth.inMemoryAuthentication().withUser("user3").password("{noop}password3").roles("USER");
    auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // "/sample3"で始まるURLはログインしていなければ表示されない
    // ".and().httpBasic()" がない場合はログインフォームを別途指定する必要がある
    // http.authorizeRequests().antMatchers("/sample3/**").authenticated().and().httpBasic();
    http.authorizeRequests().antMatchers("/sample3/**").authenticated().and().formLogin().and().logout();
    // 以下2行がないと，H2DBにWebクライアントからアクセスできない
    // 開発が終了したらSecurity的には以下2行は消したほうが良い
    http.csrf().disable();
    http.headers().frameOptions().disable(); // HTTPヘッダのX-Frame-OptionsがDENYになるとiframeでlocalhostでのアプリが使えなくなるので，H2DBのWebクライアントのためだけにdisableにする必要がある
  }
}
