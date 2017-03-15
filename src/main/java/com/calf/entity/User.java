package com.calf.entity;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author calf
 * @create 2017-03-10 17:12
 */
public class User {
    private long id;
    private String account;
    private String name;
    private Date createAt;
    private Date loginAt;

    public void setId(long id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setLoginAt(Date loginAt) {
        this.loginAt = loginAt;
    }

    public long getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getLoginAt() {
        return loginAt;
    }
}
