<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@attribute name="redirectUrl" type="java.lang.String" required="false" %>

<form class="validated-form user-form" action="<c:url value="/login"/>" method="POST">
	<label for="email"><fmt:message key="signup.form.email.label" /></label>
	<input type="email" name="email" class="email required text-input" placeholder="nome@exemplo.com"/>
	<label for="password"><fmt:message key="signup.form.password.label" /></label>
	<input name="password" type="password" class="required text-input" placeholder="Senha"/>
	<input name="redirectUrl" value="${redirectUrl}" type="hidden" />
	<input type="submit" value="Login"/>
</form>

<a href="${linkTo[ForgotPasswordController].forgotPasswordForm}">
	<fmt:message key="forgot_password.link.text" />
</a>