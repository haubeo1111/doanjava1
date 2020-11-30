package com.example.demo.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import com.example.demo.Services.DienThoaiService;
import com.example.demo.Services.QLUserService;
import com.example.demo.models.ChucNang;
import com.example.demo.dto.vidu1;
public class CustomPermissionEvaluator implements PermissionEvaluator{
	
	vidu1 vd =new vidu1();
	
	@PersistenceContext
	EntityManager em;
	
	private final String nativeQueryFindPermission = "select cn.id, cn.cnurl from chucnang cn " ;
		/*	+ " left join userchucnang ucn on ucn.idcn=cn.id  "
			+ " left join qluser qlu on qlu.id=ucn.iduser  "
			+ " left join groupuser gu on gu.id=qlu.idgroupuser "
			+ " left join groupusercn guc on guc.idgroupuser=gu.id "
			+ " left join vaitro vt on vt.id=qlu.idvaitro "
			+ " left join vaitrochucnang vtc on vtc.idvt=vt.id "
			+" where qlu.tendangnhap=?1 ";*/
	
	
	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		System.out.println("per: "+permission + " -> " + auth.getName());
		System.out.println("++"+auth.getAuthorities().toString());
		if ((auth != null) && (permission instanceof String)) {
			//vd.getall();
			//Query q=em.createNativeQuery("select * from chucnang cn ",ChucNang.class);
			//.setParameter(1,"haubeo");
	//List<ChucNang> cn=(List<ChucNang>)
			//q.getResultList();
	//if(cn==null) {System.out.println("null roi");}
			//List<Object[]> resultList = (List<Object[]>) this.em.createNativeQuery(this.nativeQueryFindPermission).setParameter(1, auth.getName()).getResultList();
			Collection<? extends GrantedAuthority> cnurl=auth.getAuthorities();
		for( GrantedAuthority cn:cnurl) {
			System.out.println(cn.toString());
			if(cn.toString().equals(String.valueOf(permission))) {
				return true;
			}
		}
				//List<Object[]> data = resultList;
			//for(Object[] per: data) {
			//	if(per.toString().equals(String.valueOf(permission))) {
			//		System.out.println("per: "+per.toString());
		
			}
		return false;
	}


	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
		System.out.println("permmmnh: "+permission);
		//if("/DienThoai/".equals(String.valueOf(permission))) {
			//return true;
	//	}
	//}
//}
		return false;
	}



}
