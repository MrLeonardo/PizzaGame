# PizzaGame

Al centro di una stanza è presente un tavolo sopra il quale sono posizionate n di pizze impilate una sopra l'altra. <br />
Attenzione, l'ultima pizza di questa pila è avvelenata!!! <br />
Il primo giocatore che mangia la pizza avvelenata perde.

### Regole del gioco

- I giocatori in gioco devono essere 2
- Il numero di pizze viene determinato randomicamente all'inizio del gioco e deve essere sempre maggiore di 10
- Ogni giocatore, durante il proprio turno, deve mangiare 1, 2 o 3 pizze
- Ogni giocatore non puó saltare il proprio turno
- Ogni giocatore non puó ripetere la scelta fatta in precedenza dall'avversario (per esempio: se il giocatore di turno decide di mangiare 1 pizza, allora l'altro giocatore è obbligato a mangiare 2 oppure 3 pizze)
- Se un giocatore durante il proprio turno non ha mosse valide (per esempio: rimane ancora 1 pizza sul tavolo e il giocatore precedente ha mangiato 1 pizza) allora viene obbligato a saltare il proprio turno. A questo punto l'altro giocatore sarà obbligato a mangiare la pizza avvelenata e, di conseguenza, a perdere. Questo è l'unico caso nel quale è consentito il salto del turno

### Esempio

- 2 giocatori (A e B)
- sul tavolo sono presenti 12 pizze
- inizia il giocatore A
- il giocatore A decide di mangiare 1 pizza (rimangono 11 pizze sul tavolo)
- il giocatore B decide di mangiare 3 pizze (rimangono 8 pizze sul tavolo)
- il giocatore A decide di mangiare 2 pizze (rimangono 6 pizze sul tavolo)
- il giocatore B decide di mangiare 1 pizza (rimangono 5 pizze sul tavolo)
- il giocatore A decide di mangiare 3 pizze (rimangono 2 pizze sul tavolo)
- il giocatore B ha perso. Se mangia 2 pizze perde. Se decide di mangiare 1 pizza, allora il giocatore A è costretto a saltare il turno in quanto non puó applicare le proprie mosse (ovvero non puó mangiare 2 oppure 3 pizze) e costringe il giocatore B a mangiare l'ultima pizza avvelenata

### Istruzioni per il candidato

- il candidato puó decidere autonomamente se realizzare un programma standalone oppure una piccola applicazione web 
- qualora il candidato decida di realizzare un programma standalone, è preferibile l'utilizzo di un linguaggio di programmazione ad oggetti (C#, Java)
- qualora il candidato decida di realizzare un'applicazione web, è preferibile l'adozione di Html, Css e Javascript
- è necessario creare un nuovo branch dal master ed effettuare il push delle modifiche sul repository corrente, comprensive di sorgenti e di istruzioni per eseguire il programma realizzato 
