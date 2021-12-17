package com.samrit.service;

import com.samrit.domain.Recipe;
import com.samrit.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Slf4j
@Service
public class ImageServiceImp implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {

        log.debug("Received a file");

        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];
            int i =0;

            for(byte b: file.getBytes()){
                byteObjects[i++] = b;
            }
            recipe.setImage(byteObjects);

            recipeRepository.save(recipe);

            log.debug("Received a file");
        } catch (IOException e) {

            log.error("Error occurred", e);
            e.printStackTrace();
        }
    }
}
