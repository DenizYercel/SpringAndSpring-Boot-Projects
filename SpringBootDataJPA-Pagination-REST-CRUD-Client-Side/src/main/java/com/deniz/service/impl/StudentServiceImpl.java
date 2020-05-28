package com.deniz.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deniz.model.Page;
import com.deniz.model.Student;
import com.deniz.model.Students;
import com.deniz.service.StudentService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentServiceImpl implements StudentService {

	static final String serverUrl = "http://localhost:8081/students/";
	static ObjectMapper mapper = new ObjectMapper();
	static MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	static RestTemplate restTemplate = new RestTemplate(Collections.singletonList(converter));
	static ResponseEntity<Students> result;
	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(new Jackson2HalModule());

		converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
		converter.setObjectMapper(mapper);
	}
	static String link;

	public static List<Student> students(int page, int pageSize) {
		String requestUri = null;

		if (link == null)
			requestUri = serverUrl + "?p=" + page + "&l=" + pageSize;
		else
			requestUri = link;

		System.out.println("request : " + requestUri);
		result = restTemplate.getForEntity(requestUri, Students.class, new HashMap<String, Object>());

		System.out.println("result : " + result);
		System.out.println("getBody : " + result.getBody());
		System.out.println("studentList : " + result.getBody().getEmbedded().getStudents());

		return result.getBody().getEmbedded().getStudents();
	}

	public static List<Student> studentsLink(String paramLink) {

		link = result.getBody().getRequiredLink(paramLink).getHref();
		ResponseEntity<Students> result2 = restTemplate.getForEntity(link, Students.class,
				new HashMap<String, Object>());
		result = result2;
		return result2.getBody().getEmbedded().getStudents();
	}

	
	private static Student getStudentRest(int studentId) {
		return restTemplate.getForObject(serverUrl + studentId, Student.class);

	}

	
	private static ResponseEntity<Student> insertStudent(Student student) {
		RestTemplate rest = new RestTemplate();
		return rest.postForEntity(serverUrl, student, Student.class);
	}

	
	private static void updateStudent(Student student) {
		RestTemplate rest = new RestTemplate();
		rest.put(serverUrl+"/"+student.getId(), student);
	}

	
	private static void deleteStudentRest(int id) {
		restTemplate.delete(serverUrl+id, id);

	}

	@Override
	public List<Student> getStudents(Integer page, Integer pageSize) {
		link = null;
		System.out.println("page : " + page + "pageSize : " + pageSize);
		return students(page, pageSize);
	}

	@Override
	public List<Student> getStudentsLink(String paramLink) {
		return studentsLink(paramLink);

	}

	@Override
	public Student getStudent(int studentId) {
		
		return getStudentRest(studentId);
	}

	@Override
	public void saveStudent(Student student) {
		if(student.getId()!=null)
			updateStudent(student);
		else
			insertStudent(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		deleteStudentRest(studentId);
		
	}

	@Override
	public int getPageSize() {
		
		return result.getBody().getPage().getNumber();
	}

	@Override
	public int getTotal() {
		
		return result.getBody().getPage().getTotalPages();
	}

	@Override
	public int getSize() {
		
		return result.getBody().getPage().getSize();
	}

	@Override
	public Page getPage() {
		
		return result.getBody().getPage();
	}

}
