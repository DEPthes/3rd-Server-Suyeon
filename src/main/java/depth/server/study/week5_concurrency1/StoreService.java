package depth.server.study.week5_concurrency1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StoreService {

    private String nameStore;

    public String saveAndFind(String name) {
        log.info("[저장] 현재 저장된 값 : nameStore = {}, 저장할 값 : name = {}", nameStore, name);
        nameStore = name; //nameStore 저장소
        sleep(1000);
        log.info("[조회] 현재 저장된 값 : nameStore = {}", nameStore);
        return nameStore;

        //saveAndFind() 메소드는 값을 저장하는데 1초가 걸린다.
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
