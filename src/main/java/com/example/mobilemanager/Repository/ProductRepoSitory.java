package com.example.mobilemanager.Repository;

import com.example.mobilemanager.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepoSitory extends JpaRepository<ProductEntity , Long> {

}
