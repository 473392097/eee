package com.lanou.action;

import com.lanou.bean.CrmStaff;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by lanouhn on 17/8/20.
 */
public class MyInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        CrmStaff crmStaff = (CrmStaff) ActionContext.getContext().getSession().get("session");

        if(crmStaff!=null){
            actionInvocation.invoke();

        }
        return "login";
    }
}
