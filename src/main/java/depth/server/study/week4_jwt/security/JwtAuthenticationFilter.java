//package depth.server.study.week4_jwt.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.security.Security;
//
//@Slf4j
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private TokenProvider tokenProvider;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            // 요청에서 토큰 가져오기
//            String token = parseBearerToken(request);
//            log.info("Filter is running");
//            //token검사하기. jwt이므로 인가 서버에 요청하지 않고도 검증 가능
//            if(token != null && !token.equalsIgnoreCase("null")){
//                // userId가져오기, 위조된 경우 예외처리됨
//                String userId = tokenProvider.validateAndGetUserId(token);
//                log.info("Authenticated userID : "+ userId);
//                // 인증 완료; SecurityContextHolder에 등록해야 인증된 사용자라고 생각함
//                AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userId, null,
//                        AuthorityUtils.NO_AUTHORITIES);
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
//                securityContext.setAuthentication(authentication);
//                SecurityContextHolder.setContext(securityContext);
//            }
//        } catch (Exception ex) {
//            logger.error("Could not set user authentication in security context", ex);
//        }
//        filterChain.doFilter(request, response);
//    }
//    private String parseBearerToken(HttpServletRequest request) {
//        //http의 요청의 헤더를 파싱해  Bearer token을 리턴한다
//        String bearerToken = request.getHeader("Authorization");
//        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearere")){
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//}
