package com.example.discount_service.repo;

import com.example.discount_service.repo.entity.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;


@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {

    Optional<Discount> findBySku(String sku);

    Page<Discount> findAll(Pageable pageable); // Support for pagination

}
