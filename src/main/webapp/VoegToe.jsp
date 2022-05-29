<%@ page contentType="text/html;charset=UTF-8" %>
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
    <form id="form" method="POST" action="Controller?command=add" novalidate>

        <p class="form-group">
            <label class="control-label" for="Beschrijving">Beschrijving:</label>
            <input id="Beschrijving" name="Beschrijving" type="text"
                   value="${BeschrijvingVorige}" class="" required>
        </p>

        <p class="form-group">
            <label class="control-label" for="Plaats">Plaats:</label>
            <input id="Plaats" name="Plaats" type="text"
                   value="${PlaatsVorige}" class="" required>
        </p>

        <p class="form-group">
            <label class="control-label" for="Email">Email:</label>
            <input id="Email" name="Email" type="text"
                   value="${EmailVorige}" class="" required>
        </p>

        <p class="form-group">
            <label for="Jaar">Jaar:</label>
            <input
                    id="Jaar" name="Jaar" type="number"
                    value="${JaarVorige}" class="" required>
        </p>

        <p class="form-group">
            <label for="Maand">Maand:</label>
            <input
                    id="Maand" name="Maand" type="number"
                    value="${MaandVorige}" class="" required>
        </p>

        <p class="form-group">
            <label for="Dag">Dag:</label>
            <input
                    id="Dag" name="Dag" type="number"
                    value="${DagVorige}" class="" required>
        </p>
        <p class="form-group">
            <label for="Telefoonnr">Telefoonnr:</label>
            <input
                    id="Telefoonnr" name="Telefoonnr" type="number"
                    value="${TelefoonnrVorige}" class="" required>
        </p>
        <p>
            <input id="submit" type="submit" value="Verstuur">
        </p>
    </form>
</main>
</body>
</html>
