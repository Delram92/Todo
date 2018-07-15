package com.prueba.todo.contoller;

import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prueba.todo.model.Todo;
import com.prueba.todo.model.TodoEstado;

import com.prueba.todo.service.TodoService;
import com.prueba.todo.serviceimpl.TodoServiceImpl;

/**
 * 
 * @author Yohana Delgado Ramos
 */
@Controller
public class TodoController implements Serializable {

	private static final long serialVersionUID = 10L;

	private TodoService todoServicio;

	private Todo itemSeleccionado;
	private List<Todo> listaTodo;
	private String mErrror;
	private boolean error = false;
	private String nombreT = "";
	private String numHorasT = "";
	private List<TodoEstado> estados;
	private Date fechainicio;
	private Date fechaCreacion;


	public TodoController() {
		todoServicio = new TodoServiceImpl();
		inicializar();
	}
//Metodo create tarea
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView crear(HttpServletRequest request, ModelMap model) {
		mErrror = "";
		error = false;
		model.put("message", mErrror);

		try {
			String nombre = request.getParameter("nombre").toUpperCase().trim();
			String numeroHoras = request.getParameter("horas").trim();

			String estadoid = request.getParameter("estado");
			Long horas = Long.valueOf(numeroHoras);

			if (verificarUnico(nombre)) {

				TodoEstado estado = new TodoEstado();
				estado.setEstadoid(Long.valueOf(estadoid));
				itemSeleccionado.setTodoNombre(nombre);
				itemSeleccionado.setTodoNumHoras(horas);
				itemSeleccionado.setTodofechaCreacion(new Date());
				itemSeleccionado.setTodoEstado(estado);
				itemSeleccionado.setPrioridad(Long.valueOf(request.getParameter("prioridad").trim()));
				itemSeleccionado.setTodoDescripcion(request.getParameter("descripcion"));
				Date fechaini = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("fechaini").trim());
				Date fechafin = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("fechafin").trim());
				itemSeleccionado.setTodoFechaInicio(fechaini);
				itemSeleccionado.setTodofechaFin(fechafin);
				todoServicio.crear(itemSeleccionado);
				return new ModelAndView("redirect:list");
			} else {
				error = true;
				nombreT = nombre;
				numHorasT = numeroHoras;
				mErrror = "Ya existe una tarea con el mismo nombre, Favor valide";
				return new ModelAndView("redirect:add");
			}

		} catch (Exception e) {
			error = true;
			mErrror = "Ocurrio un error, verifique sus datos";
			return new ModelAndView("redirect:add");
		}

	}
	
	//Update tarea

	@RequestMapping(value = "/update/{todoid}", method = RequestMethod.GET)
	public String getUpdateTodoPage(@PathVariable String todoid, HttpServletRequest request, ModelMap model) {

		Long tareaid = 0L;
		tareaid = Long.valueOf(todoid);

		itemSeleccionado = todoServicio.consultarPorId(tareaid);

		List<TodoEstado> estado = null;

		estado = todoServicio.seleccionarEstados();

		try {
			if (estado == null) {
				model.addAttribute("listEstado", null);
			} else {
				model.addAttribute("listEstado", estado);
			}
			if (itemSeleccionado == null) {
				model.addAttribute("todo", null);
				return "list";

			} else {
				model.addAttribute("todo", itemSeleccionado);
				fechainicio = itemSeleccionado.getTodoFechaInicio();
				fechaCreacion = itemSeleccionado.getTodofechaCreacion();
				return "update";
			}
		} catch (Exception e) {
			model.addAttribute("todo", null);
			model.addAttribute("listEstado", null);
			return "list";
		}

	}

	//Detalle tarea
	@RequestMapping(value = "/view/{todoid}", method = RequestMethod.GET)
	public String getViewTodoPage(@PathVariable String todoid, HttpServletRequest request, ModelMap model) {

		Long tareaid = 0L;
		tareaid = Long.valueOf(todoid);

		itemSeleccionado = todoServicio.consultarPorId(tareaid);

		try {

			if (itemSeleccionado == null) {
				model.addAttribute("todo", null);
				return "list";

			} else {
				model.addAttribute("todo", itemSeleccionado);
				return "view";
			}
		} catch (Exception e) {
			model.addAttribute("todo", null);

			return "view";
		}

	}

	//Metodo para realizar el update de la tarea
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, ModelMap model) {

		try {
			itemSeleccionado = new Todo();

			itemSeleccionado.setTodoid(Long.valueOf(request.getParameter("todoid")));

			String nombre = request.getParameter("nombre").toUpperCase();
			String numeroHoras = request.getParameter("horas").trim();
			Long horas = Long.valueOf(numeroHoras);
			String estadoid = request.getParameter("estado");

			TodoEstado estado = new TodoEstado();
			estado.setEstadoid(Long.valueOf(estadoid));
			itemSeleccionado.setTodoNombre(nombre);
			itemSeleccionado.setTodoNumHoras(horas);
			itemSeleccionado.setTodoDescripcion(request.getParameter("descripcion"));
			itemSeleccionado.setTodoEstado(estado);
			Date fechafin = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("fechafin").trim());
			itemSeleccionado.setTodoFechaInicio(fechainicio);
			itemSeleccionado.setTodofechaFin(fechafin);
			itemSeleccionado.setTodofechaCreacion(fechaCreacion);
			itemSeleccionado.setPrioridad(Long.valueOf(request.getParameter("prioridad").trim()));
			todoServicio.actualizar(itemSeleccionado);

			return new ModelAndView("redirect:list");

		} catch (Exception e) {

			return new ModelAndView("redirect:list");
		}


	}
	
	//Metodo para eliminar la tarea

	@RequestMapping(value = "/delete/{todoid}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String todoid, HttpServletRequest request, ModelMap model) {

		try {

			Long tareaid = 0L;
			tareaid = Long.valueOf(todoid);
			System.out.println(tareaid + "tareaid");
			itemSeleccionado = new Todo();
			itemSeleccionado.setTodoid(tareaid);

			todoServicio.eliminar(itemSeleccionado);
			return new ModelAndView("redirect:../list");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("redirect:../list");
		}

	}

	//Metodo que verifica si existe una tarea con el mismo nombre al momento de ser creada
	public boolean verificarUnico(String nombre) {
		boolean existe = false;
		Todo tarea = new Todo();
		tarea = null;
		try {

			tarea = todoServicio.consultarNombreUnico(nombre);
			if (tarea == null) {
				System.out.println("No existe");
				existe = true;
			}
			return existe;
		} catch (Exception e) {
			System.out.println("error" + e.getLocalizedMessage());
			return existe;
		}

	}

	
