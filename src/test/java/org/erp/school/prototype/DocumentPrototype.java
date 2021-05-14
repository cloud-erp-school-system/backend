package org.erp.school.prototype;

import org.erp.school.document.Document;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentPrototype {

    public static List<Document> getTestDocuments(){
        List<Document> testDocSet = new ArrayList<>();

        Document testDoc1 = new Document();

        testDoc1.setId("Test_Documents");
        testDoc1.setFileSize(1234);
        testDoc1.setFileType("application/pdf");
        testDoc1.setUri("/Test_Document1/test.pdf");
        testDoc1.setStorageType("File_Systems");
        testDoc1.setCreatedDate(new Timestamp(new Date().getTime()).toLocalDateTime());

        testDocSet.add(testDoc1);

        return testDocSet;
    }

    public static Document getTestDocument(){
        Document testDoc1 = new Document();

        testDoc1.setId("Test_Document1");
        testDoc1.setFileSize(1234);
        testDoc1.setFileType(".txt");
        testDoc1.setUri(testFile());
        testDoc1.setStorageType("File_Systems");
        testDoc1.setCreatedDate(new Timestamp(new Date().getTime()).toLocalDateTime());

        return testDoc1;
    }

    private static String testFile(){
        ClassLoader classLoader = DocumentPrototype.class.getClassLoader();
        File file = new File(classLoader.getResource("Test_Document1").getFile());
        return file.getAbsolutePath();
    }
}
