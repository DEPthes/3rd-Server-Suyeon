package depth.server.study.week5_concurrency1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {
    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> {
            service.saveAndFind("userA");
        };

        Runnable userB = () -> {
            service.saveAndFind("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start(); // Runnable 로직 실행
        sleep(100); // 동시성 문제 발생 지점

        // StoreServiceTest와 마찬가지로 0.1초만에 threadB를 시작했으나,
        // 쓰레드 로컬을 사용했기 때문에
        // Thread-A는 userA를, Thread-B는 userB를 저장하고 조회한다.

        threadB.start(); // Runnable 로직 실행
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