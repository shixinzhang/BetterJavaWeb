package top.shixinzhang.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import top.shixinzhang.mybatis.db.DataConnection;
import top.shixinzhang.mybatis.po.DeveloperModel;

import java.io.IOException;

/**
 * Created by zhangshixin on 19/7/13.
 */
public class Test {
    private static DataConnection dataConnection = new DataConnection();

    public static void main(String[] args) {
        try {
            SqlSession sqlSession = dataConnection.getSqlSession();

            DeveloperModel user = sqlSession.selectOne("test.findUserById", 1);
            System.out.println("姓名：" + user.getName());

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
