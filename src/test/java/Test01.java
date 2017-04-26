import com.alibaba.fastjson.JSONObject;
import common.Log;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static io.restassured.RestAssured.*;

/**
 * Created by zipon on 2017/4/7.
 */
public class Test01 {

    Logger logger = new Log("interface_1").logger;

    
    public Test01() throws FileNotFoundException {
    }

    @BeforeTest
    public void beforeTest(){
        //RestAssured.config().logConfig(new LogConfig(ps, true));
        RestAssured.config().getLogConfig().defaultStream();
    }

    @Test
    public void test(){
        RestAssured.baseURI="https://api.douban.com/v2/book";
        RestAssured.port = 8080;
        ResponseBody response =get("/1220562").body();
        JSONObject json = new JSONObject();
        json.put("baseURI","dffddd");
        RequestSpecification rs = given().contentType(ContentType.JSON).request().body(json.toJSONString()).log().everything();
        ResponseBody responsePost = given().contentType(ContentType.JSON).request().body(json.toJSONString()).log().everything().when().post("/1220562").body();
        //given().log().all();
        //get("/1220562").then().body("tags[0].count",equalTo(142));//then后跟断言
        responsePost.print();
        logger.debug(response.asString());
        System.out.println(response.jsonPath().getJsonObject("tags"));

    }

    @Test
    public void mockTest(){
        //http://mocker.ucweb.com/mock_api/58edff6ec21cb936c3bdfad5/test/
        RestAssured.baseURI="http://mocker.ucweb.com/mock_api/58edff6ec21cb936c3bdfad5/test";
        RequestSpecification requestSpecification = given().pathParam("id","1");
        logger.debug(requestSpecification.head());
        ResponseBody responseBody = given().pathParam("id",1).when().post("/{id}");
        logger.debug("请求返回为："+responseBody.asString());
    }

    @Issue("AG-2759823")
    @TestCaseId("AG-450234")
    //@Features(Feature.SMOKE)
    @Stories("DAG图所有算子的运行测试")
    @Title("冒烟测试_所有算子运行_正常测试")
    @Description("测试一个流程，用作回归冒烟测试")
    @Test
    public void realTimeTest(){
        RestAssured.baseURI = "http://indiawmdataapiservice.dev.uae.uc.cn";
        String  wm_people_id = "57e965d74f2aa79537e3a787ac31ff36";
        ResponseBody responseBody = get("/1/cp/get_people_pv/57e965d74f2aa79537e3a787ac31ff36").body();
        responseBody.print();
    }


    @Test
    public void testSSSS(){

    }
}
