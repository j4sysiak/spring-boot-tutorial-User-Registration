package com.caveofprogramming.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends PagingAndSortingRepository<SiteUser, Long> {
	
	SiteUser findByEmail(String email);

}
