package com.wanghao.ad.service;

import com.wanghao.ad.vo.CreativeRequest;
import com.wanghao.ad.vo.CreativeResponse;

public interface ICreativeService {
    CreativeResponse createCreative(CreativeRequest request);
}
