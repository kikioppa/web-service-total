package org.salem.controller;



import org.salem.service.ScoreBoardService;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.salem.login.model.ScoreBoard;
import org.salem.login.model.User;
import org.salem.login.service.UserService;
import org.salem.service.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Product controller.
 */
@Controller
public class ScoreBoardController {


	
    private ScoreBoardService scoreBoardService;

    @Autowired
    public void setScoreBoardService(ScoreBoardService scoreBoardService) {
        this.scoreBoardService = scoreBoardService;
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/scoreboards", method = RequestMethod.GET)
    public String list(@PageableDefault Pageable pageable ,Model model, HttpSession session) {
    	ModelAndView modelAndView = new ModelAndView();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = UserService.findByEmail(auth.getName());
        modelAndView.addObject("userName", user.getName() + "님 접속중" );
        modelAndView.setViewName("/scoreboards");
        model.addAttribute("scoreboards", scoreBoardService.findBoardList(pageable));
        					//("boardList", boardService.findBoardList(pageable));
        model.addAttribute("name",user.getName());
        System.out.println("Returning rpoducts:");
        return "scoreboards";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("scoreboard/{id}")
    public String showScoreBoard(@PathVariable Integer id, Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = UserService.findByEmail(auth.getName());
        model.addAttribute("scoreboard", scoreBoardService.getScoreBoardById(id));
        model.addAttribute("name",user.getName());
        return "scoreboardshow";
    }


    @RequestMapping("scoreboard/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("scoreboard", scoreBoardService.getScoreBoardById(id));
        return "scoreboardform";
    }

  

    @RequestMapping("scoreboard/new")
       public String newScoreBoard(Model model,HttpSession session) {

           Authentication auth = SecurityContextHolder.getContext().getAuthentication();
           User user = UserService.findByEmail(auth.getName());
           model.addAttribute("scoreboard", new ScoreBoard());
           model.addAttribute("name",user.getName());
           return "scoreboardform";
       }

    /**
     * Save product to database.
     *
     * @param scoreBoard
     * @return
     */
    @RequestMapping(value = "scoreboard", method = RequestMethod.POST)
    public String saveScoreBoard(ScoreBoard scoreboard) {
   
        scoreBoardService.saveScoreBoard(scoreboard);
        return "redirect:/scoreboard/" + scoreboard.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("scoreboard/delete/{id}")
    public String delete(@PathVariable Integer id) {
        scoreBoardService.deleteScoreBoard(id);
        return "redirect:/scoreboards";


    }
    
 
}