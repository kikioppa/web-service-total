package org.salem.service;

import javax.servlet.http.HttpSession;


import org.salem.login.model.ScoreBoard;


import org.salem.login.repository.ScoreBoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;



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
  
    public Page<ScoreBoard> findBoardList(Pageable pageable){
        //기본 페이지 크기안 10으로 새로운 PageRequest객체를 만들어 페이징 처리된 게시글 리스트 반환
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return scoreBoardRepository.findAll(pageable);
      }
}