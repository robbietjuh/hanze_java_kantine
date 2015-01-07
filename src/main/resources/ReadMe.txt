Week opdracht #1
================

Opgave 1b:
    Declaratie is bijvoorbeeld ik heb een int genaamd x en initialisatie is dat je aan deze int een waarde koppelt.


Opgave 4:
    Primitieve types worden direct in variablen opgeslagen en werken met waarden.
    Objecttypes worden als verwijzing opgeslagen in een variable. Alleen de verwijzing wordt dus gekopieerd.


Week opdracht #2
================

Opgave 5a:
    Een while lus is handiger omdat het verwerken van de index in de wachtirj niet meer nodig is. Dit wordt
    immers al gedaan door de CheckoutLine, waarbij de eerste persoon verwijderd wordt nadat we hem fetchen.


Week opdracht #3
================

Opgave 1:
    `Canteen.getAmountOfMoneyInCashRegister()`
    `Canteen.getAmountOfArticles()`
    `Canteen.resetCashRegister()`

Opgave 2a:
    Omdat deze methodes enkel binnen de klasse zelf aangeroepen worden. Andere klasses hoeven er dus niet per se
    toegang toe te hebben.

Opgave 2b:
    Een `HashMap` gebruik je in een situatie waarbij je een `key` moet koppelen aan bepaalde `value`. Als je
    enkel `keys` op wil slaan, zonder dat daar een bepaalde `value` aan gekoppeld moet worden, gebruik je een `HashSet`.

Opgave 3a:
    De constructor van de `CanteenSimulation` stelt eerst de initiele objecten samen die nodig zijn voor een juiste werking
    van de rest van de klasse. Hieronder vallen de kantine en de random generator.

    Nadat de initiele objecten geinitialiseerd zijn wordt een random hoeveelheid producten berekent. Dit gebeurd
    door het aanroepen van de `getRandomArray` functie. De constants `AMOUNT_OF_ARTICLES`, `MIN_ARTICLES_PER_TYPE`
    en `MAX_ARTICLES_PER_TYPE` worden doorgegeven om de random hoeveelheden te beperken.

    Hierna wordt er een nieuw aanbod geinitialiseerd, welke aan de kantine aangewezen wordt. Vanaf dit punt is het
    aan de caller om de simulatie aldanniet te starten met een aanroep naar `simulate`.

Opgave 3b:
    Wanneer we met de Random generator van Java een getal laten vallen, kunnen we dat doen met de functie `nextInt`.
    De functie `getRandomValue` maakt daar gebruik van. Bij het laten van een getal, is het mogelijk een maximum
    op te geven. Java gebruikt het getal dat als eerste paramter doorgepassed wordt, als maximum voor het laten vallen
    van de random integer. Het is echter belangrijk om te weten dat het getal niet inclusief is, maar exclusief.

    Als men 8 meegeeft, zal het getal 7 het laatste getal zijn dat vallen kan. 8 telt niet mee. Om deze reden tellen
    we 1 bij het maximum op.

Week opdracht #4
================

Opgave 1c
    Standaard is er al een constructor, deze is leeg, dus een lege constructor definiëren heeft geen zin.

Opgave 1d
    Omdat de methoden beide gebruik maken van local variables en paramaters kun je ze static maken.

Opgave 1e
    Je doel is bereikt want je kan geen instantie van Administratie(Administration) meer maken en daardoor kan je de
    methoden in de klasse Administratie(Administration) ook niet meer aanroepen

Opgave 1h
    Door de variabel final te maken is hij niet meer te wijzigen door middel van code, je moet hem zelf met
    de hand in de code wijzigen als hij anders moet;

Opgave 1i
    De compile klaagt hierover omdat de method wel van overal beschikbaar is maar de veld die gebruikt wordt niet omdat
    deze niet static is.

Opgave 1j
    Door final te veranderen in static is de variabel weer te wijzigen door middel van code
    en dit is wat je hier dus niet wil.

