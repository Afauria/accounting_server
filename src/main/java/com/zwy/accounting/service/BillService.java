package com.zwy.accounting.service;

import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.entity.BillEntity;
import com.zwy.accounting.entity.BillQueryEntity;

import java.util.List;

public interface BillService {

    Result addBill(String userid, List<BillEntity> billEntities);

    Result queryBillByCondition(BillQueryEntity billQueryEntity);

    Result deleteByBillId(String billId);

}
