package org.mvnsearch.protobuf;


import org.infinispan.protostream.ProtobufTagMarshaller;
import org.infinispan.protostream.SerializationContext;
import org.infinispan.protostream.config.Configuration;
import org.infinispan.protostream.impl.SerializationContextImpl;
import org.infinispan.protostream.impl.TagReaderImpl;
import org.infinispan.protostream.impl.TagWriterImpl;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

public class ProtoStreamTest {

    @Test
    public void testProtoStream() throws Exception {
        AccountDO accountDO = new AccountDO(1, "demo");
        final SerializationContext serCtx = serializationContext();
        final ProtobufTagMarshaller<AccountDO> marshaller = (ProtobufTagMarshaller<AccountDO>) serCtx.getMarshaller(AccountDO.class);
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final TagWriterImpl writer = TagWriterImpl.newInstance(serCtx, bos);
        marshaller.write(writer, accountDO);
        writer.flush();
        System.out.println(bos.toByteArray().length);
        final AccountDO accountDO2 = marshaller.read(TagReaderImpl.newInstance(serCtx, bos.toByteArray()));
        System.out.println(accountDO2.getName());
    }

    public SerializationContext serializationContext() {
        final Configuration configuration = Configuration.builder().build();
        SerializationContext serCtx = new SerializationContextImpl(configuration);
        LibraryInitializer libraryInitializer = new LibraryInitializerImpl();
        libraryInitializer.registerMarshallers(serCtx);
        return serCtx;
    }
}
