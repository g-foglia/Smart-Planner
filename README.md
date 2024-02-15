# Smart Planner
<p align=center>
<img src="https://github.com/g-foglia/Smart-Planner/assets/145924139/640ede92-45ee-4541-9864-3a6fa1fb699f" width=250>
</p>

## Team
I membri del team sono: 
- [Silvana Cafaro](https://github.com/zzzzilv)
- [Isabella Maria Sessa](https://github.com/isaboutoftown)
- [Gennaro Foglia](https://github.com/g-foglia)
## Overview
Smart Planner è un progetto che prevede la realizzazione di un'agenda digitale in grado di aiutare le persone ad organizzare le loro attività in modo facile e veloce. 
Progetto realizzato per il corso di Ingegneria del Software presso la facoltà di informatica dell'università degli studi di Salerno, a. a. 2023/2024.

## Struttura dei file
La cartella che ci interessa è quella "src". Al suo interno sono presenti le classi Java e i file .fxml che compongono l'applicazione. La struttura del progetto è la seguente:
-**"src/main/java/org/gennisilv/smartplanner/data"** contiene le classi che si interfacciano con il database (classi DAO) e quelle che modellano le entità dell'applicazione;
-**"src/main/java/org/gennisilv/smartplanner/logic"** contiene le classi che fanno da tramite tra le classi DAO e le altre classi dell'applicazione, andando a realizzare le operaizoni che coinvolgono il database;
-**"src/main/java/org/gennisilv/smartplanner/test"** contiene le classi di test che sono state implementate;
-**"src/main/java/org/gennisilv/smartplanner/utils"** contiene classi che compiono operazioni utili al corretto funzionamento dell'applicazione, richiamabili dalle altre;
-**"src/main/java/org/gennisilv/smartplanner"** contiene, oltre alle directory già citate, i controller dell'applicazione;
-**"src/main/resources/images"** contiene gli assets dell'applicazione;
-**"src/main/resources/org/gennisilv/smartplanner"** contiene i file .fxml che formano le interfacce grafiche dell'applicazione.

Infine nella directory **"Documents"** è presente la documentazione integrale del progetto, insieme ad un manuale d'uso per l'app. 
## Come replicare il progetto
Per replicare il progetto è necessario scaricarlo da GitHub e aprirlo con un IDE che supporti JavaFX e lo JDK 17 o successivi. Inoltre sarà necessario anche Oracle MySQL per la gesitone del database.
All'interno del branch "sql" sono presenti due file contenenti le istruzioni per generare il databse e popolarlo con dei valori iniziali. 
Nel file "src/main/java/org/gennisilv/smartplanner/data/ConPool.java" i campi password e user, nonché l'url per il database, vanno modificati con dei valori personali.

Fatto ciò per mandare in esecuzione l'applicazione basterà avviare il metodo main presente nel file "src/main/java/org/gennisilv/smartplanner/SmartPlannerApplication.java".
