<%@ include file="IncludeTop.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script type="text/javascript">

	var mikExp = /^[a-zA-Z\s]+$/;
	var dateRegex = /^(1[0-2]{1}|[1-9]{1})\/[0-9]{4}$/;
	function showError(error){
	    $("#errorContainer").append("<li>"+error+"</li>");
	}
    
    function validateForm(){
        cleanErrors();
        var result = validateCardNumber() && validateName() && validateCvv() && validateExpiryDate() && validateSpecialCharacter();
        return result;
    }

    function cleanErrors(){
    	 $("#errorContainer").html("");
    }

    function validateCardNumber(){
        var cardNumber = $("#cardNumber").val();
        var isnum = /^\d+$/.test(cardNumber);
        if(!isnum){
        	showError("Card number must have numbers only");
            return false;
        }
        if(cardNumber.length != 16){
            showError("Card number must be 16 digits");
            return false;
        }
        return true;
    }

    function validateName(){
        var name = $("#cardHolderName").val();
        if(isBlank(name)){
        	showError("Card Holder's Name can not be empty");
            return false;
        }
        if(!mikExp.test(name)){
        	showError("Card Holder's Name can not have special characters and numbers");
            return false;
        }
        return true;
    }

    function isBlank(str) {
        return (!str || /^\s*$/.test(str));
    }

    function validateCvv(){
        var cvv = $("#cvvNumber").val();
        var isnum = /^\d+$/.test(cvv);
        if(!isnum){
        	showError("CVV must be a number");
            return false;
        }
        if(cvv.length != 3){
        	showError("CVV must have 3 digits");
            return false;
        }
        return true;
    }
    
    function validateExpiryDate(){
    	var date = $("#expiryDate").val();
    	if(!dateRegex.test(date)){
    		showError("Invalid Date");
    		return false;
    	} else {
    		var splitDate = date.split("/");
    		var month = parseInt(splitDate[0]);
    		var year = parseInt(splitDate[1]);
    		var today = new Date();
    		if(today.getFullYear() > year || today.getMonth() > month ){
        		showError("Invalid Date");
        		return false;
    		}
    		
    	}
    	return true;
    }
    
    function validateSpecialCharacter(){
    	 var noError = true;
    	 var firstName = $("#firstName").val();
    	 var lastName = $("#lastName").val();
    	 var city = $("#city").val();
    	 var country = $("#country").val();
    	 var state = $("#state").val();
    	 var zip = $("#zip").val();
    	 if(!mikExp.test(firstName)){
    	        showError("Special Characters and numbers not allowed in first name");
    	        noError = false;
    	 }
    	 if(!mikExp.test(lastName)){
 	        showError("Special Characters and numbers not allowed in last name");
 	        noError = false;
 	 	 }
    	 if(!mikExp.test(city)){
 	        showError("Special Characters and numbers not allowed in city name");
 	        noError = false;
 	 	 }
    	 if(!mikExp.test(country)){
 	        showError("Special Characters and numbers not allowed in country name");
 	        noError = false;
 	 	 }
    	 if(!mikExp.test(state)){
 	        showError("Special Characters and numbers not allowed in state name");
 	        noError = false;
 	 	 }
    	 if(!/^\d+$/.test(zip)){
  	        showError("Zip code should be a number");
 	        noError = false;
    	 }
    	 return noError;
    }
    </script>
<!-- Support for Spring errors holder -->
<spring:bind path="orderForm.*">
  <c:forEach var="error" items="${status.errorMessages}">
    <B><FONT color=RED>
      <BR><c:out value="${error}"/>
    </FONT></B>
  </c:forEach>
</spring:bind>
<div id="flt_err_contiainer" style="margin: 0px auto; text-align: center;color: #FF0000">
                            <div id="flt_err" class="error">
                                <ol id="errorContainer" style="color: red;"></ol>
                            </div>
                        </div>
