package com.example.demo.dto;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Services.DangKyService;
import com.example.demo.models.DangKy;
import com.example.demo.models.QLUser;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
public class MyUserDetail implements UserDetails{
private DangKy nguoidung;
	
	
	public MyUserDetail(DangKy nguoidung) {
		this.nguoidung = nguoidung;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        System.out.println("nguoidung la"+nguoidung.getTendangnhap());
       // for (ChucNang1 privilege : nguoidung.getVaitro().get(0).getChucnang()) {
        authorities.add(new SimpleGrantedAuthority("/BangChamCong/"));
        //authorities.add(new SimpleGrantedAuthority(privilege.getMachucnang()));
      //  }
        return authorities;
	}
	
	@Override
public String getPassword() {
		return nguoidung.getPassword();
	}

	@Override
	public String getUsername() {
		return nguoidung.getTendangnhap();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
