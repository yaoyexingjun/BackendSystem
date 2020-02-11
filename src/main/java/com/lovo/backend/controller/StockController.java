package com.lovo.backend.controller;

import com.lovo.backend.dto.ProductStockDTO;
import com.lovo.backend.entity.ProductEntity;
import com.lovo.backend.entity.SpecificationEntity;
import com.lovo.backend.entity.StockEntity;
import com.lovo.backend.service.IGoodsService;
import com.lovo.backend.service.IProductService;
import com.lovo.backend.service.ISpecificationService;
import com.lovo.backend.service.IStockService;
import com.lovo.backend.service.impl.SpecificationServiceImpl;
import com.lovo.backend.util.SplitCombineStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StockController {
    @Autowired
    private IStockService stockService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISpecificationService specificationService;

    @RequestMapping("findAllStockPage")
    @ResponseBody
    public int findAllStockPage(){
        return stockService.findAllPage();
    }

    @RequestMapping("findAllSupplyBatch")
    @ResponseBody
    public List<ProductStockDTO> findPage(String currPage) {
        int page = Integer.parseInt(currPage);
        Pageable pageable = PageRequest.of(page - 1, 5);
        List<StockEntity> stockList = stockService.findAllSupplyBatch(pageable);
        List<ProductStockDTO> productStockDTOList = new ArrayList<ProductStockDTO>();
        for(StockEntity stockEntity : stockList){
            ProductEntity productEntity = goodsService.findProductByProductId(stockEntity.getProductCode());
            ProductStockDTO productStockDTO = new ProductStockDTO();
            productStockDTO.setProductId(productEntity.getProductId());
            productStockDTO.setProductCode(productEntity.getProductCode());
            productStockDTO.setProductName(productEntity.getProductName());
            productStockDTO.setProductType(productEntity.getProductType());
            productStockDTO.setStockNum(stockEntity.getStockNum());
            productStockDTO.setThreshold(stockEntity.getThreshold());

            List<SpecificationEntity> specificationList = specificationService.findAllSpecificationByProductCode(productEntity.getProductCode());
            String str = "";
            for(SpecificationEntity specificationEntity : specificationList){
                str += specificationEntity.getSpecificationName() + ":" + specificationEntity.getSpecificationValue() + ";";
            }
            productStockDTO.setSpecification(str);
            productStockDTOList.add(productStockDTO);
        }
        return productStockDTOList;
    }
}
