
package com.java.test.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import com.java.test.dao.impl.PharmacyDaoImpl;
import com.java.test.model.Pharmacy;
//import com.java.test.model.PharmacyOTP;

public class PharmacyController {

	private PharmacyDaoImpl pharmacyDao;
	private Pharmacy pharmacy;
//	private PharmacyOTP pharmacyOTP;
	private String confirmPassword;

	public String getConfirmPassword() {
	    return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
	    this.confirmPassword = confirmPassword;
	}

	
//	public PharmacyOTP getPharmacyOTP() {
//		return pharmacyOTP;
//	}
//	public void setPharmacyOTP(PharmacyOTP pharmacyOTP) {
//		this.pharmacyOTP = pharmacyOTP;
//	}
	public PharmacyDaoImpl getPharmacyDao() {
		return pharmacyDao;
	}
	public void setPharmacyDao(PharmacyDaoImpl pharmacyDao) {
		this.pharmacyDao = pharmacyDao;
	}
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	
	public String registerPharmacy() {
	    String result = pharmacyDao.addPharmacy(pharmacy);
	    FacesContext.getCurrentInstance().addMessage(null,
	        new FacesMessage(FacesMessage.SEVERITY_INFO, result, null));
	    return "otp.jsf?faces-redirect=true";
	}

	
//	public String validateLogin() {
//	    String email = pharmacy.getEmail();
//	    String password = pharmacy.getPassword();
//
//	    if (pharmacyDao.validatePassword(email, password)) {
//	        return "home.jsf?faces-redirect=true";
//	    }
//
//	    if (pharmacyDao.validateTempPassword(email, password)) {
//	        return "resetPassword.jsf?faces-redirect=true";
//	    }
//
//	    FacesContext.getCurrentInstance().addMessage(null,
//	        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));
//	    return null;
//	}

	public String validateLogin() {
	    String email = pharmacy.getEmail();
	    String password = pharmacy.getPassword();

	    if (pharmacyDao.validatePassword(email, password)) {
	        Pharmacy found = pharmacyDao.getPharmacyByEmail(email);

	        if (!"Active".equalsIgnoreCase(found.getStatus())) {
	            FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                    "Account not activated. Please wait for admin approval.", null));
	            return null;
	        }

	        return "home.jsf?faces-redirect=true";
	    }

	    if (pharmacyDao.validateTempPassword(email, password)) {
	        return "login.jsf?faces-redirect=true";
	    }

	    FacesContext.getCurrentInstance().addMessage(null,
	        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));
	    return null;
	}

	
	public String validateTempPassword() {
	    String email = pharmacy.getEmail();
	    String password = pharmacy.getPassword();

	    boolean isValid = pharmacyDao.validateTempPassword(email, password);

	    if (isValid) {
	        return "resetPassword.jsf?faces-redirect=true";
	    } else {
	        FacesContext.getCurrentInstance().addMessage(null,
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid password. Please check your email.", null));
	        return null;
	    }
	}



//	public String generatePassword(String email, int otp) {
//	     pharmacyDao.generatePassword(email, otp);
//	     return "validatePass.jsf?faces-redirect=true";
//	}
//	
	
	public String generatePassword(String email, int otp) {
	    String result = pharmacyDao.generatePassword(email, otp);

	    if (result.contains("OTP verified")) {
	        return "validatePass.jsf?faces-redirect=true";
	    } else {
	        FacesContext.getCurrentInstance().addMessage(null,
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, result, null));
	        return null;
	    }
	}

	
//	public String updatePassword(String email, String pwd) {
//		return pharmacyDao.updatePassword(email, pwd);
//	}
	public String updatePassword(String email, String pwd) {
	    if (!pwd.equals(confirmPassword)) {
	        FacesContext.getCurrentInstance().addMessage(null,
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords do not match", null));
	        return null;
	    }

	    String result = pharmacyDao.updatePassword(email, pwd);
	    if ("Pharmacy Updated Successfully".equals(result)) {
	    	FacesContext.getCurrentInstance().getExternalContext().getFlash().put("message", "Password updated successfully.");

	        return "login.jsf?faces-redirect=true";
	    } else {
	        FacesContext.getCurrentInstance().addMessage(null,
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, result, null));
	        return null;
	    }
	}
	
	public String resendOtp() {
	    String email = pharmacy.getEmail(); // get email from session-scoped bean
	    String result = pharmacyDao.resendOtp(email);
	    FacesContext.getCurrentInstance().addMessage(null,
	        new FacesMessage(FacesMessage.SEVERITY_INFO, result, null));
	    return null; // stay on same page
	}


}


	