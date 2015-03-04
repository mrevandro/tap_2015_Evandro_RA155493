package main.java.br.ucdb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.br.ucdb.util.Cliente;

@WebServlet(urlPatterns = "/cliServlet")
public class ClienteServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = req.getIntHeader("id");
		String nome = req.getParameter("nome");
		String sexo = req.getParameter("sexo");
		String email = req.getParameter("email");
		String rg = req.getParameter("rg");
		String cpf = req.getParameter("cpf");
		
		
		Cliente c = new Cliente();
		
		c.setId(id);
		c.setNome(nome);
		c.setSexo(sexo);
		c.setEmail(email);
		c.setRg(rg);
		c.setCpf(cpf);
		
		req.setAttribute("id", c.getId());
		req.setAttribute("nome", c.getNome());
		req.setAttribute("sexo", c.getSexo());
		req.setAttribute("email", c.getEmail());
		req.setAttribute("rg", c.getRg());
		req.setAttribute("cpf", c.getCpf());
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("ImpressaoForm.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}
