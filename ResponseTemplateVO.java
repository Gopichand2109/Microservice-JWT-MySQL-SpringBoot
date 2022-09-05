package com.appointment.microservice.vo;

import com.appointment.microservice.model.AppointmentModel;

public class ResponseTemplateVO {
	private AppointmentModel model;
	private Doctor doctor;
	public AppointmentModel getModel() {
		return model;
	}
	public void setModel(AppointmentModel model) {
		this.model = model;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
}
