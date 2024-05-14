//package depth.server.study.week2_mockito;
//
//import depth.server.study.week3_security.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.reset;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    public void createTest() {
//        Assertions.assertThrows(RuntimeException.class, () -> {
//            userService.create(null);
//        });
//
//        UserEntity userEntityForNullEmail = UserEntity.builder().build();
//        Assertions.assertThrows(RuntimeException.class, () -> {
//            userService.create(userEntityForNullEmail);
//        });
//
//        UserEntity userEntityForExistUser = UserEntity.builder()
//                .email("test@test.com")
//                .username("test_username")
//                .password("test_password")
//                .build();
//
//        when(userRepository.existsByEmail(any())).thenReturn(true);
//        Assertions.assertThrows(RuntimeException.class, () -> {
//            userService.create(userEntityForExistUser);
//        });
//
//        UserEntity userEntity = UserEntity.builder()
//                .email("test@test.com")
//                .username("test_username")
//                .password("test_password")
//                .build();
//        reset(userRepository);
//        when(userRepository.save(any())).thenReturn(userEntity);
//        UserEntity returnedUserEntity = userService.create(userEntity);
//        Assertions.assertEquals("test@test.com", returnedUserEntity.getEmail());
//        Assertions.assertEquals("test_username", returnedUserEntity.getUsername());
//        Assertions.assertEquals("test_password", returnedUserEntity.getPassword());
//
//    };
//}
