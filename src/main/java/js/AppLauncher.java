package js;

import js.controller.MyBankController;
import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class AppLauncher {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8090);
        tomcat.getConnector();

        Context context = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(context, "MyBankController", new MyBankController());

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");
        tomcat.start();
        System.out.println("init...");
    }
}
