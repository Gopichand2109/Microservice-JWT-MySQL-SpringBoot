package com.appointment.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.microservice.model.AppointmentModel;

public interface AppointmentRepository extends JpaRepository<AppointmentModel, Integer> {

}
