package org.mvnsearch.protobuf;

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
}
