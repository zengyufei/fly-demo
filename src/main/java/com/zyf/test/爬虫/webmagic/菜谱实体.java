package com.zyf.test.爬虫.webmagic;

import com.alibaba.fastjson.JSONObject;
import io.ebean.Model;
import io.ebean.annotation.DbComment;

import javax.persistence.*;

@Entity
@Table(name = "caidan")
@DbComment("菜单")
public class 菜谱实体 extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DbComment("菜单标题")
    private String title;

    @DbComment("菜单打分")
    private double scope;

    @DbComment("菜单点餐次数")
    private int personNumb;

    @DbComment("菜单图片路径")
    private String imgSrc;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getScope() {
        return scope;
    }

    public void setScope(double scope) {
        this.scope = scope;
    }

    public int getPersonNumb() {
        return personNumb;
    }

    public void setPersonNumb(int personNumb) {
        this.personNumb = personNumb;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}