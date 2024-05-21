//package depth.server.study.week4_jwt.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@Slf4j
//public class SecurityConfig {
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws
//            Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//
//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        // http 시큐리티 빌더
//        http.csrf(AbstractHttpConfigurer::disable);
//        http.cors(AbstractHttpConfigurer::disable)
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers("/", "/auth/**").permitAll()
//                        .anyRequest() // /와 /auth/**이외의 모든 경로는 인증 해야됨.
//                        .authenticated() //어떠한 요청이라도 인증 필요
//                );
//
//        return http.build();
//    }
//}
