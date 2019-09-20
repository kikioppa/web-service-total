package org.salem.login.repository;




import org.salem.login.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("productdRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	
	
	Product findAllById(Integer id);
	
	
	//@Query(value = "SELECT numb1 + numb2 as total FROM ScoreBoard", nativeQuery =true)
     //ScoreBoard sumTotal(int total);

}