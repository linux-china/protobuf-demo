package org.mvnsearch.protobuf;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class AccountDO implements java.io.Serializable {
    @ProtoField(number = 1)
    Integer id;
    @ProtoField(number = 2)
    String name;
    @ProtoField(number = 3)
    String email;
    @ProtoField(number = 4)
    String phone;


    public AccountDO() {
    }

    @ProtoFactory
    public AccountDO(Integer id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
