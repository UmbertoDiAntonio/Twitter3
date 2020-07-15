# Twitter3
Twitter3 è un Applicazione Java per controllare il contenuto di messaggi scritti su twitter e eseguire statistiche su di essi
## Formato Dei Dati Restituiti
In seguito ad una richiesta al servizio i risultati vengono rappresentati mediante un JSON come un array di oggetti che rappresentano i dati appartenenti al dataset.<br>
Nello specifico il formato di ogni singolo elemento è il seguente:</p>
<pre><code>{
    "message": "RT @INGVterremoti: [STIMA #PROVVISORIA] #terremoto Mag tra 3.4 e 3.9 ore 14:06 IT del 13-07-2020, prov/zona Belluno #INGV_24825601 https://…",
    "screenName": "asiram1308",
    "createdAt": "Mon Jul 13 15:51:30 +0000 2020",
    "month": "Jul",
    "day": "13",
    "hour": "15:51:30",
    "year": "2020"
  }
</code></pre>
<p>In particolare:</p>
<ul>
<li><strong>message</strong> rappresenta il testo del messaggio selezionato</li>
<li><strong>screenName</strong> rappresenta l'username dell'autore</li>
<li><strong>createdAt</strong> fornisce una data univoca di generazione del messaggio</li>
<li><strong>month</strong> rappresenta il mese in cui è stato generato il messaggio</li>
<li><strong>day</strong> rappresenta il giorno in cui è stato generato il messaggio</li>
<li><strong>hour</strong> rappresenta l'ora in cui è stato generato il messaggio</li>
<li><strong>year</strong> rappresenta l'anno in cui è stato generato il messaggio</li>
</ul>

## Rotte
  <blockquote>
<p><strong>GET</strong> /</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista delle rotte<br>
  <blockquote>
<p><strong>POST</strong> /post</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post<br>
    <blockquote>
<p><strong>GET</strong> /setblacklist/{list}</p>
  </blockquote>
  Rotta con cui è possibile impostare una lista di parole da poter richiamare in seguito<br>
    <blockquote>
<p><strong>GET</strong> /post/author</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di tutti gli autori<br>
    <blockquote>
<p><strong>GET</strong> /post/author/{author}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di un autore<br>
    <blockquote>
<p><strong>GET</strong> /post/author/{author}/contains/{message}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di un autore che contengono una o più parole inserite<br>
    <blockquote>
<p><strong>GET</strong> /post/author/contains/{message}</p>
  </blockquote>
Rotta con cui è possibile accedere alla lista dei post di ogni autore che contengono una o più parole inserite<br>
    <blockquote>
<p><strong>GET</strong> /post/author/{author}/contains/{message}/year/{year}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di un autore che contengono una o più parole inserite scritti nell'anno inserito<br>
      <blockquote>
<p><strong>GET</strong> /post/author/contains/{message}/year/{year}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di ogni autore che contengono una o più parole inserite scritti nell'anno inserito<br>
      <blockquote>
<p><strong>GET</strong> /post/author/contains/year/{year}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di ogni autore scritti nell'anno inserito<br>
      <blockquote>
<p><strong>GET</strong> /post/author/{author}/contains/{message}/year/{year}/month/{month}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di un autore che contengono una o più parole inserite scritti nell'anno e mese inseriti<br>
        <blockquote>
<p><strong>GET</strong> /post/author/contains/{message}/year/{year}/month/{month}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di ogni autore che contengono una o più parole inserite scritti nell'anno e mese inseriti<br>
        <blockquote>
<p><strong>GET</strong> /post/author/contains/year/{year}/month/{month}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di ogni autore scritti nell'anno e mese inseriti<br>
        <blockquote>
<p><strong>GET</strong> /post/author/{author}/contains/{message}/year/{year}/month/{month}/day/{day}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di un autore che contengono una o più parole inserite scritti nell'anno, mese e giorno inseriti<br>
          <blockquote>
<p><strong>GET</strong> /post/author/contains/{message}/year/{year}/month/{month}/day/{day}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di ogni autore che contengono una o più parole inserite scritti nell'anno, mese e giorno inseriti<br>
          <blockquote>
<p><strong>GET</strong> /post/author/contains/year/{year}/month/{month}/day/{day}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di ogni autore scritti nell'anno, mese e giorno inseriti<br>
          <blockquote>
<p><strong>GET</strong> /post/author/{author}/contains/{message}/year/{year}/month/{month}/day/{day}/hour/{hour}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di un autore che contengono una o più parole inserite scritti nell'anno, mese, giorno e ora inseriti<br>
            <blockquote>
<p><strong>GET</strong> /post/author/contains/{message}/year/{year}/month/{month}/day/{day}/hour/{hour}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di ogni autore che contengono una o più parole inserite scritti nell'anno, mese, giorno e ora inseriti<br>
            <blockquote>
<p><strong>GET</strong> /post/author/contains/year/{year}/month/{month}/day/{day}/hour/{hour}</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post di ogni autore scritti nell'anno, mese, giorno e ora inseriti<br>
              <blockquote>
<p><strong>GET</strong> /post/author/contains/retweet</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post retweet<br>
              <blockquote>
<p><strong>GET</strong> /post/author/contains/tag</p>
  </blockquote>
  Rotta con cui è possibile accedere alla lista dei post che contengono tag<br>
  
  </div>
  </div>
  
## Utilizzo <br>

![GUI](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Final_Twitter_Project%20OOP/src/main/resources/GUI.PNG)

```
Avvia il file jar tramite cmd, imposta un numero di messaggi (massimo 100) e una prima parola chiave da cercare, clicca sul pulsante
di Avviamento, avverà ora il caricamento di SpringBoot, potrai effettuare delle chiamate alle rotte di esempio presenti 
nell'interfaccia o aprire questa pagina, per chiamate più specifiche avviare postman o un browser e digitare la chiamata che si desidera

```
## UML
### Class Diagram
![UML](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Final_Twitter_Project%20OOP/src/main/resources/Classi.PNG)
### Package Diagram
![UML](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Final_Twitter_Project%20OOP/src/main/resources/Package.png)
### Use Case Diagram
![UML](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Final_Twitter_Project%20OOP/src/main/resources/UseCase.png)
### Activity Diagram
![UML](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Final_Twitter_Project%20OOP/src/main/resources/Activity.png)
### Sequence Diagram
![UML](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Final_Twitter_Project%20OOP/src/main/resources/SequenceDiagram.png)




## Contribuire
Le richieste pull sono benvenute. Per modifiche importanti, ti preghiamo di aprire prima un Issues per discutere di cosa vorresti cambiare.

