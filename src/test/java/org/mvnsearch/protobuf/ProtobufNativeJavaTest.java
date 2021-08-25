package org.mvnsearch.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.TextFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mvnsearch.user.UserPB;

import java.util.Map;

/**
 * Protobuf native java test
 *
 * @author linux_china
 */
public class ProtobufNativeJavaTest {

    @Test
    public void testEncodingDecoding() throws Exception {
        UserPB user = UserPB.newBuilder()
                .setId(1)
                .setName("Jackie")
                .setEmail("demo@demo.com")
                .setPhone("186").build();
        System.out.println(TextFormat.printer().printToString(user));
        byte[] pbBytes = user.toByteArray();
        UserPB pbUser = UserPB.parseFrom(pbBytes);
        System.out.println(pbUser.getName());
        Assertions.assertEquals(pbUser.getName(), user.getName());
    }

    @Test
    public void testAnyType() throws Exception {
        UserPB user = UserPB.newBuilder()
                .setId(1)
                .setName("Jackie")
                .setEmail("demo@demo.com")
                .setPhone("186").build();
        Any any1 = Any.pack(user);
        Any any = Any.parseFrom(any1.toByteArray());
        UserPB user2 = any.unpack(UserPB.class);
        System.out.println(user2.getName());
    }

    @Test
    public void testMetadata() {
        final Descriptors.Descriptor descriptor = UserPB.getDescriptor();
        final DescriptorProtos.MessageOptions options = descriptor.getOptions();
        final Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
        for (Descriptors.FieldDescriptor fieldDescriptor : allFields.keySet()) {
            final Object field = descriptor.getOptions().getField(fieldDescriptor);
            System.out.println(field);
        }
        for (Descriptors.FieldDescriptor field : descriptor.getFields()) {
            System.out.println(field.getName());
        }
    }
}
