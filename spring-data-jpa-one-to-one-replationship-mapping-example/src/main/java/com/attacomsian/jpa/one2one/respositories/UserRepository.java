package com.attacomsian.jpa.one2one.respositories;

import com.attacomsian.jpa.one2one.domains.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}