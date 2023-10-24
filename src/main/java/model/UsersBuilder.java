package model;

public class UsersBuilder {
    private Long id;
    private String name;
    private String gender;

    private String email;

    private String status;

    public UsersBuilder id(Long id) {
        this.id = id;
        return this;

    }

    public UsersBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UsersBuilder gender(String gender) {
        this.gender = gender;

        return this;
    }

    public UsersBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UsersBuilder status(String status) {
        this.status = status;
        return this;
    }

    public Users build() {
        return new Users(id, name, email, gender, status);
    }

}
