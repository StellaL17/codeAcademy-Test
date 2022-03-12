package factoryPattern;

public class PC extends Computer {
	
	private String CPU;
	private String RAM;
	private String HDD;
	
	
	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return this.CPU;
	}
	@Override
	public String getCPU() {
		// TODO Auto-generated method stub
		return this.RAM;
	}
	@Override
	public String getRAM() {
		// TODO Auto-generated method stub
		return this.HDD;
	}
	public PC(String cPU, String rAM, String hDD) {
		super();
		CPU = cPU;
		RAM = rAM;
		HDD = hDD;
	}
	
	
	
	
	

}
