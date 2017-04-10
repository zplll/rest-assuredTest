import com.alibaba.fastjson.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by zipon on 2017/4/7.
 */
public class Test01 {
    @Test
    public void test(){
        RestAssured.baseURI="https://api.douban.com/v2/book";
        RestAssured.port = 8080;
        ResponseBody response =get("/1220562").body();
        JSONObject json = new JSONObject();
        ResponseBody responsePost = given().request().body(json).when().post();
        given().log().all();
        //get("/1220562").then().body("tags[0].count",equalTo(142));//then后跟断言
        response.print();
        System.out.println(response.jsonPath().getJsonObject("tags"));

    }
}
