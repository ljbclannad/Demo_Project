package com.example.demo.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author ：lejb
 * @date ：Created in 2020/1/9 13:51
 * @description : JMH DEMO类
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class HelloWorld {

    @Benchmark
    public void wellHelloThere() {

    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(HelloWorld.class.getSimpleName())
                .forks(1).build();
        new Runner(options).run();
    }
}
