package org.mvnsearch.protobuf;

import io.protostuff.Tag;

import java.io.Serializable;

/**
 * User javabean
 *
 * @author linux_china
 */
public class UserDO implements Serializable {
    @Tag(1)
    private Integer id;
    @Tag(2)
    private String name;
    @Tag(3)
    private String email;
    @Tag(4)
    private String phone;

    public UserDO() {
    }

    public UserDO(Integer id, String name, String email, String phone) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
