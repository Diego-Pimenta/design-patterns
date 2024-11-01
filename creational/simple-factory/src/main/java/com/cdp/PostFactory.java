package com.cdp;

import com.cdp.entities.BlogPost;
import com.cdp.entities.NewsPost;
import com.cdp.entities.Post;
import com.cdp.entities.ProductPost;

public class PostFactory {

    public static Post createPost(String type) {
        return switch (type) {
            case "blog" -> new BlogPost();
            case "news" -> new NewsPost();
            case "product" -> new ProductPost();
            default -> throw new IllegalArgumentException("Post type is unown");
        };
    }
}
