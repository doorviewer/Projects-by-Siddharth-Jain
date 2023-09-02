import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectC {

    static Connection con;
    public static Connection createC(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // load driver
            String user = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/lms_main";
            con = DriverManager.getConnection(url,user,password);  // create connection
        } catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
