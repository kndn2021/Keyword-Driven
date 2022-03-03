package nsdlUtilities;

public class ThreadTime {

	public static void threadTime() {
		try {
//		String trim = inputData.split(".").trim();
//		String trim = inputData.substring(inputData.indexOf(".")-4);
			long input = 5000;
//			long input = Long.parseLong(inputData.toString().trim());
			Thread.sleep(input);
		} catch (InterruptedException e) {
			System.out.println("Thread error");
			e.printStackTrace();
		}
	}

}
