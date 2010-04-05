package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.ListModel;

import org.junit.Before;
import org.junit.Test;


public class StatisticsTest {

	private Statistics statistics;
	
	@Before public void
	setUp() {
		statistics = new Statistics();
	}
	
	@Test public void
	canBeUsedAsListModel() {
		assertTrue(statistics instanceof ListModel);
	}
	
	@Test public void
	displaySpecificationsWithOneWood() {
		statistics.addContract("200m3 chene");
		assertEquals("chene : 200m3", statistics.get(0));
	}
	
	@Test public void
	displaySpecificationsWithTwoWoods() {
		statistics.addContract("200m3 chene");
		statistics.addContract("100m3 hetre");
		assertEquals("hetre : 100m3", statistics.get(1));
	}
	
	@Test public void
	canDetectAnAlreadyKnownWood() {
		assertEquals(-1, statistics.contains("chene"));
		statistics.addElement("chene : 200m3");
		assertEquals(0, statistics.contains("chene"));
	}
	
	@Test public void
	canExtractVolumeValue() {
		assertEquals(200, statistics.extractVolumeValueFromStat("chene : 200m3"));
	}
	
	@Test public void
	displaySpecificationWithTwoTimesTheSameWood() {
		statistics.addContract("200m3 chene");
		statistics.addContract("150m3 chene");
		assertEquals("chene : 350m3", statistics.get(0));
	}
}
