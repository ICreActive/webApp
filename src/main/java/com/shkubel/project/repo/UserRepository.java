package com.shkubel.project.repo;

import com.shkubel.project.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
