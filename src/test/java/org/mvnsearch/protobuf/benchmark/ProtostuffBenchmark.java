package org.mvnsearch.protobuf.benchmark;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import jmh.mbr.junit5.Microbenchmark;
import org.mvnsearch.protobuf.UserDO;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * protostuff benchmark test
 *
 * @author linux_china
 */
@Microbenchmark
public class ProtostuffBenchmark extends BaseBenchmark {
    private static Schema<UserDO> userDOSchema = RuntimeSchema.getSchema(UserDO.class);

    @Benchmark
    public void benchmark() throws Exception {
        final byte[] protostuff;
        // Re-use (manage) this buffer to avoid allocating on every serialization   buffer.clear()
        LinkedBuffer buffer = LinkedBuffer.allocate(512);
        protostuff = ProtostuffIOUtil.toByteArray(userDO, userDOSchema, buffer);
        UserDO userDO2 = userDOSchema.newMessage();
        ProtostuffIOUtil.mergeFrom(protostuff, userDO2, userDOSchema);
    }
}
