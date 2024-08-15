package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class CategoriesController
{
    private CategoryDao categoryDao = new CategoryDao();

    @GetMapping("/categories")
    public String getCategories(Model model)
    {
        ArrayList<Category> categories = categoryDao.getCategories();

        model.addAttribute("categories", categories);

        return "categories/index";
    }

    @GetMapping("/categories/{id}")
    public String details(Model model, @PathVariable int id)
    {
        ArrayList<Category> categories;

        var category = categoryDao.getCategoryById(id);
        model.addAttribute("categories", category);

        return "categories/details";
    }
}

