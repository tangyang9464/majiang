package web.majiang.DTO;

public class GitHubUser {
    private String username;
    private Long id;
    private String uuid;
    private String avatar;

    public GitHubUser(String username, Long id, String uuid, String avatar) {
        this.username = username;
        this.id = id;
        this.uuid = uuid;
        this.avatar = avatar;
    }

    public String getusername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public String getuuid() {
        return uuid;
    }

    public String getavatar() {
        return avatar;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setuuid(String uuid) {
        this.uuid = uuid;
    }

    public void setavatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", uuid='" + uuid + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
