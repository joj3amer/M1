package com.restful.hotel.repositories;

import com.restful.hotel.models.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
}
