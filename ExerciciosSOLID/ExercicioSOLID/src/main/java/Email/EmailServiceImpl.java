package Email;

public class EmailServiceImpl implements EmailServiceInterface {

    @Override
    public void sendEmailConfirmation(String email){
        System.out.println("Enviando email de confirmacao para: " + email);
    }
}
