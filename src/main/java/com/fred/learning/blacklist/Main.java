package com.fred.learning.blacklist;

import com.alibaba.fastjson.JSON;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-20
 * Desc     :  todo
 */
public class Main {

    public static void main(String[] args) {
        BlackListResult blackListResult = new BlackListResult<>();

        BlackListDubboVO blackListDubboVO = new BlackListDubboVO();
        blackListDubboVO.setApplyTime("2019-12-12");
        blackListDubboVO.setLoanTime("2019-12-20");
        blackListDubboVO.setLastBillingDate("2019-12-20");
        blackListDubboVO.setLastRepaymentDate("2019-12-20");
        blackListDubboVO.setOverdueAmount(5000L);
        blackListDubboVO.setOverdueDays(34);
        blackListResult.setData(JSON.toJSON(blackListDubboVO));

        System.out.println(blackListResult);
    }
}
