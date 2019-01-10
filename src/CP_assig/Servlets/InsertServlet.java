package CP_assig.Servlets;

import CP_assig.SqlConnection;
import CP_assig.Employee;
import com.google.gson.Gson;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;




@WebServlet(name = "InsertServlet" , urlPatterns = "/InsertServlet")

public class InsertServlet extends HttpServlet{

    String userName = "eladTanaami";//add to constants
    String password = "1q2w3e";//add to constants
    String url = "jdbc:sqlserver://U-PC\\SQLEXPRESS:1433;databaseName=CheckPoint";//add to constants

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
//        UsersManager userManager = Ex03.Utils.ServletUtils.getUserManager(getServletContext());
        resp.setContentType("application/json");
//                ResultSet rs=null;

        try {
            PrintWriter out = resp.getWriter();

            SqlConnection dataBaseConnection = SqlConnection.InstansOfSqlConnection();
            Connection connServer = dataBaseConnection.getConection();
            Statement statement = connServer.createStatement();
            String queryString = "select * from Employees";//add to constants
            ResultSet rs = statement.executeQuery(queryString);

            ArrayList<Employee> employeesList = new ArrayList<>();
            while (rs.next()) {
                employeesList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
//            employeesList.add(new Employee(53,"dan","shallom","dfs@gmail.com"));
//            employeesList.add(new Employee(23,"dani","dayan","fdg@gmail.com"));
            Gson json = new Gson();
//            Set<String> usersList = getEmployees();

              out.println(json.toJson(employeesList));
            out.flush();
        } catch (Exception e) {
//
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

//get data from the form

        String firstNameFromParameter = req.getParameter("firstName");
        String LastnameFromParameter = req.getParameter("lastName");
        String emailAddressFromParameter = req.getParameter("email");
        String queryParams =firstNameFromParameter+","+LastnameFromParameter +"," +emailAddressFromParameter;
//add ID number
        try {
            PrintWriter out = resp.getWriter();
        //add the employee to the data base
        SqlConnection dataBaseConnection = SqlConnection.InstansOfSqlConnection();
        Connection connServer = dataBaseConnection.getConection();
        Statement statement = connServer.createStatement();
//            " insert into users (first_name, last_name, date_created, is_admin, num_points)"
//                    + " values (?, ?, ?, ?, ?)";
        String queryString = "insert into Employees (firsName,lastName,email) values (queryParams)";//add to constants
        ResultSet rs = statement.executeQuery(queryString);
            resp.setContentType("text/html");
            resp.sendRedirect( "http://localhost:8080/index.html");
//           out.print(true);
        } catch (Exception e) {
//
        }

    }
}
