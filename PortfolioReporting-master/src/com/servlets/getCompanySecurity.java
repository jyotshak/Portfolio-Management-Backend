package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.CompanySecurityDAO;
import com.dao.CompanySecurityDAOImpl;
import com.displayAttributes.enrichedCompanySecurity;

/**
 * Servlet implementation class getCompanySecurity
 */
@WebServlet("/getCompanySecurity")
public class getCompanySecurity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCompanySecurity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		CompanySecurityDAO dao=new CompanySecurityDAOImpl();
		
		List<enrichedCompanySecurity> list=dao.getCompanySecurity();
		
		
		JSONArray array=new JSONArray();
		for(int i=0;i<list.size();i++)
		{
			JSONObject jo=new JSONObject();
			jo.put("trade_date", list.get(i).getTRADE_DATE().toString());
			jo.put("quantity", list.get(i).getQuantity());
			jo.put("price", list.get(i).getPrice());
			jo.put("security_symbol", list.get(i).getSECURITY_SYMBOL());
			array.add(jo);
			
		}
		JSONObject finaljson=new JSONObject();
		finaljson.put("companySecurity", array);
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println(finaljson.toString());
		 response.getWriter().write(finaljson.toString());
	}

}
