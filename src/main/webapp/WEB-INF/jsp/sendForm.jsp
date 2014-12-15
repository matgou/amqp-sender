<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Sender Application</title>
</head>
<body>
   <h2>Introduction</h2>
   Depuis cette page vous pouvez envoeyr des messages via le protocole AMQP.
   
   <h2>Envoi de message</h2>
   <form action="send" method="POST">
   <label for="nb_message">Nombre de message &agrave; envoyer</label>
   <input type="text" id="nb_message" name="nb_message" />
   <br/>
   <label for="txt_message">Contenu message</label>
   <input type="text" id="txt_message" name="txt_message" />
   <br/>
   <input type="submit" value="Submit">
   </form>
</body>
</html>