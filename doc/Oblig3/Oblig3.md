# **Oblig 3**

## **Møtereferat**

**Dato: Torsdag 16.03.2023** <br>
**Sted: Vilvite** <br>
**Deltagere: Sandra, Hilde, Guro, Mattias** <br>
**Referent: Mattias** <br>

*Oppsummering:* <br>
Grunnet obligatoriske oppgaver i andre fag (blant annet INF222), ble møte i dag i det korteste laget. Derfor vil vi ta et ekstra møte førstkommende mandag. Det ble snakket litt om spritebatch og tegning av hovedkarakter.

*Diskusjoner:* <br>
Det ble diskutert hvordan vi løser friends og enemies i Tiled. Her konkluderte vi med å lage et eget objektlag for friends og et eget objektlagt for enemies. 

*Neste møte* <br>
Mandag 20.03.2022 <br>

*Oppgaver til neste gang:* <br>
Lage objektlag for friends og enemies i Tiled. 

___

**Dato: Mandag 20.03.2023** <br>
**Sted: Vilvite** <br>
**Deltagere: Sandra, Hilde, Guro, Cecilie, Mattias** <br>
**Referent: Mattias** <br>

*Oppsummering:* <br>
Vi startet møtet med å se litt på hvordan vi ligger ann og hva vi har igjen. Dette gjelder både i henhold til oblig 3, og til det endelige resultatet. Vi hadde som utgangspunkt at vi skulle klare å lage 3 level + et "boss" level. Vi ser dog per nå at dette kan være litt overambisiøst, og at vi heller skal sette "boss" level som et stretch goal. Dette diskuteres nøyere i avsnitet **Stretch goal** under **Krav og spesifikasjoner**. Videre har vi og i fellesskap sørget for at det ligger inne riktige lag i kartet.

*Diskusjoner:* <br>
Under møte ble det diskutert hvordan vi skal løse kollisjon og inventory. Vi kom frem til at vi skal ha en egen klasse som håndterer kollisjon og inventory. Dette er for å unngå at vi skal ha for mye kode i klassene til hovedkarakter og fiender.

*Neste møte* <br>
Torsdag 23.03.2023 <br>

*Oppgaver til neste gang:* <br>
Begynne welcome screen og pause screen.

___

**Dato: Torsdag 23.03.2023** <br>
**Sted: Vilvite** <br>
**Deltagere: Hilde, Guro, Cecilie, Mattias** <br>
**Referent: Mattias** <br>

*Oppsummering:* <br>
Møte startet med å oppsumere hva de enkelte de har gjort siden sist. Her ble det blant annet presentert hvordan vi har løst kollisjon med objekter. Eksemepelvis når spillkarakteren kolliderer med døren som skal ta spilleren til neste level. I tilegg har vi i stor grad diskutert hvordan vi videre skal utarbeide welcome screen og pause screen.

*Diskusjoner:* <br>
Som beskrevet over har vi i stor grad jobbet med welcome screen og pause screen. Her har vi møtt på noen problemer. Planen var i utgangspunktet å ha ulike skjermer/klasser for pause og welcome. Dette har dog bydd på problemer dypere ned i biblioteket. Derfor gitt mye av dette møte til å diskutere hvordan vi skal løse dette. Løsningen vi ser som mest hensiktsmessig er å samle dette i gameScreen som har forskjellig states.

*Neste møte* <br>
30.03.2023 <br>

*Oppgaver til neste gang:* <br>
Til neste gang vil hovedfokuset være videre arbeidet med welcome screen og pause screen. 

___

**Dato: Torsdag 30.03.2023** <br>
**Sted: Vilvite** <br>
**Deltagere: Sandra, Hilde, Cecilie, Mattias** <br>
**Referent: Mattias** <br>

*Oppsummering:* <br>
Siden forrige møte har hvert medlem på teamet skrevet en del kode individuelt. Derfor brukte vi en del tid i starten på å gå gjennom hver enkelt sin kode, slik at alle på teamet er oppdatert. Videre har vi diskutert "PowerUps", som beskrevet under. 

*Diskusjoner:* <br>
Under møte ble det diskutert vi skal ta i bruk "PowerUps" for å oppgradere spilleren. Vi har sett at dette er et krav at koden inneholder. Vår tanker er det skal ligge noen objekter i kartet. Når spillkarakteren kolliderer med disse, vil han kunne løpe fortere i en gitt tidsperiode. 

