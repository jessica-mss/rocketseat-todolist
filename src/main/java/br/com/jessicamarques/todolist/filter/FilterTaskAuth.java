package br.com.jessicamarques.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;
import br.com.jessicamarques.todolist.model.UserModel;
import br.com.jessicamarques.todolist.repository.IUserRepository;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {
	
	@Autowired
	private IUserRepository IUserRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String Authorization = request.getHeader("Authorization");
		String AuthorizationWithoutBearer = Authorization.split(" ")[1];
		System.out.println("Authorization");
		System.out.println(AuthorizationWithoutBearer);
		
		byte[] base64DecodedBytes = Base64.getDecoder().decode(AuthorizationWithoutBearer);
		String decodedAuthorization = new String(base64DecodedBytes);
		System.out.println(decodedAuthorization);
		
		String[] credentials = decodedAuthorization.split(":");
		String username = credentials[0];
		String password = credentials[1];
		
		UserModel user = IUserRepository.findByUsername(username);
		
		if(user == null) {
			response.sendError(401, "Usuário não autorizado!");
		} else {
			Result passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
			if (passwordVerify.verified) {
				filterChain.doFilter(request, response);				
			} else {
				response.sendError(401, "Usuário não autorizado!");
			}
		}
		
	}
	
		
	
}
