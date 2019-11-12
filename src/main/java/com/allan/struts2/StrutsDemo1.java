package com.allan.struts2;

import com.allan.entity.User;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class StrutsDemo1 {
    public String execute() throws OgnlException {
        OgnlContext ognlContext = new OgnlContext();
        ognlContext.put("name", "allan");
        String name = (String)Ognl.getValue("#name", ognlContext, ognlContext.getRoot());
        System.out.println(name);

        //获取root中的数据
        User user = new User();
        user.setName("fier");
        ognlContext.setRoot(user);
        String name2 = (String)Ognl.getValue("name", ognlContext, ognlContext.getRoot());
        System.out.println(name2);
        return "success";
    }
}
