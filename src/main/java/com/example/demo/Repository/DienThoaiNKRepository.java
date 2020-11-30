package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DienThoaiNK;
@Repository
public interface DienThoaiNKRepository extends CrudRepository<DienThoaiNK,Long>{
	@Query(value = "select * from DienThoaiNK where isdelete=0 order by mank",nativeQuery=true)
	List<DienThoaiNK> getAll();
	@Query(value = "select * from DienThoaiNK where isdelete=0 and mank=? ",nativeQuery=true)
	List<DienThoaiNK> getAllnk(long mank);
	@Query(value = "select * from DienThoaiNK where id=? and isdelete=0  ",nativeQuery=true)
	Optional<DienThoaiNK> find(long id);
	@Query(value = "SELECT * FROM DienThoaiNK WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<DienThoaiNK> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM DienThoaiNK WHERE name LIKE ? ",nativeQuery=true)
	List<DienThoaiNK> findlk(String name);
	
	List<DienThoaiNK> findByNameLike(String name);
}
