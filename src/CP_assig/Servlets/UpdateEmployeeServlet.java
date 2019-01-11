package CP_assig.Servlets;

import CP_assig.Employee;
import CP_assig.SqlConnection;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UpdateEmployeeServlet extends HttpServlet {

    String userName = "eladTanaami";//add to constants
    String password = "1q2w3e";//add to constants
    String url = "jdbc:sqlserver://U-PC\\SQLEXPRESS:1433;databaseName=CheckPoint";//add to constants

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        int idFromParameter = Integer.parseInt(req.getParameter("id"));
        String firstNameFromParameter = "'"+ req.getParameter("firstName")+"'";
        String LastnameFromParameter =  "'"+req.getParameter("lastName")+"'";
        String emailAddressFromParameter =  "'"+req.getParameter("email")+"'";//add ID number
//       int idFromParameter =106;
//         firstNameFromParameter="'ami'";
        try {
            PrintWriter out = resp.getWriter();
            //add the employee to the data base
            SqlConnection dataBaseConnection = SqlConnection.InstansOfSqlConnection();
            Connection connServer = dataBaseConnection.getConection();
            Statement statement = connServer.createStatement();
//here need to update the data base
//            String queryString = "INSERT INTO Employees  (FirstName,LastName,Email) VALUES (" + queryParams +")";//add to constants
            if(idFromParameter>=100) {
                if (firstNameFromParameter.length() > 3) {
                    String sql = "UPDATE Employees " +
                            "SET FirstName ="+ firstNameFromParameter.toString()+ " WHERE id =" + idFromParameter;
                    statement.executeUpdate(sql);
                }
                if (LastnameFromParameter.length() > 3) {
                    String sql = "UPDATE Employees " +
                            "SET LastName ="+ LastnameFromParameter.toString()+"  WHERE id =" + idFromParameter;
                    statement.executeUpdate(sql);
                }
                if (emailAddressFromParameter.length() > 3) {
                    String sql = "UPDATE Employees " +
                            "SET Email = "+emailAddressFromParameter.toString()+"  WHERE id =" + idFromParameter;

                    statement.executeUpdate(sql);
                }
            }


            out.print(true);
        } catch (Exception e) {
//
        }

    }
}
