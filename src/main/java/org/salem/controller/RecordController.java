package org.salem.controller;


import org.salem.login.model.Record;
import org.salem.login.model.User;
import org.salem.login.service.UserService;
import org.salem.service.RecordService;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Product controller.
 */
@Controller
public class RecordController {
	@Autowired
    private RecordService recordService;

    @Autowired
    public void setProductService(RecordService recordService) {
        this.recordService = recordService;
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
   

    
    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public ModelAndView list(Model model) {
    	ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("records", recordService.listAllRecords());
        System.out.println("Returning rpoducts:");
        return modelAndView;
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("record/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("record", recordService.getRecordById(id));
        return "recordshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("record/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("record", recordService.getRecordById(id));
        return "recordform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("record/new")
    public String newProduct(Model model,HttpSession session) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = UserService.findByEmail(auth.getName());
        model.addAttribute("record", new Record());
        model.addAttribute("name",user.getName());
        return "myRecord/myRecordform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "record", method = RequestMethod.POST)
    public String saveProduct(Record record) {
    	recordService.saveRecord(record);
        return "redirect:records";
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("record/delete/{id}")
    public String delete(@PathVariable Integer id) {
    	recordService.deleteRecord(id);
        return "redirect:/records";
    }
    
 
}