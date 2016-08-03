package implication;

import java.util.HashMap;

public class DiacriticHashMap {
	
	private HashMap<String, Integer> hashMap;
	
	public DiacriticHashMap(){
		setUpHashMap();
	}
	
	public HashMap<String, Integer> getHashMap(){
		return hashMap;
	}
	
	private void setUpHashMap(){
		hashMap = new HashMap<String, Integer>();
		
		//Column: Blanks
		hashMap.put("َ.", 1);
		hashMap.put("ِ.", 1);
		hashMap.put("ُ.", 1);
		hashMap.put("ٌ.", 1);
		hashMap.put("ٍ.", 1);
		hashMap.put("َ.", 1);
		hashMap.put("ّ.", 1);
		hashMap.put(">.", 4);
		hashMap.put("<.", 4);
		hashMap.put("..", 0);
		hashMap.put("ْ.", 0);
		hashMap.put("ّ.", 4);
		hashMap.put("s.", 15);
		hashMap.put("u.", 15);
		hashMap.put("d.", 15);
                hashMap.put("ً.", 1); //Fathatan

                hashMap.put(".ً", 1); //Fathatan
		hashMap.put(".َ", 1);
		hashMap.put(".ِ", 1);
		hashMap.put(".ُ", 1);
		hashMap.put(".ٌ", 1);
		hashMap.put(".ٍ", 1);
		hashMap.put(".َ", 1);
		hashMap.put(".ّ", 1);
		hashMap.put(".>", 4);
		hashMap.put(".<", 4);
		hashMap.put(".ْ", 0);
		hashMap.put(".ّ", 4);
		hashMap.put(".s", 15);
		hashMap.put(".u", 15);
		hashMap.put(".d", 15);
		
		//Weighted Values
		
		//Column: Fatha
		hashMap.put("ََ", 0); //Fatha - Fatha
		hashMap.put("َِ", 1); //Fatha - Kasra
		hashMap.put("َُ", 1); //Fatha - Dhama
		hashMap.put("َْ", 1); //Fatha - Sukun
		hashMap.put("ًَ", 1); //Fatha - Fathatan
		hashMap.put("ٍَ", 1); //Fatha - Kasratan
		hashMap.put("ٌَ", 1); //Fatha - Dhamatan
		hashMap.put("َ>", 4); //Fatha - Hamza_UP
		hashMap.put("َ<", 4); //Fatha - Hamza_DOWN
		hashMap.put("َّ", 4); //Fatha - Shadda
		hashMap.put("َs", 15); //Fatha - Shadda (mid)
		hashMap.put("َu", 15); //Fatha - Hamza_UP (mid)
		hashMap.put("َd", 15); //Fatha - Hamza_Down (mid)
		
		//Column: Fathatan
		hashMap.put("ًَ", 1); //Fathatan - Fatha
		hashMap.put("ًِ", 1); //Fathatan - Kasra
		hashMap.put("ًُ", 1); //Fathatan - Dhama
		hashMap.put("ًْ", 1); //Fathatan - Sukun
		hashMap.put("ًً", 0); //Fathatan - Fathatan
		hashMap.put("ًٍ", 1); //Fathatan - Kasratan
		hashMap.put("ًٌ", 1); //Fathatan - Dhamatan
		hashMap.put("ً>", 4); //Fathatan - Hamza_UP
		hashMap.put("ً<", 4); //Fathatan - Hamza_DOWN
		hashMap.put("ًّ", 4); //Fathatan - Shadda
		hashMap.put("ًs", 15); //Fathatan - Shadda (mid)
		hashMap.put("ًu", 15); //Fathatan - Hamza_UP (mid)
		hashMap.put("ًd", 15); //Fathatan - Hamza_Down (mid)
		
		//Column: Dhama
		hashMap.put("َُ", 1); //Dhama - Fatha
		hashMap.put("ُِ", 1); //Dhama - Kasra
		hashMap.put("ُُ", 0); //Dhama - Dhama
		hashMap.put("ُْ", 1); //Dhama - Sukun
		hashMap.put("ًُ", 1); //Dhama - Fathatan
		hashMap.put("ٍُ", 1); //Dhama - Kasratan
		hashMap.put("ٌُ", 1); //Dhama - Dhamatan
		hashMap.put("ُ>", 4); //Dhama - Hamza_UP
		hashMap.put("ُ<", 4); //Dhama - Hamza_DOWN
		hashMap.put("ُّ", 4); //Dhama - Shadda
		hashMap.put("ُs", 15); //Dhama - Shadda (mid)
		hashMap.put("ُu", 15); //Dhama - Hamza_UP (mid)
		hashMap.put("ُd", 15); //Dhama - Hamza_Down (mid)
		
		//Column: Dhamatan
		hashMap.put("ٌَ", 1); //Dhamatan - Fatha
		hashMap.put("ٌِ", 1); //Dhamatan - Kasra
		hashMap.put("ٌُ", 1); //Dhamatan - Dhama
		hashMap.put("ٌْ", 1); //Dhamatan - Sukun
		hashMap.put("ًٌ", 1); //Dhamatan - Fathatan
		hashMap.put("ٌٍ", 1); //Dhamatan - Kasratan
		hashMap.put("ٌٌ", 0); //Dhamatan - Dhamatan
		hashMap.put("ٌ>", 4); //Dhamatan - Hamza_UP
		hashMap.put("ٌ<", 4); //Dhamatan - Hamza_DOWN
		hashMap.put("ٌّ", 4); //Dhamatan - Shadda
		hashMap.put("ٌs", 15); //Dhamatan - Shadda (mid)
		hashMap.put("ٌu", 15); //Dhamatan - Hamza_UP (mid)
		hashMap.put("ٌd", 15); //Dhamatan - Hamza_Down (mid)
		
		//Column: Kasra
		hashMap.put("َِ", 1); //Kasra - Fatha
		hashMap.put("ِِ", 0); //Kasra - Kasra
		hashMap.put("ُِ", 1); //Kasra - Dhama
		hashMap.put("ِْ", 1); //Kasra - Sukun
		hashMap.put("ًِ", 1); //Kasra - Fathatan
		hashMap.put("ٍِ", 1); //Kasra - Kasratan
		hashMap.put("ٌِ", 1); //Kasra - Dhamatan
		hashMap.put("ِ>", 4); //Kasra - Hamza_UP
		hashMap.put("ِ<", 4); //Kasra - Hamza_DOWN
		hashMap.put("ِّ", 4); //Kasra - Shadda 
		hashMap.put("ِs", 15); //Kasra - Shadda (mid)
		hashMap.put("ِu", 15); //Kasra - Hamza_UP (mid)
		hashMap.put("ِd", 15); //Kasra - Hamza_Down (mid)
		
		//Column: Kasratan
		hashMap.put("ٍَ", 1); //Kasratan - Fatha
		hashMap.put("ٍِ", 1); //Kasratan - Kasra
		hashMap.put("ٍُ", 1); //Kasratan - Dhama
		hashMap.put("ٍْ", 1); //Kasratan - Sukun
		hashMap.put("ًٍ", 1); //Kasratan - Fathatan
		hashMap.put("ٍٍ", 0); //Kasratan - Kasratan
		hashMap.put("ٌٍ", 1); //Kasratan - Dhamatan
		hashMap.put("ٍ>", 4); //Kasratan - Hamza_UP
		hashMap.put("ٍ<", 4); //Kasratan - Hamza_DOWN
		hashMap.put("ِّ", 4); //Kasra - Shadda
		hashMap.put("ِs", 15); //Kasra - Shadda (mid)
		hashMap.put("ِu", 15); //Kasra - Hamza_UP (mid)
		hashMap.put("ِd", 15); //Kasra - Hamza_Down (mid)
		
		//Column: Sukun
		hashMap.put("َْ", 1); //Sukun - Fatha
		hashMap.put("ِْ", 1); //Sukun - Kasra
		hashMap.put("ُْ", 1); //Sukun - Dhama
		hashMap.put("ْْ", 0); //Sukun - Sukun
		hashMap.put("ًْ", 1); //Sukun - Fathatan
		hashMap.put("ٍْ", 1); //Sukun - Kasratan
		hashMap.put("ٌْ", 1); //Sukun - Dhamatan
		hashMap.put("ْ>", 4); //Sukun - Hamza_UP
		hashMap.put("ْ<", 4); //Sukun - Hamza_DOWN
		hashMap.put("ّْ", 4); //Sukun - Shadda
		hashMap.put("ْs", 15); //Sukun - Shadda (mid)
		hashMap.put("ْu", 15); //Sukun - Hamza_UP (mid)
		hashMap.put("ْd", 15); //Sukun - Hamza_Down (mid)
		
		//Column: Hamza_UP
		hashMap.put(">َ", 4); //Hamza_UP - Fatha
		hashMap.put(">ِ", 4); //Hamza_UP - Kasra
		hashMap.put(">ُ", 4); //Hamza_UP - Dhama
		hashMap.put(">ْ", 4); //Hamza_UP - Sukun
		hashMap.put(">ً", 4); //Hamza_UP - Fathatan
		hashMap.put(">ٍ", 4); //Hamza_UP - Kasratan
		hashMap.put(">ٌ", 4); //Hamza_UP - Dhamatan
		hashMap.put(">>", 0); //Hamza_UP - Hamza_UP
		hashMap.put("><", 4); //Hamza_UP - Hamza_DOWN
		hashMap.put(">ّ", 4); //Hamza_UP - Shadda
		hashMap.put(">s", 15); //Hamza_UP - Shadda (mid)
		hashMap.put(">u", 0); //Hamza_UP - Hamza_UP (mid)
		hashMap.put(">d", 15); //Hamza_UP - Hamza_DOWN (mid)
		
		//Column: Hamza_DOWN
		hashMap.put("<َ", 4); //Hamza_DOWN - Fatha
		hashMap.put("<ِ", 4); //Hamza_DOWN - Kasra
		hashMap.put("<ُ", 4); //Hamza_DOWN - Dhama
		hashMap.put("<ْ", 4); //Hamza_DOWN - Sukun
		hashMap.put("<ً", 4); //Hamza_DOWN - Fathatan
		hashMap.put("<ٍ", 4); //Hamza_DOWN - Kasratan
		hashMap.put("<ٌ", 4); //Hamza_DOWN - Dhamatan
		hashMap.put("<<", 0); //Hamza_DOWN - Hamza_DOWN
		hashMap.put("<>", 4); //Hamza_DOWN - Hamza_UP
		hashMap.put("<ّ", 4); //Hamza_DOWN - Shadda
		hashMap.put("<s", 15); //Hamza_DOWN - Shadda (mid)
		hashMap.put("<u", 15); //Hamza_DOWN - Hamza_UP (mid)
		hashMap.put("<d", 0); //Hamza_DOWN - Hamza_DOWN (mid)
		
		//Column: Shadda
		hashMap.put("َّ", 4); //Shadda - Fatha
		hashMap.put("ِّ", 4); //Shadda - Kasra
		hashMap.put("ُّ", 4); //Shadda - Dhama
		hashMap.put("ّْ", 4); //Shadda - Sukun
		hashMap.put("ًّ", 4); //Shadda - Fathatan
		hashMap.put("ٍّ", 4); //Shadda - Kasratan
		hashMap.put("ٌّ", 4); //Shadda - Dhamatan
		hashMap.put("ّّ", 0); //Shadda - Shadda
		hashMap.put("ّ>", 4); //Shadda - Hamza_UP
		hashMap.put("ّ<", 4); //Shadda - Hamza_DOWN
		hashMap.put("ّs", 0); //Shadda - Shadda (mid)
		hashMap.put("ّd", 15); //Shadda - Hamza_Down (mid)
		hashMap.put("ّu", 15); //Shadda - Hamza_UP (mid)
		
		
		//Column: Hamza_UP (mid)
		hashMap.put("uَ", 15); //Hamza_UP (mid) - Fatha
		hashMap.put("uِ", 15); //Hamza_UP (mid) - Kasra
		hashMap.put("uُ", 15); //Hamza_UP (mid) - Dhama
		hashMap.put("uْ", 15); //Hamza_UP (mid) - Sukun
		hashMap.put("uً", 15); //Hamza_UP (mid) - Fathatan
		hashMap.put("uٍ", 15); //Hamza_UP (mid) - Kasratan
		hashMap.put("uٌ", 15); //Hamza_UP (mid) - Dhamatan
		hashMap.put("uu", 0); //Hamza_UP (mid) - Hamza_UP (mid)
		hashMap.put("u>", 0); //Hamza_UP (mid) - Hamza_UP
		hashMap.put("ud", 15); //Hamza_UP (mid) - Hamza_DOWN (mid)
		hashMap.put("u<", 15); //Hamza_UP (mid) - Hamza_DOWN
		hashMap.put("us", 15); //Hamza_UP (mid) - Shadda (mid)
		hashMap.put("uّ", 15); //Hamza_UP (mid) - Shadda
		
		//Column: Hamza_DOWN (mid)
		hashMap.put("dَ", 15); //Hamza_DOWN (mid) - Fatha
		hashMap.put("dِ", 15); //Hamza_DOWN (mid) - Kasra
		hashMap.put("dُ", 15); //Hamza_DOWN (mid) - Dhama
		hashMap.put("dْ", 15); //Hamza_DOWN (mid) - Sukun
		hashMap.put("dً", 15); //Hamza_DOWN (mid) - Fathatan
		hashMap.put("dٍ", 15); //Hamza_DOWN (mid) - Kasratan
		hashMap.put("dٌ", 15); //Hamza_DOWN (mid) - Dhamatan
		hashMap.put("dd", 0); //Hamza_DOWN (mid) - Hamza_DOWN (mid)
		hashMap.put("d<", 0); //Hamza_DOWN (mid) - Hamza_DOWN
		hashMap.put("du", 15); //Hamza_DOWN (mid) - Hamza_UP (mid)
		hashMap.put("d>", 15); //Hamza_DOWN (mid) - Hamza_UP
		hashMap.put("ds", 15); //Hamza_DOWN (mid) - Shadda (mid)
		hashMap.put("dّ", 15); //Hamza_DOWN (mid) - Shadda
		
		//Column: Shadda (mid)
		hashMap.put("sَ", 15); //Shadda (mid) - Fatha
		hashMap.put("sِ", 15); //Shadda (mid) - Kasra
		hashMap.put("sُ", 15); //Shadda (mid) - Dhama
		hashMap.put("sْ", 15); //Shadda (mid) - Sukun
		hashMap.put("sً", 15); //Shadda (mid) - Fathatan
		hashMap.put("sٍ", 15); //Shadda (mid) - Kasratan
		hashMap.put("sٌ", 15); //Shadda (mid) - Dhamatan
		hashMap.put("ss", 0); //Shadda (mid) - Shadda (mid)
		hashMap.put("sّ", 0); //Shadda (mid) - Shadda
		hashMap.put("su", 15); //Shadda (mid) - Hamza_UP (mid)
		hashMap.put("s>", 15); //Shadda (mid) - Hamza_UP
		hashMap.put("sd", 15); //Shadda (mid) - Hamza_DOWN (mid)
		hashMap.put("s<", 15); //Shadda (mid) - Hamza_DOWN
	}
}
