package com.learnSpring.p2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.learnSpring.p2.controller.RestController;
import com.learnSpring.p2.entity.Content;
import com.learnSpring.p2.entity.Document;
import com.learnSpring.p2.entity.Physician;
import com.learnSpring.p2.repository.PhysicianRepo;
import com.learnSpring.p2.service.TspService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class P2ApplicationTests {
	private MockMvc mockMvc;
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	@Mock PhysicianRepo physicianRepo;

	@Mock
	Physician physician;
	@Mock
	Document document;
	@Mock
	Content content;
	@Mock
	TspService tspService;
	@InjectMocks
	RestController restController;


	@BeforeEach
	void setUp(){
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(tspService).build();

	}


	 @Test
	public void getAllRecords_success() throws Exception{
		List<Physician> physicians = new ArrayList<>();
		 Physician physician1 = new Physician();
		 physician1.setId(21);
		 physician1.setName("Abhin");
		 physician1.setActiveFlag(true);
		 physician1.setCreatedTime(new Date());


		 Mockito.when(tspService.findAllPhysicians()).thenReturn(physicians);
		 mockMvc.perform(MockMvcRequestBuilders
				 .get("/tsp/physicians")
				 .contentType(MediaType.APPLICATION_JSON))
				 .andExpect(status().isOk())
				 .andDo(MockMvcResultHandlers.print());
	}


	@Test
	public void getAllDocuments_success() throws Exception{
		List<Document> documents = new ArrayList<>();

		Document document1 = new Document(1, 20231016, 202310100, "user-1", new Date());
		document1.setId(100000);
		document1.setPhyID(2);
		document1.setSessionKey(20231017);
		document1.setSourceProductID(202310104);
		document1.setCreatedBy("user-1");
		document1.setCreatedTime(new Date());


		Mockito.when(tspService.findAllAllDocuments()).thenReturn(documents);
		mockMvc.perform(MockMvcRequestBuilders
				.get("/tsp/documents")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}






}
