package top.shixinzhang.mybatis.po;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Created by zhangshixin on 19/4/6.
 */
@Alias("Developer")
public class DeveloperModel {
    private int id;
    private String name;
    private String avatar;
    private String site;
    private Date registerTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}
