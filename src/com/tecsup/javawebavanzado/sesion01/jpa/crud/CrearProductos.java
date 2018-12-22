package com.tecsup.javawebavanzado.sesion01.jpa.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;
import com.tecsup.javawebavanzado.sesion01.jpa.Producto;

public class CrearProductos {
	
	private static final int CATEGORIA_LACTEOS = 2;
	static EntityManagerFactory emf;
	static EntityManager em;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		emf = Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA");
		
		em = emf.createEntityManager();
		
		try {
			//Empieza la Tx.
			em.getTransaction().begin();
			
			Categoria cat =  em.find(Categoria.class, CATEGORIA_LACTEOS);
			System.out.println(cat);
			
			Producto prod2 = new Producto();
			prod2.setNombre("Leche Laive");
			prod2.setDescripcion("Producto Laive");
			
			Producto prod3 = new Producto();
			prod2.setNombre("Leche Gloria");
			prod2.setDescripcion("Producto Gloria");
			
			cat.addProducto(prod2);
			cat.addProducto(prod3);
			
			em.persist(prod2);
			em.persist(prod3);
			
		
			em.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			
		} finally {
			
		}
		
		em.close();
		emf.close();
		}
			

}
