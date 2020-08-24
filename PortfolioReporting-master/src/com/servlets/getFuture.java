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

import com.dao.FutureDAO;
import com.dao.FutureDAOImpl;
import com.displayAttributes.enrichedFutures;

/**
 * Servlet implementation class getFuture
 */
@WebServlet("/getFuture")
public class getFuture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getFuture() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	FutureDAO dao=new FutureDAOImpl();
	int customerId=222222;
	List<enrichedFutures> list=dao.getFuture(customerId);
	System.out.println(list);
	
	
	JSONArray array=new JSONArray();
	for(int i=0;i<list.size();i++)
	{
		JSONObject jo=new JSONObject();
		jo.put("trade_date", list.get(i).getTrade_date().toString());
		jo.put("quantity", list.get(i).getQuantity());
		jo.put("maturity", list.get(i).getMaturity().toString());
		jo.put("security_symbol", list.get(i).getSecurity_symbol());
		array.add(jo);
		
	}
	JSONObject finaljson=new JSONObject();
	finaljson.put("futures", array);
	response.setContentType("application/json");
	response.setHeader("Access-Control-Allow-Origin", "*");
	System.out.println(finaljson.toString());
	 response.getWriter().write(finaljson.toString());
	}

	

}
