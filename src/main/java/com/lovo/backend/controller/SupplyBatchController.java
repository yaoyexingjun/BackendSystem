package com.lovo.backend.controller;

import com.lovo.backend.entity.PageNationEntity;
import com.lovo.backend.entity.SupplyBatchEntity;
import com.lovo.backend.service.ISupplyBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SupplyBatchController {
    @Autowired
    private ISupplyBatchService supplyBatchService;

    @RequestMapping("findAllSupplyBatchPage")
    @ResponseBody
    public int findAllPage(){
        return supplyBatchService.findAllPage();
    }

    @RequestMapping("findAllSupplyBatch")
    @ResponseBody
    public List<SupplyBatchEntity> findPage(String currPage) {
        int page = Integer.parseInt(currPage);
        Pageable pageable = PageRequest.of(page - 1, 5);
        List<SupplyBatchEntity> list = supplyBatchService.findAllSupplyBatch(pageable);
        return list;
    }
}
