package org.chm.boot.mybatis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by charming on 2017/7/3.
 */
public class Cat {

    private int id;// 主键

    private String catName;

    private int catAge;

    public Cat(int id) {
        this.id = id;
    }

    public Cat(String catName, int catAge) {
        this.catName = catName;
        this.catAge = catAge;
    }

    //mybatis查询结果需要的构造函数
    public Cat(int id, String catName, int catAge ) {
        this.id = id;
        this.catName = catName;
        this.catAge = catAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatAge() {
        return catAge;
    }

    public void setCatAge(int catAge) {
        this.catAge = catAge;
    }
}
