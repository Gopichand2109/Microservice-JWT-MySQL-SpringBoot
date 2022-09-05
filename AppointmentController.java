package com.appointment.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.microservice.model.AppointmentModel;
import com.appointment.microservice.model.AuthenticationRequest;
import com.appointment.microservice.model.AuthenticationResponse;
import com.appointment.microservice.service.AppointmentService;
import com.appointment.microservice.service.LoginUserDetailsService;
import com.appointment.microservice.util.JwtUtil;
import com.appointment.microservice.vo.ResponseTemplateVO;


@RestController
public class AppointmentController {
	

	@Autowired
    private JwtUtil jwtUtil;
	
    @Autowired
    private AuthenticationManager authenticationManager;

	@Autowired
	AppointmentService service;
	
	@Autowired
	private LoginUserDetailsService userService;
	
	@PostMapping("/addAppointment")
	public AppointmentModel addAppointment(@RequestBody AppointmentModel app){
		return service.saveAppointment(app);
	}
	@GetMapping("/appointmentlists")
	public List<AppointmentModel> getAllAppointments(){
		return service.getAllAppointments();
	}
	
	@PutMapping("/update")
    public AppointmentModel updateAppointment(@RequestBody AppointmentModel app) {
        return service.updateAppointment(app);
    }
	 @DeleteMapping("/delete/{id}")
	  public String deleteAppointment(@PathVariable int id) {
	        return service.deleteAppointment(id);
	    }
	 @GetMapping("/appointmentwithdoctor/{id}")
	 public ResponseTemplateVO getDetailsWithAppointment(@PathVariable int id){
		 return service.getDetailsWithAppointment(id);
	 }
	 
	 
	 @PostMapping("/authenticate")
	    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authRequest) throws Exception {
		 try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            authRequest.getUsername(),
	                            authRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }
	      
	 
	        final UserDetails userDetails
            = userService.loadUserByUsername(authRequest.getUsername());

    final String token = jwtUtil.generateToken(userDetails);

    return  new AuthenticationResponse(token);
}
}
