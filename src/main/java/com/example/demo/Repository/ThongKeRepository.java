package com.example.demo.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ThongKe;

@Repository
public interface ThongKeRepository extends CrudRepository<ThongKe,String>  {
@Query(value="select dt.name ,\r\n" + 
		" case when sum(dtx.soluong) is null then 0 else sum(dtx.soluong) end as soluong \r\n" + 
		" from dienthoai dt \r\n" + 
		" left join dienthoaixk dtx on dtx.name=dt.name \r\n" + 
		" where  dtx.ngayxuat>=? and dtx.ngayxuat<=? and dtx.isdelete=0 \r\n" + 
		" group by dt.name",nativeQuery = true)
List<ThongKe> banhang(Date ngaydau,Date ngaycuoi);
@Query(value="select dt.name ,sum(dtn.soluong) as soluong from dienthoai dt \r\n" + 
		" left join dienthoaink dtn on dtn.name=dt.name \r\n" + 
		" where  dtn.ngaynhap>=? and dtn.ngaynhap<=? and dtn.isdelete=0 \r\n" + 
		" group by dt.name",nativeQuery = true)
List<ThongKe>nhapkho(Date ngaydau,Date ngaycuoi);
/*@Query(value=" select sum(dtnk.giaban) as giaban from dienthoaink dtnk \r\n" + 
		" where dtnk.ngaynhap>=? and dtnk.ngaynhap<=? and dtnk.isdelete =0",nativeQuery = true)
long tongtiennhap(Date ngaydau,Date ngaycuoi);
@Query(value="select sum(dtxk.giaban) as giaban from dienthoaixk dtxk \r\n" + 
		"where dtxk.ngayxuat>=? and dtxk.ngayxuat<=? and dtxk.isdelete =0",nativeQuery = true)
long tongtienban(Date ngaydau,Date ngaycuoi);*/
}
