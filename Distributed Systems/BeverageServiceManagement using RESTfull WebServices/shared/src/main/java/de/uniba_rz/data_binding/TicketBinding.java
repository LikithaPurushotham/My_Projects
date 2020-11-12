package de.uniba_rz.data_binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Type;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "topic", "reporter", "priority", "type",  "description", "status"})

public class TicketBinding {

	@XmlAttribute(required = true)
	private int id;
	private String topic;
	private String reporter;
	private Priority priority;
	private Type type;
	private String description;
	private Status status;

    public TicketBinding() {}


	public TicketBinding(int id, String topic, String reporter, Priority priority, Type type, String description) {
		super();
		this.id = id;
		this.topic = topic;
		this.reporter = reporter;
		this.priority = priority;
		this.type = type;
		this.description = description;
	}
	
	
	public TicketBinding(int id, String topic, String reporter, Priority priority, Type type, Status status, String description) {
		super();
		this.id = id;
		this.topic = topic;
		this.reporter = reporter;
		this.priority = priority;
		this.type = type;
		this.status = status;
		this.description = description;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getReporter() {
		return reporter;
	}


	public void setReporter(String reporter) {
		this.reporter = reporter;
	}


	public Priority getPriority() {
		return priority;
	}


	public void setPriority(Priority priority) {
		this.priority = priority;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "TicketBinding [id=" + id + ", topic=" + topic + ", reporter=" + reporter + ", priority=" + priority
				+ ", type=" + type + ", description=" + description + "]";
	}
    
}

