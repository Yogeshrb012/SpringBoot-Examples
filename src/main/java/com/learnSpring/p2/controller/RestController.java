package com.learnSpring.p2.controller;

import com.learnSpring.p2.entity.Content;
import com.learnSpring.p2.entity.Document;
import com.learnSpring.p2.entity.Physician;
import com.learnSpring.p2.projections.ContentDocumentPhysician;
import com.learnSpring.p2.projections.ContentPhysician;
import com.learnSpring.p2.repository.ContentRepo;
import com.learnSpring.p2.repository.DocumentsRepo;
import com.learnSpring.p2.service.TspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/tsp")
public class RestController {
    @Autowired
    private ContentRepo contentRepo;
    @Autowired
    private DocumentsRepo documentsRepo;

    @Autowired
    private TspService tspService;

    public RestController(TspService thetspService){
                tspService = thetspService;
    }


    @GetMapping("/physicians")
    public List<Physician> findAllPhysicians(){
        return  tspService.findAllPhysicians();
    }

    @GetMapping("/contents")
    public List<Content> contents(){
        return tspService.findallContent();
    }
    @GetMapping("/documents")
    public List<Document> docs(){
        return tspService.findAllAllDocuments();
    }

    /**
     this block of code is to get the value of particular entry of list on entries
     */

    @GetMapping("/physicians/{physicianID}")
    public Physician thePhysician(@PathVariable int physicianID){
        Physician tempPhysician = tspService.findPhysicianById(physicianID);
        if(tempPhysician == null){
            throw new RuntimeException("Physician does not exists");
        }
        return tempPhysician;
    }

    @GetMapping("/contents/{contentID}")
    public Content theContent(@PathVariable int contentID){
        Content tempContent = tspService.findContentsById(contentID);
        if(tempContent == null){
            throw new RuntimeException("Content does not exists");
        }
        return tempContent;
    }

    @GetMapping("/documents/{documentID}")
    public Document theDocument(@PathVariable int documentID){
        Document tempDocument = tspService.findDocumentsById(documentID);
        if(tempDocument == null){
            throw new RuntimeException("Document does not exists");
        }
        return tempDocument;
    }

    /**
     this block of code is to push an entry to existing tables
     */
    @PostMapping("/physicians")
    public Physician addNewPhysician(@RequestBody Physician thePhysician){
        thePhysician.setId(0);

        Physician physician =tspService.savePhysician(thePhysician);
        return physician;
    }
    @PostMapping("/documents")
    public Document addNewDocument(@RequestBody Document theDocument){
        theDocument.setId(0);

        Document tempDocument = tspService.saveDocuments(theDocument);
        return tempDocument;
    }

    @PostMapping("/contents")
    public Content addNewContent(@RequestBody Content theContent){
        theContent.setId(0);

        Content tempContent = tspService.saveContents(theContent);
        return tempContent;
    }


    /**
     this block of code is to Update the entries present in tables
     */

    @PutMapping("/physicians")
    public Physician updatePhysician(@RequestBody Physician thePhysician){
        Physician tempPhysician = tspService.savePhysician(thePhysician);
        return tempPhysician;
    }

    @PutMapping("/documents")
    public Document updateDocument(@RequestBody Document theDocument){
        Document tempDOcument = tspService.saveDocuments(theDocument);

        return tempDOcument;
    }

    @PutMapping("/contents")
    public Content updateContent(@RequestBody Content theContent){
        Content tempContent = tspService.saveContents(theContent);
        return tempContent;
    }

    /**
     * this block of code is to delete an entry
     */

    @DeleteMapping("/physicians/{physicianID}")
    public String deletePhysician(@PathVariable int physicianID){
        Physician tempPhysician = tspService.findPhysicianById(physicianID);
        if(tempPhysician == null){
            throw new RuntimeException("Physician does not exists for such id");
        }
        else {
            tspService.deletePhysicianById(physicianID);
        }
        return "Deleted Successfully!!!";
    }

    @DeleteMapping ("/documents/{documentID}")
    public String deleteDocumentsWithID(@PathVariable int documentID){
       Document tempDocument = tspService.findDocumentsById(documentID);
       if(tempDocument == null){
           throw new RuntimeException("Document for Such ID does not exists");
       }
        tspService.deleteDocumentById(documentID);
        return "Deleted Document Successfully";
    }

    @DeleteMapping("/contents/{contentID}")
    public String deleteContentById(@PathVariable int contentID){
        Content tempContent = tspService.findContentsById(contentID);
        if(tempContent == null){
            throw new RuntimeException("Such content does not exists for contentID");
        }
        tspService.deleteContentById(contentID);
        return "deleted Successfully!!!";
    }



    @GetMapping("/ContentAndPhysicians/{physicianID}")
    public List<ContentPhysician> contentWithPhysicians(@PathVariable int physicianID){

        return contentRepo.contentWithPhysicians(physicianID);
    }

    @GetMapping("/InfoOfActivePhysician/{active_Flag}")
    public List<ContentDocumentPhysician> infoOfActivePhysician(@PathVariable String active_Flag){
        return documentsRepo.getDetailsFromActivePhysician(active_Flag);
    }


}
