package playing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameQuestion  {
	private Random random  = new Random();
	private HashMap<String, ArrayList<String>> questions = new HashMap <String, ArrayList<String>>();
	private ArrayList<String> keys;
	
	private String randomKey;
	private ArrayList<String> value;
	
	public GameQuestion(){
	}
	
	public void initQLevelOne() {
		ArrayList<String> answerValues = new ArrayList<String>();
		answerValues.add("1,75 ml");
		answerValues.add("1,75ml");
		answerValues.add("1.75ml");
		answerValues.add("1.75");
		answerValues.add("1.75 ml");
		answerValues.add("1,75");
		answerValues.add("1,75 millilitre");
		//neuralgi
		ArrayList<String> neuralgi = new ArrayList<String>();
		neuralgi.add("33.75mg");
		neuralgi.add("33.75 mg");
		neuralgi.add("33,75mg");
		neuralgi.add("33,75 mg");
		neuralgi.add("33.75");
		neuralgi.add("33,75");
		//ulrika
		ArrayList<String> ulrika = new ArrayList<String>();
		ulrika.add("250 mg");
		ulrika.add("250mg");
		ulrika.add("250");
		
		
		ArrayList<String> ulrika1 = new ArrayList<String>();
		ulrika1.add("2");
		ulrika1.add("2 tabletter");
		ulrika1.add("2tabletter");
		
		ArrayList<String> rehydrex = new ArrayList<String>();
		rehydrex.add("105droppar");
		rehydrex.add("105 droppar");
		rehydrex.add("105");
		
		ArrayList<String> mixture = new ArrayList<String>();
		mixture.add("6,5 ml");
		mixture.add("6,5ml");
		mixture.add("6.5 ml");
		mixture.add("6.5ml");
		mixture.add("6.5");
		mixture.add("6,5");

		
		ArrayList<String> mixture1 = new ArrayList<String>();
		mixture1.add("15 dagar");
		mixture1.add("15dagar");
		mixture1.add("15");
		
		ArrayList<String> volym = new ArrayList<String>();
		volym.add("0,5 ml");
		volym.add("0,5ml");
		volym.add("0,5");
		volym.add("0.5 ml");
		volym.add("0.5ml");
		volym.add("0.5");
		volym.add(".5");
		volym.add(",5");
		volym.add(",5ml");
		volym.add(",5 ml");
		volym.add(".5 ml");
		volym.add(".5ml");
		
		ArrayList<String> barn= new ArrayList<String>();
		barn.add("7gm");
		barn.add("7 gm");
		barn.add("7gram");
		barn.add("7 gram");
		barn.add("7");
		
		ArrayList<String> eksem= new ArrayList<String>();
		eksem.add("3mg");
		eksem.add("3 mg");
		eksem.add("3");
		
		questions.put("Situation: En patient har en svår infektion. Han behandla med tobramycin 3mg/kg/dygn fördelat på tre lika stora doser var 8:e timme. Patienten väger 70 kg. Tobramycin injektionslösningens styrka är 40 mg/ml" + "\n Uppgift : Hur många ml får patienten per gång?", answerValues);
		questions.put("Situation: En patient med postherpetisk neuralgi ordineras Capsina® kräm 0,075 %" + "\n Uppgift : Exakt hur många mg verksam substans Capsina® innehåller en tub med 45 g kräm?", neuralgi);
		questions.put("Situation: Ulrika har ledgångsreumatism. Hon väger 50 kg. Hon får som behandling Pronaxen 10 mg/kg/dygn fördelat på två doser" + "\n Uppgift : Hur många mg borde Ulrika få per gång?", ulrika);
		questions.put("Situation: 1000 ml Rehydrex® med Glukos 25 mg/ml skall ges med en hastighet av 4,5 ml per kg kroppsvikt och timme till en patient som väger 70 kg. Infusionsaggregatet ger 20 droppar per 1 ml" + "\n Uppgift : Vad blir dropphastigheten i droppar per minut?", rehydrex);
		questions.put("Situation: Ett barn med öroninflammation blir ordinerad 500 mg fenoximetylpenicillin per dostillfälle, 2 dostillfällen per dygn" + "\n Uppgift: Hur mycket fenoximetylpenicillin erhåller barnet på exakt en vecka?",barn);
		questions.put("Situation: En patient med eksem ordineras Protopic 0,03 % salva som underhållsbehandling" + "\n Uppgift: Hur många mg verksam substans innehåller en tub på 10 gram?", eksem);
		questions.put("Situation: Mixtur Tavegyl® 50 μg/ml. Ett barn som väger 13 kg ordineras 50 μg Tavegyl® per kg kroppsvikt och dag, uppdelat på morgon och kväll" + "\n Uppgift: Hur många dagar kommer en flaska med 200 ml att räcka?", mixture1);
		questions.put("Situation: Ulrika har ledgångsreumatism. Hon väger 50 kg. Hon får som behandling Pronaxen 10 mg/kg/dygn fördelat på två doser." + "\n Uppgift: Hur mång tabletter ges då det på etiketten står tbl. Pronaxen 125 mg?", ulrika1);
		questions.put("Situation: Vid operation av ett nageltrång får patienten vänster stortå lokalbedövad med 10 mg Carbocain 20 mg/ml" + "\n Uppgift: Hur stor volym av Carbocain 20 mg/ml injiceras i tån?", volym);
		questions.put("Situation: Mixtur Tavegyl® 50 μg/ml. Ett barn som väger 13 kg ordineras 50 μg Tavegyl® per kg kroppsvikt och dag, uppdelat på morgon och kväll" + "\n Uppgift : Hur många ml lösning ska ges vid varje tillfälle?", mixture); 
		
		keys = new ArrayList<String>(questions.keySet());
	}
	
	public void initQLevelTwo() {

		ArrayList<String> questionOne = new ArrayList<String>();
		questionOne.add("20");
		questionOne.add("20 droppar");
		questionOne.add("20droppar");
		questionOne.add("20 droppar / minut");
		questionOne.add("20droppar/minut");
		questionOne.add("20 droppar per minut");

		ArrayList<String> questionTwo = new ArrayList<String>();
		questionTwo.add("80");
		questionTwo.add("80mmol");
		questionTwo.add("80 mmol");

		ArrayList<String> questionThree = new ArrayList<String>();
		questionThree.add("703000 µg");
		questionThree.add("70300");
		questionThree.add("703000µg");
		questionThree.add("703000 mikrogram");
		questionThree.add("703000mikrogram");
		
		ArrayList<String> questionFour = new ArrayList<String>();
		questionFour.add("22680 mikrogram");
		questionFour.add("22680mikrogram");
		questionFour.add("22680");
		questionFour.add("22680µg");
		questionFour.add("22680 µg");
		
		ArrayList<String> questionFive = new ArrayList<String>();
		questionFive.add("125 ml");
		questionFive.add("125ml");
		questionFive.add("125 milliliter");
		questionFive.add("125milliliter");
		questionFive.add("125");
		
		questions.put("Den totala volymen av den iordingställda Ondansertonlösningen ges sedan till pateinten. Infusionstiden är 25 minuter. Droppaggregatet ger 20dr/ml." + "\n Uppgift: Ange dropptakten för infusionen.", questionOne);
		questions.put("Du sätter infusionen kl 10:00, kl 14:00 måste du dock avbryta infusionen eftersom den har gårr subcutant. Droppaggregatet ger 20 dr/ml." + "\n Uppgift: Hur många mmol kaliumklorid har infunderats till patienten kl 14:00?", questionTwo);
		questions.put("Omvandla till angiven enhet (µ = mikro): 0,703 g", questionThree);
		questions.put("Omvandla till angiven enhet (µ = mikro): 22,68 mg", questionFour);
		questions.put("Inför en läkemedelsanalys skall du späda 95% etanol med destillerat vatten så att du får 70% etanol." + "\n Uppgift: Hur många ml destillerat vatten behöver du för spädningen av 95% etanol till slutvolymen 475 ml 70% etanol?", questionFive);
		
		keys = new ArrayList<String>(questions.keySet());
	}
	
	public String getQuestion() {
		this.randomKey = keys.get( random.nextInt(keys.size()) );
		return randomKey;
	}
	
	public void setRandomKey(String randomKey) {
		this.randomKey = randomKey;
	}
	
	public ArrayList<String> getAnswer() {
		value = questions.get(randomKey);
		return value;
	}
	public void setValue(ArrayList<String> value) {
		this.value = value;
	}
	
	public void removeUsedQuestion(String value){
		keys.remove(value);
	}

}