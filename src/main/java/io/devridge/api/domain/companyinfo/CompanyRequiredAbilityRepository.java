package io.devridge.api.domain.companyinfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRequiredAbilityRepository extends JpaRepository<CompanyRequiredAbility, Long> {

    Optional<CompanyRequiredAbility> findByName(String companyRequiredAbilityName);

    Page<CompanyRequiredAbility> findByCourseDetailIdIsNull(Pageable pageable);

    List<CompanyRequiredAbility> findByCourseDetailIdIsNull();

    List<CompanyRequiredAbility> findByCourseDetailId(Long courseDetailId);
}
