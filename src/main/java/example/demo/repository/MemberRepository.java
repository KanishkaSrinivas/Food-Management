package example.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import example.demo.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	@Query(value="SELECT * FROM MEMBER WHERE LOWER(DESIGNATION) = LOWER(:designation)", nativeQuery=true)
	Collection<Member> getByDesignation(String designation);
	
	@Query(value="SELECT * FROM MEMBER WHERE LOWER(NAME) = LOWER(:name)", nativeQuery=true)
	Collection<Member> getByName(String name);
	
	@Query(value="INSERT INTO MEMBER(NAME,DESIGNATION) VALUES(:name, :designation)", nativeQuery=true)
	void addMember(String name, String designation);
	
	@Query(value="UPDATE MEMBER SET NAME=:name WHERE ID=:id", nativeQuery=true)
	Member updateName(long id, String name);
	
}
