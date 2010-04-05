package data;

public class RequestRandomizer {
	
	private WoodRequests woodRequests;
	private boolean continueAddingRequests;
	
	public RequestRandomizer() {
		continueAddingRequests = true;
	}
	
	public String[] getPossibleWoods() {
		return new String[]{"chene", "hetre", "cerisier", "bouleau"};
	}
	
	public String[] getPossibleVolumes() {
		return new String[]{"100m3", "200m3"};
	}

	public void setWoodRequests(WoodRequests woodRequests) {
		this.woodRequests = woodRequests;
	}

	public WoodRequests getWoodRequests() {
		return woodRequests;
	}
	
	public void start() {
		new Thread(new Runnable() {
			
			public void run() {
				while(continueAddingRequests) {
					try {
						Thread.currentThread().sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (getWoodRequests().getSize() < 15) {
						getWoodRequests().addElement(getRandomRequest());
					}
				}
				
			}
		}).start();
	}

	protected String getRandomVolume() {
		int index = (int) (Math.random()*getPossibleVolumes().length);
		return getPossibleVolumes()[index];
	}

	
	protected String getRandomWood() {
		int index = (int) (Math.random()*getPossibleWoods().length);
		return getPossibleWoods()[index];
	}

	public String getRandomRequest() {
		return getRandomVolume() + " " + getRandomWood();
	}

	
}
