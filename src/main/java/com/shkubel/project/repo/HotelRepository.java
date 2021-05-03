package com.shkubel.project.repo;

import com.shkubel.project.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {


}
