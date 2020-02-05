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

    @RequestMapping("findAllSupplyBatch")
    @ResponseBody
    public PageNationEntity findAllSupplyBatch(String currPage,String pageSize){
        //第一个参数是当前页，第二个参数是每页显示条数，我不晓得为什么从页面上传过来这个currPage是1，所以我减了1
        //如果你们没问题的可以自己改
        Pageable pageable = PageRequest.of(Integer.parseInt(currPage) - 1,Integer.parseInt(pageSize));
        int totalCount = supplyBatchService.getTotalCount();
        List<SupplyBatchEntity> list = supplyBatchService.findAllSupplyBatch(pageable);
        PageNationEntity<SupplyBatchEntity> pageNationEntity = new PageNationEntity<SupplyBatchEntity>();
        pageNationEntity.setTotalCount(totalCount);
        pageNationEntity.setDataList(list);
        return pageNationEntity;
    }
}
