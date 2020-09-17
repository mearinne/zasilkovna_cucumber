package websrv.NeWAttempt;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WebServiceModel {

    public static void main(String[] args) {
        WebServiceModel webServiceModel = new WebServiceModel();
        webServiceModel.geHelloAge("John", 33);
    }

    public void geHelloAge(String name, int age) {
        String wsURL = "http://www.zasilkovna.cz/api/soap";
        URL url = null;
        URLConnection connection = null;
        HttpURLConnection httpConn = null;
        String responseString = null;
        String outputString="";
        OutputStream out = null;
        InputStreamReader isr = null;
        BufferedReader in = null;

        String xmlInput =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                        "xmlns:soap=\"http://www.zasilkovna.cz/api/soap.wsdl2\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<soap:packetStatus>" +
                        "<apiPassword>b60c9b216898c60ad694d43da8de1e30</apiPassword>" +
                        "<packetId>Z1524421816</packetId>" +
                        "</soap:packetStatus>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        try
        {
            url = new URL(wsURL);
            connection = url.openConnection();
            httpConn = (HttpURLConnection) connection;

            byte[] buffer = new byte[xmlInput.length()];
            buffer = xmlInput.getBytes();

            String SOAPAction = "";
            // Set the appropriate HTTP parameters.
            httpConn.setRequestProperty("Content-Length", String
                    .valueOf(buffer.length));
            httpConn.setRequestProperty("Content-Type",
                    "text/xml; charset=utf-8");


            httpConn.setRequestProperty("SOAPAction", SOAPAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            out = httpConn.getOutputStream();
            out.write(buffer);
            out.close();

            // Read the response and write it to standard out.
            isr = new InputStreamReader(httpConn.getInputStream());
            in = new BufferedReader(isr);

            while ((responseString = in.readLine()) != null)
            {
                outputString = outputString + responseString;
            }
           // System.out.println(outputString);
            System.out.println("");

            // Get the response from the web service call
            Document document = parseXmlFile(outputString);

            NodeList nodeLst = document.getElementsByTagName("ns1:dateTime");
            String webServiceResponse = nodeLst.item(0).getTextContent();
            System.out.println("Time is: " + webServiceResponse);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
