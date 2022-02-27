<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="nl">
<head>
    <link rel="stylesheet" href="stylesheet.css">
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meldpunt Verloren Voorwerpen</title>
</head>
<body>
<div>
    <h1><%= "Meldpunt verloren voorwerpen" %>
    </h1>
</div>
<div>
    <a href="index.jsp"><button class="button" >Info</button></a>
    <a href="VoegToe.jsp"><button class="button" >Voeg Toe</button></a>
    <a href="Overzicht.jsp"><button class="button" >Overzicht</button></a>
</div>
<div>
    <table class="center">
        <tr>
            <th>Beschrijving</th>
            <th>Datum</th>
            <th>Plaats</th>
            <th>Telefoonnr</th>
            <th>Email</th>
            <th>Pas aan</th>
            <th>Verwijder</th>
        </tr>
        <tr>
            <th>gele fiets</th>
            <th>21/02/2022</th>
            <th>Leuven</th>
            <th>048888888</th>
            <th>Jeff@email.com</th>
            <th><u>Pas aan</u></th>
            <th><u>Verwijder</u></th>
        </tr>
        <tr>
            <th>...</th>
            <th>...</th>
            <th>...</th>
            <th>...</th>
            <th>...</th>
            <th><u>Pas aan</u></th>
            <th><u>Verwijder</u></th>
        </tr>
        <tr>
            <th>...</th>
            <th>...</th>
            <th>...</th>
            <th>...</th>
            <th>...</th>
            <th><u>Pas aan</u></th>
            <th><u>Verwijder</u></th>
        </tr>
        <tr>
            <th>grijze kat</th>
            <th>15/04/2020</th>
            <th>Mechelen</th>
            <th>047777777</th>
            <th>Bob@email.com</th>
            <th><u>Pas aan</u></th>
            <th><u>Verwijder</u></th>
        </tr>
    </table>
</div>
</body>
</html>
