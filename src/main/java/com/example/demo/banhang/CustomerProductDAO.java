package com.example.demo.banhang;

import java.util.ArrayList;
import java.util.List;

public class CustomerProductDAO {
public static List<CustomerProduct> ls=new ArrayList<>();
public List<CustomerProduct> getall(){
	return ls;
}
public int save(CustomerProduct d) {
	ls.add(d);
	return 1;
}
public int find(long a) {
	int p=-1;
	for(int i=0;i<ls.size();i++) {
		if(ls.get(i).getCartsdetail()==a) {
			p=i;
		}
		
	}
	return p;
}

}
