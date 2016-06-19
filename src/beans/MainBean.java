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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
