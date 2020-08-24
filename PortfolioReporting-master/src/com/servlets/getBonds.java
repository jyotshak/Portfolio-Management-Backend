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

import com.dao.BondDAO;
import com.dao.BondDAOImpl;
import com.displayAttributes.enrichedBonds;
import com.displayAttributes.enrichedEquity;

/**
 * Servlet implementation class getBonds
 */
@WebServlet("/getBonds")
public class getBonds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getBonds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		int customerId=222222;
		BondDAO dao=new BondDAOImpl();
		List<enrichedBonds> list=dao.getBond(customerId);
		
		
		JSONArray array=new JSONArray();
		for(int i=0;i<list.size();i++)
		{
			JSONObject jo=new JSONObject();
			jo.put("trade_date", list.get(i).getTrade_date().toString());
			jo.put("quantity", list.get(i).getQuantity());
			jo.put("faceValue", list.get(i).getFaceValue());
			jo.put("maturity", list.get(i).getMaturity().toString());
			jo.put("frequency", list.get(i).getFrequency());
			jo.put("couponRate", list.get(i).getCouponRate());
			jo.put("securitySymbol", list.get(i).getSecurity_symbol());
			array.add(jo);
			
		}
		JSONObject finaljson=new JSONObject();
		finaljson.put("bonds", array);
		System.out.println(finaljson.toString());
		 response.getWriter().write(finaljson.toString());
	}

	

}
