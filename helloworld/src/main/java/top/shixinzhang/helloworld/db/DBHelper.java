package top.shixinzhang.helloworld.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zhangshixin on 19/4/6.
 */
public class DBHelper {
    public static final String URL = "jdbc:mysql://localhost:3306/helloworld";

    public static final String NAME = "com.mysql.jdbc.Driver";

    public static final String USER = "root";
    public static final String PASSWORD = "root";

    private Connection connection;
    public PreparedStatement preparedStatement;

    public DBHelper(String sql) {
        try {
            Class.forName(NAME);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.connection.close();
            this.preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
