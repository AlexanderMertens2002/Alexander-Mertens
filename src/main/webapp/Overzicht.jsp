<%@ page import="domain.db.VerlorenDB" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.model.VerlorenVoorwerp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <table class="center">
        <thead>
            <tr>
                <th>Beschrijving</th>
                <th>Datum</th>
                <th>Plaats</th>
                <th>Telefoonnr</th>
                <th>Email</th>
                <th>delete</th>

            </tr>
        </thead>
        <tbody>
        <% ArrayList<VerlorenVoorwerp> verlorenlijst = (ArrayList<VerlorenVoorwerp>) request.getAttribute("verlorenlijst"); %>
        <%
            for (VerlorenVoorwerp verlorenVoorwerp : verlorenlijst) {
        %>
            <tr>
                <td><%=verlorenVoorwerp.getBeschrijving()%>
                </td>
                <td><%=verlorenVoorwerp.getDatum()%>
                </td>
                <td><%=verlorenVoorwerp.getPlaats()%>
                </td>
                <td><%=verlorenVoorwerp.getTelefoonnr()%>
                </td>
                <td><%=verlorenVoorwerp.getEmail()%>
                </td>
                <td><a href="Controller?command=remove&beschrijving=<%=verlorenVoorwerp.getBeschrijving()%>">delete</a>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</main>
</body>
</html>
