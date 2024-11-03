package com.cdp.simple_factory;

import com.cdp.simple_factory.entities.BlogPost;
import com.cdp.simple_factory.entities.NewsPost;
import com.cdp.simple_factory.entities.Post;
import com.cdp.simple_factory.entities.ProductPost;

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
