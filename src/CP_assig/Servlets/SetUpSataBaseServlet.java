//package CP_assig.Servlets;
//
//import CP_assig.Employee;
//import CP_assig.SqlConnection;
//import com.google.gson.Gson;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//public class SetUpSataBaseServlet extends HttpServlet {
//
//    String userName = "eladTanaami";//add to constants
//    String password = "1q2w3e";//add to constants
//    String url = "jdbc:sqlserver://U-PC\\SQLEXPRESS:1433;databaseName=CheckPoint";//add to constants
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//
//        try {
//
//            SqlConnection dataBaseConnection =new SqlConnection(userName,password,url);
//
//
//        } catch (Exception e) {
////
//        }
//    }
//}
