package com.elham.restfulwebservice.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.elham.restfulwebservice.messenger.exception.DataNotFoundException;
import com.elham.restfulwebservice.messenger.model.Message;


public class MessageService {
	
	private Map<Long , Message> messages = DatabaseClass.getMessages();

	
	public MessageService() {
		messages.put(1L, new Message(1l, "Hello world!", "Elham"));
		messages.put(2L, new Message(2l, "Hello jersey!", "Elham"));
//		messages.put(3L, new Message(3l, "Hello queryParam!", "Elham"));
//		messages.put(4L, new Message(4l, "Hello pagination!", "Elham"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
			
	}
	
	public List<Message> getAllMessages(int year){
		List<Message> messageForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message msg : messages.values()) {
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR) == year)
				messageForYear.add(msg);
		}
		return messageForYear;
		
	}
	
	public List<Message> getAllMessages(int start , int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start+size>list.size()) return new ArrayList<Message>();
		return list.subList(start, size);
	}
	
	public Message getMessage(Long id) {
		Message message = messages.get(id);
		if(message==null)
			throw new DataNotFoundException("message with id: "+id+" does not exist!");
		return message;
	}

	
	public Message addMessage(Message msg) {
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg) {
		if(msg.getId() <= 0 )
			return null;
		else 
			messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
