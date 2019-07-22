package org.accp.office.interceptor;

import org.accp.office.pojo.Employee;
import org.accp.office.util.MsgUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author XingYu Yi
 * @create 2019-06-18 11:30
 */
public class MyIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Employee emp = (Employee) request.getSession().getAttribute("emp");
        if (emp == null) {
            request.setAttribute("msg", MsgUtil.custom(500,"请先登录","login"));
            request.getRequestDispatcher("/msg").forward(request,response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
