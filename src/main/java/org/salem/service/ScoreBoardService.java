package org.salem.service;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import org.salem.login.model.ScoreBoard;

@Service
public interface ScoreBoardService {

    Iterable<ScoreBoard> listAllScoreBoards();

    ScoreBoard getScoreBoardById(Integer id);

    ScoreBoard saveScoreBoard(ScoreBoard scoreboard);

    void deleteScoreBoard(Integer id);
    
   // public void getSession(Authentication auth,HttpSession session);

  //  public int total();
    
    
}