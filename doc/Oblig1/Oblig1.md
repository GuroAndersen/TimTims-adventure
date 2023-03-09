# Oblig 1

## A0 - rollefordeling


## Rollefordeling

| Navn | Rolle | Erfaring |
|:-----|:------|:---------|
| Sandra | Prosjektleder | Datatek år 2 <br> Erfaring fra INF101 og 102 |
| Guro | Front-end ansvarlig | Datatek år 2 <br> Erfaring fra INF101 og 102 <br> Lærerutdanning|
| Hilde | Git Master og back-end ansvarlig | Datatek år 2 <br> Erfaring fra INF101 og 102 <br> Nanoteknologiutdanning|
| Cecilie | Designansvarlig | Datatek år 2 <br> Erfaring fra INF101 og 102 <br> Frisørutdanning|
| Mattias | Rapportansvarlig | Datatek år 2 <br> Erfaring fra INF101 og 102 <br> Økonoiutdanning| 

## Rollebeskrivelse
**Teamleder:**

En teamleder spiller en viktig rolle i å sørge for effektiv gjennomføring av prosjektet. De har ansvaret for å organisere og distribuere oppgaver til passende medlemmer av gruppen, samt å overvåke at oppgavene blir ferdigstilt innenfor frister. Teamlederen sørger også for god oversikt og kontinuitet i prosjektet. I situasjoner hvor gruppen er uenig om hvordan de skal fortsette, har teamlederen den endelige beslutningsmyndigheten. Deres rolle er å medvirke til å løse konflikter og sørge for at gruppen arbeider sammen for å oppnå felles mål. Teamlederen spiller en avgjørende rolle i å sørge for at prosjektet blir gjennomført med suksess og innen tidsfrister.

Sandra har erfaring fra ulike jobber hvor hun har hatt lederansvar når sjefen ikke er til stede, og har derfor tidligere hatt ansvar og vist lederegenskaper. Dette gjorde hun til et naturlig valg for oss at hun ble prosjektleder, med de ferdighetene hun har fra arbeidslivet. 


**Front-end:**

Head of front-end er ansvarlig for å utvikle den delen av spillen som brukeren interagerer med. Deres oppgaver inkluderer å utvikle og implementere design, interaksjon, navigasjon og brukervennlighet. 

Guro har erfaring fra deltidsjobb der hun jobber med å designe og utvikle deler av nettsiden til en bedrift i react og typescript. Hun har også erfaring med javascript, html og css fra kurs. Dette medførte at hun fikk ansvar for front-end delen av prosjektet.

**Gitmaster:** 

En Gitmaster er en leder for en gruppes GitLab prosjekt. De har ansvar for å administrere prosjektet, fastsette regler for å sende inn kode og lære opp medlemmene i bruken av GitLab. De løser også tekniske problemer som måtte oppstå. Gitmaster-stillingen er viktig for å sikre en problemfri samarbeidsprosess og unngå merge-konflikter.

Hilde har tidligere erfaring med GitLab gjennom å være gruppeleder i inf101 og inf113, i tillegg til at hun både gamer og koder mye på fritiden. Når hun selv hadde inf101 brukte hun seminaroppgaven til å lage sitt eget spill fra bunnen av, og har derfor mye erfaring allerede innen spillutvikling. 


**Designansvarlig:**

Designansvarlig har hovedansvaret for utseendet til spillet, inkludert banedesign, poengsystem og målet med spillet. De sørger for at spillet har et sammenhengende visuelt uttrykk og gir spilleren en engasjerende opplevelse. Designansvarlig spiller en viktig rolle i å sikre at spillet har et sterkt og attraktivt visuelt element.

Cecilie er utdannet frisør og har jobbet mange år med både form og farge, i tillegg til photoshoots for produktkataloger for distributører. Hun driver ellers med billedkunst på fritiden og håper med dette prosjektet å overføre disse kunnskapene til å skape et spill hvor brukeren får en spennende, uforutsigbar og visuell opplevelse.

**Rapportansvarlig:**

Rapportansvarlig har hovedansvaret for å utarbeide den skriftlige delen av prosjektet. Dette gjelder da både dokumentasjon av koden, samt vise til hvilke prosjektmetodikk som er bruk. I tillegg vil rapportansvarlig være en som sørger for at Project-Bord, MVP-krav og brukerhistorier til en hver tid er oppdatert.

Mattias har tidligere erfaring med agil arbeidsmetodikk gjennom jobb og studier. Han har brukt metoder som scrum og kanban tidligere, og er derfor satt i denne rollen.

**Testansvarlig:**

Vi har valgt at alle skal forbedre testskriving ferdighetene sine med at hvert medlem jobber kontinuerlig med å skrive tester til sine egne metoder, samt hjelpe hverandre. 




