package top.shixinzhang.mybatis.po;

import java.io.Serializable;

/**
 * Created by zhangshixin on 19/7/11.
 */
public class User implements Serializable {
    private int id;
    private String username;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
