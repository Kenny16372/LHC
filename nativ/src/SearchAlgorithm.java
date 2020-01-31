public class SearchAlgorithm {
    private static SearchAlgorithm instance = new SearchAlgorithm();
    public static SearchAlgorithm getInstance(){
        return instance;
    }
    
    public Port port;
    public SearchAlgorithm(){
        this.port = new Port();
    }
    
    public class Port implements ISearchAlgorithm {

        @Override
        public int search(String text, String pattern) {
            int n = text.length();
            int m = pattern.length();
            int j;

            for (int i = 0; i <= (n - m); i++) {
                j = 0;

                while ((j < m) && (text.charAt(i + j) == pattern.charAt(j))) {
                    j++;
                }

                if (j == m) {
                    return i;
                }
            }

            return -1;
        }
    }
}
