package interfaceTest.interface_1;

import com.alibaba.fastjson.JSONObject;
import common.Log;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/**
 * Created by zipon on 2017/4/10.
 */
public class Interface_1Test {


    Logger logger = new Log("interface_1").logger;


    @Test
    public void logTest(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",2222);
        given()
                .contentType("application/json")
                .request().body(jsonObject.toJSONString())
        .when()
                .post("http://mocker.ucweb.com/mock_api/58edff6ec21cb936c3bdfad5/test")
        .then().body("name",equalTo("zipon"));
        logger.debug("logTest00000000000000000");
    }
}
