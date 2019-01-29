import java.util.Scanner;

public class NewYearChaos {

  // Complete the minimumBribes function below.
  static void minimumBribes(int[] a) {

    // First attempt is not efficient when large amount of data
    /*int totalbribes = 0;
    for (int i = 0; i < a.length - 1; i++) {
      int bribes = 0;
      for (int j = i; j < a.length - 1; j++) {
        if (a[i] > a[j + 1]) {
          totalbribes++;
          if (++bribes > 2) {
            System.out.println("Too chaotic");
            return;
          }
        }
      }
    }
    System.out.println(totalbribes);*/

    int bribe = 0;
    int maxBribesAllowed = 2;
    int n = a.length;
    for (int i = 0; i < n; i++) {
      // (a[i] - 1) = original index, e.g. the number 5 was at index 4
      // Check if current value moved more than maxBribesAllowed
      if ((a[i] - 1) - i > maxBribesAllowed) // Number of indexes moved
      {
        System.out.println("Too chaotic"); 
        return;
      }
      // https://hackerranksolutionc.blogspot.com/2017/02/new-year-chaos-hackerrank-solution-in.html
      // Dont get the logic on this line. Why the - maxBribesAllowed
      int q = Math.max(0, a[i] - maxBribesAllowed);
      for (int j = q; j < i; j++)
        if (a[j] > a[i])
          bribe++;
    }
    System.out.println(bribe);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] q = new int[n];

      String[] qItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int qItem = Integer.parseInt(qItems[i]);
        q[i] = qItem;
      }

      minimumBribes(q);
    }
    scanner.close();
  }
}
