package com.samrit.controller;

import com.samrit.domain.Recipe;
import com.samrit.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


public class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }
        @Test
        public void getIndexPage() throws Exception{
            //given
            Set<Recipe> recipes = new HashSet<>();
            recipes.add(new Recipe());

            Recipe recipe = new Recipe();
            recipe.setId(1L);
            recipes.add(recipe);

            when(recipeService.getRecipes()).thenReturn(recipes);

            ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(Set.class);

            //when
            String viewName = indexController.getIndexPage(model);

            //then
            assertEquals("index", viewName);
            verify(recipeService, times(1)).getRecipes();
            verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
            Set<Recipe> setInController = (Set<Recipe>) argumentCaptor.getValue();
            assertEquals(2, setInController.size());
        }

}