*Neste møte* <br>
13.04.2023 <br>

*Oppgaver til neste gang:* <br>
Neste møte blir ikke før om 2 uker, siden det er påskeferie. Likevel vil vi til neste gang fokusere på hvordan man skal hente informasjon fra kartene til menyen. Det vil si at menyen skal vise de forskjellige levelene. Dersom man ikke har spillt før, vil det kun være mulig å spille det første level. Dersom man har fullført det første levelet, skal det være mulig å starte level 2 osv. I tillegg vil vi fokusere på å få inn en friend som står og er animert i kartet.
___

**Dato: Torsdag 13.04.2023** <br>
**Sted: Vilvite** <br>
**Deltagere: Sandra, Hilde, Guro, Cecilie, Mattias** <br>
**Referent: Mattias** <br>

*Oppsummering:* <br>
Det viktigste vi har gjort i dag er klargjøre prosjekter for innlevering av Oblig 3. Derfor startet vi med å se på hver enkelt sin kode, og se om det var noe som måtte endres. Videre har alle pushet koden, og merget den til main slik at det blir et samlet prosjekt. 

*Diskusjoner:* <br>
I hovedsak har diskusjonene i dag vært hva vi skal fokusere på til neste oblig. Vi har blitt enig om at vi skal prøve i implementere noen nye features, samt fikse eksisterende bugs. For grundigere beskrivelse, se **Prioritering av oppgaver fremover**

*Neste møte* <br>
20.04.2023 <br>

*Oppgaver til neste gang:* <br>
Til neste møte skal vi ha laget en plan for sise innlevering. Dette vil si hvilke oppgaver vi skal fokusere på, og hvordan vi skal fordele oppgavene innad i gruppen.

___
## **Prosjektrapport**

### **Roller**
Under denne obligene har rollene vært mer flytende enn tidligere. I løpet av første uke av obligen ble mye av det grafiske noen lunde ferdigstillt. Det har ført til at flere har jobbet med back-end/jobbet som utvikler. Vi har likevell valgt å beholde de eksisterende rollene, da vi anser det som nødvendig å ha en ansvarlig innenfor hvert punkt.

Prosjektleder Sandra gjør fortsatt en god jobb. Vi har derfor heller ikke valgt å endre teamlead. Likevel ser at helle gruppen bidrar like mye, og at de fleste avgjørelser blir tatt i fellesskap. Det vil si at teamlead ikke har hatt behov for å gripe inn, og overstyre gruppen. Som forrige oblig ser vi ingen grunn til å utnevne en spesifikk kundekontakt, da samtlige i gruppen deltar i gruppetimen og har i fellesskap dialog med gruppeleder/foreleser.
___

### **Rollebeskrivelse**
I denne avsnittet vil vi beskrive de forskjellige rollene i taemet. Det er i stor grad vektlagt hvordan vi har jobbet frem til nå, og hvordan vi ser for oss at vi skal jobbe fremover. Beskrivelse av hvilke oppgaver de forskjellige rollene har står beskrevet i Oblig1.md. Vi har foreløpig bestemt oss for å ikke utarbeide nye roller, da vi ser at de som ble definert tidligere har fungert til nå. Derfor vil avsnittet under være svært likt som ved forrige oblig. 

*Utvikler:* <br>
Utover de beskrevne rollene under har hele teamet fungert som utviklere. Det har vært fokus på å kode i fellesskap når vi møtes, slik at alle er oppdatert på koden. Kontra tidligere oblig har gruppen som helhet hatt større fokus på å jobbe som utvikler, da det har vært det viktigste fokuset.


*Teamleder:* <br>
Rollen som teamleder har fungert svært bra. Frem til nå har det i stor grad vært enighet i gruppen, og alle har bidratt. Dette har gjort at Sandra ikke har måtte ta noen store avgjørelser der gruppen er uenig. Likevel har hun vært flink på å holde orden på prosjektet og sørger for stabil fremgang.

*Front-end:* <br>
Som front-end ansvarlig har Guro tatt ansvar for at spillfiguren og fiender er på plass. Her har hun fokusert på at brukervennligheten skal være bra, og enkel. I tillegg til å bygge et bra fundament for videre koding. Siden dette har vært en stor oppgave har hun fått god assistanse fra spesielt Hilde, men og resten av gruppen.


