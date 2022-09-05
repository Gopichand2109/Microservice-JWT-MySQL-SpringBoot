package com.appointment.microservice.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.appointment.microservice.model.AppointmentModel;
import com.appointment.microservice.repository.AppointmentRepository;
import com.appointment.microservice.vo.Doctor;
import com.appointment.microservice.vo.ResponseTemplateVO;

@Service
public class AppointmentService {
	@Autowired
	AppointmentRepository appointmentrepository;
	
	@Autowired
	RestTemplate restTemplate;

	public AppointmentModel saveAppointment(AppointmentModel app) {
		
		return appointmentrepository.save(app);
	}
	public AppointmentModel updateAppointment(AppointmentModel app) {
	
		return appointmentrepository.save(app);
		
	}
	public String deleteAppointment(int id) {
		appointmentrepository.deleteById(id);
		return "Removed from Appointment_List"+ id;
	}
	public List<AppointmentModel> getAllAppointments() {
		
		return appointmentrepository.findAll();
	}
	public ResponseTemplateVO getDetailsWithAppointment(int id) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		AppointmentModel model = appointmentrepository.findById(id).orElse(null);
		Doctor doctor = restTemplate.getForObject("http://localhost:8084/doctorbyid/"+model.getDoctor_id(),Doctor.class);
		vo.setDoctor(doctor);
		vo.setModel(model);
		return vo;
	}
	
}