## A1 - generelt

### **Project Board**

Vi har nylig etablert et Project Board i Trello for å holde styr på vårt prosjekt. Trello er et mye brukt og gratis verktøy for Project Board. Verktøyet gir oss en god oversikt og en visuell representasjon av fremdriften i prosjektet.

I Project Bordet vil vi organisere brukerhistoriene våre under kategorien "Todo". Når vi begynner å arbeide med brukerhistoriene, vil de bli plassert under kategorien "In Progress". Når en brukerhistorie er fullført, vil den bli plassert under kategorien "Done". Dette vil gi oss en kontinuerlig oppdatering om fremdriften i prosjektet, samt sikre at vi holder styr på hvilke oppgaver som er fullført og hvilke som gjenstår. Trello vil være et nyttig verktøy for å organisere og følge med på fremdriften i prosjektet.

Link til Trello ligger i README.md

### **README**

Vi har utarbeidet en readme fil der det står beskrevet:
* Navnet på spillet
* Hva spillet handler om 
* Hvordan man kjører det 
* Kjente feil
* Credits

Se README.md for utfyllende informasjon. 

### **Fordeling av roller**

Vi har fordelt roller intern i gruppen basert på tidligere erfaring og interesser. 
Ser A for utfyllende informasjon. 

## A2 - konsept

### **Story**
I vårt spill tar vi deg inn i verden til Timtim. Timtim er en liten gutt som som sliter litt med å skjønne hvordan verden fungerer. Han har ikke helt forstått hva som er godt og ondt i verden, og trenger hjelp! 

Timtim trenger å skaffe informasjon for å bli mer opplyst. Informasjonen kan han bytte til seg med forskjellige personer. For at disse personene skal være villig til å gi fra seg informasjon, ønsker de å gjenstander i innbytte. Derfor trenger Timtim hjelp til å finne disse gjemstandene!

Men, Timtim må passe seg. For i hans jakt på å finne verdifull informasjon, truer det farer. Pass på!



### **Tekniske aspekter**
* 2dimensjonal verden:
    * Horisontal flate spilleren kan bevege seg på
    * Vinduet vil bevege seg automatisk til høyre etterhvert som spilleren beveger seg (Super Mario Bros inspirert)
        * Dvs at "verden" er en større enn skjermen og scroller vertikalt, men mulighet for å hoppe opp på ting
    * Spilleren kan gå langs bakken og hoppe
    * Verden er bygget opp av blikker med fast størrelse (felter i et 2D-rutenett)
* Fiender:
    * Fiendene i spillet kan enten stå i ro eller bevege seg
    * Fiende er skadelig ved berøring, dvs spilleren mister liv
    * Spilleren kan falle til døden
    * Dersom spilleren mister alle livene sine vil den dø, og må starte nivået på nytt
    * Fiender kan og skades, dersom spilleren finner våpen
    * Våpen kan brukes på fiender for å skade dem
* Målsetning:
    * Målet med spillet er at spilleren samler gjenstander for å så gi dem til en person
    * Dersom spilleren har samlet alle gjenstandene og gitt de til vedkommende vinner spilleren det nivået
    * Gjenstandene kan finnes forskjellige steder på banen, eksempelvis fra kister


## A3.1 - Prosess og metodikk

### **Prosjektmetodikk**
Prosjektmetodikkeen vi har valgt er en kombinasjon av en agil tilnærming og kanban.

Kanban:

Kanban er en velkjent metodikk som benytter et Kanban-board, for eksempel Trello, som en sentral del av prosjektstyringen.En av de viktigste grunnene til at vi har valgt Kanban er at det gir fleksibilitet. Oppgaver kan tas inn når det er behov for det, og dette passer godt sammen med brukerhistorier som vi har skrevet. Dette gjør at teamet kan bruke mer tid på selve arbeidet. En annen fordel med Kanban er at det hjelper teammedlemmene å fokusere på en oppgave om gangen, noe som kan være spesielt nyttig for medlemmer med mindre erfaring med store programmeringsprosjekter.

Agil:

En agil tilnærming handler om å jobbe smidig. Her ser vi for oss å sette opp flere sprinter vi jobber oss gjennom. En sprint vil typisk være en innlevering. I vær sprint planlegger vi å gå gjennom noen faste faser. 

1. Planlegge
2. Designe
3. Kode og teste
4. Diskutere og vurdere veien videre

I planleggingsfasen blir vi enig om hva vi skal gjøre og hvordan vi skal gjøre det. Dette innebærer å fordele oppgaver på tvers av teamet. Dette vil gjøres basert på kapasitet og kompetanse. 

