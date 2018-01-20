package com.jiangli.spring.cloud.common.junit.data.handler;


import com.jiangli.spring.cloud.common.junit.InvokeContext;
import com.jiangli.spring.cloud.common.junit.data.DataCollector;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Jiangli
 * @date 2017/12/28 11:18
 */
public class ConsolePrintDataHandler implements DataHandler {

    @Override
    public void handler(InvokeContext context, DataCollector model) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>" + context.getGroupInvoker().getGroupName() + ">>>>>>>>>>>>>>>>>>>>");
        System.out.println("\t>>>>>>>>模式:(" + context.getInvokeMode() + ")>>>>>>>>>>>>>>>");
        if (context.isMultiThread()) {
            System.out.println("\t>>>>>>>> 线程数 * " + context.getThreadNum() + " >>>>>>>>>>>>>>>>>>>>>>>");
        }
        System.out.println("\t总次数:" + model.getTotalTimes() + "");
        System.out.println("\t总耗时:" + model.getTotalCost() + "ms");
        if (!context.isMultiThread()) {
            System.out.println("\t\t平均:" + (model.getTotalCost()) / model.getTotalTimes() + "ms");
            System.out.println("\t\t最高:" + model.getMaxCost() + "ms");
            System.out.println("\t\t最低:" + model.getMinCost() + "ms");
        }
        if (model.getTotalCost() > 0) {
            System.out.println("\t\ttps:" + parseNumber(model.getTotalTimes() * 1000.0 / model.getTotalCost()) + " /s");
        } else {
            System.out.println("\t\ttps 总耗时过小 无法估算");
        }
        if (model.getTotalTimes() > 2 && model.getTotalCost() > 0) {
            long reducedTimes = model.getTotalTimes() - 2;
            long reducedTotalCost = model.getTotalCost() - model.getMaxCost() - model.getMinCost();
            System.out.println("\t\ttps(去掉最高和最低):" + parseNumber(reducedTimes * 1000.0 / reducedTotalCost) + " /s");
        }
        System.out.println("------------------------------------------------");
    }

    public String parseNumber(String pattern, double bd) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(new BigDecimal(bd));
    }
    public String parseNumber(double bd) {
//        return parseNumber(",###,###",bd);
        return parseNumber(",###,###.00",bd);
    }
}
