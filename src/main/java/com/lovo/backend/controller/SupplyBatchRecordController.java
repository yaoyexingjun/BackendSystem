package com.lovo.backend.controller;

import com.lovo.backend.entity.SupplyRecordEntity;
import com.lovo.backend.service.ISupplyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SupplyBatchRecordController {
    @Autowired
    private ISupplyRecordService supplyRecordService;

    @RequestMapping("findTheSupplyRecord")
    @ResponseBody
    public List<SupplyRecordEntity> findTheSupplyRecordBySupplyBatch(String supplyBatch){
        List<SupplyRecordEntity> list = supplyRecordService.findAllSupplyRecordBySupplyBatch(supplyBatch);
        return list;
    }
}