I andre fase vil vi i designe produktet vi skal utforme. Her vil vi lage enkle sketsjer av hvordan produktet skal se ut og hvordan det skal fungere. 

Kode og test fasen går ut på å skrive den faktiske koden og teste hvorvidt den fungerer som ønsket. Her vil vi bruke teknikker som parprogrammering for å jobbe mest mulig effektivt. 

I siste fase vurderer vi både hvordan vi synes produktet har blitt, og hvordan vi har jobbet som gruppe. Gjør produktet det vi ønsker? Har vi jobbet bra sammen som gruppe? I tillegg ser vi på veien videre. Et viktig aspekt av den agile prosjektmetodikken er at vi her er villig til å ta nye veier, såkalt pivotering. Ser vi at det er noe vi tidligere har gjort som ikke fungerer, eller kommer på helt nye ideer vi mener er bedre, skal vi ikke nøle med å tørre å gå nye veier. 



### **Møter og kommunikasjon**
Et viktig punkt som ble diskutert i gruppen er hvor, når og hvor ofte vi skal møtes. Vi er blitt enig om å ha et fast møtepunkt, og heller sette opp andre møter etter bevhov. Vi har plan om å møtes hver torsdag i gruppetimen, og jobbe videre med prosjektet utover i dag. 

Utover dette ser vi det som hensiktsmessig at man heller møtes to og to og parprogrammerer. På denne måten for vi fordelt oppgaver utover i gruppen og kan jobbe mer effektig. 

Vi har og valgt å bruke Discord som kommunikasjonskanal. Denne plattformen muliggjør kontinuerlig kommunikasjon, i tillegg til tekniske aspekter som skjerm- og kodedeling. Samtlige i teamet er kjent med plattformen fra før, noe som gjør den som en lavterskel plattform å ta i bruk.

### **Arbeidsfordeling og oppfølgning**
Et sentralt ønske i gruppen er at alle i teamet skal bli inkludert i prosjektet og lære mest mulig. Derfor fokuserer vi på å jobbe mye sammen. Det arbeidet som blir gjort i individuelt, eller i par, vil bli delt med andre ved felles samling. Dette er et viktig aspekt da det sørger for at hele gruppen er oppdatert på prosjektet. 

### **Deling og oppbevaring av dokumenter, diagram og kodebase**
I all hovedsak kommer GitLab til å bli brukt for oppbevaring og deling av kode, dokumenter og diagrammer. Dette gjøres slik at vi sørger for at all data ligger på et og samme sted, og at det til enhver til er tilgjengelig for alle. Gitmaster har laget et system der vi lager ulike brancher basert på både hvem som jobber på hvilken del, og spesifikke deler av prosjektet. Årsaken til dette er for å gjøre det enkelt å jobbe på en feature vi ønsker å implementer, uten at det skaper konflikter. 


## A3.2 - forventet produkt

### **Overordnet mål**
Det overordnede målet er en enspiller plattformspill med hinder, ting man kan plukke opp for å få nye evner, og karakterer som hovedpersonen kan snakke med, få gjøremål og informasjon av.
Målet er at spillet skal ha 3 nivåer som hver har egne NPCs, og til sist et lite nivå som avslutter historien og spillet.


### **MVP krav**
1. Start/slutt skjerm
2. Vise spillebrettet
3. Vise spiller på spillebrettet
4. Flytte spilleren rundt på brettet
5. Spiller skal interagere med terrenget
6. Spiller kan hente ut gjenstander 
7. Fiender/allierte vises i spillet
8. Spiller kan miste liv/dø når den interagerer med terreng/fiender 

### **Brukerhistorier**

