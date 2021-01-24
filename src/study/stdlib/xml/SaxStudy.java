package study.stdlib.xml;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class SaxStudy {
    public static void main(String[] args) {
        try {
            var schemaFactory = SchemaFactory.newDefaultInstance();

            var schema = schemaFactory.newSchema(new File("resources/hoge.xsd"));
            var builder = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
            builder.setEntityResolver(null);
            var parserFactory = SAXParserFactory.newDefaultInstance();
            parserFactory.setNamespaceAware(false);
            parserFactory.setSchema(schema);
            var parser = parserFactory.newSAXParser();
            System.out.println(parser.isValidating());
            var handler = new DefaultHandler() {
                @Override
                public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
                    System.out.println("ignorableWhitespace");
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("chars:" + new String(ch, start, length));
                }

                @Override
                public void warning(SAXParseException e) throws SAXException {
                    System.err.println(e.getLocalizedMessage());
                }

                @Override
                public void error(SAXParseException e) throws SAXException {
                    System.err.println(e.getLineNumber() + ":" + e.getLocalizedMessage());
                }
            };
            System.out.println("***hoge.xml***");
            parser.parse(new File("resources/hoge.xml"), handler);
            System.out.println("***hoge-withoutdtd.xml***");
            parserFactory.setValidating(true);
            parser = parserFactory.newSAXParser();
            parser.parse(new File("resources/hoge-withoutdtd.xml"), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}