package top.shixinzhang.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import top.shixinzhang.mybatis.db.DataConnection;
import top.shixinzhang.mybatis.po.DeveloperModel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by zhangshixin on 19/7/13.
 */
public class Test {
    private static DataConnection dataConnection = new DataConnection();

    public static void main(String[] args) {
//        testConnect();

//        testFuzzySearch();

        testInsert();

//        testDelete();

//        testUpdate();
    }

    private static void testUpdate() {
        try {
            SqlSession sqlSession = dataConnection.getSqlSession();
            DeveloperModel model = new DeveloperModel();
            model.setId(12);
            model.setName("仰望星空的张拭心222");

            sqlSession.update("test.updateUserName", model);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testDelete() {
        try {
            SqlSession sqlSession = dataConnection.getSqlSession();
            int delete = sqlSession.delete("test.deleteUser", 11);
            sqlSession.commit();
            System.out.println("delete return:" + delete);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testInsert() {
        try {
            SqlSession sqlSession = dataConnection.getSqlSession();
            DeveloperModel model = new DeveloperModel();
            model.setName("张拭心的 CSDN");
            model.setSite("https://blog.csdn.net/u011240877");
            model.setAvatar("https://avatar.csdn.net/2/E/3/3_u011240877.jpg");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            model.setRegisterTime(dateFormat.parse("2019-07-14"));

//            sqlSession.insert("test.insertUser", model);
            sqlSession.insert("test.insertUserWidthTypeHandler", model);

            sqlSession.commit();

            System.out.println("id:" + model.getId());
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模糊查询
     */
    private static void testFuzzySearch() {
        try {
            SqlSession sqlSession = dataConnection.getSqlSession();
            //mapper nameSpace.id
            List<DeveloperModel> modelList = sqlSession.selectList("test.findUserByUserName", "心");
            for (int i = 0; i < modelList.size(); i++) {
                DeveloperModel developerModel = modelList.get(i);
                printDeveloperInfo(developerModel);
            }

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testConnect() {

        try {
            SqlSession sqlSession = dataConnection.getSqlSession();

            DeveloperModel user = sqlSession.selectOne("test.findUserById", 1);
            printDeveloperInfo(user);

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDeveloperInfo(DeveloperModel user) {
        System.out.println("姓名：" + user.getName());
        System.out.println("头像：" + user.getAvatar());
        System.out.println("网站：" + user.getSite());
    }
}
