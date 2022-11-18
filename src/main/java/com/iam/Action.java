package com.iam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import com.iam.persistencia.FundosPersistencia;

/**
 * Servlet implementation class Action
 */
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String perfil;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		perfil = request.getParameter("perfil");
		String fundos = new FundosPersistencia().consulta(perfil);
		
		String output = null;
		
		Gson gson = new Gson();
		output = gson.toJson(fundos);
		


		response.getWriter().write(output);
		response.getWriter().flush();
		//System.out.println(output);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
