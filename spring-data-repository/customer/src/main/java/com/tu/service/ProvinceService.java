package com.tu.service;


import com.tu.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProvinceService {
    Page<Province> findAll(Pageable pageable);

    Optional<Province> findById(Long id);

    void save(Province province);

    void remove(Long id);
    Page<Province> findAllByNameContaining(String s, Pageable pageable);
}
