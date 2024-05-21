package depth.server.study.week5_concurrency1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {
    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String saveAndFind(String name) {
        log.info("[저장] 현재 저장된 값 : nameStore = {}, 저장할 값 : name = {} ", nameStore.get(), name);
        nameStore.set(name);
        sleep(1000);
        log.info("[조회] 현재 저장된 값 : nameStore = {}", nameStore.get());
        return nameStore.get();

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}