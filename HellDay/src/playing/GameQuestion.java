package playing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameQuestion  {
	private Random random  = new Random();
	private HashMap<String, ArrayList<String>> questions;
	
	private String randomKey;
	private ArrayList<String> value;
	ArrayList<String> keys;
	
	public GameQuestion() {
		initQuestions();
		keys = new ArrayList<String>(questions.keySet());
	}
	
	public String getRandomKey() {
		this.randomKey = keys.get( random.nextInt(keys.size()) );
		return randomKey;
	}
	
//	public void setRandomKey(String randomKey) {
//		this.randomKey = randomKey;
//	}
	
	public ArrayList<String> getValue() {
		value = questions.get(randomKey);
		return value;
	}
	
//	public void setValue(ArrayList<String> value) {
//		this.value = value;
//	}
	
	private void initQuestions() {
		questions = new HashMap <String, ArrayList<String>>();
		
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
		
	}

	
	public void test(){
	
		HashMap<String, ArrayList<String>> questions = new HashMap <String, ArrayList<String>>();
		
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
		
		ArrayList<String> keys      = new ArrayList<String>(questions.keySet());
		randomKey = keys.get( random.nextInt(keys.size()) );
		value     = questions.get(randomKey);

}
}