package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/categories/add")
    public String addCategory(Model model)
    {
        model.addAttribute("category", new Category());
        model.addAttribute("action", "add");
        return "categories/add_edit";
    }

    @PostMapping("/categories/add")
    public String addCategory(Model model, @ModelAttribute("category") Category category)
    {
        categoryDao.addCategory(category);
        model.addAttribute("category", category);
        return "categories/add_success";
    }

    @GetMapping("/categories/{id}/edit")
    public String editCategory(Model model, @PathVariable int id)
    {
        Category category = categoryDao.getCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("action", "edit");
        return "categories/add_edit";
    }

    @PostMapping("/categories/{id}/edit")
    public String editCategory(@ModelAttribute("category") Category category, @PathVariable int id)
    {
        category.setCategoryId(id);
        categoryDao.updateCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/delete")
    public String deleteCategory(Model model, @PathVariable int id)
    {
        Category category = categoryDao.getCategoryById(id);
        model.addAttribute("category", category);
        return "categories/delete";
    }

    @PostMapping("/categories/{id}/delete")
    public String deleteCategory(@PathVariable int id)
    {
        categoryDao.deleteCategory(id);

        return "redirect:/categories";
    }
}


