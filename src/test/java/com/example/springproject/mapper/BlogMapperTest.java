package com.example.springproject.mapper;

import com.example.springproject.dto.BlogDto;
import com.example.springproject.entity.Blog;
import com.example.springproject.entity.User;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BlogMapperTest {

    private final BlogMapper mapper = new BlogMapperImpl();

    @Test
    void toBlogDto() {
        final String NAME = "NAME";
        final String DEFINITION = "DEFINITION";
        final String AUTHOR = "AUTHOR";
        final User USER = User.builder().id(1).build();

        Blog blog = Blog.builder()
                .id(1)
                .name(NAME)
                .definition(DEFINITION)
                .author(AUTHOR)
                .user(USER)
                .build();

        BlogDto expected = new BlogDto(NAME,
                DEFINITION,
                AUTHOR,
                USER);

        BlogDto actual = mapper.toBlogDto(blog);

        assertEquals(expected,actual);

    }

    @Test
    void toBlogEntity() {
    }
}