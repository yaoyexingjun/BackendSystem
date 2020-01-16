package com.lovo.backend.service.impl;

import com.lovo.backend.dao.ISpecificationDao;
import com.lovo.backend.entity.SpecificationEntity;
import com.lovo.backend.service.ISpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 规格业务接口实现类
 */
@Service(value = "specificationService")
public class SpecificationServiceImpl implements ISpecificationService {
    @Autowired
    private ISpecificationDao specificationDao;

    @Transactional
    public void addSpecification(SpecificationEntity specificationEntity) {
        specificationDao.save(specificationEntity);
    }

    public List<SpecificationEntity> findAllSpecificationByProductCode(String productCode) {
        return specificationDao.findAllSpecificationByProductCode(productCode);
    }
}
