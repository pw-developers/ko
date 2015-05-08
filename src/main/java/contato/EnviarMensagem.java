package contato;

public class EnviarMensagem {
	public static String validaMsg(String c_name, String c_email, String c_message){
		String msgRetorno = "";
		if(c_name.equals("") || c_email.equals("") || c_message.equals("")){
			msgRetorno = "Valores obrigatórios estão vazios.";
		}
		return msgRetorno;
	}
}
