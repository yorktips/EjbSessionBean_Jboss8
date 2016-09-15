This sample shows creating a Stateless Session Bean and deploy in Jboss8

1. JBOSS wildfly-8 (IP is 192.168.12.2)
   Deploy jar to JBoss8
   HelloWorldSessionBean-0.0.1-SNAPSHOT.jar
  
2. JBOSS wildfly-8 (IP is 192.168.12.2)
   Deploy jar to JBoss8
   HelloWorldSessionBean-0.0.1-SNAPSHOT.jar
   
3. Create App User in JBoss
   User: app1
   Password: pass123!

4. HelloWordSessionClient makes a remote lookup for this EJB

5. In Wildfly, for remote access to EJBs, use the ejb: namespace with the following syntax:

   For stateless beans:
      ejb:<app-name>/<module-name>/<distinct-name>/<bean-name>!<fully-qualified-classname-of-the-remote-interface>

   For stateful beans:
      ejb:<app-name(Ear)>/<module-name(Jar)>/<distinct-name>/<bean-name(Concert)>!<fully-qualified-classname-of-the-remote-interface(fullpath of remote interface)>?stateful

6. Home interface and remote interface:
   6.1. Home interface:
        (1). Client is in same JVM
        (2). Direct method call(Not RMI)
        (3). Parameter pass by reference

   6.2. Remote interface:
        (1). Client is in different JVM
        (2). Remote component interface will be handled via remote method invocation (RMI)
        (3). Parameter pass by value   


   