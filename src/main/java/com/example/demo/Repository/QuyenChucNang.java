package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Login;
import com.example.demo.models.PhongBan;
import com.example.demo.models.QLUser;

@Repository
public interface QuyenChucNang extends CrudRepository<QLUser,Long>{
	@Query(value = "select qus.tendangnhap from qluser qus  inner join userchucnang ucn on qus.id=ucn.iduser inner join chucnang cn on cn.id=ucn.idcn inner join vaitro vt on vt.id=qus.idvaitro  inner join vaitrochucnang vtc on vtc.idvt=vt.id   inner join groupuser gu on gu.id=qus.idgroupuser inner join groupusercn gucn on gucn.idgroupuser=gu.id  where cn.cnurl=? and qus.isdelete=0  group by qus.tendangnhap",nativeQuery=true)
	List<String> getAll(String url);
	@Query(value = "select qus.tendangnhap from qluser qus  inner join userchucnang ucn on qus.id=ucn.iduser inner join chucnang cn on cn.id=ucn.idcn inner join chucnangcha cna on cna.id=cn.cncha inner join vaitro vt on vt.id=qus.idvaitro  inner join vaitrochucnang vtc on vtc.idvt=vt.id   inner join groupuser gu on gu.id=qus.idgroupuser inner join groupusercn gucn on gucn.idgroupuser=gu.id  where cna.cnurl=? and qus.isdelete=0  group by qus.tendangnhap",nativeQuery=true)
	List<String> getAlla(String url);
	@Query(value="select vt.tenvt from vaitro vt inner join qluser qlu on qlu.idvaitro=vt.id where qlu.tendangnhap=?",nativeQuery=true)
	String tenvaitro(String tendangnhap);
	@Query(value="select vt.tenvt from vaitro vt inner join qluser qlu on qlu.idvaitro=vt.id inner join dangky dk on dk.tendangnhap=qlu.tendangnhap where dk.tendangnhap=? ",nativeQuery=true)
    String vaitro(String tendangnhap);
	@Query(value=" select distinct cn.cnurl from chucnang cn \r\n " + 
			" left join userchucnang ucn on ucn.idcn=cn.id\r\n " + 
			" left join qluser qlu on qlu.id=ucn.iduser\r\n " + 
			" left join groupuser gu on gu.id=qlu.idgroupuser\r\n " + 
			" left join groupusercn guc on guc.idcn=cn.id\r\n " + 
			" left join vaitro vt on vt.id=qlu.idvaitro\r\n " + 
			" left join vaitrochucnang vtcn on vtcn.idcn=cn.id\r\n " + 
			" left join dangky dk on dk.tendangnhap=qlu.tendangnhap\r\n " + 
			" where dk.tendangnhap=? ",nativeQuery=true)
	List<String> cnurl(String tendangnhap);
}

