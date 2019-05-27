import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionJDBC {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "jU3y3gIV";

        Connection connection = connectJDBC(url, user, password);

        ArrayList<String> tablesSQL = new ArrayList<String>();
        tablesSQL.add("CREATE TABLE IF NOT EXISTS \"USER\"(\n" +
                "user_id serial PRIMARY KEY,\n" +
                "name varchar(50) UNIQUE NOT NULL,\n" +
                "birthday TIMESTAMP NOT NULL,\n" +
                "login_id TIMESTAMP NOT NULL,\n" +
                "city varchar(355) NOT NULL,\n" +
                "email varchar(355) UNIQUE NOT NULL,\n" +
                "description TEXT NOT NULL);");

        tablesSQL.add("CREATE TABLE IF NOT EXISTS \"ROLE\"(\n" +
                "role_id serial PRIMARY KEY,\n" +
                "name varchar(50) UNIQUE NOT NULL,\n" +
                "CHECK (name = 'Administration' OR name = 'Clients' OR name = 'Billing'),\n" +
                "description TEXT NOT NULL);");

        tablesSQL.add("CREATE TABLE IF NOT EXISTS \"USER_ROLE\"(\n" +
                "id INTEGER UNIQUE NOT NULL,\n" +
                "role_id integer NOT NULL,\n" +
                "user_id integer NOT NULL,\n" +
                "PRIMARY KEY (role_id, user_id),\t\n" +
                "CONSTRAINT USER_ROLE_user_id_fkey FOREIGN KEY (user_id)\n" +
                "\tREFERENCES \"USER\" (user_id) MATCH SIMPLE\n" +
                "\tON UPDATE NO ACTION ON DELETE NO ACTION,\n" +
                "CONSTRAINT ROLE_role_id_fkey FOREIGN KEY (role_id)\n" +
                "\tREFERENCES \"ROLE\" (role_id) MATCH SIMPLE\n" +
                "\tON UPDATE NO ACTION ON DELETE NO ACTION);");

        createTables(connection, tablesSQL);

        connection.close();
    }

    /* Connection - объект, который держит соединение с БД */
    public static Connection connectJDBC(String url, String user, String password) throws SQLException {
        Connection cn = null;
        DriverManager.registerDriver(new org.postgresql.Driver());
        cn = DriverManager.getConnection(url, user, password);
        return cn;
        //cn.close();
    }

    public static void createTables(Connection cn, ArrayList<String> tablesSQL) throws SQLException {
        PreparedStatement ps = null;
        for (String elem : tablesSQL){
            ps = cn.prepareStatement(elem);
            ps.executeUpdate();
        }
        ps.close();
    }

    /* Statement - объект, который выполняет запрос к БД */

    /* Result set - объект с результатом запроса */

}