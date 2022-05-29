<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 28/05/2022
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <link rel="stylesheet" href="stylesheet.css">
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meldpunt Verloren Voorwerpen</title>
</head>
<body>
<header>
    <h1><%= "Meldpunt verloren voorwerpen" %>
    </h1>

    <nav>
        <ul>
            <li><a href="Controller?command=home">Info</a></li>
            <li><a href="Controller?command=VoegToe">Voeg Toe</a></li>
            <li><a href="Controller?command=Overzicht">Overzicht</a></li>
            <li><a href="Controller?command=find">find</a></li>
        </ul>
    </nav>
</header>
<main>
    <h2>Zoek een verloren object</h2>

    <form id="form" method="Get" action="Controller?command=startfind" novalidate>
        <p style="margin: 2% 25% 2%; color: #ffffff">Welke verloren object zoek je?</p>
        <input type="hidden" value="startfind" name="command">
        <p>
            <label for="Beschrijving">Beschrijving:</label>
            <input id="Beschrijving" name="Beschrijving" type="text" value="" required>
        </p>
        <p>
            <label for="find">&nbsp;</label>
            <input id="find" type="submit" value="vind" name="find">
        </p>
    </form>
    <footer>
        <p>U deed al ${aantalGevonden} succesvolle zoekopdrachten</p>
        <form id="noform" method="Get" action="Controller?command=resetcookie" novalidate>
            <p>
                <input type="hidden" value="resetcookie" name="command">
                <input id="button" type="submit" value="zet teller op 0" name="resetcookie">
            </p>
        </form>
    </footer>
</main>
</body>
</html>
