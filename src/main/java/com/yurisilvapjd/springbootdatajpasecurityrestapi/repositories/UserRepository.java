package com.yurisilvapjd.springbootdatajpasecurityrestapi.repositories;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);
}
