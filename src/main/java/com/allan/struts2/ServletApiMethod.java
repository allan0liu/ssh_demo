package com.allan.struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class ServletApiMethod extends ActionSupport {

    @Override
    public String execute() throws Exception{
        ActionContext context = ActionContext.getContext();
        Map<String, Object> parameters = context.getParameters();
        for(String key: parameters.keySet()){
            String[] value = (String[])parameters.get(key);
            System.out.println("key: " + key + " value: " + value[0]);
        }

        //向request中存入数据
        context.put("requestName" , "张三");
        context.getSession().put("sessionName", "sb");
        context.getApplication().put("applicationName", "five");
        return "success";
    }
}
