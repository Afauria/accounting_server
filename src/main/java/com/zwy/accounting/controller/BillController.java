package com.zwy.accounting.controller;

import com.alibaba.fastjson.JSONArray;
import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.entity.BillEntity;
import com.zwy.accounting.entity.BillQueryEntity;
import com.zwy.accounting.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/add")
    public Object addBill(@RequestHeader(value = "userid", required = true) String userid, @RequestBody String jsonString) {
        List<BillEntity> billEntities = JSONArray.parseArray(jsonString, BillEntity.class);
        return billService.addBill(userid, billEntities);
    }


    //GET方式查询 指定变量
//    @GetMapping("/query")
//    public Object queryBillByCondition(@RequestHeader(value = "userid", required = true) String userId, @RequestParam(value = "accountid", required = false) String accountId, @RequestParam(value = "categorytype", required = false) Integer categoryType, @RequestParam(value = "categoryid", required = false) String categoryId) {
//        return billService.queryBillByCondition(userId, accountId, categoryType, categoryId);
//    }

    //POST方式查询 传json字符串
    @PostMapping("/query")
    public Object queryBill(@RequestHeader(value = "userid", required = true) String userId, @RequestBody BillQueryEntity billQueryEntity) {
        billQueryEntity.setCreator(userId);
        return billService.queryBillByCondition(billQueryEntity);
    }

    @PostMapping("/delete")
    public Object deleteByAccountId(@RequestHeader(value = "userid", required = true) String userId, @RequestBody BillQueryEntity billQueryEntity) {
        return billService.deleteByBillId(billQueryEntity.getBillId());
    }
}

