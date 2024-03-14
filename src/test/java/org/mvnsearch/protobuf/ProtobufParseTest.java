package org.mvnsearch.protobuf;

import io.protostuff.compiler.model.Message;
import io.protostuff.compiler.model.Proto;
import io.protostuff.compiler.parser.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.Collections;
import java.util.List;

public class ProtobufParseTest {

    @Test
    public void testParse() throws Exception {
        String protobufText = "syntax = \"proto3\";\n" +
                "\n" +
                "package org.mvnsearch.person;\n" +
                "\n" +
                "message Person {\n" +
                "  optional string name = 1;\n" +
                "  optional int32 id = 2;\n" +
                "  optional string email = 3;\n" +
                "}\n";
        CharStream charStream = CharStreams.fromReader(new StringReader(protobufText));
        Importer importer = new ImporterImpl(new FileDescriptorLoaderImpl(new ParseErrorLogger(), Collections.emptySet()));
        ProtoContext protoContext = importer.importFile(name -> charStream, "demo.proto");
        Proto proto = protoContext.getProto();
        List<Message> messages = proto.getMessages();
        for (Message message : messages) {
            System.out.println(message.getName());
            System.out.println(message.toString());
        }
    }
}
