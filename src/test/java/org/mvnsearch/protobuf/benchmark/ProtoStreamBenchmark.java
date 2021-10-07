package org.mvnsearch.protobuf.benchmark;

import jmh.mbr.junit5.Microbenchmark;
import org.infinispan.protostream.ProtobufUtil;
import org.infinispan.protostream.SerializationContext;
import org.mvnsearch.protobuf.AccountDO;
import org.mvnsearch.protobuf.BaseBenchmark;
import org.mvnsearch.protobuf.LibraryInitializerImpl;
import org.openjdk.jmh.annotations.Benchmark;

@Microbenchmark
public class ProtoStreamBenchmark extends BaseBenchmark {
    private static SerializationContext serCtx = serializationContext();

    @Benchmark
    public void benchmark() throws Exception {
        final byte[] bytes = ProtobufUtil.toByteArray(serCtx, accountDO);
        ProtobufUtil.fromByteArray(serCtx, bytes, AccountDO.class);
    }

    private static SerializationContext serializationContext() {
        final SerializationContext serCtx = ProtobufUtil.newSerializationContext();
        new LibraryInitializerImpl().registerMarshallers(serCtx);
        return serCtx;
    }

}
