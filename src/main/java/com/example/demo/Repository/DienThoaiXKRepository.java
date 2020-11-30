package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DienThoaiXK;
import com.example.demo.models.DienThoaiXK;
@Repository
public interface DienThoaiXKRepository extends CrudRepository<DienThoaiXK,Long>{
	@Query(value = "select * from DienThoaiXK where isdelete=0 order by maxk",nativeQuery=true)
	List<DienThoaiXK> getAll();
	@Query(value = "select * from DienThoaiXK where isdelete=0 and maxk=? ",nativeQuery=true)
	List<DienThoaiXK> getAllnk(long mank);
	@Query(value = "select * from DienThoaiXK where id=? and isdelete=0  ",nativeQuery=true)
	Optional<DienThoaiXK> find(long id);
	@Query(value = "SELECT * FROM DienThoaiXK WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<DienThoaiXK> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM DienThoaiXK WHERE name LIKE ? and isdelete=0 ",nativeQuery=true)
	List<DienThoaiXK> findlk(String name);
	
	List<DienThoaiXK> findByNameLike(String name);
}
