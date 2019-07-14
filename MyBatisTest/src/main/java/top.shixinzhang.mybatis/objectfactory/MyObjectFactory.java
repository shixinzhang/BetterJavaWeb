package top.shixinzhang.mybatis.objectfactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import top.shixinzhang.mybatis.po.DeveloperModel;

import java.util.List;
import java.util.Properties;

/**
 * Created by zhangshixin on 19/7/14.
 */
public class MyObjectFactory extends DefaultObjectFactory {
    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    /**
     * 上面的 create 方法也会调用这个方法
     *
     * @param type
     * @param constructorArgTypes
     * @param constructorArgs
     * @param <T>
     * @return
     */
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T t = super.create(type, constructorArgTypes, constructorArgs);

        if (DeveloperModel.class.isAssignableFrom(type)) {
            DeveloperModel developerModel = (DeveloperModel) t;
            developerModel.print();
        }

        return t;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("setProperties: " + properties);
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
