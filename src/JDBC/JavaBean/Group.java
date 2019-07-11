package JDBC.JavaBean;

public class Group {
    private Integer id;
    private Integer userId;
    private String groupName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Group(Integer id, Integer userId, String groupName) {
        this.id = id;
        this.userId = userId;
        this.groupName = groupName;
    }

    public Group() {
    }
}
