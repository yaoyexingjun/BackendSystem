package com.lovo.backend.controller;

import com.lovo.backend.dto.StockBatchProductDTO;
import com.lovo.backend.entity.ProductEntity;
import com.lovo.backend.entity.StockBatchEntity;
import com.lovo.backend.service.IGoodsService;
import com.lovo.backend.service.IStockBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StockBatchController {
    @Autowired
    private IStockBatchService stockBatchService;
    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("findAllStockBatchPage")
    @ResponseBody
    public int findAllPage(String supplyBatch){
        return stockBatchService.findAllPage(supplyBatch);
    }

    @RequestMapping("findTheStockBatch")
    @ResponseBody
    public List<StockBatchProductDTO> findPage(String currPage,String supplyBatch) {
        int page = Integer.parseInt(currPage);
        Pageable pageable = PageRequest.of(page - 1, 5);
        List<StockBatchEntity> stockBatchList = stockBatchService.findStockBatchBySupplyBatch(supplyBatch,pageable);
        List<StockBatchProductDTO> list = new ArrayList<StockBatchProductDTO>();
        for(StockBatchEntity stockBatchEntity : stockBatchList){
            ProductEntity productEntity = goodsService.findProductByProductCode(stockBatchEntity.getProductCode());
            StockBatchProductDTO stockBatchProductDTO = new StockBatchProductDTO();
            stockBatchProductDTO.setBatch(stockBatchEntity.getBatch());
            stockBatchProductDTO.setPrice(stockBatchEntity.getPrice());
            stockBatchProductDTO.setProductCode(stockBatchEntity.getProductCode());
            stockBatchProductDTO.setProductName(productEntity.getProductName());
            stockBatchProductDTO.setPurchaseNum(stockBatchEntity.getPurchaseNum());
            stockBatchProductDTO.setSupplierName(stockBatchEntity.getSupplierName());
            stockBatchProductDTO.setTotalMoney(stockBatchEntity.getTotalMoney());
            stockBatchProductDTO.setSupplyOrderCode(stockBatchEntity.getSupplyOrderCode());
            list.add(stockBatchProductDTO);
        }
        return list;
    }
}
