package org.salem.login.repository;

import java.util.List;


import org.salem.login.model.ScoreBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository("scoreboardRepository")
public interface ScoreBoardRepository extends JpaRepository<ScoreBoard, Integer> {

	ScoreBoard findAllById(Integer id);
	
	
	//@Query(value = "SELECT numb1 + numb2 as total FROM ScoreBoard", nativeQuery =true)
     //ScoreBoard sumTotal(int total);

}