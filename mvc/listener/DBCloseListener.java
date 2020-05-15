package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model.Proccess;

public class DBCloseListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	    Proccess.conClose();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
