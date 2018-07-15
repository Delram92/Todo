package com.prueba.todo.contoller;

import java.io.Serializable;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.prueba.todo.model.TodoEstado;
import com.prueba.todo.service.TodoEstadoServicie;
import com.prueba.todo.serviceimpl.TodoEstadoServiceImpl;

/**
 * 
 * @author Yohana Delgado Ramos
 */

@Controller
public class TodoEstadoController implements Serializable {

	private static final long serialVersionUID = 10L;

	private TodoEstadoServicie todoEstadoServicio;

	private TodoEstado itemSeleccionado;
	private List<TodoEstado> listaTodoEstado;

	private boolean error = false;
	private String nombree = "";
	private String descripcione = "";
	private String mErrror = "";

	public TodoEstadoController() {
		todoEstadoServicio = new TodoEstadoServiceImpl();
		inicializar();
	}

	@RequestMapping(value = "/addEstado", method = RequestMethod.POST)
	public ModelAndView crear(HttpServletRequest request, ModelMap model) {
		String nombre = request.getParameter("nombre").toUpperCase().trim();
		String descrip = request.getParameter("descripcion");
		error = false;

		try {
			if (verificarUnico(nombre)) {

				itemSeleccionado.setEstadoNombre(nombre);

				itemSeleccionado.setDescripcion(request.getParameter("descripcion"));

				todoEstadoServicio.crear(itemSeleccionado);

				return new ModelAndView("redirect:listEstado");
			}

			else {
				error = true;
				nombree = nombre;
				descripcione = descrip;
				// model.put("message",mErrror);
				mErrror= "Ya existe un estado con el mismo nombre, favor valide";
				return new ModelAndView("redirect:addEstado");
			}

		} catch (Exception e) {
			mErrror = "Ocurrio un error, favor verifique los datos ingresados";
			return null;
		}

	}

	@RequestMapping(value = "/listEstado", method = RequestMethod.GET)
	public String listCustomer(ModelMap model) {

		List<TodoEstado> results = null;

		try {
			results = todoEstadoServicio.consultarTodoEstados();

			if (results.isEmpty()) {
				model.addAttribute("listTodoEstado", null);
			} else {
				model.addAttribute("listTodoEstado", results);
			}
			return "listEstado";
		} catch (Exception e) {
			return null;
		}

	}

	public TodoEstado getItemSeleccionado() {
		return itemSeleccionado;
	}

	public List<TodoEstado> getListaTodoEstado() {

		listaTodoEstado = todoEstadoServicio.consultarTodoEstados();
		return listaTodoEstado;
	}

	public boolean verificarUnico(String nombre) {
		boolean existe = false;
		TodoEstado estado = new TodoEstado();
		estado = null;
		//error = true; 
		try {

			estado = todoEstadoServicio.consultarNombreUnico(nombre);
			if (estado == null) {
				System.out.println("No existe");
				existe = true;
			}
			return existe;
		} catch (Exception e) {
			System.out.println("error" + e.getLocalizedMessage());
			return existe;
		}

	}

	public TodoEstadoServicie getTodoEstadoServicio() {
		return todoEstadoServicio;
	}

	private void inicializar() {
		itemSeleccionado = new TodoEstado();
	}



	@RequestMapping(value = "/addEstado", method = RequestMethod.GET)
	public String getAddCustomerPage(ModelMap model) {

		if (error) {
			
			model.put("message", mErrror);
			model.put("nombre", nombree);
			model.put("descripcion", descripcione);
			return "addEstado";
		} else {
			itemSeleccionado = new TodoEstado();

			return "addEstado";
		}

	}



	public void setItemSeleccionado(TodoEstado itemSeleccionado) {
		this.itemSeleccionado = itemSeleccionado;
	}

	public void setListaTodoEstado(List<TodoEstado> listaTodoEstado) {
		this.listaTodoEstado = listaTodoEstado;
	}



	public void setTodoEstadoServicio(TodoEstadoServicie todoEstadoServicio) {
		this.todoEstadoServicio = todoEstadoServicio;
	}

}
