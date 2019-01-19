package org.mvnsearch.protobuf.benchmark;

import jmh.mbr.junit5.Microbenchmark;
import org.mvnsearch.protobuf.BaseBenchmark;
import org.mvnsearch.user.UserPB;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * protobuf native benchmark
 *
 * @author linux_china
 */
@Microbenchmark
public class ProtobufNativeBenchmark extends BaseBenchmark {

    @Benchmark
    public void benchmark() throws Exception {
        UserPB.parseFrom(userPB.toByteArray());
    }
}
