package Student;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class sku 
{
public static void main(String[] args)
{
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
EntityManager entityManager=entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();
prasanth p=new prasanth();
Scanner s=new Scanner(System.in);
boolean flog=true;
while(flog)
{
	System.out.println("1.Add the Student Deatials");
	System.out.println("2.Fetch the Student Deatails by usn");
	System.out.println("3.Modify the Student Deatails by usn");
	System.out.println("4.Remove the Student Deatails");
	System.out.println("5.Fetch all  the Student Deatails");
	System.out.println("6.Delete all  the Student Deatails");
	System.out.println("7.Exit");
	switch(s.nextInt())
	{
	case 1:
	{
		System.out.println("enter the name of student");
		p.setName(s.next());
		System.out.println("enter the usn of student");
		p.setUsn(s.next());
		System.out.println("enter the branch of student");
		p.setBranch(s.next());
		System.out.println("enter the phno of student");
		p.setPhno(s.nextLong());
		entityTransaction.begin();
		entityManager.merge(p);
		entityTransaction.commit();
		System.out.println("student should be added succesfully");
	}break;

	case 2:
	{   
		System.out.println("enteer the usn no");
	    prasanth ph=entityManager.find(prasanth.class,s.next());
		if(ph!=null)
		{
	    System.out.println(ph.getName()+" "+ph.getUsn()+" "+ph.getBranch()+" "+ph.getPhno());
		System.out.println("fetch the data by usn is done");
		}
		else
		{
			System.out.println("no usn found");
		}
	}break;
	case 3:
	{
		System.out.println("enteer the usn no");
		  prasanth ph=entityManager.find(prasanth.class,s.next());
			if(ph!=null)
			{
				System.out.println("enter the phone no");
				entityTransaction.begin();
				ph.setPhno(s.nextLong());
				entityManager.merge(ph);
				entityTransaction.commit();
			}
			else
			{
				System.out.println("no usn found");
			}
	}break;
	case 4:
	{

		System.out.println("enteer the usn no for remove student");
		 prasanth ph=entityManager.find(prasanth.class,s.next());
			if(ph!=null)
			{
			
				entityTransaction.begin();
				entityManager.remove(ph);
				entityTransaction.commit();
			}
			else
			{
				System.out.println("no usn found");
			}
	}break;
	case 5:
	{
		Query query=entityManager.createQuery("select h from prasanth h",prasanth.class);
		List<prasanth> ph=query.getResultList();
		for(prasanth a:ph)
		{
			System.out.println(a.getName()+" "+a.getUsn()+" "+a.getBranch()+" "+a.getPhno());
		}break;
	}
	case 6:
	{
		entityTransaction.begin();
		Query query=entityManager.createQuery("delete from prasanth");
		query.executeUpdate();
		entityTransaction.commit();
	}break;
	case 7:
	{
		flog=false;
		System.out.println("thank you");
	}break;
	}
}
}
}