package model;

public class PostsBuilder {

    private String title;

    private String body;

    public PostsBuilder title(String title) {
        this.title = title;
        return this;
    }

    public PostsBuilder body(String body) {
        this.body = body;
        return this;
    }

    public Posts build() {
        return new Posts(title, body);
    }
}
