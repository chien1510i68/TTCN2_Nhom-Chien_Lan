package com.example.mobilemanager.Repository;

import com.example.mobilemanager.Entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity , Long> {
}
