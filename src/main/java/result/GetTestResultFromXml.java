package result;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.XMLHelper;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.testng.annotations.Test;


import java.util.Iterator;
import java.util.List;


/**
 * Created by zipon on 2017/4/27.
 */
public class GetTestResultFromXml {
    private String targetPath = "target/surefire-reports/testng-results.xml";
    public JSONArray getTestResult() throws DocumentException {
        JSONArray result = new JSONArray();
        Element rootElement = new XMLHelper().getRootElement(targetPath);
        List classElements =  rootElement.element("suite").element("test").elements("class");
        for (int i = 0;i<classElements.size();i++) {
            Element classElement = (Element)classElements.get(i);
            JSONObject classJO = new JSONObject();
            classJO.put("name",classElement.attributeValue("name"));

            //创建一个jsonarray装method标签
            JSONArray testMethodArray = new JSONArray();
            //获取test-method list
            List testMethodElements= classElement.elements("test-method");
            for (int j = 0;j<testMethodElements.size();j++){
                Element testMethodElement = (Element)testMethodElements.get(j);
                JSONObject testMethodJO = new JSONObject();
                testMethodJO.put("name",testMethodElement.attributeValue("name"));
                testMethodJO.put("status",testMethodElement.attributeValue("status"));
                testMethodJO.put("started-at",testMethodElement.attributeValue("started-at"));
                System.out.println(testMethodElement.attributeValue("started-at"));
                testMethodJO.put("finished-at",testMethodElement.attributeValue("finished-at"));
                if(testMethodElement.attributeValue("status").equals("FAIL")) {
                    testMethodJO.put("exception", testMethodElement.element("exception").attributeValue("class")+"-------"+testMethodElement.element("exception").element("message").getTextTrim());
                }
                testMethodArray.add(testMethodJO);
            }
            classJO.put("testMethods",testMethodArray);

            result.add(classJO);
        }

        System.out.println(result);
        return  result;
    }

    public static void main(String[] args) throws DocumentException {
        new GetTestResultFromXml().getTestResult();
    }
}
