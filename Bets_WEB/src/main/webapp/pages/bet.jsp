<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BetResult</title>
</head>
<body>
    <c:if test="${pairForBet == 0}">
        <h4>The selected pair does not exist<br/><p>
    </c:if>

    <c:if test="${pairForBet != 0}">
        <c:if test="${leadNumber != 0}">
            <h4>Lead number is ${leadNumber}<br/>
        </c:if>
        <c:if test="${leadNumber == 0}">
            <h4>There are several leaders in the race<br/>
        </c:if>

        <c:if test="${pairForBet == leadNumber}">
            <h4>You won!<br/>
        </c:if>
        <c:if test="${pairForBet != leadNumber}">
            <h4>You lost.<br/>
        </c:if>

        <h4>Your sum is ${totalSum}<br/><p>
    </c:if>

    <c:if test="${totalSum > 0}">
        <form action="/pairs" method="get">
            <input type="submit" value="Play again">
        </form>
    </c:if>
    <c:if test="${totalSum <= 0}">
        <h4>There are no funds in the account<br/>
    </c:if>
</body>
</html>