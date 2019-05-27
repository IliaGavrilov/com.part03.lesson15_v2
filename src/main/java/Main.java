import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";

        //String url = "jdbc:oracle:thin:@//localhost:5432:postgres";
        String user = "postgres";
        //String password = "postgres";
        String password = "jU3y3gIV";

        /* Connection - объект, который держит соединение с БД */
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres");
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection cn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /* Statement - объект, который выполняет запрос к БД */

        /* Result set - объект с результатом запроса */

    }
}
