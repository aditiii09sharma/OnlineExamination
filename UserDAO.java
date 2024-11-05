import java.sql.*;

public class UserDAO {
    public static boolean validate(String username, String password) {
        try (Connection con = DBUtil.getConnection();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updatePassword(String username, String newPassword) {
        try (Connection con = DBUtil.getConnection();
             PreparedStatement pst = con.prepareStatement("UPDATE users SET password=? WHERE username=?")) {
            pst.setString(1, newPassword);
            pst.setString(2, username);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
