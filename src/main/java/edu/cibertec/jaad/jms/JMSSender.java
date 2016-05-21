package edu.cibertec.jaad.jms;


import org.apache.log4j.Logger;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Java-VS on 21/05/2016.
 */
public class JMSSender {

    public static final Logger LOG = Logger.getLogger(JMSSender.class);
    public static final String CF_NAME = "jms/QUEUECF";
    public static final String QUEUE_NAME = "jms/JAADQUEUE";

    public static void main(String[] args) {

        try {

            Context ctx = new InitialContext();
            ConnectionFactory cnFactory = (ConnectionFactory) ctx.lookup(CF_NAME);
            Destination destination = (Destination) ctx.lookup(QUEUE_NAME);

            Connection connection = cnFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();

            // enviar msg
            MessageProducer producer = session.createProducer(destination);
            //TextMessage message = session.createTextMessage("Zorro se la come doblada");
            ObjectMessage message = session.createObjectMessage();
            message.setObject(new Profesor("Manuel","44100540"));
            producer.send(message);

            LOG.info("Mensaje Enviado");
            producer.close();
            session.close();
            connection.close();

            System.exit(0); //FIXME retirame
        } catch (NamingException|JMSException e) {
            LOG.error("error" , e);
        }

    }


}
