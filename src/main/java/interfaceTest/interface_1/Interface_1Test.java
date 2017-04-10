package interfaceTest.interface_1;

import common.Log;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by zipon on 2017/4/10.
 */
public class Interface_1Test {
    Logger logger = new Log("interface_1").logger;
    @Test
    public void logTest(){
        logger.debug("logTest00000000000000000");
    }
}
