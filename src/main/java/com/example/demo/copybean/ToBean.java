package com.example.demo.copybean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/4 11:32
 * @description :
 */

public class ToBean {

    private String id;
    private String name;

    private Integer age;

    private Date createTime;

    private BigDecimal money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
