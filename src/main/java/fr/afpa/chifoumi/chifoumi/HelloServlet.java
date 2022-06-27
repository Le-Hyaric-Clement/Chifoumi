package fr.afpa.chifoumi.chifoumi;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int choixJoueur = 0;
        int choixIa = 0;
        String resultat ="";

        String parametreUn =request.getParameter("Pierre");
        String parametreDeux =request.getParameter("Papier");
        String parametreTrois =request.getParameter("Ciseau");

        if (parametreUn != null) {
            choixJoueur = 0;
        } else if (parametreDeux != null) {
            choixJoueur = 1;
        }else if (parametreTrois != null) {
            choixJoueur = 2;
        }
        choixIa = (int) Math.floor(Math.random() * 3);

        if (choixJoueur == choixIa) {
            resultat = "Egalité";
        }
        if (choixJoueur == 0 && choixIa == 2) {
            resultat = "Pierre VS Ciseau : Vous gagnez la manche";
        }
        if (choixJoueur == 2 && choixIa == 0) {
            resultat = "Ciseau VS Pierre : Vous perdez la manche";
        }
        if (choixJoueur == 1 && choixIa == 0) {
            resultat = "Feuille VS Pierre : Vous gagnez la manche";
        }
        if (choixJoueur == 1 && choixIa == 2) {
            resultat = "Feuille VS Ciseau : Vous perdez la manche";
        }
        if (choixJoueur == 0 && choixIa == 1) {
            resultat = "Pierre VS Feuille : Vous perdez la manche";
        }
        if (choixJoueur == 2 && choixIa == 1) {
            resultat = "Ciseau VS Feuille : Vous gagnez la manche";
        }

        request.setAttribute("resultatFinal",resultat);

        RequestDispatcher rd =
                request.getRequestDispatcher(
                        "WEB-INF/resultat.jsp"
                );
        rd.forward(request, response);
    }

    public void destroy() {
    }
}