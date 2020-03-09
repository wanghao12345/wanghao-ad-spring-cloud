package com.wanghao.ad.service.impl;

import com.wanghao.ad.constant.Constants;
import com.wanghao.ad.dao.AdPlanRepository;
import com.wanghao.ad.dao.AdUnitRepository;
import com.wanghao.ad.entity.AdPlan;
import com.wanghao.ad.entity.AdUnit;
import com.wanghao.ad.exception.AdException;
import com.wanghao.ad.service.IAdUnitService;
import com.wanghao.ad.vo.AdUnitRequest;
import com.wanghao.ad.vo.AdUnitResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AdUnitService implements IAdUnitService {

    private final AdPlanRepository planRepository;
    private final AdUnitRepository unitRepository;

    @Autowired
    public AdUnitService(AdPlanRepository planRepository, AdUnitRepository unitRepository) {
        this.planRepository = planRepository;
        this.unitRepository = unitRepository;
    }

    @Override
    public AdUnitResponse createUnit(AdUnitRequest request) throws AdException {
        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        Optional<AdPlan> adPlan = planRepository.findById(request.getPlanId());
        if (!adPlan.isPresent()) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        AdUnit oldAdUnit = unitRepository.findByPlanIdAndUnitName(
            request.getPlanId(), request.getUnitName()
        );
        if (oldAdUnit != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_UNIT_ERROR);
        }

        AdUnit newAdUnit = unitRepository.save(
            new AdUnit(
                request.getPlanId(),
                request.getUnitName(),
                request.getPositionType(),
                request.getBudget()
            )
        );

        return new AdUnitResponse(
            newAdUnit.getId(),
            newAdUnit.getUnitName()
        );
    }
}
