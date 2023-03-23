# **Oblig 3**

HUSK:
Stretch goal - BOSS!

## **Møtereferat**

**Dato: Torsdag 16.03.2023** <br>
**Sted: Vilvite** <br>
**Deltagere: Sandra, Hilde, Guro, Mattias** <br>
**Referent: Mattias** <br>

*Oppsummering:* <br>
Grunnet obligatoriske oppgaver i andre fag (blant annet INF222), ble møte i dag i det korteste laget. Derfor vil vi ta et ekstra møte førstkommende mandag. Det ble snakket litt om spritebatch og tegning av hovedkarakter.
legge til objektlag for friends og enemies i Tiled

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
Vi startet møtet med å se litt på hvordan vi ligger ann og hva vi har igjen. Dette gjelder både i henhold til oblig 3, og til det endelige resultatet. Vi hadde som utgangspunkt at vi skulle klare å lage 3 level + et "boss" level. Vi ser dog per nå at dette kan være litt overambisiøst, og at vi heller skal sette "boss" level som et stretch goal. Dette diskuteres nøyere i ...TODO... Videre har vi og i fellesskap sørget for at det ligger inne riktige lag i kartet.

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
Møte startet med å oppsumere hva de enkelte de har gjort siden sist. Her ble det blant annet presentert hvordan vi har løst kollisjon med objekter. Eksemepelvis når spillkarakteren kolliderer med døresn som skal ta spilleren til neste level. I tilegg har vi i stor grad diskutert hvordan vi videre skal utarbeide welcome screen og pause screen.

*Diskusjoner:* <br>
Som beskrevet over har vi i stor grad jobbet med welcome screen og pause screen. Her har vi møtt på noen problemer. Planen var i utgangspunktet å ha ulike skjermer/klasser for pause og welcome. Dette har dog bydd på problemer dypere ned i biblioteket. Derfor gitt mye av dette møte til å diskutere hvordan vi skal løse dette. Løsningen vi ser som mest hensiktsmessig er å samle dette i gameScreen som forskjellig states.

*Neste møte* <br>
30.03.2023 <br>

*Oppgaver til neste gang:* <br>
TODO

___

**Dato: Torsdag 30.03.2023** <br>
**Sted: Vilvite** <br>
**Deltagere: Sandra, Hilde, Guro, Cecilie, Mattias** <br>
**Referent: Mattias** <br>

*Oppsummering:* <br>
TODO

*Diskusjoner:* <br>
TODO

*Neste møte* <br>
TODO <br>

*Oppgaver til neste gang:* <br>
TODO

___

## **Prosjektrapport**

### **Roller**
Under denne obligene har rollene vært mer flytende enn tidligere. I løpet av første uke av obligen ble mye av det grafiske noen lunde ferdigstillt. Det har ført til at flere har jobbet med back-end/jobbet som utvikler. Vi har likevell valgt å beholde de eksisterende rollene, da vi anser det som nødvendig å ha en ansvarlig innenfor hvert punkt.

Prosjektleder Sandra gjør fortsatt en god jobb. Vi har derfor heller ikke valgt å endre teamlead. Likevel ser at helle gruppen bidrar like mye, og at de fleste avgjørelser blir tatt i fellesskap. Det vil si at teamlead ikke har hatt behov for å gripe inn, og overstyre gruppen. Som forrige oblig ser vi ingen grunn til å utnevne en spesifikk kundekontakt, da samtlige i gruppen deltar i gruppetimen og har i fellesskap dialog med gruppeleder/foreleser.
___

### **Rollebeskrivelse**
I denne avsnittet vil vi beskrive de forskjellige rollene i taemet. Det er i stor grad vektlagt hvordan vi har jobbet frem til nå, og hvordan vi ser for oss at vi skal jobbe fremover. Beskrivelse av hvilke oppgaver de forskjellige rollene har står beskrevet i Oblig1.md. Vi har foreløpig bestemt oss for å ikke utarbeide nye roller, da vi ser at de som ble definert tidligere har fungert til nå. Derfor vil avsnittet under være svært likt som ved forrige oblig. 

*Utvikler* <br>
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
Prosjektmetodikken begynner i større grad å bli en naturlig arbeidsmåte for teamet som helhet. Selv om flere synes den agile tilnærmingen var uvant i start, begynner det nå falle på plass. Vi er blitt mer bevisste enn tidligere på følge de satte stegene i hver sprint (planlegge, designe, kode og teste, diskutere veien videre). Men det viktigste læringsmomentet vi har hatt til nå er at vi er blitt mye mer smidig på å tørre å pivotere til andre retninger dersom vi ser det nødvendig. Eksempelvis jobbet gruppen lenge med å implementere welcome screen og pause screen som egne klasser. Da vi så at det ville skape videre problemer i koden, og vi fant en bedre løsning, nølte ikke gruppen med å prøve et annet alternativ. Dette viser en agil tilnærming som vi føler vi mestrer. 

Projectboardet har blitt flittig brukt siden sist gang, og vi føler som gruppe at dette er en natulig det av prosjektmetodikken. 



____
### **Gruppedynamikk**
TODO
___
### **Kommunikasjon**
TODO
___

### ***Retroperspektiv/forbedringspunkter***
TODO
___

### **Bidrag til kodebasen**
Under oblig 1 fikk vi tilbakemelding å at vi hadde for ujevne commits. Dette har vært et stort fokus i denne obligen. Vi har oppnådd et mye jevnere nivå denne gangen. Årsaken til dete er for det første at samtlige i gruppen har blit bedre på git. Dette gjør at gruppen som helhet har blitt tryggere på å pushe kode. Videre har flere nå jobbet med koden selvstendig som fører til flere commits per person. <br>

Likevel vil det også denne gangen være noen ujevnheter. Årsaken til dette er blant annet at individer på gruppen har forskjellige git-vaner, samt at noen fortsatt har jobbet med det grafiske som ikke fører til commits. Dog er vi fornøyd med fordelingen av commits, og anser den som naturlig.
___

## Krav og spesifikasjon

### **Prioriterte krav i Oblig 3**
TODO
___
### **Nye MVP krav**
TODO
___
### **Oversikt over brukerhistorier**
TODO

___

### **Prioritering av oppgaver fremover**
TODO
___
### **Bugs**
TODO
___
## Produkt og kode
TODO
___
### **Utbedring av feil**
TODO
___
### **Kjøre koden**
TODO
___
### **Klassediagram**
TODO
___
### **Tester**
TODO
___
### **Analyseverktøy**
TODO

___