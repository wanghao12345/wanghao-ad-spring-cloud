package com.wanghao.ad.service;

import com.wanghao.ad.exception.AdException;
import com.wanghao.ad.vo.AdUnitRequest;
import com.wanghao.ad.vo.AdUnitResponse;

public interface IAdUnitService {
    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;
}
