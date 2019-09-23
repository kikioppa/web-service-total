package org.salem.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    
    Page<ScoreBoard> findBoardList(Pageable pageable);

    
   
}