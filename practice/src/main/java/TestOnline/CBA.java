package TestOnline;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dungphan on 8/16/17.
 */
public class CBA {

    public static Collection<Integer> getIdsByMessage(String xmlStr, String message) {
        if (message == null || message.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(xmlStr)));

            NodeList messages = doc.getElementsByTagName("message");
            for (int i = 0; i < messages.getLength(); i++) {
                Node messageNode = messages.item(i);
                if (message.equals(messageNode.getTextContent())) {
                    result.add(Integer.parseInt(messageNode.getParentNode().getAttributes().getNamedItem("id").getTextContent()));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<log>\n" +
                "    <entry id = \"1\">\n" +
                "        <message>Application started</message>\n" +
                "    </entry>\n" +
                "    <entry id = \"2\">\n" +
                "        <message>Application ended</message>\n" +
                "    </entry>\n"+
                "</log>";

        Collection<Integer> results = CBA.getIdsByMessage(xml, "Application ended");

        for(int i : results) {
            System.out.print(i + " ");
        }
    }
}
