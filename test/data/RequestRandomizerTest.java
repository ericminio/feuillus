package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class RequestRandomizerTest {

	private RequestRandomizer requestRandomizer;
	
	@Before public void 
	setUp() {
		requestRandomizer = new RequestRandomizer();
	}
	
	@Test public void
	possibleWoodsSet() {
		assertEquals(new String[]{"chene", "hetre", "cerisier", "bouleau"}, requestRandomizer.getPossibleWoods());
	}
	
	@Test public void
	possibleVolumes() {
		assertEquals(new String[]{"100m3", "200m3"}, requestRandomizer.getPossibleVolumes());
	}
	
	@Test public void
	canStoreAWoodRequestsReference() {
		WoodRequests woodRequests = new WoodRequests();
		requestRandomizer.setWoodRequests(woodRequests);
		assertEquals(woodRequests, requestRandomizer.getWoodRequests());
	}
	
	@Test public void
	canChooseARandomVolume() {
		List<String> set = Arrays.asList(requestRandomizer.getPossibleVolumes());
		String volume = requestRandomizer.getRandomVolume();
		assertTrue(set.contains(volume));
		
		boolean atLeastOneDifferentAfter50Throws = false;
		String anotherThrow;
		for (int i=0; i<50; i++) {
			anotherThrow = requestRandomizer.getRandomVolume();
			if (!volume.equalsIgnoreCase(anotherThrow)) {
				atLeastOneDifferentAfter50Throws = true;
			}
		}
		assertTrue(atLeastOneDifferentAfter50Throws);
	}
	
	@Test public void
	canChooseARandomWood() {
		List<String> set = Arrays.asList(requestRandomizer.getPossibleWoods());
		String wood = requestRandomizer.getRandomWood();
		assertTrue(set.contains(wood));
		
		boolean atLeastOneDifferentAfter50Throws = false;
		String anotherThrow;
		for (int i=0; i<50; i++) {
			anotherThrow = requestRandomizer.getRandomWood();
			if (!wood.equalsIgnoreCase(anotherThrow)) {
				atLeastOneDifferentAfter50Throws = true;
			}
		}
		assertTrue(atLeastOneDifferentAfter50Throws);
	}
	
	@Test public void
	requestSpecification() {
		String request = requestRandomizer.getRandomRequest();
		String[] parts = request.split(" ");
		assertEquals(2, parts.length);
		
		List<String> possibleVolumes = Arrays.asList(requestRandomizer.getPossibleVolumes());
		List<String> possibleWoods = Arrays.asList(requestRandomizer.getPossibleWoods());
		assertTrue(possibleVolumes.contains(parts[0]));
		assertTrue(possibleWoods.contains(parts[1]));
	}
}
