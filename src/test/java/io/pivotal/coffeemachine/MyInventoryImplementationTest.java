package io.pivotal.coffeemachine;

public class MyInventoryImplementationTest extends InventoryTests {

	@Override
	protected Inventory getInventory() {
		// TODO Auto-generated method stub
		return new MyInventoryImplementation();
	}

}
