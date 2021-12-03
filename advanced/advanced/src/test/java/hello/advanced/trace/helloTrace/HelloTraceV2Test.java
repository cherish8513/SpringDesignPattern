package hello.advanced.trace.helloTrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class HelloTraceV2Test {

    @Test
    public void begin_end() throws Exception{
        //given
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "hello2");

        //when
        trace.end(status2);
        trace.end(status);

        //then
    }

    @Test
    public void begin_exception() throws Exception{
        //given
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "hello2");
        //when
        trace.exception(status2, new IllegalStateException());
        trace.exception(status, new IllegalStateException());

        //then
    }
}