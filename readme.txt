This sample shows creating a Stateless Session Bean and deploy in JBoss Application Server (AS) 5.1.0

  JDK 6 (Java SE 6)
  EJB 3.0 (stateless session bean)
  Eclipse Indigo
  JBoss Application Server (AS) 5.1.0
  EJB 3.0 Java Persistence API (JPA)
  
  mysql-connector-java-5.1.39-bin.jar ->  C:\jboss-5.1.0.GA\server\default\lib
  mysql-ds.xml and persistance.xml must be: META-INFO/
  
  <connection-url>jdbc:mysql://localhost:3306/test</connection-url> 
  <driver-class>com.mysql.jdbc.Driver</driver-class> 
  <user-name>root</user-name> 
  <password></password> 
		  
1. JBOSS  (IP is 192.168.12.2)
   Deploy jar to JBoss8
   HelloWorldSessionBean-0.0.1-SNAPSHOT.jar
   Create Queue:
   JBoss Installation Folder/server/default/deploy/jbossmq-destinations-service.xml:
	 <mbean code="org.jboss.mq.server.jmx.Queue"  
	   name="jboss.mq.destination:service=Queue,name=BookQueue">  
	   <depends optional-attribute-name="DestinationManager">
	      jboss.mq:service=DestinationManager
	   </depends>  
	 </mbean>  
 
2. Create App User in JBoss
   User: app1
   Password: pass123!

3. HelloWordSessionClient makes a remote lookup for this EJB

4. In JBOSS, for remote access to EJBs, use the ejb: namespace with the following syntax:

   For stateless beans:
      ejb:<app-name>/<module-name>/<distinct-name>/<bean-name>!<fully-qualified-classname-of-the-remote-interface>

   For stateful beans:
      ejb:<app-name(Ear)>/<module-name(Jar)>/<distinct-name>/<bean-name(Concert)>!<fully-qualified-classname-of-the-remote-interface(fullpath of remote interface)>?stateful

5. Home interface and remote interface:
   5.1. Home interface:
        (1). Client is in same WebApp(Ear or War ) in a JVM
        (2). Direct method call(Not RMI)
        (3). Parameter pass by reference

   5.2. Remote interface:
        (1). Client is in different JVM or different webapp (even in same JBM, different web app can'e make local call)
        (2). Remote component interface will be handled via remote method invocation (RMI)
        (3). Parameter pass by value   


   
