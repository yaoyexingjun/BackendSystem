package com.lovo.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovo.backend.entity.ProductEntity;
import com.lovo.backend.service.IProductService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("findAllPage")
    public int findAllPage(){
        int a=productService.findPage();
        return a;
    }

    @RequestMapping("findAll")
    public List<ProductEntity> findAll(){
        List<ProductEntity>list=productService.findAll(1);
        System.out.println(list.size());
        return list;
    }
    @RequestMapping("souState")
    public List<ProductEntity>findState(String soushou,String select2){
        System.out.println(soushou+"@@"+select2);
        int state=0;
        if (select2!=""){
            state  =Integer.parseInt(select2);
        }

        List<ProductEntity>list=productService.findState(state,soushou,1);
        return list;
    }

    @RequestMapping("productFenYe")
    public List<ProductEntity>findPage(String soushou,String select2,String currPage){
        int page=Integer.parseInt(currPage);
        int state=0;
        if (select2!=""&&select2!=null){
            state  =Integer.parseInt(select2);
        }
        List<ProductEntity>list=productService.findState(state,soushou,page);
        return list;
    }

    @RequestMapping("update")
    public List<ProductEntity> updateAndFindAll(String a,String b,String soushou,String select2){
      //a是物品编号 b是修改成的状态 soushou是产品类型 select2是当前状态
        String up="";
       int state= Integer.parseInt(b);
        System.out.println(a+"_"+b+"_"+soushou+"_"+select2);
      if (state==1){
          productService.updateState(2,a);
          up=2+","+a;
          rabbitTemplate.convertAndSend("standUp","getUp",up);

      }else if(state==2){
            productService.updateState(3,a);
          up=3+","+a;
          rabbitTemplate.convertAndSend("standUp","getUp",up);
        }else if(state==3){
          productService.updateState(2,a);
          up=2+","+a;
          rabbitTemplate.convertAndSend("standUp","getUp",up);
      }
        int state2=0;
        if (select2!=""){
            state2=Integer.parseInt(select2);
        }

        List<ProductEntity>list=productService.findState(state2,soushou,1);
        return list;

    }

    @RequestMapping("stateFindPage")
    public int stateFindPage(String select2,String soushou){
        int state=0;
        if (select2==""||select2==null){
            state=0;
        }else {
            state=Integer.parseInt(select2);
        }
        System.out.println(state);
       int page= productService.findStatePage(state,soushou);
        return  page;
    }
}
