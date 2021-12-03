package hello.advanced.trace.helloTrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloTraceV1Test {

    @Test
    public void begin_end() throws Exception{
        //given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");

        //when
        trace.end(status);

        //then
    }

    @Test
    public void begin_exception() throws Exception{
        //given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");

        //when
        trace.exception(status, new IllegalStateException());

        //then
    }
}