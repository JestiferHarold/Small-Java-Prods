public class Test{
private String toHealthBar(int health, int maxHealth, int barSize) {
  StringBuilder bar = new StringBuilder("|");
  double percentage = ((double)health)/maxHealth;
  int numHearts = (int)(percentage * barSize);
  for (int ii = 0 ; ii < numHearts ; ++ii) {
    bar.append("#");
  }
  for (int ii = numHearts ; ii < barSize ; ++ii) {
    bar.append("-");
  }
  return bar.append("|").toString();
}
	public static void main(String[] args){
		Test testing = new Test();
		System.out.println(testing.toHealthBar(10, 100, 100));
	}
}
