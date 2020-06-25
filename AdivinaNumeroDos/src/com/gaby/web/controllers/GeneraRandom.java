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
 * Servlet implementation class GeneraRandom
 */
@WebServlet("/GeneraRandom")
public class GeneraRandom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneraRandom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Inicio sesion
		HttpSession misession = request.getSession(true);
		//Obtengo valores de numero1 y numero2
		String numero1 = request.getParameter("numero1");
		String numero2 = request.getParameter("numero2");
				
		//Guardo String en sesion para usarlos en JSP
		misession.setAttribute("Título", "Adivina el número en el rango dado:");
		misession.setAttribute("button", "Try");
		misession.setAttribute("Ayuda", "Ingresa un número");
		        
		//Cuando comienza numero1 y numero2 son null
		if(numero1==null && numero2==null) {
			misession.setAttribute("Aviso", "Ingrese rango");
		}
		        
		//Si no se ingresan los 2 valores
		else if(numero1.isEmpty() && numero2.isEmpty() || numero1.isEmpty() || numero2.isEmpty() ) {
			misession.setAttribute("Título", "Como no ingresaste un rango, adivina el número en el rango:");
		    misession.setAttribute("numero1", "0");
		    misession.setAttribute("numero2", "100");
		            
		    //Genero numero random dentro del rango
		    int numeroRandom = (int) Math.floor(Math.random()*(0-100+1)+100);
		    //Guardo el valor en session
		    misession.setAttribute("numeroRandom", numeroRandom);
		            
		    //Iniciando contador
		    int count=10;
		    misession.setAttribute("click", count);
		    misession.setAttribute("clicks", " disponibles para jugar");
		}
		        
		//Ambos valores ingresados
		else {
		        	
		   	//Guardo valores numero1 y numero2 en sesion
			misession.setAttribute("numero1", numero1);
		    misession.setAttribute("numero2", numero2);
		            
		  	//Transformo ambos valores a int
		   	int numInicial = Integer.parseInt(numero1);
		    int numFinal = Integer.parseInt(numero2);
		            
		    //Genero numero random dentro del rango
		    int numeroRandom = (int) Math.floor(Math.random()*(numInicial-numFinal+1)+numFinal);
		    //Guardo el valor en session
		    misession.setAttribute("numeroRandom", numeroRandom);
		            
		    //Iniciando contador
		    int count=10;
		    misession.setAttribute("click", count);
		    misession.setAttribute("clicks", " disponibles para jugar");
		}
		        
		//Ejecuta en Adivina.jsp
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/IngresaNumero.jsp");
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
