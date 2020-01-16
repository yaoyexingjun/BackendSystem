package com.lovo.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovo.backend.entity.ProductEntity;
import com.lovo.backend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("findAll")
    public List<ProductEntity> findAll(){
        List<ProductEntity>list=productService.findAll(1);
        System.out.println(list.size());
        return list;
    }
    @RequestMapping("souState")
    public List<ProductEntity>findState(String soushou,String select2){
        System.out.println(soushou+"---"+select2);
        int state=0;
        if (select2!=""){
            state  =Integer.parseInt(select2);
        }

        List<ProductEntity>list=productService.findState(state,soushou,1);
        return list;
    }

    @RequestMapping("update")
    public List<ProductEntity> updateAndFindAll(String a,String b,String soushou,String select2){
       int state= Integer.parseInt(b);
        System.out.println(state);
      if (state==1){
          productService.updateState(2,a);
      }else if(state==2){
            productService.updateState(3,a);
        }else if(state==3){
          productService.updateState(2,a);
      }
        int state2=0;
        if (select2!=""){
            state2=Integer.parseInt(select2);
        }

        List<ProductEntity>list=productService.findState(state2,soushou,1);
        return list;

    }
}