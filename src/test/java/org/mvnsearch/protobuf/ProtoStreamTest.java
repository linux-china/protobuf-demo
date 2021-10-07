package org.mvnsearch.protobuf;


import org.infinispan.protostream.ProtobufUtil;
import org.infinispan.protostream.SerializationContext;
import org.junit.jupiter.api.Test;

public class ProtoStreamTest {

    @Test
    public void testProtoStream() throws Exception {
        final SerializationContext serCtx = ProtobufUtil.newSerializationContext();
        new LibraryInitializerImpl().registerMarshallers(serCtx);
        AccountDO accountDO = new AccountDO(1, "leijuan", "linux_china@hotmail.com", "186");
        final byte[] bytes = ProtobufUtil.toByteArray(serCtx, accountDO);
        AccountDO accountDO2 = ProtobufUtil.fromByteArray(serCtx, bytes, AccountDO.class);
        System.out.println(accountDO2.getName());
    }
}
