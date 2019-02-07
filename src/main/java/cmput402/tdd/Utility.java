package cmput402.tdd;

import java.util.HashMap;
import java.util.ArrayList;
import cmput402.tdd.service.Search;

public class Utility {

	public HashMap<String, Float>  countAverageScore(Search search){
		HashMap<String, ArrayList<Integer>> scores= search.returnAll();
		HashMap<String, Float> result = new HashMap<String, Float>();
		Float avg;

		for(String player : scores.keySet()){
			avg = (float)scores.get(player).get(1) / scores.get(player).get(0);
			System.out.println(avg);
			result.put(player, avg);
		}

		return result;
	}
	
	public HashMap<String, Integer>  findTopScorer(Search search){
		HashMap<String, ArrayList<Integer>> scores = search.returnAll();
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		Integer score = 0;
		String topPlayer = "";

		for(String player : scores.keySet()){
			if (scores.get(player).get(1) > score){
				score = scores.get(player).get(1);
				topPlayer = player;
			}
		}
		result.put(topPlayer, score);
		return result;
	}
	
}
