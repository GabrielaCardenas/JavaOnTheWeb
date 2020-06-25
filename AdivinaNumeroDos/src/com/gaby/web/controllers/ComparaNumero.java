package com.gaby.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ComparaNumero
 */
@WebServlet("/ComparaNumero")
public class ComparaNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComparaNumero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Continuo sesion
		HttpSession misession= (HttpSession) request.getSession();
		
		//Guardo String en sesion para usarlos en JSP
		misession.setAttribute("Título", "Adivina el número en el rango dado:");
		misession.setAttribute("button", "Try");
		
		//Usando contador
		int count = (int) misession.getAttribute("click");
		misession.setAttribute("click", count);
				
		//Obtengo parametro numeroDado del formulario
		String numeroDado = request.getParameter("numeroDado");
		int numeroRandom = (int) misession.getAttribute("numeroRandom");
		
		//Al comienzo numeroDado es null
		if(numeroDado==null || numeroDado.isEmpty()) {
			misession.setAttribute("Ayuda", "Ingresa un número");
			misession.setAttribute("click", count);
			misession.setAttribute("clicks", " disponibles para jugar");
		}
		
		//Con el dato ingresa comienzo a comparar
		else {
			
			//Transformo numeroDado a int
			int numDado = Integer.parseInt(numeroDado);
			misession.setAttribute("numeroDado", numDado);
    		
    		//Si es adivinado
    		if(numDado == numeroRandom ){
    			
    			//Se guarda el mensaje en sesion para usar en JSP
        		misession.setAttribute("Ayuda", numeroDado + " is the number!");
        		
        		//Cambia el valor de button para jugar de nuevo
        		misession.setAttribute("button", "Jugar de nuevo");
    		}
    		
    		//Si es muy menor se guarda mensaje para usar en JSP
    		else if(numDado < numeroRandom-2) {
    			misession.setAttribute("Ayuda", "Too low!");
    		}
    		
    		//Si es muy mayor se guarda mensaje para usar en JSP
    		else if(numDado > numeroRandom+2) {
    			misession.setAttribute("Ayuda", "Too high!");
    		}
    		//Si esta muy cerca se guarda mensaje para usar en JSP
    		else {
    			misession.setAttribute("Ayuda", "Estás cerca!");
    		}
		}
		
		//Si el botón es clickeado (distinto de null), dar valor count a "button" disminuido en 1
		if ("Try".equals(misession.getAttribute("button"))) {
		   	count--;
		   	misession.setAttribute("click", count);
		}
				
		//Si no es clickeado, dar valor count a "button"
		else {
		   	misession.setAttribute("click", count);
		}
		
		//Cuando el jugador pierde
		if("Jugar de nuevo".equals(misession.getAttribute("button")) || count<0) {
			
			count=10;
			misession.setAttribute("click", count);
			misession.setAttribute("clicks", " disponibles para jugar");
			
			//Obtengo valores numero1 y numero2 en sesion
			String numero1 = (String) misession.getAttribute("numero1");
	        String numero2 = (String) misession.getAttribute("numero2");
	        
	        int num1 = Integer.parseInt(numero1);
	        int num2 = Integer.parseInt(numero2);
	        
	        //Se genera nuevo numero aleatorio
    		numeroRandom = (int) Math.floor(Math.random()*(num1-num2+1)+num2);
    		misession.setAttribute("numeroRandom", numeroRandom);
    		
		}
		else if(count==0) {
			misession.setAttribute("clicks", " Has perdido!");
			misession.setAttribute("button", "Jugar de nuevo");
		}
		
		//Puede seguir jugando intentos mayor a cero
		else {
			misession.setAttribute("clicks", " disponibles para jugar");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/IngresaNumero.jsp");
        view.forward(request, response);
		
	}

}
