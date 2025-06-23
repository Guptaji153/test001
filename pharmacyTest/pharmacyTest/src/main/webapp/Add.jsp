<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>


<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Add.css">
</head>
<body>
<f:view>
    <h:form>
        <div class="form-container">
            
            <div class="form-group">
                <h:outputLabel for="pharmacyName" value="Pharmacy Name:" styleClass="form-label" />
                <h:inputText id="pharmacyName" value="#{pharmacy.pharmacyName}" styleClass="form-input" />
            </div>
            
             <div class="form-group">
                <h:outputLabel for="ownerName" value="Owner Name:" styleClass="form-label" />
                <h:inputText id="ownerName" value="#{pharmacy.ownerName}" styleClass="form-input" />
            </div>
            
            <div class="form-group">
                <h:outputLabel for="gstNo" value="GST Number:" styleClass="form-label" />
                <h:inputText id="gstNo" value="#{pharmacy.gstNo}" styleClass="form-input" />
            </div>

            <div class="form-group">
                <h:outputLabel for="licenseNo" value="License No:" styleClass="form-label" />
                <h:inputText id="licenseNo" value="#{pharmacy.licenseNo}" styleClass="form-input" />
            </div>

            <div class="form-group">
                <h:outputLabel for="contactNo" value="Contact No:" styleClass="form-label" />
                <h:inputText id="contactNo" value="#{pharmacy.contactNo}" styleClass="form-input" />
            </div>

            <div class="form-group">
                <h:outputLabel for="email" value="Email:" styleClass="form-label" />
                <h:inputText id="email" value="#{pharmacy.email}" styleClass="form-input" />
            </div>
            
            <div class="form-group">
                <h:outputLabel for="state" value="State:" styleClass="form-label" />
                <h:inputText id="state" value="#{pharmacy.state}" styleClass="form-input" />
            </div>

            <div class="form-group">
                <h:outputLabel for="city" value="City:" styleClass="form-label" />
                <h:inputText id="city" value="#{pharmacy.city}" styleClass="form-input" />
            </div>
            
            <div class="form-group">
                <h:outputLabel for="pinCode" value="Pin Code:" styleClass="form-label" />
                <h:inputText id="pinCode" value="#{pharmacy.pinCode}" styleClass="form-input" />
            </div>
            
            <div class="form-group">
                <h:outputLabel for="addressLine1" value="Address Line1:" styleClass="form-label" />
                <h:inputText id="addressLine1" value="#{pharmacy.addressLine1}" styleClass="form-input" />
            </div>
            
            <div class="form-group">
                <h:commandButton value="Submit" action="#{controller.registerPharmacy}" styleClass="submit-button" />
            </div>

        </div>
    </h:form>
</body>
</html>
</f:view>
