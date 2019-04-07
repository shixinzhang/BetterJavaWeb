package top.shixinzhang.springmvc.dao;

import top.shixinzhang.springmvc.model.DeveloperModel;

import java.util.List;

/**
 * Created by zhangshixin on 19/4/7.
 */
public interface DeveloperDao {
    List<DeveloperModel> getAllDevelopers();

    DeveloperModel getDeveloperInfo(String id);

    boolean addDeveloper(DeveloperModel developerModel);

    boolean deleteDeveloper(DeveloperModel developerModel);
}
