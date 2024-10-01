package com.example.pdfindexer;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.UUID;

public interface DocumentRepository extends ElasticsearchRepository<DocumentContent, UUID> {
}
