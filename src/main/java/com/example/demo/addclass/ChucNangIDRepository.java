package com.example.demo.addclass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.MapKey;
import javax.validation.constraints.Null;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ChucNangIDRepository extends CrudRepository<ChucNangID,Long>{
	
	@Query(value ="select cn.id,cn.tencn, \r\n" + 
			" CASE \r\n" + 
			"			WHEN  ll.idcn is null THEN  0 ELSE cn.id \r\n" + 
			"		END as idcn \r\n" + 
			" from chucnang cn  \r\n" + 
			"			 left join (select ucn.idcn from  userchucnang ucn \r\n" + 
			"			 inner join qluser qlu on qlu.id=ucn.iduser where qlu.id=?) ll on ll.idcn=cn.id ",nativeQuery = true)
			
	List<ChucNangID>chucnangus(long id);
	
}