*Gitmaster:* <br> 
Rollen til gitmaster har vært svært viktig frem til nå. Det er viktig at alle har pushet til git, og at alle har fått med seg endringer som er gjort i koden. Utvalgte i gruppen sliter fortsatt litt med Git, så dette har gjort rollen til Gitmaster ekstremt viktig. Hilde har god kontroll på git, og vært flink til å lære opp resten av gruppen.

*Designansvarlig:* <br>
Designansvarlig har hatt en viktig rolle frem til nå. Det er viktig at vi har en god grafikk, og at det er en god brukeropplevelse. Nå som spillbrettet begynner å ta form, har designansvarlig hatt en viktig rolle i å utforme hvordan spillet skal se ut. Cecilie har utformet et bra utgangspunkt for spillet. Siden dette og har vært en stor oppgave har hun fått hjelp fra teamleder.

*Rapportansvarlig:* <br>
Som hovedansvarlig for rapporten har Mattias sørget for at møterefeferatene er på plass, og at alle har fått med seg hva som har blitt diskutert. Han har også tatt hovedansvaret for å skrive rapporten. Som rollen er beskrevet har Mattias og sørget for at teamet følger gitt prosjektmetodikk. Dette innebærer at vi har prøvd å holde oss til de satte stegene i sprinten, samt bruke kanban-boardet aktivt.


*Testansvarlig:* <br>
Samtlige i gruppen har ansvar for å utvikle tester. Vi har fokusert på å først utarbeide interface, deretter tester. Til slutt har vi laget kode basert på dette. Ved forrige oblig fikk vi noen trekk i poeng grunnet mangel på tester. Derfor har det vært enda større fokus enn tidligere på dette. 

___
### **Erfaringer rundt gruppen og prosjektmetodikk**
Prosjektmetodikken begynner i større grad å bli en naturlig arbeidsmåte for teamet som helhet. Selv om flere synes den agile tilnærmingen var uvant i starten, begynner det nå falle på plass. Vi er blitt mer bevisste enn tidligere på følge de satte stegene i hver sprint (planlegge, designe, kode og teste, diskutere veien videre). Men det viktigste læringsmomentet vi har hatt til nå er at vi er blitt mye mer smidig på å tørre å pivotere til andre retninger dersom vi ser det nødvendig. Eksempelvis jobbet gruppen lenge med å implementere welcome screen og pause screen som egne klasser. Da vi så at det ville skape videre problemer i koden, og vi fant en bedre løsning, nølte ikke gruppen med å prøve et annet alternativ. Dette viser en agil tilnærming som vi føler vi mestrer. 

Projectboardet har blitt flittig brukt siden sist gang, og vi føler som gruppe at dette er en natulig det av prosjektmetodikken. Vi har siden sist gang fått inn flere rutiner hva gjelder Projectboardet som gjør arbeidet mer effektivt. Med en gang et team-medlem kommer på en oppgave som burde vært gjort skrives den opp i projectboardet. Videre vil gruppen i fellesskap diskutere hvorvidt dette bør gjennomføres, hvor høy prioritet den oppgaven har, og hvem som skal gjennomføre den. På denne måten sikrer vi at vi ikke glemmer noe, samt at vi i fellesskap blir enighet om hvordan det er mest hensiktsmessig å gjennomføre en oppgave. 

____
### **Gruppedynamikk**
Dynamikken i gruppen fortsetter å være svært god. Etter å ha jobbet sammen i noen måneder nå begynner gruppen å kjenne hverandre bedre, og føle seg mer trygge på hverandre. Dette fører til at vi i større grad har en åpen dialog, og at gruppen tør i gi direkte tilbakemeldinger til hverandre. Dette aspektet er svært viktig, spesielt når man har en agil prosjektmetodikk. Det at individere i gruppen våger å si ifra når hen føler at vi bør prøve andre løsninger, eller pivotere inn på et annet spor, er helt avgjørende for å lykkes med en slik prosjektmetodikk. Dette føler vi at at vi i større grad mestre nå enn tidligere.
___
### **Kommunikasjon**
Kommunikasjonen i gruppen har vært veldig god, men kontra tidligere har vi fått brynt oss på noen utfordringer. Ved flere anledninger har utvalgte i gruppen vært syk under gruppetimer og team-møter. Dette har ført til at vi har måtte prøve å finne en måte å få de som ikke vær til stede, til å være oppdatert på hva som er blitt gjort siden sist, samt hva de bør gjøre til neste gang. I starten gjorde vi dette i sin helhet over Discord. Dette ser vi etterkant fungerte helt middels. Selv Discord er en fin plattform å snakke sammen på, vil noe informasjon forsvinne kontra å snakke sammen fysisk. Derfor valgte vi etterhvert å heller løse det ved at enten en på teamet som var på gruppetimen ringer den som var syk og forteller hva som ble gjort og hva vi anbefaler å gjøre videre, eller ved å sette opp ett ekstra team-møte. Dette har fungert veldig bra, og vi føler at vi har fått en god måte å håndtere dette på. <br>

