import java.sql.*;
import java.util.Scanner;

public class JDBC3
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","");
        PreparedStatement ps = con.prepareStatement("insert into EMP values (?,?)");

        int i=2;
        while(i>0)
        {
            ps.setInt(2,sc.nextInt());
            ps.setString(1,sc.nextLine());

            i--;
            System.out.println("_________________");
            ps.executeUpdate();
        }
        ResultSet rs=ps.executeQuery("select * from `EMP`");
        while(rs.next())
        {
            System.out.println(rs.getString("Name") + " "+ rs.getInt("Rollno"));
        }
        con.close();

    }
}
