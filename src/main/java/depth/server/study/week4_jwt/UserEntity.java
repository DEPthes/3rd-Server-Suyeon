//package depth.server.study.week4_jwt;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.GenericGenerator;
//
//@Data
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
//public class UserEntity {
//    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    private String id; // 유저에게 고유하게 부여되는 id
//
//    @Column(nullable = false)
//    private String username; // 아이디로 사용할 유저네임. 이메일or문자열 가능
//
//    private String password; // 패스워드
//
//    private String role; // ex. 어드민, 일반 사용자 등
//
//    private String authProvider; // OAuth 적용 시 사용할 유저 정보 제공자 (github)
//}
