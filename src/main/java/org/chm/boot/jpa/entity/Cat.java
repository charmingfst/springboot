package org.chm.boot.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by charming on 2017/7/3.
 */
@Entity
public class Cat {
    /**
     * 主键:
     * 使用@Id指定主键。
     *
     * 生成策略:
     * 使用代码@GeneratedValue(strategy=GenerationType.AUTO)
     * 指定主键的生成策略,MySQL默认为自增长。
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;// 主键

    private String catName;// 姓名，默认生成字段名cat_name

    private int catAge;// 年龄，默认生成字段名cat_age

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
