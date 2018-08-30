package example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import example.demo.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{
	
	@Query(value="INSERT INTO FOOD(NAME) VALUES(:name)", nativeQuery=true)
	void addFood(String name);
	
	@Query(value="UPDATE FOOD SET NAME=:name WHERE ID=:id", nativeQuery=true)
	void updateFood(long id, String name);
	
}
