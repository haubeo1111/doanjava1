package com.example.demo.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.Services.DangKyService;
import com.example.demo.dto.MyUserDetail;
import com.example.demo.Repository.DangkyRepository;
import com.example.demo.Repository.QuyenChucNang;
import com.example.demo.Repository.UserRepository;
import com.example.demo.models.DangKy;
import com.example.demo.models.QLUser;
import com.example.demo.models.Role;
import com.example.demo.models.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
    private UserRepository userRepository;
@Autowired
private DangkyRepository dangkyRepository;
@Autowired
private DangKyService dangKyService;
@Autowired
 QuyenChucNang quyenChucNang;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	//Nguoidung nd = this.nguoiDungService.findByTen(tennnguoidung);
    	DangKy dangky=dangKyService.findBytendangnhap(username).get();
    	List<String>cnurl=quyenChucNang.cnurl(username);
    System.out.println("username la :"+username);
		if (dangky == null) {
			throw new UsernameNotFoundException("Could not find nguoi dung");
		};
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	       for(String cn:cnurl) {
	    	   authorities.add(new SimpleGrantedAuthority(cn));
	       }
	       String vaitro=quyenChucNang.vaitro(username);
	       authorities.add(new SimpleGrantedAuthority(vaitro));
	       
	       return new org.springframework.security.core.userdetails.User(
	                dangky.getTendangnhap(),dangky.getPassword(), authorities);
		//return new MyUserDetail(nd);
	}
    	/*  //User user = userRepository.findByEmail(username);
    	DangKy dangky=null;
    	for (int j = 0; j < dangKyService.findAll().size(); j++) {
			if (username.equalsIgnoreCase(dangKyService.findAll().get(j).getTendangnhap())
				) {
			 dangky=dangKyService.findAll().get(j);
			}}
        if (dangky == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
       String vaitro=quyenChucNang.vaitro(username);
        Set<String> vt=new HashSet<>();
        vt.add(vaitro);
       // Set<Role> roles = user.getRoles();
        for (String v : vt) {
            grantedAuthorities.add(new SimpleGrantedAuthority(v));
       }

        return new org.springframework.security.core.userdetails.User(
                dangky.getTendangnhap(),dangky.getPassword(), grantedAuthorities);
    }*/
}
