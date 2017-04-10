package common;

import org.apache.log4j.*;

import java.io.File;


public class Log {
	public Logger logger;
	public static String log4jdir;
    private static String filePath = "src/main/java/common/log4j.properties";
    public static String loggerName = "test_log";
    
    public Log(String name){  
    	loggerName = name;
    	logger = Logger.getLogger(loggerName);
        log4jdir = System.getenv( "log4jdir" );
        if(log4jdir==null)
        	log4jdir = "testlog";
        System.setProperty("log4jdir", log4jdir); 
        PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
     }
    public Log(){  
    	
    	logger = Logger.getLogger(loggerName);
        log4jdir = System.getenv( "log4jdir" );
        if(log4jdir==null)
        	log4jdir = "testlog";
        System.setProperty("log4jdir", log4jdir); 
        PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
     }

    

}
