package org.apache.dubbo.samples.api.seata;

import io.seata.rm.tcc.api.BusinessActionContext;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

@DubboService(version = "1.0.0")
public class TccActionTwoImpl implements TccActionTwo{

    public boolean prepare(BusinessActionContext actionContext, String b, List list) {
        String xid = actionContext.getXid();
        System.out.println("TccActionTwo prepare, xid:" + xid + ", b:" + b + ", c:" + list.get(1));
        return true;
    }

    public boolean commit(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        System.out.println("TccActionTwo commit, xid:" + xid + ", b:" + actionContext.getActionContext("b") + ", c:" + actionContext.getActionContext("c"));
        ResultHolder.setActionTwoResult(xid, "T");
        return true;
    }


    public boolean rollback(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        System.out.println("TccActionTwo rollback, xid:" + xid  + ", b:" + actionContext.getActionContext("b") + ", c:" + actionContext.getActionContext("c"));
        ResultHolder.setActionTwoResult(xid, "R");
        return true;
    }
}
