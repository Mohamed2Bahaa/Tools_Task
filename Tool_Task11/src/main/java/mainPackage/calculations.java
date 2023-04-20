package mainPackage;

import java.util.List;
import javax.ejb.Stateless;
import  javax.ws.rs.core.MediaType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;

@Stateless
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class calculations{
	
	@PersistenceContext
	private EntityManager entitymanager ;
	
@POST
@Path("/calc")
@Consumes(MediaType.APPLICATION_JSON)
public Result calc(EntityCalculation obj)		
	{       int num ;
		    Result R =new Result();	    
		   
	       	if (obj.getOperation().equals("+")) 
         	{
	       		num = obj.getNumber1()+obj.getNumber2() ;
       	 		R.setResult(num) ;
       	 	 
       	 	}
	       	else if (obj.getOperation().equals("-"))
       		{
	       		num = obj.getNumber1()-obj.getNumber2();
       			R.setResult(num) ;
       		
       		}
	       	else if (obj.getOperation().equals("*"))
       		{
	       		num = obj.getNumber1()*obj.getNumber2() ;
       			R.setResult(num) ;
       		
       		}
	       	else if (obj.getOperation().equals("/"))
	       	{	
	       		num = obj.getNumber1()/obj.getNumber2() ;
	       		R.setResult(num) ;
          
            }
	       	
	        entitymanager.persist(obj);
	        return  R ;
	} 
    
@GET
@Path("/calculations")
@Produces(MediaType.APPLICATION_JSON)
public List<EntityCalculation> GetCalculation()
{
	TypedQuery<EntityCalculation> query = entitymanager.createQuery("SELECT calcs FROM EntityCalculation calcs",EntityCalculation.class);
			List<EntityCalculation> calcs =query.getResultList() ;
	return calcs  ;
}

}
