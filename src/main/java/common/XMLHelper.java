package common;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Created by zipon on 2017/4/27.
 */
public class XMLHelper {

    public Element getRootElement(String XMLPathStr) throws DocumentException {
            Document document = new SAXReader().read(new File(XMLPathStr));
            Element rootElement = document.getRootElement();
            return rootElement;
    }

}
