import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        //String url = "jdbc:postgresql://localhost:5432/postgres";
        String url = "jdbc:oracle:thin:@//localhost:5432:postgres";

        /* Connection - объект, который держит соединение с БД */
        try {
            Connection cn =
                    DriverManager.getConnection(url,
                    "postgres", "jU3y3gIV");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        /* Statement - объект, который выполняет запрос к БД */

        /* Result set - объект с результатом запроса */

    }
}
