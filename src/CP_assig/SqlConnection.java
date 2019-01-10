package CP_assig;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {

    public Connection getConection() {
        return conection;
    }

    private Connection conection = null;
    private static SqlConnection single_sqlConnection = null;
    private String userName = "eladTanaami";
    private String password = "1q2w3e";
    private String url = "jdbc:sqlserver://U-PC\\SQLEXPRESS:1433;databaseName=CheckPoint";

    public static SqlConnection InstansOfSqlConnection() {
        if (single_sqlConnection == null) {
            single_sqlConnection = new SqlConnection();
        }
        return single_sqlConnection;
    }


    private SqlConnection() {


        this.userName = "eladTanaami";
        this.password = "1q2w3e";
        this.url = "jdbc:sqlserver://U-PC\\SQLEXPRESS:1433;databaseName=CheckPoint";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conn = DriverManager.getConnection(url,
                    userName, password);
            System.out.println("connected");
            this.conection = conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public  dbConnect(String db_connect_string,
//                               String db_userid,
//                               String db_password)
//    {
//        db_connect_string=url;
//        db_userid=userName;
//        db_password=password;
//        ResultSet rs=null;
//        try {
//
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//            Connection conn = DriverManager.getConnection(db_connect_string,
//                    db_userid, db_password);
//
//            System.out.println("connected");
//            Statement statement = conn.createStatement();
//            String queryString = "select * from Employees";
//            rs = statement.executeQuery(queryString);
//
////            while (rs.next()) {
////                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }
//    public static void main(String[] args)
//    {
//        ConnectMSSQLServer connServer = new ConnectMSSQLServer();
//        connServer.dbConnect("jdbc:sqlserver://&lt;hostname&gt;", "&lt;user&gt;",
//                "&lt;password&gt;");
//    }
}
