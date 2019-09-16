package org.salem.service;

import javax.servlet.http.HttpSession;


import org.salem.login.model.ScoreBoard;


import org.salem.login.repository.ScoreBoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import org.salem.login.model.User;
//import com.bit.geha.security.SecurityMember;

/**
 * service implement.
 */
@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {

    private ScoreBoardRepository scoreBoardRepository;

    @Autowired
    public void setScoreBoardRepository(ScoreBoardRepository scoreBoardRepository) {
        this.scoreBoardRepository = scoreBoardRepository;
    }

    @Override
    public Iterable<ScoreBoard> listAllScoreBoards() {
        return scoreBoardRepository.findAll();
    }

    @Override
    public ScoreBoard getScoreBoardById(Integer id) {
        return scoreBoardRepository.findAllById(id);
    }

    @Override
    public ScoreBoard saveScoreBoard(ScoreBoard scoreboard) {
        return scoreBoardRepository.save(scoreboard);
    }

    @Override
    public void deleteScoreBoard(Integer id) {
        scoreBoardRepository.deleteById(id);
    }
    

    
}