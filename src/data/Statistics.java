package data;

import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class Statistics extends DefaultListModel {

	public void addContract(String contract) {
		String[] parts = contract.split(" ");
		
		int found = contains(parts[1]);
		if (found != -1) {
			String oldElement = (String) get(found);
			int oldVolumeValue = extractVolumeValueFromStat(oldElement);
			
			String volumeToAdd = parts[0];
			int indexM3OfElementToBeAdded = volumeToAdd.indexOf("m3");
			int valueToAdd = Integer.valueOf(volumeToAdd.substring(0, indexM3OfElementToBeAdded));
			
			String element = parts[1] + " : " + (oldVolumeValue+valueToAdd) + "m3";
			setElementAt(element, found);
		}
		else {
			addElement(parts[1] + " : " + parts[0]);
		}
	}

	protected int extractVolumeValueFromStat(String element) {
		int indexOfValueStart = element.indexOf(" : ") + 3;
		int indexOfValueEnd = element.indexOf("m3");
		int oldVolumeValue = Integer.valueOf(element.substring(indexOfValueStart, indexOfValueEnd));
		return oldVolumeValue;
	}

	protected int contains(String wood) {
		int found = -1;
		for (int i=0; i<getSize(); i++) {
			if (((String)get(i)).startsWith(wood)) {
				found = i;
			}
		}
		return found;
	}

}
