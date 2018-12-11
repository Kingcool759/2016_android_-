package bean;

public class UserBean {
    private int user_id;
    private String user_name;
    private String password;
    private String user_phone;

    public UserBean(int user_id, String user_name, String password, String user_phone) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.user_phone = user_phone;
    }

    public UserBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

}
