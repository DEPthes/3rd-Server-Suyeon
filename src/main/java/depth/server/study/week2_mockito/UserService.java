//package depth.server.study.Week2_Mockito;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//public class UserService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    public UserEntity create(final UserEntity userEntity) {
//        if(userEntity == null || userEntity.getEmail() == null) {
//            throw new RuntimeException("Invalid Arguments");
//        }
//
//        final String email = userEntity.getEmail();
//        if(userRepository.existsByEmail(email)) {
//            log.warn("Email already exists{}", email);
//            throw new RuntimeException("Email already exists");
//        }
//        return userRepository.save(userEntity);
//    }
//
//}
