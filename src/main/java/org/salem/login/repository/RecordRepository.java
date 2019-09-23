package org.salem.login.repository;




import org.salem.login.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("recordRepository")
public interface RecordRepository extends JpaRepository<Record, Integer> {

	
	
	
	Record findAllById(Integer id);
	
	
	//@Query(value = "SELECT numb1 + numb2 as total FROM ScoreBoard", nativeQuery =true)
     //ScoreBoard sumTotal(int total);

}