package depth.server.study.Week1_TestCode;

public class PasswordValidator {
    public static final String WRONG_PW_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 9자 이상 15자 이하여야 합니다.";
    public static void validate(String password){
        int length = password.length();

        if(length < 9 || length > 15){
            throw new IllegalArgumentException(WRONG_PW_LENGTH_EXCEPTION_MESSAGE);
        }
    }

}
