package com.lovo.backend.controller;

import com.lovo.backend.entity.BackEndEntity;
import com.lovo.backend.entity.BackUserEntity;
import com.lovo.backend.service.IBackEndService;
import com.lovo.backend.service.IBackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BackUserController {
    @Autowired
    private IBackUserService backUserService;
    @Autowired
    private IBackEndService backEndService;
    @RequestMapping("findAllUserProduct")
     public List<BackUserEntity> findAllUserProduct(){
        List<BackUserEntity> list=backUserService.findAll();
        System.out.println(list.size());
        return list;
     }
    @RequestMapping("findAllEndProduct")
    public List<BackEndEntity> findAllEndProduct(){
        List<BackEndEntity> endList=backEndService.findAll();
        System.out.println(endList.size());
        return endList;
    }

}