Utover dette er i fornøyd med dynamikken i gruppen. Alle får komme til ordet, alle meninger blir hørt, og den generelle kommunikasjonen er veldig god.
___

### ***Retroperspektiv/forbedringspunkter***
Som ved forrige oblig blir mye av retroperspektivet diskutert under avsnittene Prosjektmetodikk, gruppedynamikk og kommunikasjon. 

Likevel er det verdt å nevne at vi til enhver tid har vært bevist på, og diskutert, hva som fungerer og hva som kan forbedres. Dette gjelder prosjektmetodikk, roller i teamet, kommunikasjon og selve koden. Det at vi har denne dialogen i gruppen gjør at vi sørger for at vi til enhver til er effektive, samt at trivselen på gruppen er på topp. <br>

Det vi ønsker å forbedre under neste oblig er tydelig kommunisere og bevisstgjøre hverander på hvilken del av sprinten vi er på til ethvert tidspunkt. Selv om vi gjennomføre en sprint som en gruppe, vil team-medlemmene jobbe på forskjellige deler av koden, og vil til tider være på forskjellige deler av sprinten. Spesielt i tilfeller hvor vi pivoterer, kan det være vanskelig å vite om vi er på planleggingsstadiet, eller om vi er i designstadiet. Dette kan føre til at vi ikke er like effektive som vi kunne vært. 

___

### **Bidrag til kodebasen**
Under oblig 1 fikk vi tilbakemelding å at vi hadde for ujevne commits. Dette har vært et stort fokus i denne obligen. Vi har oppnådd et mye jevnere nivå denne gangen. Årsaken til dette er for det første at samtlige i gruppen har blitt bedre på git. Dette gjør at gruppen som helhet har blitt tryggere på å pushe kode. Videre har flere nå jobbet med koden selvstendig som fører til flere commits per person. <br>

Likevel vil det også denne gangen være noen ujevnheter. Årsaken til dette er blant annet at individer på gruppen har forskjellige git-vaner, samt at noen fortsatt har jobber med det grafiske som ikke fører til commits. Dog er vi fornøyd med fordelingen av commits, og anser den som naturlig. 
___

## Krav og spesifikasjon

### **Strech goal**
Som diskutert i møtereferatet fra 20.03.2023 har vi besluttet at det å lage et "boss" level blir et stretch goal. Utgangspunktet vårt var å ha 3 vanlige level, i stigende vanskelighetsgrad, før vi til slutt har et "boss" level. Dette "boss" levelet er noe vi ønsker å få på plass ved siste oblig, men vil ikke bli førsteprioritet. <br>

Et "boss" level vil si at det vil være en større fiende som hovedkarakterer må kjempe mot. Dette kan sammenlignes med en "boss" i eksempelvis Super Mario. 
___
### **Prioriterte krav i Oblig 3**
I denne obligen har vi i hovedsak fokusert på følgende krav:
1. start/slutt skjerm
5. Spilleren skal interagere med terrenget
7. Fiender/allierte vises i spillet
9. Vise grafikk til spilleren
11. Få kamera til å stoppe før man ser den sorte kanten rundt spillbrettet
___
### **Nye MVP krav**
Vi har under denne obligen laget et nytt MVP krav. Hovedfokuset har vært å fullføre de eksisterende, så kun ett nytt har oppstått. Det er:

12. Spillkarakteren kan foredres ved å få tak i en "PowerUp"
___
### **Oversikt over brukerhistorier**
Brukerhistoriene er i stor grad lik som ved forrige oblig. Årsaken til dette er, som beskrevet over, at hovedfokuset har vært i implementere eksisterende krav. Likevel har vi laget en ny brukerhistorie, som tilhører det nye MVP kravet.

