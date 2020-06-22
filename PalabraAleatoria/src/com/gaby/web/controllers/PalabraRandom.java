package com.gaby.web.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Random
 */
@WebServlet("/PalabraRandom")
public class PalabraRandom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PalabraRandom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contador=0;
		//Inicio sesion
		HttpSession session = request.getSession();
		
		//Contador
        //Si el botón es clickeado (distinto de null), dar valor count a "generar" aumentado en 1
		if (session.getAttribute("generar") != null) {
			//GetAttribute entrega valor Object
        	contador = (int) session.getAttribute("generar");
        	contador++;
        	session.setAttribute("generar", contador);
        }
		
		//Si el botón no ha sido clickeado en la session el valor de count es cero
		else {
        	session.setAttribute("generar", 0);
        }
		
		//Genera la fecha del ultimo acceso en un objeto y da ese atributo a "session"
		Date date = new Date(session.getLastAccessedTime());
		session.setAttribute("date", date);
		
		//Genera la palabra aleatoria
		char[] caracteres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        StringBuilder palabra = new StringBuilder(10);
        
        for(int i = 0; i < 10; i++) { //Agregar caracter 10 veces al StringBuilder
        	
            int indice = random.nextInt(35); //Selecciona aleatoriamente un num del 0 al 36
        	char caracter = caracteres[indice]; //Selecciona el caracter en la posición del indice
            palabra.append(caracter); // Agrega caracter
        }
        
        //Entrega el atributo guardado en palabra para usar en el JSP con getAttibute
	    session.setAttribute("palabra", palabra);
		
		
		//Ejecuta JSP
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Generate.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
