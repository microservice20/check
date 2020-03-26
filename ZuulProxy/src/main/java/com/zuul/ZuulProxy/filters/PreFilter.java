package com.zuul.ZuulProxy.filters;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.protocol.RequestContent;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import ch.qos.logback.core.net.SyslogOutputStream;

public class PreFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}


	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		System.out.println("Request Method: " + request.getMethod()+ " Request URL: "+ request.getRequestURL().toString());
		return null;
	}

}
