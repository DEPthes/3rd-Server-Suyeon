package depth.server.study.week1_testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * pw 최소 9자 이상 15자 이하
 * pw가 9자 미만 또는 15자 초과이면 예외 발생
 * 경계조건 확인
 */
public class PasswordValidatorTest {

    //테스트 클래스or메소드에 이름 부여 (의도 또는 설명 작성)
    @DisplayName("비밀번호가 9자 이상 15자 이하면 정상")
    @Test // 테스트 메소드 선언
    void validatePasswordTest(){
        assertThatCode(()-> PasswordValidator.validate("123456789"))
                .doesNotThrowAnyException();
        // assertThatCode : 실패하지 않는 코드를 검증하는 것
    }

    @DisplayName("비밀번호가 9자 미만인 경우 예외 발생")
    @Test
    void validatePasswordShortExceptionTest() {
        assertThatCode(() -> PasswordValidator.validate("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                //발생한 예외가 IllegalArgumentException클래스의 인스턴스인지 비교하는 메소드
                .hasMessageContaining(PasswordValidator.WRONG_PW_LENGTH_EXCEPTION_MESSAGE);
    }

    @DisplayName("비밀번호가 15자 초과인 경우 예외 발생")
    @Test
    void validatePasswordLongExceptionTest() {
        assertThatCode(() -> PasswordValidator.validate("12345678901234567890"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PasswordValidator.WRONG_PW_LENGTH_EXCEPTION_MESSAGE);
    }

    @DisplayName("경계조건(8자,16자)에 대한 테스트")
    @ParameterizedTest // 테스트메소드가 인자를 받을 수 있게 하는 테스트 선언
    @ValueSource(strings = {"12345678", "1234567890123456"})
    /** 리터럴 값의 단일 배열을 지정, 인자를 받는 테스트를 호출할 때 단일 인수를 제공
        리터럴 값 : 변하지 않는 데이터 (상수 : 변하지 않는 '수') */
    void validatePasswordBoundaryTest(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PasswordValidator.WRONG_PW_LENGTH_EXCEPTION_MESSAGE);
    }

}
// 참고 : https://www.wool-dev.com/backend-engineering/java/java-test-code-simple/
