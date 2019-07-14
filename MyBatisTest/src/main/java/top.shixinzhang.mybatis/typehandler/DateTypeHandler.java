package top.shixinzhang.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;

/**
 * Created by zhangshixin on 19/7/14.
 */
public class DateTypeHandler implements TypeHandler<java.util.Date> {
//public class DateTypeHandler extends BaseTypeHandler<java.util.Date> {


    /**
     * 为 sql 配置传入参数时调用，在参数传入 db 之前执行
     * @param preparedStatement
     * @param i
     * @param date
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, java.util.Date date, JdbcType jdbcType) throws SQLException {
        System.out.println("before setParameter");
        preparedStatement.setDate(i, new Date(date.getTime()));
        System.out.println("after setParameter");
    }

    /**
     * 供 select 方法使用，数据库返回结果时做转换
     * @param resultSet
     * @param s 字段名
     * @return
     * @throws SQLException
     */
    @Override
    public Date getResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("before getResult, String");
        return resultSet.getDate(s);
    }

    /**
     * 供 select 方法使用
     * @param resultSet
     * @param i 字段下标
     * @return
     * @throws SQLException
     */
    @Override
    public Date getResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("before getResult, int");
        return resultSet.getDate(i);
    }

    /**
     * 供存储过程使用
     * @param callableStatement
     * @param i 字段下标
     * @return
     * @throws SQLException
     */
    @Override
    public Date getResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("before getResult, callableStatement");
        return callableStatement.getDate(i);
    }
}
