package com.wr1ttenyu.beself.ssm.webappconfig.springmvc;

import com.wr1ttenyu.beself.ssm.webappconfig.spring.RootConfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 基于Servlet3规范,可以在java类中配置Servlet,而不是在web.xml中
 * 扩展AbstractAnnotationConfigDispatcherServletInitializer都会自动的配置springMvc的DispatcherServlet
 * 
 * 在Servlet3.0环境中,容器会在类路径中查找实现了javax.servlet.ServletContainerInitializer接口的类,如果能发现的话,
 * 就会用它来配置Servlet容器。
 * Spring提供了这个接口的实现,名为SpringServletContainerInitializer,这个类反过来又会查找实现WebApplicationInitailizer
 * 的类并将配置任务交给!它们!来完成。
 * AbstractAnnotationConfigDispatcherServletInitializer实现了WebApplicationInitailizer，因此当部署到
 * Servlet3.0容器中,就会自动发现,并用他来配置Servlet上下文。
 * 
 * 
 * ! AbstractAnnotationConfigDispatcherServletInitializer
 * 会同时创建DispatcherServlet和ContextLoaderListener !
 * 
 * @author wr1ttenyu
 */
public class SsmWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 加载ContextLoaderListener上下文环境
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	/**
	 * 加载DispatcherServlet上下文环境
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	/**
	 * 配置DispatcherServlet映射(也就是拦截哪些路径)
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * PS: ServletContext、WebApplicationContext、DispatcherServletContext 三者之间的关系
	 * ServletContext: web容器提供了一个全局的上下文环境，这个上下文就是ServletContext
	 * WebApplicationContext:
	 * 在web容器启动时会触发容器初始化事件，contextLoaderListener监听到这个事件后其contextInitialized方法就会被调用，在这个方法中，
	 * spring会初始化一个启动上下文，这个上下文就是根上下文，也就是WebApplicationContext
	 * DispatcherServletContext: DispatcherServlet上下文在初始化的时候会建立自己的IoC上下文，用以持有spring
	 * mvc相关的bean。
	 * 在建立DispatcherServlet自己的IoC上下文时，会利用WebApplicationContext.ROOTWEBAPPLICATIONCONTEXTATTRIBUTE
	 * 先从ServletContext中获取之前的根上下文(即WebApplicationContext)作为自己上下文的parent上下文。
	 * 有了这个parent上下文之后，再初始化自己持有的上下文。
	 * 
	 * ServletContext ----宿主-----> WebApplicationContext
	 * 
	 * WebApplicationContext ----parent-----> DispatcherServletContext
	 * 
	 * 参考：http://www.cnblogs.com/weknow619/p/6341395.html
	 */
}
