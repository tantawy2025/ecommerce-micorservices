package com.example.pricing_service.repo;

import com.example.pricing_service.repo.entity.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;


@Repository
public interface PricingRepository extends JpaRepository<Pricing,Long> {

    @Query("SELECT p FROM Pricing p WHERE p.sku = :sku AND :date BETWEEN p.startDate AND p.endDate")
    Pricing findBySkuAndDate(@Param("sku") String sku, @Param("date") LocalDateTime date);

    Optional<Pricing> findBySkuAndCurrency(String sku, String currency);

}
