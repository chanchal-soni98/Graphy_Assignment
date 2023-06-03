package com.graphy.Service;

import com.graphy.Repository.UserRepository;
import com.graphy.model.User;
import com.opencsv.CSVWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Service
public class EmailService {
	
	
	private static String email_log_file = "\"C:\\Users\\CHANCHAL SONI\\Desktop\\Graphy\\Graphy_Assignment\\email_log.csv.txt\"";
	
	private CSVWriter csvWriter;
	private static int page_size = 100;
	@Autowired
	private UserRepository ur;
	
	public void sendEmailsToUser(int page) {
		// Pagination for user database to manage.
        PageRequest pageRequest = PageRequest.of(page, page_size);
        Page<User> userPage = ur.findAll(pageRequest);
        List<User> us = userPage.getContent();
		for (User user : us) {
            sendEmail(user);
        }
		System.out.println("Mail sent");
	}
	private void sendEmail(User user) {
        // Set up the properties for the email server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Set up the email session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("chanchalsoni19998@gmail.com", "@Cs11955");
            }
        });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("chanchalsoni19998@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            
            //Email content
            message.setSubject("Regarding Graphy's Assignment");
            message.setText("Here I am submitting my assignment please find it.");

            // Send the email
            Transport.send(message);

            // successfully sent email
            logEmail(user.getEmail());
            
        } catch (MessagingException me) {
            // Exception Handle for email sending errors
            me.printStackTrace();
//            System.out.println();
        }
    }

    private void logEmail(String email) {
    	String[] record = { email };
        csvWriter.writeNext(record);
        try {
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace(); // Handle CSV file logging errors
        }
	}
}
