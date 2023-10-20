package com.learnSpring.p2.service;

import com.learnSpring.p2.entity.Content;
import com.learnSpring.p2.entity.Document;
import com.learnSpring.p2.entity.Physician;
import com.learnSpring.p2.repository.ContentRepo;
import com.learnSpring.p2.repository.DocumentsRepo;
import com.learnSpring.p2.repository.PhysicianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TspService {
    private PhysicianRepo physicianRepo;
    private ContentRepo contentRepo;
    private DocumentsRepo documentsRepo;

    @Autowired
    public TspService(PhysicianRepo physicianRepository, ContentRepo contentRepository, DocumentsRepo documentsRepository ){
        physicianRepo = physicianRepository;
        contentRepo = contentRepository;
        documentsRepo = documentsRepository;
    }

    public List<Physician> findAllPhysicians() {
        return physicianRepo.findAll();
    }


    public List<Document> findAllAllDocuments() {
        return documentsRepo.findAll();
    }


    public List<Content> findallContent() {
        return contentRepo.findAll();
    }


    public Physician findPhysicianById(int id) {
        Optional<Physician> result = physicianRepo.findById(id);
        Physician physician =null;
        if(result.isPresent()){
            physician = result.get();
        }
        else {
            throw new RuntimeException("Physician DOes Not exists");
        }
        return physician;
    }


    public Content findContentsById(int id) {
        Optional<Content> result = contentRepo.findById(id);
        Content content = null;
        if(result.isPresent()){
            content = result.get();
        }
        else{
            throw new RuntimeException("Content does not exists");
        }
        return content;
    }


    public Document findDocumentsById(int id) {
        Optional<Document> result = documentsRepo.findById(id);
        Document document = null;
        if(result.isPresent()){
            document = result.get();
        } else{
            throw new RuntimeException("Document does not exists");
        }
        return document;
    }

    public Physician savePhysician(Physician thePhysician) {
        return physicianRepo.save(thePhysician);
    }

    public Content saveContents(Content theContent) {
        return contentRepo.save(theContent);
    }


    public Document saveDocuments(Document theDocument) {
        return documentsRepo.save(theDocument);
    }


    public void deletePhysicianById(int id) {
        physicianRepo.deleteById(id);
    }


    public void deleteContentById(int id) {
        contentRepo.deleteById(id);
    }


    public void deleteDocumentById(int id) {
        documentsRepo.deleteById(id);
    }


}
