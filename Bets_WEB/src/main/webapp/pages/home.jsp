<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Horse racing bets</title>
</head>
<body>

    <h4>Your sum is ${totalSum}

    <h3>Enter the data about the pairs</h3><p>

    <form action="/pairs" method="post">
        <input type="text" name="horse" placeholder="Horse name  "> ${error_horse}<br/><p>
        <input type="text" name="rider" placeholder="Rider's name"> ${error_rider}<br/><p>
        <input type="number" name="number" placeholder="Pair number "> ${error_number}<br/><p>
        <input type="submit" value="Save pair">
    </form>

    <h3>Pairs ${pairs} <br/>

    <h3>Make your bet</h3><p>
        <form action="pairs/bet" method="post">
        <input type="number" name="betPair" placeholder="Pair number" required><br/><p>
        <input type="number" name="betSum" placeholder="Bet sum" required min="1" max="${totalSum}"><br/><p>
        <input type="submit" value="Make bet">
    </form>
</body>
</html>