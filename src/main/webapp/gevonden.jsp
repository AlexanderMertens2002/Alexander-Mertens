<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 28/05/2022
  Time: 11:47
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
    <article>
        <p>dit is het voorwerp waar je naar zocht: ${VerlorenVoorwerp.toonBeschrijving()}</p>
    </article>
</main>
</body>
</html>
