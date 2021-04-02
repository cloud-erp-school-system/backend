package org.erp.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import org.erp.school.dto.DocumentRequestDto;
import org.erp.school.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api
@RequestMapping("/document")
public class DocumentController {

    private static Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private DocumentService docService;

    @PostMapping(name = "Endpoint for uploading documents")
    public @ResponseBody
    ResponseEntity postDocuments(
            @RequestParam(name = "documentJson", required = true) String docReuqestJson,
            @RequestParam(name = "documents", required = true) MultipartFile[] documents) {

        // validation
        try {
            ObjectMapper objMapper = new ObjectMapper();
            LOGGER.info("request : " + docReuqestJson);
            DocumentRequestDto docReq = objMapper.readValue(docReuqestJson, DocumentRequestDto.class);

            docService.postDocuments(documents, docReq);

        } catch (Exception e) {
            // logger to-do
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{docId}", name = "Endpoint for fetching documents")
    public @ResponseBody
    ResponseEntity getDocument(@Valid @PathVariable("docId") String docId) {

        String fileBase64 = null;
        try {
            fileBase64 = docService.getFile(docId);
        } catch (Exception e) {
            // logger tp be added
            LOGGER.info("Exception while getting document {}", e.getMessage());
        }

        return new ResponseEntity<String>(fileBase64, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{docId}", name = "Endpoint for deleting documents")
    public @ResponseBody
    ResponseEntity removeDocument(@Valid @PathVariable("docId") String docId) {

        boolean isRemoved = true;
        try {
            isRemoved = docService.deleteDocuments(docId);
        } catch (Exception e) {
            // logger exception and throw custom exception based on the error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Boolean>(new Boolean(isRemoved), HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/org/{orgId}", name = "Endpoint for fetching all documents for an organization")
    public @ResponseBody
    ResponseEntity fectchDosumentIds(@Valid @PathVariable("orgId") String organizationId) {

        List<String> docIds = null;
        try {
            docIds = docService.fetchAllDocIdsForOrg(organizationId);
        } catch (Exception e) {
            // logger exception and throw custom exception based on the error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<String>>(docIds, HttpStatus.OK);
    }
}
