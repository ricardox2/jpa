package com.venta.test;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.venta.dto.*;

public class AddTest {
	EntityManagerFactory emf;
	EntityManager em;
	
	@Before
	public void iniciar() {
		emf=Persistence.createEntityManagerFactory("venta");
		em=emf.createEntityManager();		
	}
	
	@Test
	public void addcategoria() {
		em.getTransaction().begin();
		Categoria ncat=new Categoria(1,"Bebidad espirituosas");
		Categoria ncat1=new Categoria(2,"Bebidad normales");
		
		em.persist(ncat);
		em.persist(ncat1);
			
		em.getTransaction().commit();
		
		Categoria c1=em.find(Categoria.class, 1);
		Categoria c2=em.find(Categoria.class, 2);
		
		em.getTransaction().begin();
		Producto p1=new Producto("Cerveza",200,c1);
		Producto p2=new Producto("Pisco",500,c1);
		
		Producto p3=new Producto("Agua",300,c2);
		Producto p4=new Producto("Jugo",400,c2);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Cliente cl1=new Cliente("12323478","Juan","Perez","Huaraz");
		Cliente cl2=new Cliente("12323478","Pepe","Wey","Huaraz");
		Cliente cl3=new Cliente("12323478","Luna","Tahua","Huaraz");
		Cliente cl4=new Cliente("12323478","Miguel","Webas","Huaraz");
		
		em.persist(cl1);
		em.persist(cl2);
		em.persist(cl3);
		em.persist(cl4);
		em.getTransaction().commit();
		
		Cliente cli1=em.find(Cliente.class, 25);
		Cliente cli2=em.find(Cliente.class, 26);
		
		
		Date date = Calendar.getInstance().getTime();
		
		em.getTransaction().begin();
		Factura f1=new Factura("1234567", date, cli1);
		Factura f2=new Factura("1234568", date, cli2);
		em.persist(f1);
		em.persist(f2);
		em.getTransaction().commit();
		
		
		Factura fc1=em.find(Factura.class, 3);
		Factura fc2=em.find(Factura.class, 4);
		Producto pr1=em.find(Producto.class, 32);
		Producto pr2=em.find(Producto.class, 33);
		Producto pr3=em.find(Producto.class, 34);
		Producto pr4=em.find(Producto.class, 35);
		
		
		em.getTransaction().begin();
		Detalle d1=new Detalle(5, 2, fc1, pr1);
		Detalle d2=new Detalle(15, 3, fc1, pr2);
		Detalle d3=new Detalle(1.5, 2, fc2, pr1);
		Detalle d4=new Detalle(2.5, 1, fc2, pr3);
		Detalle d5=new Detalle(4, 7, fc2, pr4);
		em.persist(d1);
		em.persist(d2);
		em.persist(d3);
		em.persist(d4);
		em.persist(d5);
		em.getTransaction().commit();
		
	}
}