Opgave 2b
    Als deze niet boven aan staat is het niet mogelijk om de variabelen van de super klasse te gebruiken
    omdat ze niet geinitialiseerd zijn.

Week opdracht #5
================

Opgave 1c
    Als je de equals methode gebruikt werkt het wel maar als je de == gebruikt werkt het niet, dan zijn ze niet identiek
    aan elkaar.

Opgave 1d
    Bij het gebruik van == worden de objecten 'raw' met elkaar vergeleken. Omdat het in dit geval gaat om
    twee verschillende objecten (aldanniet met dezelfde properties e.d.), zal het adres in het geheugen verschillen.
    Dit zal ervoor zorgen dat een vergelijking met == niet werkt: de memory addresses komen niet overeen.

Opgave 2b
    Zie /src/main/resources/DebitcardPaymentMethod.pay(double).jpg

Opgave 2c
    Dit is gedaan zodat een andere klasse deze variable niet aan kan passen. Dit is handig
    omdat als je hem private had gemaakt een subklasse er niet bij kon en dat kan nu wel.

Opgave 5a
    Je kan geen instantie maken van een interface via new. Het is logisch dat dit niet kan
    want een interface is abstract en implementeert helemaal niets; het is enkel een soort
    definitie, een lijdraad voor het opstellen van een echte klasse.

Opgave 5b
    Je kan geen instantie maken van een abstracte klasse via new. Het is logisch dat dit niet kan
    want een abstracte klasse is abstract.

Opgave 5c
    Nee, een klasse kan niet meerdere klassen overerven.

Opgave 5d
    Ja, een klasse kan meerdere interfaces implementeren.

Opgave 5e
    Ja, een klasse kan een (of meerdere) interface(s) implementeren en een klasse overerven.

Opgave 5f
    Ja, je implementeert ze immers niet.

Opgave 5g
    Ja, de klasse moet abstract zijn als ten minste één methode abstract is. Als de klasse niet abstract is,
    zul je de code niet kunnen compilen; dit is een soort fail-safe zodat je niet per abuis de implementatie
    van een methode kan vergeten, tenzij je expliciet aangeeft dat er abstracte methodes in de klasse zitten.

Opgave 5h
    Wanneer je logisch gezien één en dezelfde handeling meerdere keren uitvoert, maar deze technisch gezien
    toch van elkaar verschillen spreken we van polymorfisme.

Opgave 6a
    Ja, dat kan. Het abstract maken van een klasse geeft de compiler de instructie om abstracte methodes in de
    klasse te honereren. Het zegt echter niet dat het verplicht is dat er vanaf dat moment abstracte methodes
    in de klasse komen te zitten. Om het simpel te zeggen, het geeft je 'toestemming' om abstracte methodes toe
    te voegen aan de klasse - het verplicht je er niet toe.

Opgave 6b
    Ja dat moet want in de abstracte klasse is de body van de abstracte methode niet gedefineerd dus als je dat
    niet hoefde te doen heb je een zinloze methode, wat potentieel bugs zou kunnen veroorzaken als iemand
    'per ongeluk' vergeet een bepaalde methode alsnog te implementeren.

Opgave 6c
    Een logische oplossing zou zijn om een `NotImplementedException` te raisen. Dit zorgt ervoor dat de compiler
    alsnog een implementatie voor de methode ziet, terwijl de methode per definitie eigenlijk niets doet. Mocht
    iemand de methode alsnog aanroepen, dan is het voor de caller ook nog eens duidelijk dat deze niet geimplementeerd
    is door de Exception die er ontstaat.

Opgave 6d
    Het is geinitialiseerd dus kan niet abstract zijn

Opgave 6e
    Een final method is een method dat niet meer extended of overriden kan worden om de implementatie te veranderen.
    Het is niet mogelijk om een methode abstract en final tegelijk te maken; in dat geval zou er geen implementatie
    zijn en zal die er ook nooit kunnen komen.