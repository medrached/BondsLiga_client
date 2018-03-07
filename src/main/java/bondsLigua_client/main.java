package bondsLigua_client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bondsLiga.bondsLigua_server.interfaces.companyServices;
import tn.esprit.bondsLiga.bondsLigua_server.interfaces.shareServices;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Company;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Share;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String jndi="bondsLigua_server-ear/bondsLigua_server-ejb/TodoService!tn.esprit.bondsLiga.bondsLigua_server.services.TodoServiceRemote";
		Context context=new InitialContext();
		TodoServiceRemote td=(TodoServiceRemote)context.lookup(jndi);
		System.out.println(td.sayHello());*/
		
		
		String jndiName = "bondsLigua_server-ear/bondsLigua_server-ejb/companyServiceImpl!tn.esprit.bondsLiga.bondsLigua_server.interfaces.companyServices";
		String jndiNames= "bondsLigua_server-ear/bondsLigua_server-ejb/shareServiceImpl!tn.esprit.bondsLiga.bondsLigua_server.interfaces.shareServices";
  		Context context;
		try {
		context = new InitialContext();
  		companyServices proxy=(companyServices) context.lookup(jndiName);
  		shareServices proxy1=(shareServices) context.lookup(jndiNames);
  		Company c=new Company();
  		Share d=new Share() ;
  		d.setPotentialFluctuationState(15);
  		d.setPrice(54);
	
		
  		
  	
  		proxy1.addShare(d);
  		
		c.setFreeShareNumber(5);

		c.setOperatingIncome(56);
		c.setTokenSharesNUmber(4);

	
		proxy.addCompany(c);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	proxy.addCompany(c1);
	
	
	
/*	Company r=proxy.searchById(1);
		r.setFreeShareNumber(5);
		r.setOperatingIncome(5);
		r.setTokenSharesNUmber(5);	
		proxy.updateCompany(r);
	
	*/
	//	proxy.delete(1);
	

	 
		// 	proxy.updateCompany(r);
	
	
		// proxy.delete(2);
		
		
		
		
		
	}

}
