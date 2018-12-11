package bean;

public class User_detailsBean {
    private int user_id;
    private String user_nickname;
    private String user_sex;
    private int user_age;
    private String user_school;
    private String user_signature;

    public User_detailsBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User_detailsBean(int user_id, String user_nickname, String user_sex, int user_age, String user_school,
        String user_signature) {
        super();
        this.user_id = user_id;
        this.user_nickname = user_nickname;
        this.user_sex = user_sex;
        this.user_age = user_age;
        this.user_school = user_school;
        this.user_signature = user_signature;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_school() {
        return user_school;
    }

    public void setUser_school(String user_school) {
        this.user_school = user_school;
    }

    public String getUser_signature() {
        return user_signature;
    }

    public void setUser_signature(String user_signature) {
        this.user_signature = user_signature;
    }

}
