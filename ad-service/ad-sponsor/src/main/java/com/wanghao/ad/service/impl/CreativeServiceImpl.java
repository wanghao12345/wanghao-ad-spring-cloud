package com.wanghao.ad.service.impl;

import com.wanghao.ad.dao.CreativeRepository;
import com.wanghao.ad.entity.Creative;
import com.wanghao.ad.service.ICreativeService;
import com.wanghao.ad.vo.CreativeRequest;
import com.wanghao.ad.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {

        Creative creative = creativeRepository.save(request.convertToEntity());

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
