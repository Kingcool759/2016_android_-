package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User_detailsBean;

public class User_detailsDao {
    /**
     * 获得用户详情方法
     */
    public User_detailsBean getDetails(int user_id) {
        Connection conn = DataBase.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert user_details(user_id,user_nickname,user_sex,user_age,user_school)values(?,?,?,?,?)";
        String sql2 = "Select * from user_details where user_id='" + user_id + "'";
        String sql_select = "select * from user_details where user_id='" + user_id + "'";
        User_detailsBean udbean = new User_detailsBean();
        try {
            // 查找有没有该user_id,没有就插入一条数据
            pstmt = conn.prepareStatement(sql_select);
            ResultSet r2 = pstmt.executeQuery();
            if (!r2.next()) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, user_id);
                pstmt.setString(2, "");
                pstmt.setString(3, "");
                pstmt.setString(4, "");
                pstmt.setString(5, "");
                pstmt.executeUpdate();
                udbean.setUser_nickname("");
                udbean.setUser_sex("");
                udbean.setUser_age(0);
                udbean.setUser_school("");
            } else {
                // 有就获得数据
                pstmt = conn.prepareStatement(sql2);
                ResultSet rs = pstmt.executeQuery();
                udbean.setUser_nickname(r2.getString("user_nickname"));
                udbean.setUser_sex(r2.getString("user_sex"));
                udbean.setUser_age(r2.getInt("user_age"));
                udbean.setUser_school(r2.getString("user_school"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return udbean;
    }

    /**
     * 保存用户详情方法
     */
    public void saveDetails(int user_id, String user_nickname, String user_sex, int user_age, String user_school) {
        Connection conn = DataBase.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert user_details(user_id,user_nickname,user_sex,user_age,user_school)values(?,?,?,?,?)";
        String sql2 = "update user_details set user_nickname=?,user_sex=?,user_age=?,user_school=? where user_id=?";
        String sql_select = "select * from user_details where user_id='" + user_id + "'";
        try {
            // 查找有没有该user_id,没有就插入一条数据
            pstmt = conn.prepareStatement(sql_select);
            ResultSet r2 = pstmt.executeQuery();
            if (!r2.next()) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, user_id);
                pstmt.setString(2, user_nickname);
                pstmt.setString(3, user_sex);
                pstmt.setInt(4, user_age);
                pstmt.setString(5, user_school);
                pstmt.executeUpdate();
            } else {
                // 有就修改数据
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, user_nickname);
                pstmt.setString(2, user_sex);
                pstmt.setInt(3, user_age);
                pstmt.setString(4, user_school);
                pstmt.setInt(5, user_id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
