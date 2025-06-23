<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Reset Password</title>
    <link rel="stylesheet" type="text/css" href="css/validatePass.css" />
</head>
<body>
    <h:form>
        <div class="form-container">

            <h2>Reset Your Password</h2>

            <!-- Email input -->
            <div class="form-group">
                <h:outputLabel for="email" value="Email Id:" styleClass="form-label" />
                <h:inputText id="email" value="#{controller.pharmacy.email}" required="true" styleClass="form-input" />
            </div>

            <!-- New Password -->
            <div class="form-group">
                <h:outputLabel for="newPassword" value="New Password:" styleClass="form-label" />
                <h:inputSecret id="newPassword" value="#{controller.pharmacy.password}" required="true" styleClass="form-input" />
            </div>

            <!-- Confirm New Password -->
            <div class="form-group">
                <h:outputLabel for="confirmPassword" value="Confirm Password:" styleClass="form-label" />
                <h:inputSecret id="confirmPassword" value="#{controller.confirmPassword}" required="true" styleClass="form-input" />
            </div>

            <!-- Submit Button -->
            <div class="form-group">
                <h:commandButton value="Update Password"
                                 action="#{controller.updatePassword(controller.pharmacy.email, controller.pharmacy.password)}"
                                 styleClass="submit-button" />
            </div>

            <!-- Message Display -->
            <h:messages globalOnly="true" style="color:red;" />

        </div>
    </h:form>
</body>
</html>
</f:view>