//Retorna la lista de tareas
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listTodo(ModelMap model) {

		List<Todo> results = null;

		try {
			results = todoServicio.consultarTodos();

			if (results.isEmpty()) {
				model.addAttribute("listTodo", null);
			} else {
				model.addAttribute("listTodo", results);
			}
			return "list";
		} catch (Exception e) {
			return null;
		}

	}
	
	//Retorna la lista de tareas realizadas

	@RequestMapping(value = "/listHecho", method = RequestMethod.GET)
	public String listTodoHecho(ModelMap model) {

		List<Todo> results = null;

		try {
			results = todoServicio.consultarFinalizados();

			if (results.isEmpty()) {
				model.addAttribute("listHecho", null);
			} else {
				model.addAttribute("listHecho", results);
			}
			return "listHecho";
		} catch (Exception e) {
			return null;
		}

	}

	public Todo getItemSeleccionado() {
		return itemSeleccionado;
	}

	public List<Todo> getListaTodo() {

		listaTodo = todoServicio.consultarTodos();
		return listaTodo;
	}

	public TodoService getTodoServicio() {
		return todoServicio;
	}

	private void inicializar() {
		itemSeleccionado=new Todo();
	}

	//Metodo para retornar la vista que permite crear tareas, carga los estados y se los asigna con el valor listEstado

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddTodoPage(ModelMap model) {
		List<TodoEstado> estado = null;

		estado = todoServicio.seleccionarEstados();
		try {
			if (estado.isEmpty()) {
				model.addAttribute("listEstado", null);
			} else {
				model.addAttribute("listEstado", estado);
			}
		} catch (Exception e) {
			model.addAttribute("listEstado", null);
		}

		if (error) {

			model.put("message", mErrror);
			model.put("nombre", nombreT);
			model.put("horas", numHorasT);
			return "add";
		} else {
			itemSeleccionado = new Todo();

			return "add";
		}

	}

	@PostConstruct
	public void prerender() {
		inicializar();

	}

	
	public void setItemSeleccionado(Todo itemSeleccionado) {
		this.itemSeleccionado = itemSeleccionado;
	}

	public void setListaTodo(List<Todo> listaTodo) {
		this.listaTodo = listaTodo;
	}

	
	public void setTodoServicio(TodoService todoServicio) {
		this.todoServicio = todoServicio;
	}

	@RequestMapping("/") //Retorna la pagina de inicio
	public String welcome(Map<String, Object> model) {
		return "index";
	}

	public List<TodoEstado> getEstados() {
		return estados;

	}

	public void setEstados(List<TodoEstado> estados) {
		this.estados = estados;
	}

	public String getmErrror() {
		return mErrror;
	}

	public void setmErrror(String mErrror) {
		this.mErrror = mErrror;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
