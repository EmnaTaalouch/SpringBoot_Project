package tn.esprit.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.services.Interfaces.ContratService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("ContartController")
@Slf4j
public class ContratController {

	@Autowired
	ContratService contserv; 
	@Autowired
	EtudiantRepository etudrep ;

	@Autowired
    private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}") private String sender;
	@Value("${spring.mail.password}") private String password;
	
	
	@GetMapping("displayallcontrats")
	public List<Contrat> retrieveAllContrats() {
		return contserv.retrieveAllContrats();
	}

	@PutMapping("updateContrat")
	public Contrat updateContrat(@RequestBody Contrat ce) {
		return contserv.updateContrat(ce);
	}

	@PostMapping("newContrat")
	public Contrat newContrat( @RequestBody Contrat ce) {
		ce=contserv.addContrat(ce);
		return ce ;
	}
	
	
	@GetMapping("displayContratById/{id}")
	@ResponseBody
	public Contrat retrieveContrat(@PathVariable("id") int idContrat) {
		
		return contserv.retrieveContrat(idContrat);
	} 

	@DeleteMapping("deleteContrat/{id}")
	public void removeContrat(@PathVariable("id") int  idContrat) {
       contserv.removeContrat(idContrat);		
	}
	
	@GetMapping("addcontratToEtudiant/{idetudiant}/{idcontrat}")
	public int addcontratToEtudiant(@PathVariable("idetudiant") int idetudiant,@PathVariable("idcontrat") int idc) {;
	/*	Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password);
			}
		});
	Etudiant e = etudrep.findById(idetudiant).get();
    // Setting up necessary details
	try {
		// Create a MimeMessage object.
		MimeMessage mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress(sender));
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("emna.taalouch@esprit.tn"));
		mimeMessage.setSubject("Affectation d'un contrat");
		mimeMessage.setText("Bonjour"+e.getPrenomE()+" "+e.getNomE()+", on vous a affecté le contrat de l'id: "+idc);
		Transport.send(mimeMessage);

	} catch (MessagingException mex) {
		mex.printStackTrace();
	}

	Etudiant e = etudrep.findById(idetudiant).get();
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	mailSender.setHost("smtp.gmail.com");
	mailSender.setPort(587);
	
	mailSender.setUsername(sender);
	mailSender.setPassword(password);
	 
	Properties properties = new Properties();
	properties.setProperty("mail.smtp.auth", "true");
	properties.setProperty("mail.smtp.starttls.enable", "true");
	 
	mailSender.setJavaMailProperties(properties);
	
	SimpleMailMessage message = new SimpleMailMessage();
	 
	message.setFrom(sender);
	message.setTo("emna.taalouch@esprit.tn");
	message.setSubject("Affectation d'un contrat");
	message.setText("Bonjour"+e.getPrenomE()+" "+e.getNomE()+", on vous a affecté le contrat de l'id: "+idc);
	 
	mailSender.send(message);
   */
		return contserv.affecterContratToEtudiant(idetudiant,idc);
	}
	
	
	@DeleteMapping("dropcontratdaujourdhui")
	public void dropcontratdaujourdhui() {
		 contserv.dropAllContratsEveryYear();
	}
	
	@DeleteMapping("deletecontratdujour")
	 public int DeleteLesContratDunjour() {
		// log.info("deleting ... ");
		 return contserv.dropcontratdunjour();
	 }

}
