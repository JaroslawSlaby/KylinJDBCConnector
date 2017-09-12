import driver.KylinDriver;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        KylinDriver kylinDriver = new KylinDriver();
        Statement statement = kylinDriver.connectToDatabase("admin", "KYLIN", "jdbc:kylin://localhost:7070/test");
        kylinDriver.returnQueryResults(statement, "select * from test");
    }
}

