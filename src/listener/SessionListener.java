package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener,ServletContextListener,ServletRequestListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("有一个用户进来了....");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("用户离开了.....");

	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request请求结束");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("request请求处理");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
