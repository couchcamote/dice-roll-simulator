package com.alexiesracca.sandbox.dto;

import java.util.List;


public class Response{
	
	public static enum Status {
		SUCCESS,
		FAILURE
	}
	
	private GenericDto dto;
	
	private String text;
	
	private List<GenericDto> list;
	
	private String message;
	
	private Status status;
	
	public Response(Status status, String message){
		this.status = status;
		this.message = message;
	}
	
	public Response(Status status, String message, String text){
		this(status, message);
		setText(text);
	}
	
	public Response(Status status, String message, GenericDto dto){
		this(status, message);
		setDto(dto);
	}
	
	// public Response(Status status, String message, List<GenericDto> list){
	// 	this(status, message);
	// 	setList(list);
	// }

	public Response(Status status, String message, List list){
		this(status, message);
		setList(list);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public GenericDto getDto() {
		return dto;
	}

	public void setDto(GenericDto dto) {
		this.dto = dto;
	}

	public List<GenericDto> getList() {
		return list;
	}

	public void setList(List<GenericDto> list) {
		this.list = list;
	}
		
}