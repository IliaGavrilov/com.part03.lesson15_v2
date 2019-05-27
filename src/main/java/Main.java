//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//
//public class Main {
//
//    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        String user = "postgres";
//        String password = "jU3y3gIV";
//
//        DriverManager.registerDriver(new org.postgresql.Driver());
//        Connection cn = null;
//        /* Connection - объект, который держит соединение с БД */
//        try {
//            cn = DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        //if exist
//
//        /* Statement - объект, который выполняет запрос к БД */
//
//        /* Result set - объект с результатом запроса */
//
//        cn.close();
//
//    }
//}
