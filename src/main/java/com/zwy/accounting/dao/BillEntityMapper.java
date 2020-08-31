package com.zwy.accounting.dao;

import com.zwy.accounting.entity.BillEntity;
import com.zwy.accounting.entity.BillQueryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillEntityMapper {

    int insert(List<BillEntity> record);

//    List<BillEntity> selectByCondition(@Param("creator") String userId, @Param("accountId") String accountId, @Param("categoryType") Integer categoryType, @Param("categoryId") String categoryId);

    List<BillEntity> selectByCondition(BillQueryEntity billQueryEntity);

    int deleteByBillId(String billId);
}