//package depth.server.study.week4_jwt;
//
//import depth.server.study.week4_jwt.security.TokenProvider;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RestController
//@RequestMapping("/auth")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private TokenProvider tokenProvider;
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
//        try {
//            if(userDTO == null || userDTO.getPassword() == null) {
//                throw new RuntimeException("Invalid Password value.");
//            }
//            // 요청을 이용해 저장할 유저 생성
//            UserEntity user = UserEntity.builder()
//                    .username(userDTO.getUsername())
//                    .password(userDTO.getPassword())
//                    .build();
//            // 서비스를 이용해 레포지토리에 유저 저장
//            UserEntity registeredUser = userService.create(user);
//            UserDTO responseUserDTO = UserDTO.builder()
//                    .id(registeredUser.getId())
//                    .username(registeredUser.getUsername())
//                    .build();
//            return ResponseEntity.ok().body(responseUserDTO);
//        } catch (RuntimeException e) {
//            // 유저 정보는 항상 하나이므로 리스트로 만들어야 하는 ResponseDTO가 아니라 그냥 UserDTO 리턴
//            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
//            return ResponseEntity
//                    .badRequest()
//                    .body(responseDTO);
//        }
//    }
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
//        UserEntity user = userService.getByCredentials(
//                userDTO.getUsername(),
//                userDTO.getPassword());
//        if(user != null) {
//            // token 생성
//            final String token = tokenProvider.create(user);
//            final UserDTO responseUserDTO = UserDTO.builder()
//                    .username(user.getUsername())
//                    .id(user.getId())
//                    .token(token)
//                    .build();
//            return ResponseEntity.ok().body(responseUserDTO);
//        } else {
//            ResponseDTO responseDTO = ResponseDTO.builder()
//                    .error("Login failed.")
//                    .build();
//            return ResponseEntity
//                     .badRequest()
//                    .body(responseDTO);
//        }
//    }
//}
