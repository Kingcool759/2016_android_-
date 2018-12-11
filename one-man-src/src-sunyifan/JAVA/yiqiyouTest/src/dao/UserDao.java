package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    /**
     * 注册用户方法(返回-1表示该用户已存在，返回1表示注册成功);
     */
    public int adduser(String user_name, String password, String user_phone) {
        Connection conn = DataBase.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert user(user_id,user_name,password,user_phone)values(?,?,?,?)";
        String sql2 = "select * from user";
        String sql_select = "select * from user where user_name='" + user_name + "'";
        try {
            // 查找有没有重复的user_name
            pstmt = conn.prepareStatement(sql_select);
            ResultSet r2 = pstmt.executeQuery();
            if (r2.next()) {
                return -1;
            }
            // 找到最小的可以接收的user_id
            int count = 0;
            pstmt = conn.prepareStatement(sql2);
            ResultSet r = pstmt.executeQuery();
            while (r.next() && count + 1 == r.getInt("user_id")) {
                count = r.getInt("user_id");
            }
            count++;
            // 加入新用户
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, count);
            pstmt.setString(2, user_name);
            pstmt.setString(3, password);
            pstmt.setString(4, user_phone);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 根据user_name查找user_id
     */
    public int selectuid(String user_name) {
        Connection conn = DataBase.getConnection();
        int user_id = 0;
        PreparedStatement pstmt = null;
        String sql = "select * from user where user_name='" + user_name + "'";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user_id = rs.getInt("user_id");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user_id;
    }

    /**
     * 验证登录
     */
    public String verifyUser(String user_name, String password) {
        Connection conn = DataBase.getConnection();
        PreparedStatement pstmt = null;
        String sql = "select user_name,password from user where user_name='" + user_name + "'";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    return "登录成功！";
                } else {
                    return "密码错误！";
                }
            } else {
                return "该用户不存在！";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
}
