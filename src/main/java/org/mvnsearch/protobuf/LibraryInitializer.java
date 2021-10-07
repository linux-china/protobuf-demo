package org.mvnsearch.protobuf;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(
        includeClasses = {
                AccountDO.class,
        },
        schemaFileName = "uic-account.proto",
        schemaFilePath = "/")
public interface LibraryInitializer extends SerializationContextInitializer {
}