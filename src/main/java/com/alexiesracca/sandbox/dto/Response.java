package com.alexiesracca.sandbox.dto;

import java.util.List;

import com.alexiesracca.sandbox.entity.GenericEntity;

public class Response{
	
	public static enum ResponseStatus {
		SUCCESS,
		FAILURE
	}
	
	private GenericEntity entity;
	
	private String text;
	
	private List<GenericEntity> list;
	
	private String message;
	
	private ResponseStatus status;
	
	public Response(ResponseStatus status, String message){
		
	}
	
	public Response(ResponseStatus status, String message, String text){
		this(status, message);
		setText(text);
	}
	
	public Response(ResponseStatus status, String message, GenericEntity entity){
		this(status, message);
		setEntity(entity);
	}
	
	public Response(ResponseStatus status, String message, List<GenericEntity> list){
		this(status, message);
		setList(list);
	}

	public GenericEntity getEntity() {
		return entity;
	}

	public void setEntity(GenericEntity entity) {
		this.entity = entity;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<GenericEntity> getList() {
		return list;
	}

	public void setList(List<GenericEntity> list) {
		this.list = list;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
		
}