package ui.controller;

import domain.db.VerlorenDB;
import domain.model.VerlorenVoorwerp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {
    private VerlorenDB db = new VerlorenDB();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destination;

        String command = request.getParameter("command");
        if (command == null) {
            command = "home";
        }
        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "Overzicht":
                destination = Overzicht(request, response);
                break;
            case "VoegToe":
                destination = VoegToe(request, response);
                break;
            case "add":
                destination = addVoegToe(request, response);
                break;
            case "find":
                destination = find(request,response);
                break;
            case "startfind":
                destination = startfind(request,response);
                break;
            case "resetcookie":
                destination = resetcookie(request,response);
                break;
            case "recentVerloren":
                destination = recentVerloren(request, response);
                break;
            case "remove":
                destination = remove(request, response);
                break;

            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String remove(HttpServletRequest request, HttpServletResponse response) {
        String beschrijving = request.getParameter("beschrijving");
        db.Remove(beschrijving);
        request.setAttribute("verlorenlijst", db.getAlle());
        return "Overzicht.jsp";
    }

    private String addVoegToe(HttpServletRequest request, HttpServletResponse response) {
        if(request.getParameter("Beschrijving").length() == 0 ||
                request.getParameter("Jaar").length() == 0 ||
                request.getParameter("Maand").length() == 0 ||
                request.getParameter("Dag").length() == 0 ||
                request.getParameter("Plaats").length() == 0 ||
                request.getParameter("Telefoonnr").length() == 0 ||
                request.getParameter("Email").length() == 0){
            request.setAttribute("BeschrijvingVorige", request.getParameter("Beschrijving"));
            request.setAttribute("JaarVorige", request.getParameter("Jaar"));
            request.setAttribute("MaandVorige", request.getParameter("Maand"));
            request.setAttribute("DagVorige", request.getParameter("Dag"));
            request.setAttribute("PlaatsVorige", request.getParameter("Plaats"));
            request.setAttribute("TelefoonnrVorige", request.getParameter("Telefoonnr"));
            request.setAttribute("EmailVorige", request.getParameter("Email"));
            return "VoegToe.jsp";
        }
        else {
            VerlorenVoorwerp verlorenVoorwerp = new VerlorenVoorwerp();
            setBeschrijving(verlorenVoorwerp, request);
            setJaar(verlorenVoorwerp, request);
            setMaand(verlorenVoorwerp, request);
            setDag(verlorenVoorwerp, request);
            setPlaats(verlorenVoorwerp, request);
            settelephoon(verlorenVoorwerp, request);
            setEmail(verlorenVoorwerp, request);
            db.voegToe(verlorenVoorwerp);
            return Overzicht(request, response);
        }
    }

    private void setBeschrijving(VerlorenVoorwerp verlorenVoorwerp, HttpServletRequest request) {
        String Beschrijving = request.getParameter("Beschrijving");
        request.setAttribute("BeschrijvingVorige", Beschrijving);
        verlorenVoorwerp.setBeschrijving(Beschrijving);
    }

    private void setJaar(VerlorenVoorwerp verlorenVoorwerp, HttpServletRequest request) {
        String Jaar = request.getParameter("Jaar");
        request.setAttribute("JaarVorige", Jaar);
        verlorenVoorwerp.setJaar(Integer.parseInt(Jaar));
    }

    private void setMaand(VerlorenVoorwerp verlorenVoorwerp, HttpServletRequest request) {
        String Maand = request.getParameter("Maand");
        request.setAttribute("MaandVorige", Maand);
        verlorenVoorwerp.setMaand(Integer.parseInt(Maand));
    }

    private void setDag(VerlorenVoorwerp verlorenVoorwerp, HttpServletRequest request) {
        String Dag = request.getParameter("Dag");
        request.setAttribute("DagVorige", Dag);
        verlorenVoorwerp.setDag(Integer.parseInt(Dag));
    }

    private void setPlaats(VerlorenVoorwerp verlorenVoorwerp, HttpServletRequest request) {
        String Plaats = request.getParameter("Plaats");
        request.setAttribute("PlaatsVorige", Plaats);
        verlorenVoorwerp.setPlaats(Plaats);
    }

    private void settelephoon(VerlorenVoorwerp verlorenVoorwerp, HttpServletRequest request) {
        String Telefoonnr = request.getParameter("Telefoonnr");
        request.setAttribute("TelefoonnrVorige", Telefoonnr);
        verlorenVoorwerp.setTelefoonnr(Integer.parseInt(Telefoonnr));
    }

    private void setEmail(VerlorenVoorwerp verlorenVoorwerp, HttpServletRequest request) {
        String Email = request.getParameter("Email");
        request.setAttribute("EmailVorige", Email);
        verlorenVoorwerp.setEmail(Email);
    }

    private String VoegToe(HttpServletRequest request, HttpServletResponse response) {
        return "VoegToe.jsp";
    }

    private String recentVerloren(HttpServletRequest request, HttpServletResponse response) {
        return "recentVerloren.jsp";
    }

    private String find(HttpServletRequest request, HttpServletResponse response) {
        Cookie aantalgevonden = getCookieWithKey(request, "aantalgevonden");
        request.setAttribute("aantalGevonden",aantalgevonden == null ? 0 : aantalgevonden.getValue());
        return "find.jsp";
    }

    private String resetcookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie nieuwaantalgevonden = new Cookie("aantalgevonden", "0");
        response.addCookie(nieuwaantalgevonden);
        request.setAttribute("aantalGevonden",0);
        return "find.jsp";
    }


    private String Overzicht(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("verlorenlijst", db.getAlle());
        return "Overzicht.jsp";
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        String zoekgeschiedenistext = "";
        String langstveroren = db.oudste().getBeschrijving();
        ArrayList<String> zoekgeschiedenis = new ArrayList<String>();
        HttpSession session = request.getSession();
        zoekgeschiedenis = (ArrayList<String>) session.getAttribute("zoekgeschiedenis");
        if (zoekgeschiedenis == null){
            zoekgeschiedenistext = "U zocht nog niet op";}
        else {
            zoekgeschiedenistext = "<p>U zocht reeds naar:</p><ul>" ;
            for (String zoekopdracht : zoekgeschiedenis){
                zoekgeschiedenistext += "<li>"+zoekopdracht + "</li>";
            }
            zoekgeschiedenistext += "</ul>";
        }

        request.setAttribute("zoekgeschiedenis", zoekgeschiedenistext);
        request.setAttribute("oudeste", langstveroren);
        return "index.jsp";
    }


    private String startfind(HttpServletRequest request, HttpServletResponse response) {
        Cookie aantalgevonden = getCookieWithKey(request, "aantalgevonden");
        String destination;
        String beschrijving = request.getParameter("Beschrijving").replace("_", " ");
        ArrayList<String> zoekgeschiedenis;
        HttpSession session = request.getSession();
        zoekgeschiedenis = (ArrayList<String>) session.getAttribute("zoekgeschiedenis");
        if(zoekgeschiedenis == null){ zoekgeschiedenis = new ArrayList<String>();}
        zoekgeschiedenis.add(beschrijving);
        session.setAttribute("zoekgeschiedenis",zoekgeschiedenis);

        VerlorenVoorwerp zoekvoorwerp = db.find(beschrijving);
        if (zoekvoorwerp != null) {
            destination = "gevonden.jsp";
            request.setAttribute("VerlorenVoorwerp",zoekvoorwerp);
            Cookie nieuwaantalgevonden = new Cookie("aantalgevonden",aantalgevonden == null ? "1" : String.valueOf(Integer.parseInt(aantalgevonden.getValue()) + 1));
            response.addCookie(nieuwaantalgevonden);
        } else {
            request.setAttribute("aantalGevonden",aantalgevonden == null ? 0 : aantalgevonden.getValue());
            destination = "find.jsp";
        }
        return destination;
    }

    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (Cookie cookie : cookies
        ) {
            if (cookie.getName().equals(key))
                return cookie;
        }
        return null;
    }
}
