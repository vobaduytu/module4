package com.tu.repository;

import com.tu.model.Province;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {
     Page<Province> findAllByNameContaining(String s, Pageable pageable);
}
