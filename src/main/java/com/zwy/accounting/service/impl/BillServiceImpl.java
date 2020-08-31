package com.zwy.accounting.service.impl;

import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.common.utils.ResultUtil;
import com.zwy.accounting.dao.BillEntityMapper;
import com.zwy.accounting.entity.BillEntity;
import com.zwy.accounting.entity.BillQueryEntity;
import com.zwy.accounting.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

//修饰service组件,加上之后可以使用@AutoWired自动导入,value值唯一,否则会报错
//@Service和@Controller与@Component等效,只不过用名称区分控制层和业务层
@Service(value = "billService")
@Transactional
public class BillServiceImpl implements BillService {
    @Autowired
    private BillEntityMapper billMapper;//这里会报错，但是并不会影响

    @Override
    public Result addBill(String userid, List<BillEntity> billEntities) {
        for (BillEntity entity : billEntities) {
            String id = UUID.randomUUID().toString().replace("-", "");
            entity.setBillId(id);
            entity.setCreator(userid);
        }
        int res = billMapper.insert(billEntities);
        if(res > 0) {
            return ResultUtil.success(billEntities);
        }
        return null;
    }

    @Override
    public Result queryBillByCondition(BillQueryEntity billQueryEntity) {
        List<BillEntity> billEntities = billMapper.selectByCondition(billQueryEntity);
        return ResultUtil.success(billEntities);
    }


    @Override
    public Result deleteByBillId(String billId) {
        int res = billMapper.deleteByBillId(billId);
        if(res > 0){
            return ResultUtil.success(null);
        }
        return ResultUtil.error(10001, "删除失败，不存在此ID");
    }
}
