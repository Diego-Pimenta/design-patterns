package com.cdp.simple_factory;

import com.cdp.simple_factory.entities.Post;

public class Main {

    public static void main(String[] args) {
        Post post = PostFactory.createPost("blog");
        System.out.println(post);
    }
}