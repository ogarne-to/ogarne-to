package to.ogarne.ogarneblog.web;

public class PostContent {

    String content = "";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostContent(ContentBuilder builder) {
        this.content = builder.content;


    }
}
