package study.stdlib;

import org.xml.sax.DTDHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

public class SaxStudy {
    public static void main(String[] args) {
        try {
            var schemaFactory = SchemaFactory.newDefaultInstance();
            schemaFactory.newSchema();
            var builder = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
            builder.setEntityResolver(null);
            var readerFactory = XMLReaderFactory.createXMLReader();
            var parserFactory = SAXParserFactory.newDefaultInstance();
            parserFactory.setNamespaceAware(false);
            parserFactory.setValidating(false);
            parserFactory.setSchema(null);
            var parser = parserFactory.newSAXParser();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}