package com.calf.entity;

import java.util.Date;

/**
 * 类别实体类
 *
 * @author calf
 * @create 2017-03-15 12:29
 */
public class Category {

    private long id;
    private String name;
    private Date createAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
