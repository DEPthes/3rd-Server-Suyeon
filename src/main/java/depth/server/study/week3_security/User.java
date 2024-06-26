//package depth.server.study.week3_security;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//
//
//import java.sql.Timestamp;
//
//@Entity
//@Data
//public class User {
//    @Id
//    @GeneratedValue
//    private int id; // 기본키
//    private String username; // 사용자 아이디
//    private String password; // 사용자 비밀번호
//    private String email; // 사용자 이메일
//    private String role; // 사용자 권한
//
//    @CreationTimestamp
//    private Timestamp createDate; // 회원가입한 날짜
//}