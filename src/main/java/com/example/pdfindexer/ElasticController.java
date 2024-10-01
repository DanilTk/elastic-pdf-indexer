package com.example.pdfindexer;

import com.example.pdfindexer.controller.PdfIndexer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping(value = "/foo")
@RequiredArgsConstructor
public class ElasticController {

	private final PdfIndexer pdfIndexer;

	@PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
	public void upload(@RequestPart("file") MultipartFile file) {
		pdfIndexer.processPdf(file);
	}
}
