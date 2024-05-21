package depth.server.study.week5_concurrency1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class StoreServiceTest {
    private StoreService storeService = new StoreService();

    @Test
    void field() {
        log.info("main test");
        Runnable userA = () -> {
            storeService.saveAndFind("userA");
        };
        Runnable userB = () -> {
            storeService.saveAndFind("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("Thread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("Thread-B");

        threadA.start(); // Runnable 로직 실행
        sleep(100); // 동시성 문제 발생 O
        threadB.start(); // Runnable 로직 실행

        // saveAndFind()메소드는 저장에 1초(1000밀리초)가 걸리는데,
        // threadA가 시작되고 0.1초만에 threadB가 개입한 상황
        // -> 따라서 userA를 저장했음에도 userB라는 값을 조회하게 됨


        sleep(3000); // 메인 쓰레드 종료 대기
        log.info("main exit");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
