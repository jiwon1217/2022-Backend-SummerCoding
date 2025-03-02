package com.landvibe.summer.mvc.controller;

import com.landvibe.summer.mvc.dto.request.PostCategoryReq;
import com.landvibe.summer.mvc.dto.response.GetCategoriesRes;
import com.landvibe.summer.mvc.dto.response.PostCategoryRes;
import com.landvibe.summer.mvc.entity.Category;
import com.landvibe.summer.mvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/category")
    public PostCategoryRes create(@RequestBody PostCategoryReq request) {
        Long categoryId = categoryService.register(request);
        if (categoryId.equals(-1L)) {
            return new PostCategoryRes(-1, null);
        }
        Map<String, Long> map = new HashMap<>();
        map.put("id", categoryId);
        return new PostCategoryRes(1, map);
    }

    @GetMapping("/categories")
    public GetCategoriesRes read() {
        List<Category> categories = categoryService.getCategories();
        Integer size = categories.size();
        return new GetCategoriesRes(size, categories);
    }
}