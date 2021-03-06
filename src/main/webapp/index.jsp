<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <p>
            Ben je iets verloren ?
            Meld het dan hier bij de MVV zodat de eerlijke vinder het aan jouw terug kan bezorgen.
        </p>
        <p>
            <%if (request.getAttribute("zoekgeschiedenis") == null){ %>
            U zocht nog niet op
            <% }
            else{ %>
                ${zoekgeschiedenis}
            <%
                }
            %>
        </p>
        <p>
            het langst vermiste voorwerp is ${oudeste}
        </p>

    </article>
</main>
</body>
</html>