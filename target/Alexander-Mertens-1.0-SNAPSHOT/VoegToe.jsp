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
    <form>
        <label for="Beschrijving">Beschrijving:</label><br>
        <input type="text" id="Beschrijving" name="Beschrijving" value=""><br>
        <label for="Datum">Datum:</label><br>
        <input type="date" id="Datum" name="Datum" value=""><br><br>
        <label for="Plaats">Plaats:</label><br>
        <input type="text" id="Plaats" name="Plaats" value=""><br><br>
        <label for="Telefoonnr">Telefoonnr:</label><br>
        <input type="tel" id="Telefoonnr" name="telefoonnr" value=""><br><br>
        <label for="Email">Email:</label><br>
        <input type="email" id="Email" name="Email" value=""><br><br>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
