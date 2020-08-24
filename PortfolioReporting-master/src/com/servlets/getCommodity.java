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

import com.dao.CommodityDAO;
import com.dao.CommodityDAOImpl;
import com.displayAttributes.enrichedCommodity;
import com.displayAttributes.enrichedEquity;

/**
 * Servlet implementation class getCommodity
 */
@WebServlet("/getCommodity")
public class getCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCommodity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		CommodityDAO dao=new CommodityDAOImpl();
		int customerId=111111;
		List<enrichedCommodity> list=dao.getCommodity(customerId);
		
		
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
		finaljson.put("commodity", array);
		System.out.println(finaljson.toString());
		 response.getWriter().write(finaljson.toString());
				
	
	
	
	}

	

}
