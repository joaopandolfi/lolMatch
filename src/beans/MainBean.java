package beans;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import constants.Config;
import controller.LoginControl;
import model.User;
import persistence.UserDAO;
import riot.LolAPI;

@ManagedBean(name="mainBean")
@SessionScoped
public class MainBean implements Serializable {
	private static final long serialVersionUID = 1L;
	User user = new User();
	LolAPI api = LolAPI.getInstance(Config.LOL_API);
	
	public String login(){
		FacesContext context = FacesContext.getCurrentInstance();
		LoginControl loginControl = new LoginControl(api);
		if(loginControl.login(user)){
			return "main";
		}
		System.out.println("senha errada");
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login ou senha inválida",""));
		return "";
	}

	public String register(){
		FacesContext context = FacesContext.getCurrentInstance();
		UserDAO userDAO = new UserDAO();
		if(userDAO.saveCascade(user)){
			return login();
		}
		System.out.println("Erro ao cadastrar usuario");
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro a cadastrar usuario",""));
		return "";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String makeAvaliationStars(double avaliation){
		String modelStar ="<i class='fa fa-star%s margin-r-5'></i>";
		String result = "";
		for(int i = 0 ; i< 5;i++){
			if(i <= avaliation)
				result += String.format(modelStar, "");
			else if(i <= (avaliation +1))
				result+= String.format(modelStar, "-half-o");
			else 
				result+= String.format(modelStar, "-o");
		}
		return result;
	}


}
