package com.wanghao.ad.dao;

import com.wanghao.ad.entity.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdUnitRepository extends JpaRepository<AdUnit, Long> {
    AdUnit findByPlanIdAndUnitName(Long planId, String unitName);
    List<AdUnit> findAllByUnitStatus(Integer unitStatus);
}
