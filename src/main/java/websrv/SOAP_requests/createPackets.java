package websrv.SOAP_requests;

import Configuration.endpoint;
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

public class createPackets {


    public String performRequest_and_getResponse(String body_0,String body_1 ,String body_2, String body_3,
                                                 String body_4,String body_5,
                                                 String tagName, int index) {
        String wsURL = new endpoint().getEndpoint;
        URL url = null;
        URLConnection connection = null;
        HttpURLConnection httpConn = null;
        String responseString = null;
        String outputString="";
        OutputStream out = null;
        InputStreamReader isr = null;
        BufferedReader in = null;
        String webServiceResponse = null;

        String xmlInput =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                        "xmlns:soap=\"http://www.zasilkovna.cz/api/soap.wsdl2\" " +
                        "xmlns:soap1=\"http://www.zasilkovna.cz/api/soap.wsdl\">" +
                           "<soapenv:Header/>" +
                           "<soapenv:Body>" +
                              "<soap:createPackets>" +
                                 body_0+
                                 "<packets>" +
                                    "<!--1 or more repetitions:-->" +
                                    "<soap1:attributes>" +
                                       "<!--You may enter the following 27 items in any order-->" +
                                        body_1+
                                       "<soap1:dispatchOrder>" +
                                          body_2 +
                                       "</soap1:dispatchOrder>" +
                                       "<soap1:customsDeclaration>" +
                                          "<!--You may enter the following 3 items in any order-->" +
                                          body_3 +
                                          "<soap1:items>" +
                                             "<!--1 or more repetitions:-->" +
                                             "<soap1:item>" +
                                                body_4 +
                                             "</soap1:item>" +
                                          "</soap1:items>" +
                                       "</soap1:customsDeclaration>" +
                                       "<soap1:size>" +
                                         body_5+
                                       "</soap1:size>" +
                                    "</soap1:attributes>" +
                                 "</packets>" +
                                 "<transaction>?</transaction>" +
                              "</soap:createPackets>" +
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

            NodeList nodeLst = document.getElementsByTagName(tagName);
            webServiceResponse = nodeLst.item(index).getTextContent();
            System.out.println(webServiceResponse);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return webServiceResponse;
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
