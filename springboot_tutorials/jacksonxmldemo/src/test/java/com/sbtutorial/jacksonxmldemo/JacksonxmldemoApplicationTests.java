package com.sbtutorial.jacksonxmldemo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@SpringBootTest
class JacksonxmldemoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void whenJavaSerializedToXmlStr_thenCorrect() throws JsonProcessingException {
	    XmlMapper xmlMapper = new XmlMapper();
	    String xml = xmlMapper.writeValueAsString(new SimpleBean());
	    assertNotNull(xml);
	}
	
	@Test
	public void whenJavaGotFromXmlStr_thenCorrect() throws IOException {
	    XmlMapper xmlMapper = new XmlMapper();
	    SimpleBean value
	      = xmlMapper.readValue("<SimpleBean><a>1</a><b>2</b></SimpleBean>", SimpleBean.class);
	    assertTrue(value.getA() == 1 && value.getB() == 2);
	}
	



}
