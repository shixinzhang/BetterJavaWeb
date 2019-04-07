package top.shixinzhang.springmvc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import top.shixinzhang.springmvc.model.DeveloperModel;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangshixin on 19/4/7.
 */
@Repository("developerDaoImpl")
public class DeveloperDaoImpl implements DeveloperDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DeveloperModel> getAllDevelopers() {
        String sql = "select * from developer";
        return query(sql);
    }

    @Override
    public DeveloperModel getDeveloperInfo(String id) {
        String sql = "select * from developer where id=" + id;
        List<DeveloperModel> developerModels = query(sql);
        if (developerModels == null || developerModels.isEmpty()) {
            return null;
        }

        return developerModels.get(0);
    }

    @Override
    public boolean addDeveloper(DeveloperModel developerModel) {
        String sql = "INSERT INTO developer(name,avatar,site) VALUES(" +
                "'" + developerModel.getName() + "'," +
                "'" + developerModel.getAvatar() + "'," +
                "'" + developerModel.getSite() + "')";

        System.out.println("sql: " + sql);

        try {
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteDeveloper(DeveloperModel developerModel) {
        String sql = "UDPATE developer SET name='" + developerModel.getName() + "' WHERE id=" + developerModel.getId();

        System.out.println("sql: " + sql);

        try {
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private List<DeveloperModel> query(String sql) {
        final List<DeveloperModel> developerModelList = new ArrayList<>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                developerModelList.add(buildDeveloperModel(resultSet));
            }
        });
        return developerModelList;
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
}
