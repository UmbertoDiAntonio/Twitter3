# Twitter3
Twitter3 è un Applicazione Java per controllare il contenuto di messaggi scritti su twitter e eseguire statistiche su di essi

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
### Classi
![UML](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Final_Twitter_Project%20OOP/src/main/resources/Classi.PNG)
### Casi D'Uso
![UML](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Twitter3/src/main/resources/UMLCasiD'Uso.PNG)
### Sequenze
![UML](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Twitter3/src/main/resources/UMLSequence.png)
### Package Structure
![UML](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Twitter3/src/main/resources/Package%20Structure.png)
### Type Heracly
![UML](https://github.com/UmbertoDiAntonio/Twitter3/blob/master/Twitter3/src/main/resources/Type%20Hierarchy.png)


## Contribuire
Le richieste pull sono benvenute. Per modifiche importanti, ti preghiamo di aprire prima un Issues per discutere di cosa vorresti cambiare.

