package com.learnSpring.p2;


import com.learnSpring.p2.controller.RestController;
import com.learnSpring.p2.entity.Content;
import com.learnSpring.p2.entity.Document;
import com.learnSpring.p2.entity.Physician;
import com.learnSpring.p2.repository.PhysicianRepo;
import com.learnSpring.p2.service.TspService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ServiceTest {
    private MockMvc mockMvc;
    @Mock
    TspService tspService;

    @InjectMocks
    RestController restController;

    @BeforeEach void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllThePhysicians() throws Exception {

        List<Physician> physicians = Arrays.asList(
                new Physician("Arnav",true,new Date()),
                new Physician("Sushil",false,new Date())
        );

        Mockito.when(tspService.findAllPhysicians()).thenReturn(physicians);

        List<Physician> physicianList = restController.findAllPhysicians();

        assertEquals(physicians.size(), physicianList.size());
        assertEquals(physicians.get(0).getName(), physicianList.get(0).getName());

        Mockito.verify(tspService, times(1)).findAllPhysicians();


    }

    @Test
    public void testThePhysicianByID() throws Exception{
        int id = 1;
        Physician physician = new Physician();
        physician.setId(1);
        physician.setName("sanat");
        physician.setActiveFlag(false);
        physician.setCreatedTime(new Date());


        Mockito.when(tspService.findPhysicianById(id)).thenReturn(physician);

        Physician toVerify = tspService.findPhysicianById(id);

        assertEquals(physician.getId(),toVerify.getId());
        assertEquals(physician.getName(),toVerify.getName());

        Mockito.verify(tspService, Mockito.times(1)).findPhysicianById(id);

    }
    @Test
    public void testAllContents() throws  Exception{
        List<Document> documents = Arrays.asList(
                new Document(1,20231016,202310100,"user-1",new Date()),
                new Document(2,20231016,202310100,"user-2",new Date())
        );

        Mockito.when(tspService.findAllAllDocuments()).thenReturn(documents);

        List<Document> documentList = restController.docs();

        assertEquals(documents.size(),documentList.size() );
        assertEquals(documents.get(0).getCreatedBy(), documentList.get(0).getCreatedBy());

        Mockito.verify(tspService, Mockito.times(1)).findAllAllDocuments();
    }
    @Test
    public void testAllDocumentsByID() throws  Exception{

        int id = 100000;
        Document document = new Document();
        document.setId(100000);
        document.setPhyID(2);
        document.setCreatedBy("user-1");
        document.setSessionKey(20231016);
        document.setSourceProductID(202310105);
        document.setCreatedTime(new Date());

        Mockito.when(tspService.findDocumentsById(id)).thenReturn(document);

        List<Document> documentList = (List<Document>) restController.theDocument(id);
        assertEquals(document.getId(), 100000);
        assertEquals(document.getPhyID(), 2);

        Mockito.verify(tspService, Mockito.times(1)).findDocumentsById(id);

    }

}
