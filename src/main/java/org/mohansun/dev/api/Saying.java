package org.mohansun.dev.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

// it’s immutable
//  makes Saying instances very easy to reason about in multi-threaded environments as well as single-threaded environments.
//  it uses the JavaBeans standard for the id and content properties. This allows Jackson to serialize it to the JSON we need.
// The Jackson object mapping code will populate the id field of the JSON object with the return value of #getId(),
//  likewise with content and #getContent().
//  Lastly, the bean leverages validation to ensure the content size is no greater than 3.
public class Saying {
    private long id;

    @Length(max = 3)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
