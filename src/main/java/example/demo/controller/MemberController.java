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

import example.demo.model.Member;
import example.demo.repository.MemberRepository;

@RestController
@CrossOrigin	
@RequestMapping("demo/member")
public class MemberController {

	public MemberRepository memRepository;
	public MemberController(MemberRepository memRepository) {
		super();
		this.memRepository = memRepository;
	}

	@GetMapping("/")
	Collection<Member> getAll(){
		return memRepository.findAll();
	}
	
	@GetMapping("/find")
	Collection<Member> getByDesignation(@RequestParam("designation") String designation){
		return memRepository.getByDesignation(designation);
	}
	
	@GetMapping("/findName")
	Collection<Member> getByName(@RequestParam("name") String name){
		return memRepository.getByName(name);
	}
	
	@PostMapping("/add")
	void addMember(@RequestParam("name") String name, @RequestParam("designation") String designation) {
		memRepository.addMember(name, designation);
	}
	
	@PutMapping("/changeName")
	Member updateName(@RequestParam("id") long id, @RequestParam("name") String name) {
		memRepository.updateName(id, name);
		return memRepository.getOne(id);
	}
	
	@DeleteMapping("/remove")
	void deleteName(@RequestParam("id") long id) {
		memRepository.deleteById(id);
	}
	
}
