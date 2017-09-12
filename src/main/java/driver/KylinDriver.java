package driver;
import java.sql.*;
import java.util.Properties;

public class KylinDriver {

    public Statement connectToDatabase(String username, String password, String connectionPath) {
        try {
            Driver kylinDriver = (Driver) Class.forName("org.apache.kylin.jdbc.Driver").newInstance();
            Properties info = new Properties();
            info.put("user", username);
            info.put("password", password);
            Connection conn = kylinDriver.connect(connectionPath, info);
            return conn.createStatement();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void returnQueryResults(Statement statement, String query) {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                System.out.println(resultSet.getString(i));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
