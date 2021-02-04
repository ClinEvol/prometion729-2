package com.ujiuye.prometion.pojo;
//年龄分布
public class AgeDistribution {
    private Integer count;
    private String name;

    public AgeDistribution(Integer count, String name) {
        this.count = count;
        this.name = name;
    }

    public AgeDistribution() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
