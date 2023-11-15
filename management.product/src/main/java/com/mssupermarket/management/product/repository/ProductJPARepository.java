package com.mssupermarket.management.product.repository;

import com.mssupermarket.management.product.entity.ProductMySQLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductJPARepository extends JpaRepository<ProductMySQLEntity,Long> {

    Optional<ProductMySQLEntity> findBySku(String sku);

    Optional<ProductMySQLEntity> findById(Long id);
}
