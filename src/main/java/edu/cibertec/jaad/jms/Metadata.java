package edu.cibertec.jaad.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.ConnectionMetaData;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by Java-VS on 21/05/2016.
 */
public class Metadata {

    private static final Logger LOG = LoggerFactory.getLogger(Metadata.class);

    public static void main(String[] args) {


        //verificando la conexion
        try {
            Context ctx = new InitialContext();
            ConnectionFactory cnFactory = (ConnectionFactory) ctx.lookup("jms/QUEUECF");
            Connection connection = cnFactory.createConnection();
            ConnectionMetaData metaData = connection.getMetaData();

            LOG.info("JMS Version: " + metaData.getJMSMajorVersion() +"."+ metaData.getJMSMinorVersion());
            LOG.info("JMS Provider: " + metaData.getJMSProviderName());
            LOG.info("JMS Provider Version: " + metaData.getProviderMajorVersion()+"."
                    +metaData.getProviderMinorVersion());
            connection.close();

            //FIXME Retirame por favor
            System.exit(0); // el system exit es para terminar la emulacion del servidor

        } catch (Exception e) {
            LOG.error("Error ", e);
        }
    }


}
