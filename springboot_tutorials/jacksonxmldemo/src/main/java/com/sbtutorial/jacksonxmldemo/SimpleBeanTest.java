package com.sbtutorial.jacksonxmldemo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SimpleBeanTest {
	
	@Test
	public void whenJavaSerializedToXmlStr_thenCorrect() throws JsonProcessingException {
	    XmlMapper xmlMapper = new XmlMapper();
	    String xml = xmlMapper.writeValueAsString(new SimpleBean());
	    assertNotNull(xml);
	}

}
