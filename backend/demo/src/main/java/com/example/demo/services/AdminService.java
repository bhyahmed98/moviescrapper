package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;

@Service

public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();

	}

	public Admin getAdminById(Long id) {
		return adminRepository.findById(id).get();
	}

	public void addAdmin(Admin admin) {
		adminRepository.save(admin);
	}

	public void deleteAdmin(Long Id) {
		adminRepository.deleteById(Id);
	}

	;
}
