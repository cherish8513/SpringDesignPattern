package hello.advanced.trace.threadLocal;

import hello.advanced.trace.threadLocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService service = new ThreadLocalService();

    @Test
    public void field() throws Exception{
        //given
        log.info("main start");

        Runnable userA = () -> {
            service.logic("userA");
        };
        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        //when
        threadA.start();
        sleep(10); // 동시성 문제 발생X
        threadB.start();

        //then
        sleep(3000); // 메인 쓰레드 종료 대기(java의 count down latch가 더 좋다)
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
