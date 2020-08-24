package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dao.EquityDAO;
import com.dao.EquityDAOImpl;
import com.displayAttributes.enrichedEquity;

/**
 * Servlet implementation class getEquity
 */
@WebServlet("/getEquity")
public class getEquity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getEquity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		
		EquityDAO dao=new EquityDAOImpl();
		int customerId=333333;
		List<enrichedEquity> list=dao.getEquity(customerId);
		JSONArray array=new JSONArray();
		for(int i=0;i<list.size();i++)
		{
			JSONObject jo=new JSONObject();
			jo.put("trade_date", list.get(i).getTrade_date().toString());
			jo.put("quantityOfTradedSecurity", list.get(i).getQuantityOfTradedSecurity());
			jo.put("price", list.get(i).getPrice());
			jo.put("securitySymbol", list.get(i).getSecuritySymbol());
			array.add(jo);
			
		}
		JSONObject finaljson=new JSONObject();
		finaljson.put("equity", array);
		 response.getWriter().write(finaljson.toString());
				
	
	}

}
