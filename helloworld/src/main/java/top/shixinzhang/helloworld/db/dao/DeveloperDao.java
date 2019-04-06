package top.shixinzhang.helloworld.db.dao;

import top.shixinzhang.helloworld.db.DBHelper;
import top.shixinzhang.helloworld.db.model.DeveloperModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangshixin on 19/4/6.
 */
public class DeveloperDao {
    public List<DeveloperModel> getAllDevelopers() {
        List<DeveloperModel> developerList = new ArrayList<>();
        String sql = "select * from developer";
        DBHelper dbHelper = new DBHelper(sql);
        ResultSet resultSet = null;
        try {
            resultSet = dbHelper.preparedStatement.executeQuery();
            while (resultSet.next()) {
                developerList.add(buildDeveloperModel(resultSet));
            }
            resultSet.close();
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developerList;
    }

    public DeveloperModel getDeveloper(String developerId) {
        String sql = "select * from developer where id=" + developerId;
        DBHelper dbHelper = new DBHelper(sql);
        DeveloperModel developerModel = null;
        try {
            ResultSet resultSet = dbHelper.preparedStatement.executeQuery();
            if (resultSet.next()) {
                developerModel = buildDeveloperModel(resultSet);
            }
            resultSet.close();
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developerModel;
    }

    private DeveloperModel buildDeveloperModel(ResultSet resultSet) throws SQLException {

        //查询结果里的字段要和数据库里的顺序一致
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String avatar = resultSet.getString(3);
        String site = resultSet.getString(4);

        DeveloperModel developerModel = new DeveloperModel();
        developerModel.setId(id);
        developerModel.setName(name);
        developerModel.setSite(site);
        developerModel.setAvatar(avatar);
        return developerModel;
    }

    public boolean addDeveloper(DeveloperModel developerModel) {
        String sql = "INSERT INTO developer(name,site,avatar) VALUES(" +
                "'" + developerModel.getName() + "'," +
                "'" + developerModel.getSite() + "'," +
                "'" + developerModel.getAvatar() + "'" + ");";
        System.out.println("sql=" + sql);
        DBHelper dbHelper = new DBHelper(sql);
        return execute(dbHelper);
    }

    private boolean execute(DBHelper dbHelper) {
        try {
            dbHelper.preparedStatement.execute();
            dbHelper.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDeveloper(String id, String name) {
        String sql = "UPDATE developer SET name='" + name + "' WHERE id=" + id;
        System.out.println("sql=" + sql);
        DBHelper dbHelper = new DBHelper(sql);
        try {
            dbHelper.preparedStatement.executeUpdate();
            dbHelper.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDeveloper(String id) {
        String sql = "DELETE FROM developer WHERE id=" + id;
        System.out.println("sql=" + sql);
        DBHelper dbHelper = new DBHelper(sql);
        return execute(dbHelper);
    }
}
