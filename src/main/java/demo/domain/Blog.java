package demo.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 002559 on 2018/8/29.
 */
@Document(indexName = "blog", type = "blog")
public class Blog implements Serializable{

    @Id
    private String id;
    private String title;
    private String tag;
    private String content;

    protected Blog(){};

    public Blog(String title, String tag, String content) {
        this.title = title;
        this.tag = tag;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(
                "Blog[id='%s', title='%s', tag='%s', content='%s']",
                id, title, tag, content);
    }
}
