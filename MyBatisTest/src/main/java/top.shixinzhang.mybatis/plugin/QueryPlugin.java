package top.shixinzhang.mybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * Created by zhangshixin on 19/7/14.
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "query",
                args = {
                        MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
                }
        )
})
public class QueryPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("intercept");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("setProperties: " + properties);
    }
}
