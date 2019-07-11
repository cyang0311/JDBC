package JDBC;

public class Users {
    private Integer id;
    private String uname;
    private String pwd;
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Users(Integer id, String uname, String pwd, String sex) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.sex = sex;
    }
     public Users(){

     }
}
