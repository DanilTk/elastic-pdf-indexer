package com.example.pdfindexer.controller;

import com.example.pdfindexer.DocumentContent;
import com.example.pdfindexer.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PdfIndexer {

	private final DocumentRepository documentRepository;

	@SneakyThrows
	public void processPdf(MultipartFile file) {
		String text = parsePdf(file);
		indexPdf(text);
	}

	private void indexPdf(String text) {
		DocumentContent entity = new DocumentContent(UUID.randomUUID(), text);
		entity = documentRepository.save(entity);
	}

	private String parsePdf(MultipartFile file) {
		try {
			PDDocument document = Loader.loadPDF(file.getBytes());
			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(document);
			document.close();
			return text;
		} catch (Exception e) {
			throw new RuntimeException("Error parsing PDF", e);
		}

	}

}