*Fullførte brukerhistorier*
| Brukerhistorie | Akseptansekriterier | Arbeidsoppgaver | Krav |
|:--------------:|:-------------------:|:---------------:|:-----|
| Som spiller skal jeg kunne se et spillbrett når jeg starter spillet. | Gitt at spilleren starter et spill: <br> -Bakken, taket være tydelig markert <br> -Hindringer være tydelig adskilt fra bakgrunnen | Metode som viser spillbrettet når spiller starter spillet fra menyen | 2 |
| Som spiller skal jeg til enhver se en spiller-objekt og tydelig skille den fra andre objekter | Gitt at spillet spilles skal: <br> - spillfiguren til envher være synlig <br> -spillfiguren skille seg fra andre objekter | Lage en spillfigur som tydelig skiller seg fra bakgrunnen <br> Metode som viser spiller på spillbrettet | 3 |
| Som spiller skal jeg kunne flytte på spilleren | Gitt at spilleren trykker “W”: <br> -skal spilleren hoppe <br> Gitt at spilleren trykker "A" skal: <br> -skal spilleren bevege seg til venstre <br> Gitt at spilleren trykker "D" <br> -skal spilleren bevege seg til høyre | Metode i controller som registrerer tastetrykk <br> Metode som beveger spilleren basert på tastetrykk | 4 |
| Som spiller skal jeg se den grafiske fremstillingen av spillfiguren | Gitt at spillet spilles <br> -skal spilleren se en figur som tydelig markerer seg som "hovedkarakteren" i spillet | Metode som implementerer spillfiguren | 9|
| Som spiller skal jeg ikke se den sorte kanten rundt spillbrettet | Gitt at spilleren beveger seg til kanten av spillbrettet<br> -skal kameratet stoppe <br> -skal spilleren IKKE se den svarte kanten rundt spillbrettet | Metode som implementerer kamera | 11|

*Påbegynte brukerhistorier* <br>
| Brukerhistorie | Akseptansekriterier | Arbeidsoppgaver | Krav |
|:--------------:|:-------------------:|:---------------:|:-----|
| Som spiller skal jeg se en meny når jeg starter spillet. Der skal jeg ha mulighet til å velge mellom å starte spille, eller se informasjon om spillet | Gitt at spillet startes skal: <br> -spilleren måte en meny med forskjellige valg <br>- Hvert valg skal ta spilleren til et nytt vindu | Metode som viser menyen når programet starter <br> Metode som kan kjøre andre klasser | 1 |
| Som spiller jeg kunne interagere med terenget | Gitt at spilleren går bort til et hinder skal: <br> - spillfiguren stoppe <br> Gitt at spilleren hopper på et objekt: <br> -skal spilleren kunne lande på et objekt | Metode som gjør gjør at spilleren stopper når den interagerer med terrenget | 5 |
| Som spiller skal jeg kunne hente gjenstander fra kister | Gitt at spillfiguren åpner en kiste: <br> -skal enten spilleren få en "power-up" <br> -eller motta informasjon som senere kan byttes | Metode som gir spilleren gjenstander når den åpner en kiste <br> Metode som gir spilleren våpen når den åpner en kiste | 6 |
| Som spiller skal jeg kunne se fiender og allierte | Gitt at spilleren er på et sted i spillbrettet der det er fiender eller alierte <br> -skal spilleren tydelig klare å skille fiender/alierte fra bakgrunnen <br> -skal spilleren vite forskjell på fiende og alliert | Metode som som lager fiender <br> Metode som lager allierte | 7 |
___

*Ikke-påbegynte brukerhistorier*
| Brukerhistorie | Akseptansekriterier | Arbeidsoppgaver | Krav |
|:--------------:|:-------------------:|:---------------:|:-----|
| Som spiller skal jeg se at jeg mister liv når jeg jeg interagerer med en fiende | Gitt at spilleren interagerer med en fiende <br> -skal spilleren tydelig se hvor mye liv den mister <br> -skal spilleren tydelig se hvor mye liv den har igjen | Metode som gjør at spilleren mister liv ved kontakt med fiender <br> Metode som gjør at spilleren dør når den er tom for liv | 8 |
| Som spiller skal jeg se at jeg mister liv dersom jeg faller ut av brettet | Gitt at spilleren faller en viss distanse <br> -skal spilleren tydelig se at den dør | Metode som gjør at spiller dør og spillet starter på nytt dersom spiller faller ut av brettet | 8|
| Som spiller skal jeg se en siste "boss" på siste level | Gitt at spilleren kommer til siste level <br> -skal spilleren se en figur som tydelig er en "boss" <br> -skal spilleren kunne kjempe mot denne "bossen" | Metode som implementerer "boss" | 10|

