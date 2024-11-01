package com.cdp;

import com.cdp.entities.Post;

public class Main {

    public static void main(String[] args) {
        Post post = PostFactory.createPost("blog");
        System.out.println(post);
    }
}