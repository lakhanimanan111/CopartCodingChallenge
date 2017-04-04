package com.copart.coding.PdfExtractor;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;



public class PdfExtractor {
	
	    public static void main(String args[]) {
	        PDFTextStripper pdfStripper = null;
	        PDDocument pdDoc = null;
	        COSDocument cosDoc = null;
	        File file = new File("C:/Users/manan/Documents/MyDocs/Resume/MyResume/OnlineApplications/Resume_MananLakhani.pdf");
	        try {
	            PDFParser parser = new PDFParser(new FileInputStream(file));
	            parser.parse();
	            cosDoc = parser.getDocument();
	            pdfStripper = new PDFTextStripper();
	            pdDoc = new PDDocument(cosDoc);
	            pdfStripper.setStartPage(1);
	            pdfStripper.setEndPage(5);
	            String parsedText = pdfStripper.getText(pdDoc);
	            System.out.println(parsedText);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	    }
	}

