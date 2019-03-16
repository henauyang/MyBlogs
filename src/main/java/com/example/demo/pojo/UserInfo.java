package com.example.demo.pojo;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Created by zhuzhengping on 2017/4/22.
 * 实体类，可用于Controller中直接接受参数
 */
public class UserInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;


    private String title;

    private String bt;

    private String content;

//    @Max(value = 999999,message = "超过最大数值")
//    @Min(value = 000000,message = "密码设定不正确")
    private String ower;

    private Timestamp create_time;

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", bt='" + bt + '\'' +
                ", content='" + content + '\'' +
                ", ower='" + ower + '\'' +
                ", create_time=" + create_time +
                '}';
    }

    public UserInfo(Integer id, String title, String bt, String content, String ower,Timestamp create_time) {
        this.id = id;
        this.title = title;
        this.bt = bt;
        this.content = content;
        this.ower = ower;
        this.create_time=create_time;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBt() {
        return bt;
    }

    public void setBt(String bt) {
        this.bt = bt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwer() {
        return ower;
    }

    public void setOwer(String ower) {
        this.ower = ower;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}