*Nye MVP brukerhistorier* <br>
| Brukerhistorie | Akseptansekriterier | Arbeidsoppgaver | Krav |
|:--------------:|:-------------------:|:---------------:|:-----|
| Som spiller skal jeg kunne plukke opp en "PowerUp" og forbedre spillekarakterens ferdigheter | Gitt at spilleren plukker opp en "PowerUp" <br> -skal spillkarakteren bevege seg raskere i en gitt tidsperiode | Metode som implementerer "PowerUp" | 12 |


### **Prioritering av oppgaver fremover**
De viktigste elementene i spillet er nå på plass. Til den endelige innleveringen vil vi fokusere på å få på plass noen flere features, samt fikse bugs. 

De viktigste oppgavene fremover er: <br>

*PowerUp* <br> 
Spilleren skal ha muligheten til å forbedre sine ferdigheter. Det vil eksempelvis være ved å plukke opp et objekt, for å så bevege seg raskere eller hoppe høyere. <br>

*Bevegende fiender* <br>
Til nå har vi kun statiske fiender. Det vil si at objekter i spillet som er fiendlig for spilleren står i ro. Til den endelige innleveringen vil vi implementere bevegende fiender. Dette vil gjøre spillet mer utfordrende, og gi spilleren en mer helhetlig opplevelse. <br>

*Returnere til meny og fortsette på et annet level* <br>
Spillet vårt består av 3 level. Til den endelige innleveringen ønsker vi å få på plass at dersom spilleren har fullført et level, vil det ligge som "åpent" i menyen. Det vil si at spilleren til enhver tid skal kunne returnere til menyen og fortsette på et annet level som spilleren har åpnet. 


*Spillkarakteren dør dersom den faller utenfor brettet* <br>
Dersom spillkarakteren eksempelvis faller ned i vann eller "utenfor spillbrettet". Skal den miste alle livene og dø. Dette er noe vi ønser å få på plass til den endelige innleveringen. <br>

Det er laget et nytt mvp krav for PowerUp. Dette er grunnet vi føler det ikke inngår i de eksisterende kravene, derav må være et eget. De resterende oppgavene inngår i stor grad i eksisterende mvp krav og brukerhistorier, og vi har derfor ikke laget nye.

*Musikk/lyd*
Implementere bakgrunsmusikk og/eller lydefekkter i spillet. <br>

___
### **Bugs**
Totaloversikt over kjente bugs ligger i README.

___
## Produkt og kode

### **Utbedring av feil**
Siden forrige oblig har vi ikke fått påpekt noen feil vi bør jobbe med eller noen bugs med koden som bør fikses. Det eneste vi fikk påpekt var at vi hadde litt for lite tester. Dette har vi derfor hatt større fokus på under denne obligen. Se avsnittet om testing for mer informasjon.

Likevel er det noen bugs vi hadde i README under forrige oblig som vi har fikset. Disse er bugsene er: <br>
* Det er mulig å gå utenfor brettet på noen nivåer
* Kamera følger ikke spiller ut til venste, men gjør det til høyre

Vi har fortsatt ikke laget tester for alle aspekter av spillet, men dette er noe vi skal ha på plass til den neste og endelige innleveringen. 
___
### **Kjøre koden**
Se README for instruksjoner.

Vi har ikke hatt tilgang til Linux under denne innleveringen, og har derav ikke fått testet det. Men vi har nå fått tak i en person i Storbritannia som bruker Linux, som har sagt han kan testet det for oss til neste oblig. Dette vil derfor bære på plass til siste innlevering. 
___
### **Klassediagram**
Se ClassDiagramOblig3.png.
Dersom det er i dårlig oppløsning, ta kontakt så kan vi sende det direkte på Discord.

___
### **Tester**
Per nå har vi tester til følgende klasser: <br>
* PlayerState
* BodyManager
* TiledMapManager
* GameModel
* GameMap
* CombatEntity
* Enemy
* Friend
* Player
* Inventory

___
### **Analyseverktøy**
Vi har heller ikke under denne obligen prioritert å ta i bruk et analyseverktøy. Vi har brukt tid på å få på plass store deler av koden, samt skrive tilhørende tester. Vi vil vurdere om dette er noe vi skal bruke til siste innlevering, men det vil ikke være førsteprioritet.
___