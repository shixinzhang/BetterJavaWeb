package top.shixinzhang.mybatis.po;

import org.apache.ibatis.type.Alias;

/**
 * Created by zhangshixin on 19/4/6.
 */
@Alias("Developer")
public class DeveloperModel {
    private int id;
    private String name;
    private String avatar;
    private String site;

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
}
