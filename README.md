# EsameProgrammazione
Esame programmazione ad oggetti.

Per il funzionamento del progetto deve essere importata la libreria json-simple.jar

Comandi utilizzabili:

/metadati : restituzione metadati

/dati : restituzione dati

/stats/"scelta" : Restituzione statistiche basilari

/dati/"filtro"/maggiore(o minore)/"valore" : restituzione di un JSONArray filtrato. I filtri disponibili sono Infortuni ed InfortuniMortali

/dati/"valore1"$and"valore2" : Restituzione JSONArray filtrato secondo la logica AND. Il primo operatore è l'anno, il secondo è da selezionarsi tra Infortuni ed InfortuniMortali

/dati/$not"valore" : restituzione JSONArray filtrato, ignorando l'anno selezionato nel "valore".

N.B.: i campi con il doppio apice sono da intendersi come a discrezione del client
