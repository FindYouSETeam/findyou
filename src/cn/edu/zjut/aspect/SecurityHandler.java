package cn.edu.zjut.aspect;

import org.aspectj.lang.annotation.Before; 
import org.aspectj.lang.annotation.Aspect; 
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class SecurityHandler 
{
	/** 定义Pointcut,Pointcut的名称是modify，
	* 此方法不能有返回值和参数，该方法只是一个标识*/
	@Pointcut("execution(* cn.edu.zjut.dao.*.save(..)) || execution(* cn.edu.zjut.dao.*.delete(..)) || execution(* cn.edu.zjut.dao.*.update(..))") 
	private void modify(){};
	
	/** 定义Advice，标识在那个切入点何处织入此方法 */
	@Before("modify()")
	private void checkSecurity() 
	{
		System.out.println("---checkSecurity()---"); 
	}
}
