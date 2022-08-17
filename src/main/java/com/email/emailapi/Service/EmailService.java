package com.email.emailapi.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public boolean sendEmail(String subject, String message, String to, String from,String password) {
		boolean f = false;
		
//		 "password":"uqilatiajfbotpjv"

		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
		System.out.println("PROPERTIES" + properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from,password);
			}
		});

		session.setDebug(true);

		 try {
	            // Create a default MimeMessage object.
	            Message m = new MimeMessage(session);

	   	m.setFrom(new InternetAddress(from));

		m.setRecipients(Message.RecipientType.TO,
	              InternetAddress.parse(to));

		m.setSubject("My HTML message");

		   // Put your HTML content using HTML markup
		   m.setContent(
	              "<!DOCTYPE html>\n"
	              + "<head>\n"
	              + "    <meta charset='UTF-8'>\n"
	              + "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n"
	              + "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n"
	              + "    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css'>\n"
	              + "    <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js'></script>\n"
	              + "    \n"
	              + "    <title>Email Template</title>\n"
	              + "\n"
	              + "    <style>\n"
	              + "       \n"
	              + "        * {\n"
	              + "            box-sizing: border-box;\n"
	              + "            margin: 0;\n"
	              + "            padding: 0;\n"
	              + "            font-family: Google Sans, Roboto, Arial, sans-serif;\n"
	              + "        }\n"
	              + "        .main_container {\n"
	              + "            width: 100%;\n"
	              + "        }\n"
	              + "        .main_container img {\n"
	              + "            object-fit: cover;\n"
	              + "        }\n"
	              + "        .intro_logo img {\n"
	              + "            width: 20%;\n"
	              + "            object-fit: cover;\n"
	              + "        }\n"
	              + "        .intro h1 {\n"
	              + "            font-size: 18px;\n"
	              + "        }\n"
	              + "        .intro p {\n"
	              + "            margin-top: 0.3em;\n"
	              + "            font-size: 14px;\n"
	              + "        }\n"
	              + "        .countries {\n"
	              + "            background: #F8F8F8;\n"
	              + "            border-radius: 20px;\n"
	              + "            padding: 1em;\n"
	              + "            margin-bottom: 1em;\n"
	              + "            text-align: center;\n"
	              + "        }\n"
	              + "        \n"
	              + "        .target_audience p {\n"
	              + "            text-align: center;\n"
	              + "            font-size: 14px;\n"
	              + "            font-weight: 500;\n"
	              + "        }\n"
	              + "        .countries span {\n"
	              + "           font-size: 14px;\n"
	              + "        }\n"
	              + "        .cards {\n"
	              + "            display: flex;\n"
	              + "            justify-content: space-between;\n"
	              + "            flex-wrap: wrap;\n"
	              + "            margin-right: 1em;\n"
	              + "            /* gap: 1em; */\n"
	              + "            margin-bottom: 1em;\n"
	              + "            text-align: center;\n"
	              + "        }\n"
	              + "        .card_body {\n"
	              + "            width: 30%;\n"
	              + "            background: #F8F8F8;\n"
	              + "            border-radius: 26px;\n"
	              + "            padding: 2em;\n"
	              + "            margin-right:1em;\n"
	              + "        }\n"
	              + "        .card_body h2 {\n"
	              + "            font-weight: 700;\n"
	              + "            font-size: 16px;\n"
	              + "        }\n"
	              + "        .card_body p {\n"
	              + "            font-size: 14px;\n"
	              + "        }\n"
	              + "        .target_audience {\n"
	              + "            background: #F8F8F8;\n"
	              + "            border-radius: 20px;\n"
	              + "            padding: 1em;\n"
	              + "            margin-bottom:1em;\n"
	              + "        }\n"
	              + "        .details {\n"
	              + "            margin: 2em 0;\n"
	              + "            font-weight: 500;\n"
	              + "            font-size: 14px;\n"
	              + "            line-height: 1.4;\n"
	              + "        }\n"
	              + "        .below_details {\n"
	              + "            margin-bottom: 1em;\n"
	              + "        }\n"
	              + "        .portal_details {\n"
	              + "            margin-top: 1em;\n"
	              + "            font-size: 14px;\n"
	              + "            width: 80%;\n"
	              + "        }\n"
	              + "          .bid {\n"
	              + "            background: #3F86F0;\n"
	              + "            border-radius: 26px;\n"
	              + "            width: 100%;\n"
	              + "            border: none;\n"
	              + "            margin: 1em 0;\n"
	              + "            font-size: 16px;\n"
	              + "            color: white;\n"
	              + "            padding: 0.5em;\n"
	              + "            cursor: pointer;\n"
	              + "            display: block;\n"
	              + "            /* display: flex;\n"
	              + "            justify-content: center; */\n"
	              + "            text-decoration: none;\n"
	              + "        }\n"
	              + "        .center{\n"
	              + "            text-align:center;\n"
	              + "            color:white;\n"
	              + "        }\n"
	              + "       \n"
	              + "        .note {\n"
	              + "            font-size: 14px;\n"
	              + "        }\n"
	              + "        .managed_by {\n"
	              + "            margin-top: 1em;\n"
	              + "            margin-bottom: 4em;\n"
	              + "            font-size: 14px;\n"
	              + "        }\n"
	              + "        .order_details {\n"
	              + "            font-size: 14px;\n"
	              + "            margin-bottom: 1em;\n"
	              + "            padding-left: 1em;\n"
	              + "        }\n"
	              + "        .order_details p {\n"
	              + "            font-weight: 600;\n"
	              + "        }\n"
	              + "        .email_footer {\n"
	              + "            padding: 2em 2em 4em 2em;\n"
	              + "            background: #F8F8F8;\n"
	              + "        }\n"
	              + "        .regards {\n"
	              + "            font-weight: 400;\n"
	              + "            font-size: 14px;\n"
	              + "            color: #5C5C5C;\n"
	              + "        }\n"
	              + "        .footer_logo {\n"
	              + "            /*width: 200px;*/\n"
	              + "            height: 150px;\n"
	              + "        }\n"
	              + "        .footer_logo img {\n"
	              + "            width: 170px;\n"
	              + "             /*width: 100%; */\n"
	              + "            /*height: 100%;*/\n"
	              + "            object-fit: cover;\n"
	              + "        }\n"
	              + "        .details_logo {\n"
	              + "            display: flex;\n"
	              + "            justify-content: space-between;\n"
	              + "        }\n"
	              + "        .email_footer p {\n"
	              + "            line-height: 1.4;\n"
	              + "        }\n"
	              + "        .managed_by_details {\n"
	              + "            margin-right: 22em;\n"
	              + "        }\n"
	              + "        .managed_by_details,\n"
	              + "        .mobile a,\n"
	              + "        .mobile p {\n"
	              + "            font-weight: 400;\n"
	              + "            font-size: 14px;\n"
	              + "            color: #5C5C5C;\n"
	              + "            text-decoration: none;\n"
	              + "            line-height: 1.4;\n"
	              + "        }\n"
	              + "        .managed_by_details .name {\n"
	              + "            font-weight: 600;\n"
	              + "            margin-top: 1em;\n"
	              + "        }\n"
	              + "        .mobile {\n"
	              + "            margin: 2em 0;\n"
	              + "        }\n"
	              + "        .policy_letter_container footer {\n"
	              + "            background: #F8F8F8;\n"
	              + "            padding: 3em;\n"
	              + "            margin-top: 1em;\n"
	              + "        }\n"
	              + "        .copyright {\n"
	              + "            font-weight: 400;\n"
	              + "            font-size: 14px;\n"
	              + "            line-height: 38px;\n"
	              + "            color: #5C5C5C;\n"
	              + "            margin-bottom: 1em;\n"
	              + "        }\n"
	              + "        .company_info {\n"
	              + "            margin-top: 1em;\n"
	              + "            font-weight: 400;\n"
	              + "            font-size: 14px;\n"
	              + "            color: #5C5C5C;\n"
	              + "        }\n"
	              + "        .footer_content p,\n"
	              + "        .company_info a {\n"
	              + "            font-weight: 400;\n"
	              + "            font-size: 14px;\n"
	              + "            color: #5C5C5C;\n"
	              + "        }\n"
	              + "        .company_info a {\n"
	              + "            margin-right: 0.5em;\n"
	              + "        }\n"
	              + "        .reserved_policy {\n"
	              + "            margin-top: 1em;\n"
	              + "        }\n"
	              + "        .portal_link,\n"
	              + "        .mail,\n"
	              + "        .links {\n"
	              + "            color: #3f86f0;\n"
	              + "            text-decoration: none;\n"
	              + "        }\n"
	              + "        .content {\n"
	              + "            display: flex;\n"
	              + "        }\n"
	              + "        .left_content {\n"
	              + "            width: 70%;\n"
	              + "        }\n"
	              + "        .right_content {\n"
	              + "            width: 30%;\n"
	              + "        }\n"
	              + "        .container_img {\n"
	              + "            margin-bottom: 4em;\n"
	              + "        }\n"
	              + "        .container_img img {\n"
	              + "            width: 200px;\n"
	              + "            height: 200px;\n"
	              + "            object-fit: cover;\n"
	              + "        }\n"
	              + "          .card_body:last-child {\n"
	              + "            margin-right: 0;\n"
	              + "        }\n"
	              + "        @media (max-width:450px) {\n"
	              + "            .right_content {\n"
	              + "                padding-right: 1em;\n"
	              + "                word-wrap: break-word;\n"
	              + "            }\n"
	              + "                    .managed_by_details {\n"
	              + "                margin-right: 2em;\n"
	              + "            }\n"
	              + "            .intro_logo img {\n"
	              + "                width: 50%;\n"
	              + "                object-fit: cover;\n"
	              + "            }\n"
	              + "            .footer_logo img {\n"
	              + "                width: 150px;\n"
	              + "            }\n"
	              + "            .managed_by_details {\n"
	              + "                margin-right: 3em;\n"
	              + "            }\n"
	              + "            .container_img img {\n"
	              + "                width: 150px;\n"
	              + "                height: 150px;\n"
	              + "                object-fit: cover;\n"
	              + "            }\n"
	              + "            .cards {\n"
	              + "                display: block;\n"
	              + "                margin-right: 0;\n"
	              + "            }\n"
	              + "            .card_body {\n"
	              + "                width: 100%;\n"
	              + "                margin-bottom: 1em;\n"
	              + "            }\n"
	              + "            .footer_logo {\n"
	              + "                width: 100px;\n"
	              + "                height: 100px;\n"
	              + "                object-fit: cover;\n"
	              + "            }\n"
	              + "        }\n"
	              + "    </style>\n"
	              + "</head>\n"
	              + "<body>\n"
	              + "    <div class='main_container'>\n"
	              + "        <div class='content'>\n"
	              + "            <div class='left_content'>\n"
	              + "                <div class='container'>\n"
	              + "                    <div class='left_container'>\n"
	              + "                        <section class='intro_logo'>\n"
	              + "                            <img src='https://firebasestorage.googleapis.com/v0/b/mirats-fulcrum.appspot.com/o/SalesManagement%2FRough%2FImages%2Fmiratsinsights_logo%20(2).png?alt=media&token=e128e98f-2620-462c-9f1f-5f9bfdaf40fc'\n"
	              + "                                alt='logo'>\n"
	              + "                        </section>\n"
	              + "                        <section class='intro'>\n"
	              + "                            <h1>Hey {{bid_contact_name}}!</h1>\n"
	              + "                            <h1>We've a new project for you!</h1>\n"
	              + "                            <p>Please provide pricing, feasibility and field time for the following study. </p>\n"
	              + "                        </section>\n"
	              + "                    </div>\n"
	              + "                </div>\n"
	              + "                <div class='cards_order_container'>\n"
	              + "                    <div class='cards_container'>\n"
	              + "                         <section class='target_audience'>\n"
	              + "                            <p>Target Audience - {{target_audience}}</p>\n"
	              + "                        </section>\n"
	              + "                        {{#each tableData}}\n"
	              + "                        <section class='countries'>\n"
	              + "                        {{#each country}}\n"
	              + "                            <span>{{this.label}},</span>\n"
	              + "                        {{/each}}\n"
	              + "                        </section>\n"
	              + "                        <div class='cards'>\n"
	              + "                         <section class='card_body'>\n"
	              + "                                <h2>{{this.loi}}</h2>\n"
	              + "                                <p>Length of Interview (LOI)</p>\n"
	              + "                            </section>\n"
	              + "                            <section class='card_body'>\n"
	              + "                                <h2>{{this.IR}}%</h2>\n"
	              + "                                <p>Incidence Rate (IR)</p>\n"
	              + "                            </section>\n"
	              + "                            <section class='card_body'>\n"
	              + "                                <h2>{{this.required_samples}}</h2>\n"
	              + "                                <p>Sample Size <br /> (N required)</p> \n"
	              + "                            </section>     \n"
	              + "                        </div>\n"
	              + "                        \n"
	              + "                        {{/each}}\n"
	              + "                                          \n"
	              + "                        <section class='details'>\n"
	              + "                            <p class='below_details'> Simplified Details (of what is given above) :</p>\n"
	              + "                            <p>Target Audience : {{target_audience}}</p><br/>\n"
	              + "                            {{#each tableData}}\n"
	              + "                           {{#each country}}\n"
	              + "                            <span>{{this.label}}, </span>\n"
	              + "                           {{/each}} \n"
	              + "                           <p>Length of interview(LOI) - {{this.loi}} mins</p>\n"
	              + "                           <p>Incidence Rate(IR)- {{this.IR}} %</p>\n"
	              + "                           <p>Sample Size- {{this.required_samples}}</p>\n"
	              + "                           <br>\n"
	              + "                        {{/each}}\n"
	              + "                        </section>\n"
	              + "                        <p class='portal_details'>Please share your best quote. You can provide your quote directly from\n"
	              + "                            our\n"
	              + "                            <a href='https://supplier.miratsinsights.com/opportunity/{{id}}' class='portal_link'> Supe (Supplier Portal)</a> — by clicking the button given\n"
	              + "                            below you\n"
	              + "                            can quote on this project or reply to this email.\n"
	              + "                        </p>\n"
	              + "                         <a href='https://supplier.miratsinsights.com/opportunity/{{id}}' class='bid'>\n"
	              + "                              <p class='center'>Bid Now</p>\n"
	              + "                            </a>\n"
	              + "                        <p class='note'>Please Note - Always loop in\n"
	              + "                            <a class='mail' href='mailto:vendors@miratsinsights.com'>vendors@miratsinsights.com </a>\n"
	              + "                            while\n"
	              + "                            sending your quote.\n"
	              + "                        </p>\n"
	              + "                        <p class='managed_by'>This project is managed by {{sales.basicinfo.firstname}} {{sales.basicinfo.lastname}} <a href='mailto:{{sales.email}}'>( {{sales.email}} )</a>\n"
	              + "                            if you\n"
	              + "                            have any questions you can reply to this email, or use our\n"
	              + "                            <a class='links' href='https://supplier.miratsinsights.com'> Mirats Supe (our supplier portal — that’s\n"
	              + "                                for you only)</a> to get quick response from our sales team and manage bids efficiently.\n"
	              + "                        </p>\n"
	              + "                    </div>\n"
	              + "                </div>\n"
	              + "            </div>\n"
	              + "            <!-- right side -->\n"
	              + "            <div class='right_content'>\n"
	              + "                <section class='container_img'>\n"
	              + "                    <img src='https://firebasestorage.googleapis.com/v0/b/mirats-fulcrum.appspot.com/o/SalesManagement%2FRough%2FImages%2Fnamaste_mail.png?alt=media&token=5062c9e3-87ad-4e8e-ae14-f669493cf90b'\n"
	              + "                        alt=''>\n"
	              + "                </section>\n"
	              + "                <div class='order'>\n"
	              + "                    <section class='order_details'>\n"
	              + "                        <span>Order ID</span>\n"
	              + "                        <p>#{{id}}</p>\n"
	              + "                    </section>\n"
	              + "                    <section class='order_details'>\n"
	              + "                        <span>Sales Manager</span>\n"
	              + "                        <p>{{sales.basicinfo.firstname}} {{sales.basicinfo.lastname}}</p>\n"
	              + "                    </section>\n"
	              + "                    <section class='order_details'>\n"
	              + "                        <span>Study Type</span>\n"
	              + "                        <p>{{type}}</p>\n"
	              + "                    </section>\n"
	              + "                    <section class='order_details'>\n"
	              + "                        <span>Survey Type</span>\n"
	              + "                        <p>{{survey_type}}</p>\n"
	              + "                    </section>\n"
	              + "                    <section class='order_details'>\n"
	              + "                        <span>Device Allowed</span>\n"
	              + "                       {{#each device_compatibility}}\n"
	              + "                       <p>{{this}}</p>\n"
	              + "                       {{/each}}\n"
	              + "                        {{!-- <p{{device_compatility[0]}}</p> --}}\n"
	              + "                    </section>\n"
	              + "                </div>\n"
	              + "            </div>\n"
	              + "        </div>\n"
	              + "        <footer class='email_footer'>\n"
	              + "            <p class='regards'>Best Regards,</p>\n"
	              + "            <div class='details_logo'>\n"
	              + "                <section class='managed_by_details'>\n"
	              + "                    <h3 class='name'>{{basicinfo.firstname}} {{basicinfo.lastname}}</h3>\n"
	              + "                    <p>{{WorkDetails.position}}</p>\n"
	              + "                    <p>{{WorkDetails.department}}, {{WorkDetails.division}}</p>\n"
	              + "                    <p>{{WorkDetails.teamname}}</p>\n"
	              + "                    <p>Skype ID : {{WorkDetails.skypeID}}</p>\n"
	              + "                </section>\n"
	              + "                <section class='footer_logo'>\n"
	              + "                    <img src='https://firebasestorage.googleapis.com/v0/b/mirats-fulcrum.appspot.com/o/SalesManagement%2FRough%2FImages%2Fmiratsinsights_logo.png?alt=media&token=24c84374-91ca-4f39-b9c3-9fb39e611382'\n"
	              + "                        alt=''>\n"
	              + "                </section>\n"
	              + "            </div>\n"
	              + "            <section class='mobile'>\n"
	              + "                <p>Mobile: {{basicinfo.phonenumber}}</p>\n"
	              + "                <p><a href='mailto:{{data.email}}'>{{email}}</a></p>\n"
	              + "                <p><a href='http://www.miratsinsights.com/'> Website: http://www.miratsinsights.com/</a></p>\n"
	              + "            </section>\n"
	              + "            <section class='footer_content'>\n"
	              + "                <h3 class='copyright'>TM and © 2021 Mirats Insights, LLC. All rights reserved.</h3>\n"
	              + "                <p>Mirats Insights Private Limited </p>\n"
	              + "                <p>Office No 7022, 1Aerocity NIBR Corporate Park</p>\n"
	              + "                <p>Nr Sakinaka Junction, Safed Pul, Mumbai,</p>\n"
	              + "                <p>Maharashtra 400 072 India</p>\n"
	              + "            </section>\n"
	              + "            <section class='company_info'>\n"
	              + "                <p>CIN: U72900UP2021PTC153917.</p>\n"
	              + "                <p>GSTIN: 27AAPCM0779A1ZD.</p>\n"
	              + "                <p class='reserved_policy'>All Rights Reserved <span>|</span> Privacy Policy</p>\n"
	              + "            </section>\n"
	              + "        </footer>\n"
	              + "    </div>\n"
	              + "</body>\n"
	              + "</html>","text/html");

		   // Send message
		   Transport.send(m);

		   System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
		   e.printStackTrace();
		   throw new RuntimeException(e);
	      }
		return f;

	}



}
