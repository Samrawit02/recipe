package com.samrit.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }
    @Test
    public void getId() {
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }
    @Test
    public void getDescription() {
        String descValue = "TeaSpoon";
        category.setDescription(descValue);
        assertEquals(descValue,category.getDescription());
    }
    @Test
    public void getRecipes() {

    }

}