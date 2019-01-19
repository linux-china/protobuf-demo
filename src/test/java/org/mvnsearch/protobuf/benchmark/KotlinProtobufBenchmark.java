package org.mvnsearch.protobuf.benchmark;

import jmh.mbr.junit5.Microbenchmark;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * kotlin protobuf Serialization benchmark
 *
 * @author linux_china
 */
@Microbenchmark
public class KotlinProtobufBenchmark extends BaseBenchmark {

    @Benchmark
    public void benchmark() {
        KotlinAssistantKt.benchmark(userKDO);
    }
}
