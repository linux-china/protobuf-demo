package org.mvnsearch.protobuf;

import com.google.protobuf.Any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mvnsearch.user.UserPB;

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
}
