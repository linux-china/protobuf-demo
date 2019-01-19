package org.mvnsearch.protobuf;


import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * protostuff test
 *
 * @author linux_china
 */
public class ProtostuffTest {
    private static Schema<UserDO> userDOSchema = RuntimeSchema.getSchema(UserDO.class);

    @Test
    public void testEncodingDecoding() {
        UserDO userDO = new UserDO(1, "Jackie", "demo@demo.com", "186");
        final byte[] protostuff;
        // Re-use (manage) this buffer to avoid allocating on every serialization   buffer.clear()  performance still good
        LinkedBuffer buffer = LinkedBuffer.allocate(256);
        protostuff = ProtostuffIOUtil.toByteArray(userDO, userDOSchema, buffer);
        UserDO userDO2 = userDOSchema.newMessage();
        ProtostuffIOUtil.mergeFrom(protostuff, userDO2, userDOSchema);
        System.out.println(userDO2.getName());
        Assertions.assertEquals(userDO.getName(), userDO2.getName());
    }
}
