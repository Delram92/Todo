package com.prueba.todo.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


/**
 * 
 * @author Yohana Delgado Ramos
 */


@Entity
public class TodoEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	private Long estadoid;

	@Index
	@NotNull
	private String estadoNombre;
	
	private String descripcion;

	public TodoEstado() {
	}

	public TodoEstado(Long estadoid) {
		this.estadoid = estadoid;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TodoEstado)) {
			return false;
		}
		TodoEstado other = (TodoEstado) object;
		if ((this.estadoid == null && other.estadoid != null)
				|| (this.estadoid != null && !this.estadoid.equals(other.estadoid))) {
			return false;
		}
		return true;
	}

	public Long getEstadoid() {
		return estadoid;
	}

	public String getEstadoNombre() {
		return estadoNombre;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (estadoid != null ? estadoid.hashCode() : 0);
		return hash;
	}

	public void setEstadoid(Long estadoid) {
		this.estadoid = estadoid;
	}

	public void setEstadoNombre(String estadoNombre) {
		this.estadoNombre = estadoNombre;
	}

	@Override
	public String toString() {
		return "com.prueba.todo.model.TodoEstado[ estadoid=" + estadoid + " ]";
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
