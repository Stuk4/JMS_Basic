package edu.cibertec.jaad.jms;

import org.apache.log4j.Logger;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Java-VS on 21/05/2016.
 */
public class JMSReceiver {

    public static final Logger LOG = Logger.getLogger(JMSReceiver.class);
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
            MessageConsumer consumer = session.createConsumer(destination);
            LOG.info("Esperando por mensaje");
            //TextMessage message = (TextMessage) consumer.receive(2000);
            ObjectMessage message = (ObjectMessage) consumer.receive();
            Profesor profesor = (Profesor) message.getObject();

            LOG.info(profesor);


            consumer.close();
            session.close();
            connection.close();

            session.close();
        } catch (NamingException|JMSException e) {
            LOG.error("error" , e);
        }
    }




}
