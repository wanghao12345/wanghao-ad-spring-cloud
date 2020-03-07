package com.wanghao.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 过滤器
 */
@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {
    @Override
    public String filterType() { // 过滤的类型
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() { // 过滤的顺序，数字越小越优先
        return 0;
    }

    @Override
    public boolean shouldFilter() { // 是否执行过滤器，false不执行，true执行
        return true;
    }

    @Override
    public Object run() throws ZuulException { // 具体过滤
        RequestContext ctx = RequestContext.getCurrentContext(); // 请求上下文
        ctx.set("startTime", System.currentTimeMillis());
        return null;
    }
}
