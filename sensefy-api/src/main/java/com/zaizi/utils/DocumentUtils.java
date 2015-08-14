package com.zaizi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/**
 * <p>Document Utility class</p>
 * @author Antonio David Perez Morales <aperez@zaizi.com>
 *
 */
public class DocumentUtils
{
    private static final Logger logger = LoggerFactory.getLogger( DocumentUtils.class );
    /**
     * <p>Converts a {@code Document} object into {@code String} representation</p>
     * @param doc the {@code Document} to transform
     * @return a {@code String} containing the String representation of the document
     * @throws TransformerException
     */
    public static String documentToString(Document doc) throws TransformerException {
        Element element = doc.getDocumentElement();
        return elementToString(element);
    }
    
    /**
     * <p>Converts an {@code Element} object into {@code String} representation</p>
     * @param element
     * @return
     * @throws TransformerException
     */
    public static String elementToString(Element element) throws TransformerException {
        DOMSource domSource = new DOMSource(element);
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(domSource, streamResult);
        
        return stringWriter.toString();
    }
    
    /**
     * <p>Creates a new {@code Document} instance</p> 
     * @return the new {@code Document} instance
     */
    public static Document createDocument() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = null;
        try
        {
            db = dbf.newDocumentBuilder();
        }
        catch (ParserConfigurationException e)
        {
            logger.error( "Error creating the document ",e );
        }
        
        return db.newDocument();
    }



}