| Brukerhistorie | Akseptansekriterier | Arbeidsoppgaver | Krav |
|:--------------:|:-------------------:|:---------------:|:-----|
| Som spiller skal jeg se en meny når jeg starter spillet. Der skal jeg ha mulighet til å velge mellom å starte spille, eller se informasjon om spillet | Gitt at spillet startes skal: <br> -spilleren måte en meny med forskjellige valg <br>- Hvert valg skal ta spilleren til et nytt vindu | Metode som viser menyen når programet starter <br> Metode som kan kjøre andre klasser | 1 |
| Som spiller skal jeg kunne se et spillbrett når jeg starter spillet. | Gitt at spilleren starter et spill: <br> -Bakken, taket være tydelig markert <br> -Hindringer være tydelig adskilt fra bakgrunnen | Metode som viser spillbrettet når spiller starter spillet fra menyen | 2 |
| Som spiller skal jeg til enhver se spilleren og tydelig skille den fra andre objekter | Gitt at spillet spilles skal: <br> - spillfiguren til envher være synlig <br> -spillfiguren skille seg fra andre objekter | Lage en spillfigur som tydelig skiller seg fra bakgrunnen <br> Metode som viser spiller på spillbrettet | 3 |
| Som spiller skal jeg kunne flytte på spilleren | Gitt at spilleren trykker “W”: <br> -skal spilleren hoppe <br> Gitt at spilleren trykker "A" skal: <br> -skal spilleren bevege seg til venstre <br> Gitt at spilleren trykker "D" <br> -skal spilleren bevege seg til høyre | Metode i controller som registrerer tastetrykk <br> Metode som beveger spilleren basert på tastetrykk | 4 |
| Som spiller jeg kunne interagere med terenget | Gitt at spilleren går bort til et hinder skal: <br> - spillfiguren stoppe <br> Gitt at spilleren hopper på et objekt: <br> -skal spilleren kunne lande på et objekt | Metode som gjør gjør at spilleren stopper når den interagerer med terrenget | 5 |
| Som spiller skal jeg kunne hente gjenstander fra kister | Gitt at spillfiguren åpner en kiste: <br> -skal enten spilleren få en "power-up" <br> -eller motta informasjon som senere kan byttes | Metode som gir spilleren gjenstander når den åpner en kiste <br> Metode som gir spilleren våpen når den åpner en kiste | 6 |
| Som spiller skal jeg kunne se fiender og allierte | Gitt at spilleren er på et sted i spillbrettet der det er fiender eller alierte <br> -skal spilleren tydelig klare å skille fiender/alierte fra bakgrunnen <br> -skal spilleren vite forskjell på fiende og alliert | Metode som som lager fiender <br> Metode som lager allierte | 7 |
| Som spiller skal jeg se at jeg mister liv når jeg jeg interagerer med en fiende | Gitt at spilleren interagerer med en fiende <br> -skal spilleren tydelig se hvor mye liv den mister <br> -skal spilleren tydelig se hvor mye liv den har igjen | Metode som gjør at spilleren mister liv ved kontakt med fiender <br> Metode som gjør at spilleren dør når den er tom for liv | 8 |
| Som spiller skal jeg se at jeg mister liv dersom jeg faller ut av brettet | Gitt at spilleren faller en viss distanse <br> -skal spilleren tydelig se at den dør | Metode som gjør at spiller dør og spillet starter på nytt dersom spiller faller ut av brettet | 8|

## A4 - kode
I denne delen har vi på å utarbeide et minimumsprodukt. 

Dette er et testprodukt, og har ikke en direkte tilknytning til vår mvp. Likevel er den relevant, og kan knyttes til mvp krav 2, 3 og 4.

2. Vise spillebrettet
3. Vise spiller på spillebrettet
4. Flytte spilleren rundt på brettet

Årsaken til at vi har valgt å fokusere på disse kravene er at vi ser dem som mest aktuelle å utarbeide i starten av vår faktiske MVP. 
Koden er lastet opp på GitLab. Se README.md for instruksjon for hvordan å kjøre koden, samt link til GitLab

## A5 - oppsummering
Teamet er fornøyd med gruppedynamikk, prosjektmetodikk og produkt så langt. Som gruppe har vi vært flink å samarbeide, og alle har funnet sin plass i teamet. Arbeidsfordelingen har vært jevn, og alle føler at de har bidratt. Det er noe skjevfordeling i antall commits. Dette skyldes i stor grad parprogrammering, og utfordringer med Git. Produktet vi har utarbeidet så langt står til forventing, og anses som et godt utgangspunkt for videre mvp. I henhold til prosjektmetodikken føler vi så langt at dette har gått bra. Den agile tilnærmingen er uvant for noen på gruppen, men alle er positivt innstilt til å bruke den videre. Det er enighet i gruppen om at vi ikke skal være redd for å tenke nye tanker, gå nye veier, og tørre å forkaste tidligere ideer dersom vi ser nye ideer som bedre. 

Videre har vi bemerket oss punkter gruppen har forbedringspotensiale på. Vi har hatt noen utfordringer med Git, da særlig med å merge brancher. Gitmaster har vært en viktig nøkkelspiller for å få det til å fungere, og vi har i fellesskap laget en plan for hvordan vi skal løse dette fremover. I tillegg har gruppen en travel periode nå i overgang februar/mars, grunnet konte-eksamener og obligatoriske innleveringer, men vi vil derfor kompenesere med å bruke ekstra mye tid på prosjektet når dette roer seg. Gruppen som helhet har heller ikke integrert Trello i sin arbeidshverdag. Samtlige ser verdien av å bruke dette som et Kanban-board, og det vil derfor fremover være økt fokus på å bruke dette kontinuerlig. 





