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

import com.dao.OptionsDAO;
import com.dao.OptionsDAOImpl;
import com.displayAttributes.enrichedEquity;
import com.displayAttributes.enrichedoptions;

/**
 * Servlet implementation class getOption
 */
@WebServlet("/getOption")
public class getOption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getOption() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		OptionsDAO dao=new OptionsDAOImpl();
		List<enrichedoptions> list=new ArrayList<>();
		int customer_id=111111;
		list=dao.getOptions(customer_id);
		
		
		
		
		JSONArray array=new JSONArray();
		for(int i=0;i<list.size();i++)
		{
			JSONObject jo=new JSONObject();
			jo.put("trade_date", list.get(i).getTrade_date().toString());
			jo.put("quantityOfTradedSecurity", list.get(i).getQuantity());
			jo.put("strikeprice", list.get(i).getStrikePrice());
			jo.put("securitySymbol", list.get(i).getSecurity_symbol());
			jo.put("premium", list.get(i).getPremium());
			jo.put("lotSize", list.get(i).getLotSize());
			jo.put("expirationdate", list.get(i).getExpirationDate().toString());
			
			array.add(jo);
			
		}
		JSONObject finaljson=new JSONObject();
		finaljson.put("options", array);
		 response.getWriter().write(finaljson.toString());
		
	}

}
