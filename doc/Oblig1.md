# Oblig 1

## A1 - generelt

### **Project Board (lage eksempel)**

Vi har nylig etablert et Project Board i Trello for å holde styr på vårt prosjekt. Trello er et mye brukt og gratis verktøy for Project Board. Verktøyet gir oss en god oversikt og en visuell representasjon av fremdriften i prosjektet.

I Project Bordet vil vi organisere brukerhistoriene våre under kategorien "Todo". Når vi begynner å arbeide med brukerhistoriene, vil de bli plassert under kategorien "In Progress". Når en brukerhistorie er fullført, vil den bli plassert under kategorien "Done". Dette vil gi oss en kontinuerlig oppdatering om fremdriften i prosjektet, samt sikre at vi holder styr på hvilke oppgaver som er fullført og hvilke som gjenstår. Trello vil være et nyttig verktøy for å organisere og følge med på fremdriften i prosjektet.

### **README (fix!)**

Vi har utarbeidet en readme fil der det står beskrevet:
* Navnet på spillet
* Hva spillet handler om 
* Hvordan man kjører det 
* Kjente feil
* Credits

Se README.md for utfyllende informasjon. 

### **Fordeling av roller**

Vi har fordelt roller intern i gruppen basert på tidligere erfaring og interesser. 
Ser Oblig0.md for utfyllende informasjon. 

## A2 - konsept

### **Story**
I vårt spill tar vi deg inn i verden til Timtim. Timtim er en liten gutt som som sliter litt med å skjønne hvordan verden fungerer. Han har ikke helt forstått hva som er godt og ondt i verden, og trenger hjelp! 

Timtim trenger å skaffe informasjon for å bli mer opplyst. Informasjonen kan han bytte til seg med forskjellige personer. For at disse personene skal være villig til å gi fra seg informasjon, ønsker de å ting i innbytte. Derfor trenger Timtim hjelp til å finne disse tingene!

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
    * Spilleren kan og falle til døden
    * Dersom spilleren mister alle livene sine vil den dø, og må starte nivået på nytt
    * Fiender kan og skades, dersom spilleren finner våpen
    * Våpen kan brukes på fiender for å skade dem
* Målsetning:
    * Målet med spillet er at spilleren samler "items" for å så gi dem til en person
    * Dersom spilleren har samlet alle "itemsene" og gitt de til vedkommende vinner spilleren det nivået
    * "Items" kan finnes forskjellige steder på banen, eksempelvis fra kister


## A3.1 - Prosess og metodikk

### **Prosjektmetodikk**
Prosjektmetodikkeen vi har valgt er en kombinasjon av en agil/smidig tilnærming og kanban.

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

Vi har og valgt å bruke Discord som komminikasjonskanal. Denne plattformen muliggjør kontinuerlig kommunikasjon, i tillegg til tekniske aspekter som skjerm- og kodedeling. Samtlige i teamet er kjent med plattformen fra før, noe som gjør den som en lavterskel plattform å ta i bruk.

### **Arbeidsfordeling og oppfølgning**
Et sentralt ønske i gruppen er at alle i teamet skal bli inkludert i prosjektet og lære mest mulig. Derfor fokuserer vi på å jobbe mye sammen. Det arbeidet som blir gjort i individuelt, eller i par, vil bli delt med andre ved felles samling. Dette er et viktig aspekt da det sørger for at hele gruppen er oppdatert på prosjektet. 

### **Deling og oppbevaring av dokumenter, diagram og kodebase**
I all hovedsak kommer GitLab til å bli brukt for oppbevaring og deling av kode, dokumenter og diagrammer. Dette gjøres slik at vi sørger for at all data ligger på et og samme sted, og at det til enhver til er tilgjengelig for alle. Gitmaster har laget et system der vi lager ulike brancher basert på både hvem som jobber på hvilken del, og spesifikke deler av prosjektet.Årsaken til dette er for å gjøre det enkelt å jobbe på en feature vi ønsker å implementer, uten at det skaper konflikter. 


## A3.2 - forventet produkt

### **Overordnet mål**
Det overordnede målet er et enspiller plattformspill med hinder, ting man kan plukke opp for å få nye evner, og karakterer som (?) er spillere som man kan snakke med og få gjøremål og informasjon av.
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
| Som spiller skal jeg se en meny når jeg starter spillet. Der skal jeg ha mulighet til å velge mellom å starte spille, eller se informasjon om spillet | Gitt at spillet startes skal: <br> -spilleren måte en meny med forskjellige valg <br>- Hvert valg skal ta spilleren til et nytt vindu | Metode som --- | 1 |
| Som spiller skal jeg kunne se et spillbrett når jeg starter spillet. | Gitt at spilleren starter et spill: <br> -Bakken, taket være tydelig markert <br> -Hindringer være tydelig adskilt fra bakgrunnen | Metode som --- | 2 |
| som spiller skal jeg til enhver se spilleren og tydelig skille den fra andre objekter | Gitt at spillet spilles skal: <br> - spillfiguren til envher være synlig <br> -spillfiguren skille seg fra andre objekter | Metode som --- | 3 |
| Som spiller skal jeg kunne flytte på spilleren | Gitt at spilleren trykker “pil opp”: <br> -skal spilleren hoppe <br> Gitt at spilleren trykker "pil venstre skal: <br> -skal spilleren bevege seg til venstre <br> Gitt at spilleren trykker "pil høyre" <br> -skal spilleren bevege seg til høyre | Metode -- | 4 |
| Som spiller jeg kunne interagere med terneget | Gitt at spilleren går bort til et hinder skal: <br> - spillfiguren stoppe <br> Gitt at spilleren hopper på et objekt: <br> -skal spilleren kunne lande på et objekt | Metode som -- | 5 |
| Som spiller skal jeg kunne hente gjenstander fra kister | Gitt at spillfiguren åpner en kiste: <br> -skal enten spilleren få en "power-up" <br> -eller motta informasjon som senere kan byttes | Metode som -- | 6 |
| SOm spiller skal jeg kunne se fiender og allierte | Gitt at spilleren er på et sted i spillbrettet der det er fiender eller alierte <br> -skal spilleren tydelig klare å skille fiender/alierte fra bakgrunnen <br> -skal spilleren vite forskjell på fiende og alliert | Metode som -- | 7 |
| Som spiller skal jeg se at jeg mister liv når jeg jeg interagerer med en fiende | Gitt at spilleren interagerer med en fiende <br> -skal spilleren tydelig se hvor mye liv den mister <br> -skal spilleren tydelig se hvor mye liv den har igjen | Metode som -- | 8 |
| Som spiller skal jeg se at jeg mister liv dersom jeg faller for høyt | Gitt at spilleren faller en viss distanse <br> -skal spilleren tydelig se at den dør | Metode som --- | 8|

## A4 - kode
I denne delen har vi på å utarbeide et minimumsprodukt. Det inneholder ......

Dette er et testprodukt, og har ikke en direkte tilknytning til vår mvp. Likevel er den relevant, og kan knyttes til mvp krav x, y og z

## A5 - oppsummering





