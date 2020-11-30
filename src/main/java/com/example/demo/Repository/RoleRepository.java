package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Role;
@Repository
public interface RoleRepository  extends CrudRepository<Role, Integer>{
	 Role findByName(String name);
}
