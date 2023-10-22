package com.kh.member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Cost;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberCostController
 */
@WebServlet("/cost.me")
public class MemberCostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM");
        
        String month = "";
        int status = 0;
        
        
        if(request.getParameter("month")!=null) {
        	 month = request.getParameter("month");
        	 System.out.println("ajax");
        	 status = 1;
        }else {
        	 month = fm.format(new Date());	
        	 System.out.println("servlet");
        }
        
       
        
        Calendar cal = Calendar.getInstance();
        
        
        try {
			cal.setTime(fm.parse(month));
			cal.add(Calendar.MONTH,-1);	       	       	       
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        String beforeMonth = fm.format(cal.getTime());     
        
        int memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
        
        
        Cost cost1 = new MemberService().selectCost(month,memberNo);       // 이번달 관리비            
        Cost cost2 = new MemberService().selectCost(beforeMonth,memberNo); // 지난달 관리비
         
        if(status==1) { //ajax로 요청할 경우
        	ArrayList<Cost> list = new ArrayList<>();
        	list.add(cost1);
        	list.add(cost2);
        	
        	response.setContentType("application/json; charset=UTF-8");
    		new Gson().toJson(list,response.getWriter());
       	
        }else {
        	request.setAttribute("month", cost1);
            request.setAttribute("beforeMonth", cost2);
            request.getRequestDispatcher("views/member/memberCostView.jsp").forward(request, response);	
        }                              	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
