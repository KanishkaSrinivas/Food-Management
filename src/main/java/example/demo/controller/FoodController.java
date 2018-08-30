package example.demo.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.demo.model.Food;
import example.demo.repository.FoodRepository;

@RestController
@CrossOrigin
@RequestMapping("/demo/food")
public class FoodController {

	public FoodRepository foodRepository;
	
	public FoodController(FoodRepository foodRepository) {
		super();
		this.foodRepository = foodRepository;
	}

	@GetMapping("/")
	Collection<Food> getAll(){
		return foodRepository.findAll();
	}
	
	@DeleteMapping("/remove")
	void deleteFood(@RequestParam("id") long id) {
		foodRepository.deleteById(id);
	}
	
	@PostMapping("/add")
	void addFood(@RequestParam("name") String name) {
		foodRepository.addFood(name);
	}
	
	@PutMapping("/changeFood")
	Food updateFood(@RequestParam("id") long id, @RequestParam("name") String name) {
		foodRepository.updateFood(id, name);
		return foodRepository.getOne(id);
	}
	
	@GetMapping("/one")
	Food getOneFood(@RequestParam("id") long id) {
		try {
			return foodRepository.getOne(id);
		}
		catch(Exception e){
			return null;
		}
	}

}
