package com.shkubel.project.repo;

import com.shkubel.project.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
