package bondsLigua_client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bondsLiga.bondsLigua_server.services.TodoService;
import tn.esprit.bondsLiga.bondsLigua_server.services.TodoServiceRemote;

public class main {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		String jndi="bondsLigua_server-ear/bondsLigua_server-ejb/TodoService!tn.esprit.bondsLiga.bondsLigua_server.services.TodoServiceRemote";
		Context context=new InitialContext();
		TodoServiceRemote td=(TodoServiceRemote)context.lookup(jndi);
		System.out.println(td.sayHello());
	}

}
