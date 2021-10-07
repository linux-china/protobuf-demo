package org.mvnsearch.protobuf;


import com.google.protobuf.TextFormat;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mvnsearch.user.UserPB;

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

    @Test
    public void testWithNative() {
        UserPB user = UserPB.newBuilder()
                .setId(1)
                .setName("Jackie")
                .setEmail("demo@demo.com")
                .setPhone("186").build();
        byte[] pbBytes = user.toByteArray();
        UserDO userDO = userDOSchema.newMessage();
        ProtostuffIOUtil.mergeFrom(pbBytes, userDO, userDOSchema);
        System.out.println(userDO.getName());
    }

    @Test
    public void testGenerateProtobufIdl() {
        RuntimeSchema<UserDO> userDORuntimeSchema = (RuntimeSchema<UserDO>) userDOSchema;
        System.out.println("syntax = \"proto3\";");
        System.out.println("package " + UserDO.class.getPackage().getName() + ";");
        System.out.println("message " + UserDO.class.getSimpleName() + " {");
        userDORuntimeSchema.getFields().forEach(userDOField -> {
            System.out.println("    " + userDOField.type.name().toLowerCase() + " " + userDOField.name + " = " + userDOField.number + ";");
        });
        System.out.println("}");
    }
}
