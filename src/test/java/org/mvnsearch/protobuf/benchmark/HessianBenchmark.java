package org.mvnsearch.protobuf.benchmark;

import com.caucho.hessian.io.HessianSerializerInput;
import com.caucho.hessian.io.HessianSerializerOutput;
import jmh.mbr.junit5.Microbenchmark;
import org.mvnsearch.protobuf.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * hessian benchmark
 *
 * @author linux_china
 */
@Microbenchmark
public class HessianBenchmark extends BaseBenchmark {

    @Benchmark
    public void benchmark() throws Exception {
        decode(encode(userDO));
    }


    public static byte[] encode(Object obj) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(256);
        HessianSerializerOutput output = new HessianSerializerOutput(bos);
        output.writeObject(obj);
        output.flush();
        return bos.toByteArray();

    }

    public static Object decode(byte[] content) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(content);
        HessianSerializerInput input = new HessianSerializerInput(bis);
        return input.readObject();

    }
}