<form action="<c:url value="/shop/newOrder.do"/>" method="post" onsubmit="return validateForm()">

<TABLE id="orderForm" border=0 cellpadding=3 cellspacing=1 class="data">
<TR><TH colspan=2>
<FONT color=GREEN size=4><B>Payment Details</B></FONT>
</TH></TR><TR><TD>
Card Type:</TD><TD>
  <spring:bind path="orderForm.order.cardType">
    <select name="<c:out value="${status.expression}"/>">
      <c:forEach var="cardType" items="${creditCardTypes}">
        <option <c:if test="${cardType == status.value}">selected</c:if> value="<c:out value="${cardType}"/>">
        <c:out value="${cardType}"/></option>
	    </c:forEach>
    </select>
  </spring:bind>
</TD></TR>
<TR><TD>
Card Number:</TD><TD>
  <spring:bind path="orderForm.order.creditCard">
	  <input id="cardNumber" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>"/>
  </spring:bind>
  <font color=red size=2>* Use a fake number!</font>
</TD></TR>
<TR><TD>
CVV:</TD><TD>
  <spring:bind path="orderForm.order.cvv">
	  <input id="cvvNumber" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="4"/>
  </spring:bind>
  <font color=red size=2>* Use a fake number!</font>
</TD></TR>
<TR><TD>
Card Holder's Name:</TD><TD>
  <spring:bind path="orderForm.order.cardholdersName">
	  <input id="cardHolderName" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="80"/>
  </spring:bind>
</TD></TR>
<TR><TD>
Expiry Date (MM/YYYY):</TD><TD>
  <spring:bind path="orderForm.order.expiryDate">
	  <input id="expiryDate" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="7"/>
  </spring:bind>
</TD></TR>
<TR><TH colspan=2 style="text-align: center;">
<FONT color=GREEN size=4><B>Billing Address</B></FONT>
</TH></TR>

<TR><TD>
First name:</TD><TD>
  <spring:bind path="orderForm.order.billToFirstName">
	  <input id="firstName" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="80"/>
  </spring:bind>
</TD></TR>
<TR><TD>
Last name:</TD><TD>
  <spring:bind path="orderForm.order.billToLastName">
	  <input id="lastName" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="80"/>
  </spring:bind>
</TD></TR>
<TR><TD>
Address 1:</TD><TD>
  <spring:bind path="orderForm.order.billAddress1">
	  <input type="text" size="40" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="80"/>
  </spring:bind>
</TD></TR>
<TR><TD>
Address 2:</TD><TD>
  <spring:bind path="orderForm.order.billAddress2">
	  <input type="text" size="40" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="80"/>
  </spring:bind>
</TD></TR>
<TR><TD>
City: </TD><TD>
  <spring:bind path="orderForm.order.billCity">
	  <input id="city" type="text" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="80"/>
  </spring:bind>
</TD></TR>
<TR><TD>
State:</TD><TD>
  <spring:bind path="orderForm.order.billState">
	  <input id="state" type="text" size="4" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="80"/>
  </spring:bind>
</TD></TR>
<TR><TD>
Zip:</TD><TD>
  <spring:bind path="orderForm.order.billZip">
	  <input id="zip" type="text" size="10" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="20"/>
  </spring:bind>
</TD></TR>
<TR><TD>
Country:</TD><TD>
  <spring:bind path="orderForm.order.billCountry">
	  <input id="country" type="text" size="15" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" maxlength="20"/>
  </spring:bind>
</TD></TR>

<TR><TD colspan=2>
  <spring:bind path="orderForm.shippingAddressRequired">
    <input type="checkbox" name="<c:out value="${status.expression}"/>" value="true" <c:if test="${status.value}">checked</c:if>>
		Ship to different address...
  </spring:bind>
</TD></TR>

</TABLE>
<P>
<input type="image" src="../images/button_submit.gif">

</form>

<%@ include file="IncludeBottom.jsp" %>
