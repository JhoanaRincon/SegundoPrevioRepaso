package elecciones.controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import elecciones.dao.VotanteDao;
import elecciones.entities.Votante;

/**
 * Servlet implementation class VotanteController2
 */
@WebServlet("/")
public class VotanteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VotanteDao votantedao;
    /**
     * Default constructor. 
     */
    public VotanteController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 votantedao = new VotanteDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getServletPath();
		try {

			switch (action) {
			case "/new": 
				showNewForm(request, response);
				break;
			case "/insert":
				insert(request, response);
				break;
			case "/update":
				update(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/delete":
				delete(request, response);
				break;
			default:
				listVotantes(request,response); //error
				break;
			}
			
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//RequestDispatcher para que nos de acceso a un recurso, que seria una pagina jsp(la interfaz del usuario)
		RequestDispatcher dispatcher = request.getRequestDispatcher("registroVotantes.jsp");
		//se redirecciona hacia el recurso que seleciona
		dispatcher.forward(request, response);
	}
	
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//se guarda los elementos que se recibe en el request en nuevas variables
				
				String nombre = request.getParameter("nombre");
				String email = request.getParameter("email");
				String documento = request.getParameter("documento");
				
				
				//se crea un nuevo usuario, pero sin el id
				Votante votante = new Votante(nombre, email, documento);
				//llama el metodo insertar de la clase UsuarioDao para enviarle los prametros que recibio, y que UsuarioDao los lleve a la base de datos
				votantedao.insert(votante);
				//redirecciona  una localizacion "list"
				response.sendRedirect("list");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String documento = request.getParameter("documento");
		

		//se crea un nuevo usuario, pero sin el id
		Votante votante = new Votante(id,nombre, email, documento);
		//llama el metodo insertar de la clase UsuarioDao para enviarle los prametros que recibio, y que UsuarioDao los lleve a la base de datos
		votantedao.update(votante);
		//redirecciona  una localizacion "list"
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
				//se guarda en una variable el parametro que lleg por request (que para esta es id), se parcea a int ya que llega en String
				int id = Integer.parseInt(request.getParameter("id"));
				//se crea un objeto usuario y se inicializa con el metodo select de la clase usuarioDao(mandando el usuario perteneciente al id)
				Votante votanteActual = votantedao.get(id);
				//montando el contexto de la peticion y se envia el objeto usuarioActual
				//se envia el objeto del usuario consultado a la peticion para que sea manejado en el jsp
				request.setAttribute("votante", votanteActual);
				//RequestDispatcher para que nos de acceso a un recurso, que seria una pagina jsp(la interfaz del usuario)
				RequestDispatcher dispatcher = request.getRequestDispatcher("registroVotantes.jsp");
				//se redirecciona hacia el recurso que seleciona
				dispatcher.forward(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//se guarda en una variable el parametro que lleg por request (que para esta es id), se parcea a int ya que llega en String
		int id = Integer.parseInt(request.getParameter("id"));
		//se envia el id por medio del metodo update() de la clase usuario.
		votantedao.delete(id);
		//redirecciona  una localizacion "list"
		response.sendRedirect("list");	
	}
	
	
	private void listVotantes(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException{
		//se crea un ArrayList para los usuarios, se llama al metodo selectAll() de la clase UsuarioDao para que selecione todos los usuarios
		List<Votante> listVotantes = votantedao.list(); //error
		//se va a enviar el listado para que se cargue en el formulario
		request.setAttribute("listadoVotantes", listVotantes);
		//RequestDispatcher para que nos de acceso a un recurso,
		//que seria una pagina jsp(la interfaz del usuario) usuarioList.jsp es quien va a recibir el listado de usuarios
		RequestDispatcher dispatcher = request.getRequestDispatcher("listadoVotantes.jsp");
		//se redirecciona hacia el recurso que seleciona
		dispatcher.forward(request, response);
	}
	
}
