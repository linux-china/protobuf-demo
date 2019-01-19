package org.mvnsearch.protobuf;

import org.mvnsearch.user.UserPB;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@Fork(1)
@Warmup(iterations = 1)
@Measurement(iterations = 2)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class BaseBenchmark {
    protected UserPB userPB = UserPB.newBuilder()
            .setId(1)
            .setName("Jackie")
            .setEmail("demo@demo.com")
            .setPhone("186").build();

    protected UserDO userDO = new UserDO(1, "Jackie", "demo@demo.com", "186");
    protected UserKDO userKDO = new UserKDO(1, "Jackie", "demo@demo.com", "186");

}
