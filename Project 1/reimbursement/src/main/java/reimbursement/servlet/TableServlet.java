package reimbursement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reimbursement.controller.TableControler;

public class TableServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1603311120902701527L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = TableControler.buildPage(request);
        request.setAttribute("table", message); //inserts the table into the
        request.getRequestDispatcher("/resources/html/tableveiw.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
