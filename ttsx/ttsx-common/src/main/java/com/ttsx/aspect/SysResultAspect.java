package com.ttsx.aspect;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ttsx.vo.SysResult;


//@ControllerAdvice //定义异常处理类  只针对controller层生效
@RestControllerAdvice
public class SysResultAspect {
	/**
	 * 如果程序报错,则统一返回系统的异常信息
	 * SysResult.fail()
	 */
	@ExceptionHandler({RuntimeException.class,SQLException.class})
	//@ResponseBody
	public SysResult sysResultFail(Exception e) {
		System.out.println("~~~~服务器异常"+e.getMessage());
		return SysResult.fail();
	}
}
